# Health Tracker Cookbook — Framework & Specification (v1)

## Purpose
A fridge-first, nutrition-aware cookbook. Given available ingredients and a maximum cooking time (default 15 minutes), suggest feasible recipes from the repository, favouring high protein, low effort and minimal shopping.

## Source of truth
- Recipe Markdown files contain complete instructions and original + adapted versions.
- `recipes.json` is the machine-readable searchable index. Update both together.
- Each recipe has a stable lowercase hyphenated ID and relative Markdown path.
- Do not invent taste ratings or treat estimated macros as verified.

## Required metadata
`id`, `name`, `category` (array), `path`, `servings`, `total_minutes`, `active_minutes`, `difficulty` (1–5), `ingredient_hassle` (1–5), `essential_ingredients`, `optional_ingredients`, `substitutions`, `quick_version` (nullable), `nutrition` (estimated calories and protein per serving, with estimate flag), `taste_rating` (null until tested), `status` (to_try/tried/favourite), `requires_prep` and `notes`.

Ingredient entries should use canonical singular lowercase names, with quantities in the Markdown recipe. `essential_ingredients` are required for the **indexed Health Tracker version**, not necessarily for all variants. Substitutions must state which ingredient they replace and any impact on time or nutrition. Treat water, salt, pepper and cooking spray as pantry assumptions only if confirmed by the user.

## Rating definitions
- **Difficulty:** 1 = assemble/reheat; 2 = basic cooking; 3 = several coordinated steps; 4 = technique/timing sensitive; 5 = advanced.
- **Ingredient hassle:** 1 = mostly staples; 2 = common groceries; 3 = several fresh or uncommon items; 4 = specialist; 5 = hard to source or substantial advance preparation.
- **Taste:** 1–5, provided by user after trying. Null means not rated.
- **Total time:** elapsed time to serve, including cooking and prerequisite preparation. If a precooked ingredient is assumed, explicitly set `requires_prep` and do not claim a guaranteed under-15-minute match.
- **Active time:** hands-on minutes.
- **Ingredient count:** count essential + optional food ingredients, excluding basic seasoning.

## Matching and sorting
1. Normalise input ingredients with aliases (e.g. eggs→egg; mozzarella→cheese only when recipe accepts generic cheese).
2. For each recipe, check essential ingredient coverage and known substitutions; do not assume the user owns optional ingredients.
3. Categorise: **ready_now** (all essentials, time fits), **adaptable** (valid substitution or explicitly documented quick version), **missing_one**, **shopping_required**.
4. Strict time filtering: only label under-15-minute when total elapsed time <=15 and no uncounted prerequisite. If a quick variant qualifies, show it as a **variant** with changed ingredient and macro assumptions.
5. Rank within categories by fewest missing essentials, time, difficulty, ingredient hassle, then protein (descending). Allow sorting by each field and taste when rated.
6. Show missing ingredients, substitutions, recipe link, estimated calories/protein and short steps. Never claim a dish can be made from available ingredients if required components are missing.
7. Don't assume a fridge inventory persists between requests unless the user supplies or maintains one.

## New recipe workflow
1. Preserve original recipe and source/provenance.
2. Create weighed Health Tracker adaptation; estimate macros with assumptions.
3. Identify essential/optional ingredients and credible substitutions.
4. Estimate total/active time, difficulty, ingredient hassle; add quick version only if realistic.
5. Save Markdown using `RECIPE_TEMPLATE.md`.
6. Add one entry to `recipes.json`, verify unique ID, valid path, complete required fields, and update README index.
7. Mark ratings provisional until user cooks and reviews.

## Meal categories
A recipe may belong to multiple categories (breakfast, lunch, dinner, snack). Store each recipe once using its stable ID and one Markdown file; category is a filter, not a directory constraint. The **Anytime** filter means all categories and is not a stored tag. Do not duplicate recipes across folders. Fridge-first matching searches all categories by default unless the user requests a meal type.
