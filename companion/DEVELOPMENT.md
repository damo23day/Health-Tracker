# Health Tracker Companion — Development Framework

## Purpose
Health Tracker Companion is a **personal, single-user Android automation utility** built specifically for Damien's Samsung phone/Galaxy Watch and the existing Health Tracker repository.

It is not intended to be a commercial app, Play Store product, multi-user platform or reusable health product. Development should optimise for **minimum complexity, minimum taps and reliable personal use**.

## Roles
### ChatGPT — Architect / Product Owner
Defines requirements, architecture and small build tasks; reviews architectural changes; protects simplicity and compatibility with the Health Tracker.

### Codex — Builder
Implements approved tasks, tests them, preserves existing data structures and reports blockers or assumptions. Codex should not expand scope or introduce product-grade infrastructure without a demonstrated need.

### GitHub — Source of truth
Stores source code, specifications, development history and the existing structured Health Tracker records.

## Core development rule
> Build the smallest thing that reliably works for this user on this phone.

Prefer a simple script, Android platform feature or small utility over a larger framework when both solve the requirement reliably.

## What we are building
A small **sideloaded APK** that acts primarily as a bridge between Android/Samsung capabilities and the Health Tracker.

It may provide:
- Health Connect access
- workout detection/checking
- notifications
- Quick Log
- speech-to-text
- scheduled prompts
- local pending queue
- secure synchronisation

It does not need normal commercial-app infrastructure.

## Deliberate shortcuts
Because this is a personal utility, it is acceptable to:
- optimise for one Samsung Android device
- use sideloaded APK distribution
- keep a single Android app module
- use a very small UI
- use fixed personal configuration where safe
- rely on Android/Samsung features available on the target device
- favour maintainability for one user over general portability

## Shortcuts we should NOT take
Simplicity must not mean unsafe handling of credentials or unreliable health records.

Do not:
- commit secrets/API keys/tokens
- hard-code a broad GitHub credential into source or APK
- fabricate measured health data
- silently discard failed entries
- create duplicate records on retries
- overwrite existing Health Tracker data incorrectly

## MVP discipline
A feature belongs in the first version only if it:
- makes logging faster,
- removes an existing manual step,
- imports useful phone/watch data, or
- is necessary to make those functions reliable or secure.

No dashboards, account system, social features, commercial onboarding, app-store work or general-purpose platform architecture.

## Development workflow
1. ChatGPT defines a small outcome and acceptance criteria.
2. Codex inspects relevant existing code/data.
3. Codex implements the smallest complete change.
4. Test it on the real Samsung environment where applicable.
5. Review results.
6. Commit clearly.
7. Only then add the next capability.

## First milestone
> Build a minimal sideloadable APK that installs on the target Samsung phone, obtains the required Health Connect permission and displays a real recent supported exercise session.

No AI, GitHub writing, voice logging or smart reminders are required for this first proof.