# Health Tracker Companion — Personal Android Helper Specification

## Purpose
Create the smallest possible Android helper that reduces the friction of entering updates into Damien's existing ChatGPT Health Tracker Project.

This helper is **not the Health Tracker intelligence**. ChatGPT remains responsible for understanding natural language, using existing Project context, interpreting regular meals/drinks, estimating nutrition, answering follow-up questions, reviewing the day/week, and updating the Health Tracker GitHub repository.

## Primary requirement
Damien should be able to receive or trigger a Health Tracker notification, press one obvious button, and arrive at the existing ChatGPT Health Tracker workflow with as little navigation as the supported Android/ChatGPT integration permits.

## Phase 1 acceptance criteria
- Native Android project builds successfully.
- Produces a sideloadable APK for Damien's Samsung Android phone.
- Minimal dependencies and code.
- Handles Android notification permission correctly.
- Can create a test notification titled `Health Tracker Update`.
- Notification contains an `Update Health Tracker` action.
- Action launches ChatGPT.
- Investigate supported Android intent/deep-link behaviour for opening the existing Health Tracker Project/chat directly.
- Use only supported/stable routing; do not reverse-engineer private ChatGPT APIs or depend on brittle undocumented message injection.
- If direct chat/project routing is unavailable, implement the closest reliable route and document the limitation.
- No extra screen should be opened by the helper unless Android requires it or it is needed for initial setup/testing.

## Phase 1 UI
A full traditional app UI is unnecessary. A minimal setup/test activity is acceptable with controls such as:

- `Send Test Notification`
- status showing notification permission
- short explanation of what the notification action does

Normal daily use should be notification/shortcut-first rather than opening the helper.

## Phase 2
Once Phase 1 routing is proven:
- configurable morning notification
- configurable afternoon notification
- configurable evening notification
- easy manual trigger

Each prompt should contain the same simple route back into the Health Tracker ChatGPT workflow.

## Possible later convenience features
Only build after the basic workflow is tested:
- Quick Settings tile
- launcher shortcut
- home-screen shortcut/widget
- Samsung Modes & Routines compatibility
- supported side-key/hardware shortcut
- small read-only daily/weekly summary if it can be implemented simply

## Explicit non-requirements
Do not build these in Phase 1:
- Health Connect
- Samsung Health ingestion
- AI/LLM API
- natural-language parser
- food database
- direct GitHub writes
- GitHub credentials/authentication
- local health database
- workout detection
- workout-feedback processing
- complex background service
- commercial architecture
- Play Store packaging
- multi-user accounts
- web backend
- elaborate dashboard

## Existing Health Tracker workflow remains unchanged
The desired result after pressing the notification is the same workflow Damien already uses successfully:

1. Speak/type a natural update to ChatGPT.
2. ChatGPT understands it in the context of the Health Tracker Project.
3. ChatGPT asks for clarification only where necessary.
4. ChatGPT updates the appropriate Health Tracker GitHub data.
5. ChatGPT can provide current daily totals, remaining calories/protein/hydration, exercise information and weekly progress.

## Success measure
The first prototype is successful if it materially reduces the number of steps required to get from Damien's Android phone to giving this Health Tracker Project a normal spoken update.

> Build the shortcut first. Do not rebuild ChatGPT.
