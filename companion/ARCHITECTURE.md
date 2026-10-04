# Health Tracker Companion — Minimal Architecture

## Architecture goal
Use the **least complicated implementation that reliably works on Damien's Samsung Android phone**.

The current preferred form is a small **sideloaded APK**, because Android-specific access is required for Health Connect, notifications, speech input, background work and convenient launch surfaces.

This is not intended to become a conventional commercial mobile application.

## Technology
Use native Android **Kotlin** with Android/Jetpack APIs. Use Jetpack Compose if it keeps the tiny UI simpler to build and maintain.

Do not introduce Flutter, React Native, a PWA, multi-module architecture or a separate wearable app unless a real limitation requires it.

## Simple data flow
```text
Galaxy Watch
    ↓
Samsung Health
    ↓
Health Connect
    ↓
Tiny Companion APK
    ├─ workout/activity reader
    ├─ notifications
    ├─ Quick Log
    ├─ speech-to-text
    └─ small pending queue
    ↓
interpret / validate where required
    ↓
Health Tracker GitHub repository
    ↓
ChatGPT analysis/coaching
```

## APK responsibilities
Keep the APK focused on things Android is good at:
- request/read Health Connect data
- launch quickly
- accept voice/text input
- show notifications
- run suitable scheduled/background work
- retain unsent entries until confirmed synced
- show basic integration/sync status

The APK should not become the main Health Tracker database or analysis engine.

## UI
Aim for one primary Quick Log/status screen plus minimal settings.

No dashboard is required.

## Health Connect
Create a small isolated Health Connect adapter. Initially prove only that a real recent supported workout can be read from the target Samsung setup.

Do not assume Samsung Health exposes every desired field through Health Connect. Test the actual device.

## Notifications and automation
Use standard Android mechanisms where practical. WorkManager may be used for dependable deferred work. Avoid an always-running custom service unless testing proves it necessary.

For workout feedback, design around what Health Connect and Android actually permit in the background. Near-real-time is desirable; reliability and battery friendliness are more important than pretending detection is instantaneous.

## Quick Log
Start with the simplest launch route. Add Quick Settings tile/home shortcut/side-key integration only where it materially improves the real workflow.

Prefer Android speech-to-text to a custom speech stack.

## Interpretation
Do not embed a large AI model in the APK.

Simple explicit entries can be handled deterministically. Natural language can be passed to an approved AI/interpretation layer when needed. AI output must be validated before durable writes.

The exact AI mechanism is deliberately undecided until Quick Log itself works.

## GitHub synchronisation
The Health Tracker repository remains the durable structured record.

Do not embed a broad GitHub personal access token in source or the APK. Before implementing writes, choose the simplest secure mechanism suitable for this one-user system. A tiny intermediary is acceptable only if it solves a real credential/security problem; it is not required by default.

## Local storage
Use the smallest reliable local persistence solution needed to prevent lost entries and support retry. Do not add a database merely for architectural neatness.

Each queued event needs a stable ID so retries cannot duplicate durable records.

## Security
Even for a personal utility:
- no secrets in Git
- no broad token hard-coded in APK
- minimum Health Connect permissions
- secure storage for any device-held credential
- TLS for remote calls
- no unnecessary sensitive logging

## First build milestone
Build `companion/android/` as a minimal installable APK that:
1. launches on the target Samsung phone
2. checks Health Connect availability
3. requests the minimum required exercise permission
4. reads recent exercise sessions
5. displays enough information to confirm a real RPM/cycling workout is accessible
6. handles no-permission/no-data states cleanly

Nothing else is required for this proof.

## Architecture decision rule
Before adding a new service, framework, database or abstraction, ask:

> Does this make Damien's tracker materially easier or more reliable?

If the answer is no, leave it out.