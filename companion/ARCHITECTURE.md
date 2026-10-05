# Health Tracker Companion — Minimal Notification-First Architecture

## Architecture goal
Use the **least complicated implementation that reliably reduces the steps required to reach Damien's existing ChatGPT Health Tracker Project on his Samsung Android phone**.

The helper is a sideloaded APK only because Android needs installed code to create notifications/actions and convenient launch surfaces. It should not feel like another app Damien has to use.

## Technology
- native Android
- Kotlin
- standard Android notification and intent APIs
- one app module
- minimal dependencies
- Compose only if useful for the tiny setup/test activity; traditional simple Android UI is also acceptable

## Phase 1 data flow

```text
Health Tracker notification
        ↓
Update Health Tracker action
        ↓
Android intent / supported link
        ↓
ChatGPT Android app
        ↓
Existing Health Tracker Project/chat
        ↓
Damien speaks/types normally
        ↓
Existing ChatGPT + GitHub workflow
```

## APK responsibilities
For the first build the APK has only four responsibilities:
1. obtain notification permission if required
2. create the Health Tracker notification channel
3. show a test `Health Tracker Update` notification
4. launch ChatGPT from the notification action using the closest supported route to the Health Tracker Project/chat

## ChatGPT routing
Codex must investigate supported Android routing rather than assuming a private deep-link format.

Preferred outcome:
`notification action -> exact Health Tracker Project/chat`

Acceptable fallback for the proof:
`notification action -> ChatGPT app`, with the remaining manual navigation documented.

Do not use reverse-engineered/private ChatGPT endpoints, accessibility hacks, UI automation, or undocumented authenticated message injection merely to remove a tap.

## Minimal setup activity
The APK may expose a tiny activity for installation/testing:

```text
HEALTH TRACKER HELPER

Notification permission: Granted

[ Send Test Notification ]

Routing result/status
```

This screen is not intended to be the normal daily interface.

## Notifications
Phase 1 needs only a manually generated test notification.

After routing is proven, Phase 2 can add configurable morning/afternoon/evening notifications using standard Android scheduling mechanisms. Choose the simplest reliable scheduler at that point; do not add background infrastructure during Phase 1.

## No health processing in Phase 1
There is deliberately no:
- Health Connect
- Samsung Health integration
- workout reader
- speech recognition inside the helper
- AI interpretation
- GitHub API integration
- health-data persistence
- food parsing
- calorie/protein calculations
- dashboard

All health conversation/intelligence continues in ChatGPT.

## Security
Phase 1 should require no GitHub, OpenAI API or other secret credentials in the APK.

## Project location
Android source should live under:

`companion/android/`

Keep the project self-contained and easy to build into a debug APK.

## First milestone
> Install the APK on Damien's Samsung phone, press `Send Test Notification`, receive `Health Tracker Update`, press `Update Health Tracker`, and observe exactly where ChatGPT opens.

Document:
- whether ChatGPT opens successfully
- whether a specific Project/chat can be targeted through a supported route
- number of taps remaining before Damien can dictate an update
- any Samsung/Android behaviour affecting the workflow

## Architecture decision rule
> The Android helper is a shortcut into the existing Health Tracker intelligence, not a replacement for it.
