# Health Tracker

Personal health, nutrition and exercise tracking data used with ChatGPT.

## Purpose
ChatGPT is the day-to-day tracking interface. This repository is the durable source of truth for structured records and progress reviews.

## Goals
- Starting weight: 96.8 kg
- Major milestone: below 90 kg
- Long-term target: 85–86 kg
- Current phase: sustainable moderate-to-faster fat loss before December 2026
- December 2026: travel/maintenance phase
- Body goal: leaner waist, improved muscle definition and general fitness without focusing on bulk

## Tracking rhythm
- Daily: food, drinks, calories, protein, exercise, activity, water, sleep and useful notes
- Weekly: weight, waist and progress photos plus summary
- Fortnightly: deeper review and target adjustment if required
- Monthly: progress report and trend review

See `framework/health-tracker-v1.md` for the operating framework.

## Repository map

| Location | Purpose | Source of truth for |
| --- | --- | --- |
| `data/daily/YYYY/MM/YYYY-MM-DD.json` | Complete snapshot of an individual day | Daily nutrition, hydration, sleep, wellbeing and day summary |
| `data/activity/YYYY.json` | Compact daily activity history, primarily from Samsung Health | Steps, distance, active minutes, activity calories and total burned calories for trend analysis |
| `data/exercise/rpm-workouts.json` | Individual RPM workout records | RPM workout history and performance |
| `data/measurements/` | Longitudinal body measurements | Weight, waist and body-composition trends |
| `config/` | Tracker settings, targets, regular foods and supplements | Current configuration where applicable |
| `framework/` | Operating rules and tracking methodology | How the Health Tracker should be used |
| `templates/` | Standard record structures | Templates for new records |
| `training/` | Exercise and training plans | Planned training programs |

## Data rules

### Daily snapshot vs specialist datasets
Daily files provide the complete snapshot of what happened on a particular day. Specialist datasets provide compact historical series designed for trend analysis.

Some headline information is intentionally duplicated. For example, a day's step count can appear in both the daily record and the annual activity file.

When analysing trends, use the specialist dataset as the authoritative source. When reviewing a specific day, use the daily file.

### Activity
`data/activity/YYYY.json` is the authoritative longitudinal record for general daily activity imported or recorded from Samsung Health. Use it for weekly, monthly and yearly totals and averages such as steps, distance and active minutes.

Samsung Health figures captured before the end of the day should record the capture time so they are not mistaken for final daily totals.

### Exercise
Intentional workouts are stored separately from general daily activity. RPM sessions are stored in `data/exercise/rpm-workouts.json`. Future workout types such as strength training can have their own appropriate exercise dataset.

Auto-detected incidental walking can remain part of the daily/activity record and does not need to become a standalone workout record unless it is intentionally being tracked as exercise.

### Body measurements
`data/measurements/body-measurements.json` is the authoritative longitudinal record for weight, waist and body-composition measurements. Daily logs may also contain the day's measurement as contextual snapshots. Use the measurement history for trend analysis and future dashboards.

### Supplements
`config/supplements.json` is the source of truth for current supplement and electrolyte products, standard serving sizes and product-label details. Actual consumption is logged in the relevant daily JSON file.

### Nutrition
The daily JSON file is the authoritative record for food, drinks, calories, protein and hydration for that day. Estimated values should remain marked as estimates and can be refined later when better information becomes available.

## Source-of-truth principle
- **Specific day:** use the relevant daily JSON file.
- **Activity trends:** use `data/activity/YYYY.json`.
- **RPM trends:** use `data/exercise/rpm-workouts.json`.
- **Body measurement trends:** use the longitudinal file under `data/measurements/`.
- **Tracker methodology:** use `framework/`.
