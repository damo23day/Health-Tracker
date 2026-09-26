# Health Tracker Framework v1

## 1. Purpose
Use ChatGPT as the primary interface for recording food, exercise and progress while GitHub remains the durable source of truth.

## 2. Outcomes
- Starting weight: 96.8 kg
- Intermediate milestone: under 90 kg
- Long-term target: approximately 85–86 kg over roughly 12 months
- Improve waist/body composition, visible definition, strength, fitness and confidence
- Aim for a lean/toned build rather than maximum muscle size

## 3. Phases
### Phase 1 — Pre-December 2026
Moderate-to-faster sustainable fat loss while maintaining adequate nutrition and training.

### Phase 2 — December travel
Shift emphasis toward maintenance, walking/general activity and flexible eating. Gym routine is not expected to be maintained.

### Phase 3 — Post-travel
Reassess weight, measurements, activity and goals and establish the next fat-loss or maintenance phase.

## 4. Nutrition
- Use a daily calorie target plus a weekly calorie budget.
- Track protein daily.
- Normal foods may be estimated using reasonable serving assumptions.
- Ask for quantities when uncertainty could materially change the calorie estimate.
- Mark estimated nutrition rather than presenting estimates as exact.
- Do not automatically eat back reported exercise calories.
- Consider extra intake on unusually active days when appropriate.
- Do not use aggressive compensation after a high-calorie day; assess both daily intake and the weekly average.
- Calorie and protein targets are calibrated using real progress over time.

## 5. Exercise
Baseline: 4 structured sessions per week.
- 2 × approximately 45-minute RPM sessions
- 2 × strength sessions
- Additional walks, rides, DIY/manual activity or workouts are bonus activity and should still be logged.

Strength programming should account for any user-stated physical limitations and be adjusted when required.

## 6. Daily logging
Entries can be supplied conversationally throughout the day.

Track where available:
- food and drinks
- calories
- protein
- exercise type, duration and useful metrics
- steps/general activity
- water
- sleep
- weight
- hunger/energy
- notes relevant to progress

After food/activity updates, provide concise running totals when useful and proactively flag actionable patterns such as low protein, limited remaining calories, unusual hunger or training consistency.

## 7. Progress measurements
Formal check-in once per week:
- body weight
- waist measurement
- progress photos: front, side and back under reasonably consistent conditions

Additional weights can be logged whenever provided. Avoid over-interpreting individual weight fluctuations.

## 8. Reviews
### Daily
Running totals and brief coaching.

### Weekly
Summarise calorie/protein adherence, structured exercise, weight, waist, photos and notable patterns.

### Fortnightly
Review weight-loss rate, calorie target, hunger/energy, training consistency and whether targets require adjustment.

### Monthly
Create a durable progress report comparing nutrition, weight, waist, training and other useful trends.

## 9. Calibration
Calculated energy needs are starting estimates. Actual weight and measurement trends over multiple weeks are used to determine whether targets are appropriate.

## 10. Data principles
- Preserve raw entries where practical.
- Separate raw daily records from review summaries.
- Distinguish measured values from estimates.
- Use machine-readable data suitable for future dashboards/automation.
- Keep the schema simple enough to integrate with Home Assistant later.

## 11. Daily Update Command

When the user asks for a **"daily update"**, read the current day's GitHub record and provide a consistent snapshot containing:

- All food and drink logged so far, with calories and protein.
- Total calories consumed and daily calorie target.
- Percentage of daily calorie target consumed and percentage remaining.
- Total protein consumed and daily protein target.
- Percentage of daily protein target consumed and percentage remaining.
- Calories and protein remaining.
- Current local time.
- Approximate percentage of the calendar day elapsed and remaining.
- Exercise/activity logged so far.
- A short progress/context note where useful.

The percentage of the day elapsed is contextual only. Do not imply that calories or protein need to be consumed evenly across the day. Use the actual current local time when generating the update.

Where food quantities are estimated, continue to identify them as estimates.
