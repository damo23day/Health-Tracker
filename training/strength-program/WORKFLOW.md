# Strength workout planning and progression workflow

**Status:** Required procedure for every future strength-workout recommendation.
**Source of truth:** GitHub Health Tracker records, not assumptions from a previous chat.

## 1. Read history BEFORE drafting a workout
1. Read `training/strength-program/phase-1/program.json` and the latest applicable program/phase.
2. Read the **most recent completed strength session**, its post-workout feedback and next-day recovery, and review at least the previous 2–4 sessions when available. Do not treat planned sets as completed sets.
3. Read `training/equipment/home-gym.json` for actual equipment and confirmed weights/load ratings.
4. Review recent RPM, pickleball and other activities if relevant to recovery.
5. Identify the last performed loads, sets, reps, RPE/reps in reserve, technique problems, enjoyment, soreness, wrist issues, neck/back symptoms and delayed headaches. Mark unknowns explicitly.

## 2. Check current readiness BEFORE selecting exercises
Ask about today's energy and soreness, right-wrist tolerance, neck/back discomfort, any headache or radiating nerve symptoms since the previous workout, and whether symptoms occurred later or the next day. Consider sleep and recent activity. If important feedback is missing, clarify instead of assuming recovery.

If symptoms are worsening, neurological, or recurring, avoid provoking movements and advise appropriate clinician/physiotherapist review. Sudden severe headache or new neurological deficits warrant urgent medical assessment. Do not use a pain-free session alone as proof that higher loads are safe.

## 3. Progressive overload: change one variable at a time
- Default to **two strength sessions weekly** alongside RPM, allowing recovery.
- Prioritise chest, core, shoulders and arms; retain upper-back work for balanced shoulders and some leg maintenance.
- For a well-tolerated exercise with controlled form, first consider adding **1–2 reps per set** within the prescribed rep range.
- When all sets reach the top of the range with good technique and comfortable effort across repeated sessions, consider the **smallest practical weight increase**. Verify barbell capacity, collars and plate compatibility first. Available plates may not permit a suitably small increase; in that case progress through reps, tempo or technique rather than forcing a large jump.
- Add a set only after consistent recovery and tolerance, not simultaneously with an increase in load.
- Keep difficult core work (e.g. dead bugs, previously 2 × 8/side with shaking near the end) unchanged until movement quality improves.
- If there is significant soreness, wrist pain, headache, nerve symptoms or poorer technique, maintain, reduce or substitute rather than progress.
- Never treat soreness as a required marker of workout effectiveness.
- Use moderate effort and controlled repetitions; no forced repetitions or breath-holding. Avoid heavy overhead loading or unsupported spinal loading given neck/back history until appropriately assessed.

## 4. Build the next session
- Target ~45 minutes; generally 5-minute warm-up, 30–35 minutes strength/core, 5-minute cool-down, adjusted to readiness.
- Include actual sets/reps/load targets with a short explanation of what changed from the prior session and why.
- Include interactive **set-by-set checkboxes** and an actual countdown timer for every timed warm-up, cool-down and between-set rest where the interface supports it. Clearly disclose limitations of background timing.
- Choose wrist-friendly pressing and upper-body exercises; avoid painful wrist extension. Do not prescribe plate-held movements without checking secure grip and tolerability.
- Include progression and regression options.

## 5. Log immediately and check recovery later
After training, save date, exercises, completed sets, actual repetitions and weights (unknown as null), effort, form, symptoms, enjoyment and modifications in `training/strength-program/sessions/`.
Ask for delayed symptoms and recovery the next day: neck/back pain, headache, wrist symptoms, soreness, fatigue, other activities, and readiness. Append feedback to the same session file; preserve original observations and label later additions with their date.
Before the next workout, **repeat from Step 1**. Do not invent progress, reps, or loads.

## Current baseline (21–22 October 2026)
- 21 October: enjoyable, mostly easy 45-minute home full-body routine. Standard push-ups were hard on strained right wrist and highlighted chest weakness.
- Dead bugs were most demanding: 2 × 8 per side, shaking toward the end.
- 22 October: no reported neck/back problems or headaches; mild pleasant general muscle soreness; played low-intensity pickleball the previous evening.
- Continue monitoring delayed headaches and wrist response; avoid aggressive progression.
