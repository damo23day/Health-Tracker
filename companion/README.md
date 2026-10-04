# Health Tracker Companion for Android

## Project purpose
Health Tracker Companion is a **small personal sideloaded Android APK** for Damien's Samsung phone and Galaxy Watch.

Its purpose is to remove friction from day-to-day health tracking. It is not intended to become a commercial app or general health platform. Build the smallest reliable utility that connects Samsung/Android health data, quick voice logging and notifications with the existing Health Tracker repository.

The existing Health Tracker repository remains the durable source of truth.

## Core experience

```text
Galaxy Watch
    ↓
Samsung Health / Health Connect
    ↓
Health Tracker Companion APK
    ├─ workout/activity import
    ├─ workout feedback notifications
    ├─ Quick Log voice/text
    └─ morning/afternoon/evening prompts
    ↓
interpret / validate
    ↓
Health Tracker GitHub repository
    ↓
ChatGPT analysis/coaching
```

The normal workflow should not require opening ChatGPT, finding the Health Tracker Project, opening GitHub or asking separately for GitHub to be updated.

## Design philosophy
- single user
- one target Samsung Android phone/watch ecosystem
- sideloaded APK; no Play Store requirement
- native Android where required
- minimal UI
- voice first
- measured data comes from the device
- AI interprets but does not invent
- no unnecessary server/database/framework
- security and data reliability are not sacrificed for convenience

## Key interactions

### Workout feedback
After a newly completed relevant workout is available, Companion should prompt:

> **Workout complete — how did it go?**

Tap, speak naturally, submit. The subjective feedback is associated with the measured workout.

### Quick Log
Launch from the simplest useful Android shortcut/tile/action and say something such as:

> Had my standard protein coffee, two eggs on toast and finished another bottle with Hydralyte and creatine.

Submit once; the accepted entry is synchronised automatically.

### Daily prompts
Configurable morning, afternoon and evening prompts provide a quick route into logging. Later these can become context-aware to avoid unnecessary notifications.

## Existing Health Tracker destinations
| Data | Destination |
| --- | --- |
| Daily food, drinks, hydration, sleep, wellbeing and notes | `data/daily/YYYY/MM/YYYY-MM-DD.json` |
| General activity / Samsung Health history | `data/activity/YYYY.json` |
| RPM sessions | `data/exercise/rpm-workouts.json` |
| Body measurements | `data/measurements/` |
| Product / serving definitions | `config/` |
| Tracking methodology | `framework/` |

Exact write mappings must be based on the live schemas before automatic writes are implemented.

## Development documents
- `DEVELOPMENT.md` — ChatGPT Architect / Codex Builder workflow and simplicity rules
- `SPEC.md` — personal utility requirements and MVP boundaries
- `ARCHITECTURE.md` — minimal APK architecture and technical decisions

## First milestone
Do not build the whole system at once.

First prove:

> Install the minimal Companion APK on the target Samsung phone, grant Health Connect permission, and display a real recent supported RPM/cycling workout.

Once that works, add Quick Log, synchronisation, workout feedback and scheduled prompts incrementally.
