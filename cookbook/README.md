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

## Favourite recipes — Make Again

- **[Chocolate Peanut Butter Protein Mousse](dessert/chocolate-protein-mousse.md)** — tested 29 October 2026; user said very good and wants to make again. 80 g light Greek yoghurt, 10 g chocolate protein powder, 17 mL milk, 10 g peanut butter, 10 g cocoa, 5 g honey. ~225 kcal / ~19 g protein (estimated). Current preferred v2; earlier mousse test retained.

## Quick dessert recipes (some tested; estimates)

| Recipe | Total | Active | Difficulty | Ingredient hassle | Estimated protein | Taste |
|---|---:|---:|---:|---:|---:|---|
| [Chocolate Peanut Butter Protein Mousse](dessert/chocolate-protein-mousse.md) | 5 min | 5 min | 1/5 | 1/5 | ~19 g | Very good — Favourite |
| [Warm Cinnamon Apple & Yoghurt](dessert/warm-cinnamon-apple-yoghurt.md) | 7 min | 4 min | 1/5 | 1/5 | ~15 g | Not rated |
| [Chocolate Banana Mug Cake](dessert/chocolate-banana-mug-cake.md) | 8 min | 5 min | 2/5 | 1/5 | ~11 g | Not rated |

All three are initial concepts and should be tested for taste, timing and ingredient-specific macros.

- [Rice Paper Croque Madame](breakfast/rice-paper-croque-madame.md) — breakfast, lunch or dinner; 20–24 min; taste not yet rated.

- [High-Protein Pistachio Cheesecake](dessert/high-protein-pistachio-cheesecake.md) — dessert or snack; 10 min prep + 45 min bake + 8 h chill; ~254 kcal and ~14 g protein per slice (author estimate); taste not yet rated.

## Curated from The Chef Out West high-protein collection

These are initial candidates, **not personally rated**. Linked files summarise preparation and link to the author's full ingredient measurements and instructions.

| Recipe | Meal | Total | Published calories / protein per serving |
|---|---|---:|---|
| [High-Protein Microwave Chocolate Lava Cake](dessert/high-protein-microwave-chocolate-lava-cake.md) | dessert, snack | 7 min | ~339 kcal / 21 g |
| [90-Second High-Protein Chocolate Cake](dessert/90-second-high-protein-chocolate-cake.md) | dessert, snack | 7 min | ~430 kcal / 52 g |
| [Edible High-Protein Cookie Dough](dessert/edible-high-protein-cookie-dough.md) | dessert, snack | 15 min | ~368 kcal / 16 g |
| [High-Protein Microwave Pistachio Lava Cake](dessert/high-protein-microwave-pistachio-lava-cake.md) | dessert, snack | 7 min | ~497 kcal / 17 g |
| [Smoked Salmon Breakfast Bowl](breakfast/smoked-salmon-breakfast-bowl.md) | breakfast, lunch, dinner | 7 min | Unverified |
| [Easy High-Protein Tortilla Quiche](breakfast/easy-high-protein-tortilla-quiche.md) | breakfast, lunch, dinner | 20 min | ~271 kcal / 25 g |
| [High-Protein McChicken Smash Tacos](lunch/high-protein-mcchicken-smash-tacos.md) | lunch, dinner | 20 min | ~328 kcal / 27 g |
| [Bacon Egg & Cheese Rice Paper Dumplings](breakfast/bacon-egg-cheese-rice-paper-dumplings.md) | breakfast, lunch, snack | 38 min | Unverified |

The pistachio lava cake and edible cookie dough are energy-dense despite their protein content. Times are total, not just microwave cook time. The smoked salmon bowl's 7-minute time assumes pre-pickled onions.

## Cooking history (workout-style)
Each actual cook gets a numbered session in `logs/<recipe-id>.md`, recording ingredients actually used, ratings, cooking time, results and changes to test. The recipe file shows the **current version**, with prior versions and sessions retained. Proposed changes are marked **untested** until cooked.

- [Sweet Potato Waffles — current v2 (proposed)](breakfast/sweet-potato-avocado-egg-waffles.md) · [Session 001 and feedback](logs/sweet-potato-avocado-egg-waffles.md)

- [Homemade High-Protein Vanilla Bean Custard](dessert/high-protein-vanilla-bean-custard.md) — 2 servings; ~150 kcal and ~22 g protein each (provisional); 10–15 min hands-on plus chilling; **to try**.

## Must try — Matt West F*CK or SUCK series
- [Chickpea Chocolate Chip Cookies](dessert/matt-west-chickpea-chocolate-chip-cookies.md) — makes 8; ~195 kcal / ~5 g protein each (provisional). Screenshot recipe; **baking temperature and time still need checking from the original video**. Not yet cooked or rated.

## Must try — Lunch
- [Chicken Waffle Caesar Sandwich](lunch/chicken-waffle-caesar-sandwich.md) — **Healthylifestyle** Facebook recipe; makes 2 sandwiches, author claims ~340 kcal and 43 g protein each (unverified). Chicken, egg and cheese cooked as waffles, filled with cottage cheese, lettuce, tomato and Caesar dressing. **Not yet tested**.
