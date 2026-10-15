# Healthy Cookbook — Fridge-First Meal Finder

**Primary goal:** Tell Health Tracker which ingredients are in the fridge and the available cooking time (especially **15 minutes or less**). Find recipes that can be made now, with practical substitutions, while supporting protein and calorie goals.

## How to use
Example: **"I've got eggs, spinach, tuna and cheese. What can I make in 15 minutes?"**

Rank results:
1. **Make now:** all essential ingredients available and total time within limit.
2. **Make with substitutions:** missing items have credible substitutions or are optional.
3. **Missing one item:** one essential ingredient unavailable.
4. **Shopping required:** two or more essentials missing.

Never present a recipe as a match if an essential ingredient is missing without an explicit substitution. Count prerequisite cooking time (e.g. raw sweet potato), and distinguish a simplified variant from the full recipe. Return quick instructions and approximate calories/protein.

## Recipe metadata standard
Each recipe should include:
- **Total time** and **active time** in minutes; distinguish precooked ingredients.
- **Difficulty (1–5):** 1 effortless, 2 easy, 3 moderate, 4 involved, 5 advanced.
- **Ingredient hassle (1–5):** 1 staples, 2 common groceries, 3 multiple fresh purchases, 4 specialist, 5 hard to source.
- **Essential ingredients**, **optional ingredients**, **substitutions** and a **quick version** when practical.
- **Estimated calories/protein**, servings, status (To try / Tried / Favourite), **taste rating (1–5)** once tested.
- Retain the **original recipe** and the **Health Tracker version** separately. Record assumptions and don't treat estimates as verified macros.

## Recipe index (provisional; times and ratings untested)

| Recipe | Category | Total | Active | Difficulty | Ingredient hassle | Protein estimate | Taste | Status |
|---|---|---:|---:|---:|---:|---:|---|---|
| [Tuna & Vegetable Omelette](breakfast/tuna-spinach-vegetable-omelette.md) | Breakfast / Lunch | 15 min | 10 min | 2/5 | 2/5 | ~39 g | Not rated | To try |
| [Sweet Potato & Egg Waffles](breakfast/sweet-potato-avocado-egg-waffles.md) | Breakfast | 25 min* | 15 min | 2/5 | 2/5 | ~29–33 g | Not rated | To try |
| [Low-Carb Waffle Burger](lunch/low-carb-waffle-burger.md) | Lunch / Dinner | 30 min | 25 min | 3/5 | 3/5 | ~53 g | Not rated | To try |

*Sweet potato must already be cooked; otherwise allow additional time.

## Future additions
As the collection grows, consider a machine-readable recipe index and ingredient aliases for filtering (e.g. mozzarella → cheese). For now, Markdown files are the source of truth. Prioritise quick, easy, high-protein recipes that can use everyday fridge ingredients.

## Cookbook framework files
- [Specification and matching rules](SPECIFICATION.md)
- [Standard recipe template](RECIPE_TEMPLATE.md)
- [Machine-readable recipe index](recipes.json)

**Maintenance rule:** When adding or modifying a recipe, update its Markdown file, the corresponding `recipes.json` entry and the human-readable table above. The JSON index is structured data, not yet a running search application.

## Dessert recipes
Dessert is a supported meal category. Keep desserts in `dessert/` where practical; tag them in `recipes.json` and include them in the Anytime search. Prioritise easy 5–15-minute options as well as occasional treats; record portion sizes and estimated nutrition.

## Quick dessert recipes (untested estimates)

| Recipe | Total | Active | Difficulty | Ingredient hassle | Estimated protein | Taste |
|---|---:|---:|---:|---:|---:|---|
| [Chocolate Protein Mousse](dessert/chocolate-protein-mousse.md) | 5 min | 5 min | 1/5 | 1/5 | ~35 g | Not rated |
| [Warm Cinnamon Apple & Yoghurt](dessert/warm-cinnamon-apple-yoghurt.md) | 7 min | 4 min | 1/5 | 1/5 | ~15 g | Not rated |
| [Chocolate Banana Mug Cake](dessert/chocolate-banana-mug-cake.md) | 8 min | 5 min | 2/5 | 1/5 | ~11 g | Not rated |

All three are initial concepts and should be tested for taste, timing and ingredient-specific macros.
