# Health Tracker Companion for Android

## Project purpose

Health Tracker Companion is a lightweight Android companion app for the existing Health Tracker repository.

Its purpose is to remove friction from day-to-day health tracking. Instead of opening ChatGPT, finding the Health Tracker project, entering an update and then separately asking for GitHub to be updated, the Companion should make logging feel like a native part of the phone and Galaxy Watch experience.

The Companion is a **capture and integration layer**. The existing Health Tracker repository remains the durable source of truth for structured health records.

---

## Product vision

The ideal experience is:

1. Samsung/Galaxy Watch records objective health and workout data.
2. Samsung Health / Android Health Connect makes supported data available to the Companion.
3. The Companion detects useful events such as a completed workout.
4. Android presents a contextual notification.
5. The user taps the notification and gives a short voice or text update.
6. The Companion converts that update into a structured health event.
7. The appropriate Health Tracker datasets are updated automatically.
8. ChatGPT can later analyse the combined objective data and subjective notes without requiring duplicate manual entry.

Example:

> RPM workout completed — 45 min  
> How did it go?

The user taps **Add update** and says:

> Pretty tough today. Felt flat and didn't have much energy. Really struggled through the last 15 minutes.

The Companion associates that note with the workout already captured from Health Connect and updates the appropriate Health Tracker records.

---

# 1. Core principles

### 1.1 Low friction
Logging should normally take seconds and should not require navigating through ChatGPT or GitHub.

### 1.2 Voice first
Most manual entries should be possible by tapping one button, speaking naturally and submitting.

Examples:

- "Just had a large coffee."
- "Two eggs and two pieces of multigrain toast with hummus."
- "Finished another drink bottle with Hydralyte and creatine."
- "RPM was hard today. I had no energy but got through it."

### 1.3 Objective data should come from the device
Where Samsung Health / Health Connect provides reliable measured data, the Companion should import it rather than asking the user to enter it again.

Examples include steps, workout duration, heart-rate information and other supported activity metrics.

### 1.4 AI should interpret, not invent
AI may translate natural-language entries into structured records, recognise regular foods and interpret subjective comments. It must not fabricate measured health data.

### 1.5 GitHub Health Tracker remains the durable record
The Companion should write into structures compatible with the existing Health Tracker repository rather than creating a competing database of record.

### 1.6 Avoid duplicate records
Imported workouts, repeated notifications and retried network requests must not create duplicate meals, workouts or activity records.

---

# 2. Proposed architecture

```text
Galaxy Watch
     |
     v
Samsung Health
     |
     v
Android Health Connect
     |
     v
Health Tracker Companion
     |\
     | \-- Notifications / Quick Log / Voice input
     |
     v
Interpretation + validation layer
     |
     v
Health Tracker GitHub repository
     |
     v
ChatGPT Health Tracker analysis / coaching
```

The Companion should not depend on silently injecting messages into a particular ChatGPT conversation. The GitHub repository provides the shared durable data layer between the Companion and ChatGPT workflows.

---

# 3. Existing Health Tracker integration

The Companion must respect the repository's existing source-of-truth rules.

| Data | Destination |
| --- | --- |
| Daily food, drinks, hydration, sleep, wellbeing and notes | `data/daily/YYYY/MM/YYYY-MM-DD.json` |
| General activity / Samsung Health history | `data/activity/YYYY.json` |
| RPM sessions | `data/exercise/rpm-workouts.json` |
| Body measurements | `data/measurements/` |
| Product / serving definitions | `config/` |
| Tracking methodology | `framework/` |

A single captured event may legitimately update more than one dataset. For example, an RPM workout may be added to the RPM history while headline exercise information also appears in that day's daily snapshot.

---

# 4. MVP — Version 1

Version 1 should remain deliberately small and reliable.

## 4.1 Health Connect integration

Read supported data from Android Health Connect, initially concentrating on:

- exercise sessions
- workout start/end time
- workout duration
- heart-rate data where available
- calories / energy where available and appropriate
- steps
- distance
- other useful activity fields already represented by the Health Tracker schema

The exact Health Connect permissions and available Samsung Health fields must be verified during implementation.

## 4.2 Workout-completed workflow

When a relevant intentional workout is detected as completed:

1. Import the objective workout information.
2. Identify/match the workout type where possible.
3. Create a stable event identifier for duplicate protection.
4. Present a notification such as:

> **Workout complete — how did it go?**

Actions:

- **Add update**
- **Later**
- **Dismiss**

For RPM/cycling sessions, the Companion should associate the response with the imported workout.

The response may include subjective fields such as:

- perceived difficulty
- energy level
- enjoyment
- pain/discomfort
- performance observations
- general notes

## 4.3 Quick Log

Provide an Android Quick Log entry point.

Potential surfaces:

- home-screen shortcut/widget
- Quick Settings tile
- persistent/optional notification shortcut
- app shortcut from long-pressing the launcher icon
- Samsung side-key or other hardware shortcut where Android/Samsung permits it

Opening Quick Log should immediately provide:

- microphone button
- text field
- Submit button

The user should be able to speak naturally without selecting "food", "water", "coffee" or "exercise" first.

## 4.4 Natural-language interpretation

The interpretation layer should determine whether an entry represents one or more of:

- food
- drink
- water
- supplement
- workout comment
- body measurement
- wellbeing note
- correction to a previous entry

