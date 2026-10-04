# Health Tracker Companion — Personal Utility Specification

## Product statement
Health Tracker Companion is a **small personal sideloaded Android APK** for Damien's Samsung phone and Galaxy Watch. Its purpose is to make Health Tracker capture nearly effortless.

It is a front-end/automation bridge, not a replacement for Samsung Health, GitHub or ChatGPT.

## Target experience
Most interactions should happen without opening the full app.

### Workout
Galaxy Watch -> Samsung Health / Health Connect -> Companion detects/checks completed workout -> notification asks how it went -> tap -> speak -> submit -> Health Tracker updated.

### Quick Log
Shortcut/tile/button -> speak naturally -> submit -> entry interpreted and Health Tracker updated.

Example: "Had my standard protein coffee, two eggs on toast and finished a bottle with Hydralyte and creatine."

### Daily prompts
Morning, afternoon and evening prompts provide a one-tap route into Quick Log. Later they may become context-aware.

## V1 required capabilities
- sideloadable APK
- Health Connect permission/read capability
- read selected workout/activity data exposed from Samsung Health
- very small Quick Log interface
- Android speech-to-text plus editable text
- workout feedback notification
- configurable morning/afternoon/evening prompts
- safe pending/retry behaviour
- automatic synchronisation into existing Health Tracker records
- duplicate protection
- clear success/error status

## Convenience surfaces
Implement only those that prove useful, starting with the simplest:
- notification actions
- launcher/app shortcut
- Quick Settings tile
- home-screen shortcut/widget if useful
- Samsung hardware/side-key launch only if supported cleanly on the target phone

## Not required
- Google Play Store distribution
- commercial packaging
- multi-user accounts
- cross-platform support
- iOS
- web portal
- social features
- dashboards/charts
- elaborate navigation
- custom Galaxy Watch app
- standalone food database
- replacement for ChatGPT analysis
- backend/database unless genuinely needed for secure sync or AI interpretation

## UI philosophy
The full APK can be nearly one screen:

```text
HEALTH TRACKER

[ Quick Log / microphone ]

Editable recognised text

[ Submit ]

Health connected: Yes
Last sync: ...
Pending: ...
```

Settings should be minimal and only expose things the user actually needs to change.

## Data principles
- measured data comes from Health Connect/device sources
- subjective comments come from the user
- AI may interpret natural language but must not invent measurements
- ambiguous interpretations require confirmation
- existing Health Tracker repository schemas remain authoritative

## Existing destinations
- daily records: `data/daily/YYYY/MM/YYYY-MM-DD.json`
- activity history: `data/activity/YYYY.json`
- RPM history: `data/exercise/rpm-workouts.json`
- measurements: `data/measurements/`
- known definitions/configuration: `config/`

Exact mappings must be based on the live schemas before automatic writes are implemented.

## MVP success
The useful end state is:
1. Complete RPM wearing Galaxy Watch.
2. Companion obtains the available workout information through Health Connect.
3. Phone prompts for feedback.
4. Tap and say how it felt.
5. Submit once.
6. Correct Health Tracker data is updated automatically.
7. At any other time, launch Quick Log, speak a meal/drink/water update and submit without opening ChatGPT or GitHub.

## Guiding rule
> If it doesn't reduce friction in Damien's actual tracking workflow, don't build it.