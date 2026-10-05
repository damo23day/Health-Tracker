# Health Tracker Companion

## Clear scope
Health Tracker Companion is a **tiny personal Android helper** for Damien's Samsung phone. It is not intended to reproduce ChatGPT, interpret meals itself, write Health Tracker JSON itself, or become a full health application.

The existing **ChatGPT Health Tracker Project remains the intelligence and working interface**. ChatGPT continues to understand Damien's natural-language updates, use Project context, estimate/interpret meals and drinks, review progress, and create/update the structured files in the Health Tracker GitHub repository.

The Companion's job is simply to make getting an update into that existing ChatGPT workflow much faster.

## Target experience

```text
Android notification / shortcut
        ↓
[ Update Health Tracker ]
        ↓
ChatGPT Health Tracker Project/chat
        ↓
Damien dictates/types the update
        ↓
ChatGPT interprets it using existing context
        ↓
ChatGPT updates Health Tracker GitHub
        ↓
ChatGPT returns today's updated status/analysis
```

The important design decision is that **we do not duplicate the Health Tracker intelligence in Android**.

## Phase 1 — prove the shortcut
Build the smallest sideloaded Android APK/helper that can:

1. Install on Damien's Samsung phone.
2. Request notification permission where required.
3. Create a test notification named **Health Tracker Update**.
4. Provide an **Update Health Tracker** action/button.
5. When pressed, launch ChatGPT using the most reliable supported Android route available.
6. Prefer opening the existing Health Tracker Project/chat directly if a supported deep link/intent exists.
7. If direct Project/chat routing is not supported, launch ChatGPT as close to the existing Health Tracker workflow as Android and ChatGPT officially allow.
8. Clearly document the resulting number of taps and any platform limitation discovered.

Do not add Health Connect, AI APIs, GitHub authentication, food parsing, databases, dashboards or background workout detection during this proof of concept.

## Phase 2 — useful prompts
After Phase 1 works reliably, add configurable notification prompts such as:

- morning update
- afternoon update
- evening update
- optional manual **Health Tracker Update** notification/shortcut

The notification is a convenient entry point into ChatGPT; it does not need to process the health update itself.

## Phase 3 — convenient Android entry points
Only if useful after testing:

- Quick Settings tile
- launcher shortcut
- home-screen shortcut/widget
- Samsung Modes & Routines integration
- supported side-key/hardware shortcut

## Phase 4 — lightweight status view (optional)
If we later find a clean way to obtain already-calculated Health Tracker summary information without duplicating the ChatGPT workflow, a small view may show items such as:

- today's calories vs target
- protein
- hydration
- steps
- exercise
- simple weekly progress

This is optional and must not drive unnecessary architecture.

## Explicitly out of scope for now
- recreating ChatGPT intelligence in the APK
- direct meal interpretation in Android
- direct GitHub daily-file creation from Android
- storing GitHub credentials in the APK
- separate AI/LLM integration
- Health Connect integration
- automatic workout detection
- commercial app architecture
- Play Store release
- multi-user support
- separate backend/database
- elaborate dashboard

These ideas can be reconsidered later only if the simple ChatGPT shortcut workflow proves insufficient.

## Source of truth
The existing Health Tracker repository remains the durable structured record. ChatGPT continues to manage those records in the same way as the current working Health Tracker Project workflow.

## Guiding rule
> Do not rebuild what already works in ChatGPT. Make it faster for Damien to get into the existing Health Tracker conversation and give an update.