It should use existing Health Tracker configuration such as known products, regular foods, bottle sizes and supplement definitions where available.

Low-confidence or ambiguous interpretations should be shown for confirmation rather than silently committed incorrectly.

## 4.5 Automatic GitHub update

After a valid entry is accepted, the Companion should automatically update the relevant repository file(s).

The normal user experience should **not** require the instruction "update GitHub".

Each write should include enough metadata to understand its origin, for example:

```json
{
  "source": "health-tracker-companion",
  "capture_method": "voice",
  "captured_at": "ISO-8601 timestamp"
}
```

The precise schema should be aligned with existing files before implementation.

---

# 5. Scheduled check-ins

The Companion should support configurable prompts rather than relying solely on fixed alarms.

Initial check-ins:

### Morning
Prompt for breakfast / morning intake if appropriate.

### Afternoon
Prompt for lunch, drinks and general intake.

### Evening
Prompt for dinner, hydration and anything missing from the day.

These should eventually become context-aware.

Example:

Instead of:

> Log your water.

Prefer:

> You've logged 1.5 L today. Any more water or drinks to add?

A reminder should be suppressed where the relevant information has already been adequately recorded.

---

# 6. Context-aware notifications — later phase

Once the MVP is reliable, notifications can use current tracker data to ask better questions.

Examples:

- Workout detected -> ask how it felt.
- Low logged hydration late in the day -> ask about unlogged drinks/water.
- No food recorded around lunch -> offer a quick meal update.
- Health Connect has new daily activity totals -> sync without interrupting the user.
- A workout has objective metrics but no subjective feedback -> offer a follow-up.

The goal is useful prompting, not notification spam.

---

# 7. Offline and reliability behaviour

Quick logging should still work when network access is temporarily unavailable.

Proposed behaviour:

1. Save the entry to a local pending queue.
2. Mark it as `pending_sync`.
3. Retry when connectivity returns.
4. Mark it synced only after the remote write succeeds.
5. Use stable event IDs/idempotency rules to prevent duplicate writes.

The app should expose a simple status such as:

- Synced
- 2 updates waiting to sync
- Sync error — tap to retry

---

# 8. Security and privacy

Health information and GitHub credentials must be treated as sensitive.

Requirements:

- request only required Health Connect permissions
- do not hard-code GitHub credentials into the application source
- store local secrets using appropriate Android secure storage
- minimise locally retained health data
- use encrypted network connections
- provide a clear way to revoke integrations
- avoid logging sensitive health payloads unnecessarily in diagnostic logs

A safer long-term architecture may use a small authenticated backend/service to perform repository writes rather than distributing a broad GitHub token to the Android application. This decision should be made during technical design.

---

# 9. Suggested project phases

## Phase 1 — Foundation

- Android project scaffold
- Companion settings screen
- Health Connect permission flow
- read basic activity/workout data
- display latest imported data locally

## Phase 2 — Quick Log

- Quick Log UI
- speech-to-text
- text entry
- structured event model
- local pending queue

## Phase 3 — Repository sync

- map Companion events to existing Health Tracker schemas
- safe GitHub authentication/write mechanism
- automatic commits
- duplicate protection
- sync status/error handling

## Phase 4 — Workout assistant

- detect newly completed intentional workouts
- RPM matching
- post-workout notification
- capture subjective workout feedback
- combine watch metrics + user feedback

## Phase 5 — Daily prompts

- morning check-in
- afternoon check-in
- evening check-in
- configurable notification times

## Phase 6 — Smart prompts

- context-aware reminders
- missing-data detection
- hydration awareness
- smarter meal prompts
- workout recovery/context prompts

## Phase 7 — Deeper ChatGPT integration

Explore richer AI interpretation and analysis while continuing to use the Health Tracker repository as the durable data layer.

---

# 10. Definition of a successful MVP

The MVP is successful when the following scenario works reliably:

1. Complete an RPM workout while wearing the Galaxy Watch.
2. Samsung Health/Health Connect records the workout.
3. Companion detects the completed session.
4. Phone displays a workout-feedback notification.
5. Tap the notification.
6. Say how the workout felt.
7. Submit.
8. Objective metrics and subjective feedback are written to the correct Health Tracker records automatically.
9. Later, use Quick Log to say: "Had a coffee and finished another bottle of water with Hydralyte and creatine."
10. That entry is interpreted and written to the day's Health Tracker record without opening GitHub or manually requesting a repository update.

---

# 11. Initial development priorities

Do **not** begin by trying to implement every possible Samsung Health metric or AI feature.

Development order:

1. Confirm existing repository schemas.
2. Scaffold Android app.
3. Prove Health Connect can read a completed workout from the target Samsung phone/watch setup.
4. Build Quick Log voice/text capture.
5. Define a reliable structured event format.
6. Prove one safe automatic repository write.
7. Add workout feedback notification.
8. Add scheduled daily check-ins.
9. Add smarter interpretation and context-aware prompts.

This keeps the project testable at every stage and gives us a useful product early rather than building a large integration before proving the important pieces.

---

## Working name

**Health Tracker Companion**

Platform: **Android**  
Primary wearable/data ecosystem: **Samsung Galaxy Watch + Samsung Health + Health Connect**  
Durable data store: **Health Tracker GitHub repository**  
Primary interaction: **notifications + Quick Log + voice**
