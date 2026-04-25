-- =========================================
-- VARIABLES (IDs reutilizables)
-- =========================================

-- INGREDIENTES
DECLARE @Flour UNIQUEIDENTIFIER = NEWID();
DECLARE @Sugar UNIQUEIDENTIFIER = NEWID();
DECLARE @Butter UNIQUEIDENTIFIER = NEWID();
DECLARE @Eggs UNIQUEIDENTIFIER = NEWID();
DECLARE @Milk UNIQUEIDENTIFIER = NEWID();
DECLARE @Chocolate UNIQUEIDENTIFIER = NEWID();
DECLARE @Yeast UNIQUEIDENTIFIER = NEWID();
DECLARE @Salt UNIQUEIDENTIFIER = NEWID();

-- =========================================
-- INSERT INGREDIENTS
-- =========================================
INSERT INTO Ingredients (Id, Name, UrlImage) VALUES
(@Flour, 'Harina', 'https://img.com/flour.jpg'),
(@Sugar, 'Azúcar', 'https://img.com/sugar.jpg'),
(@Butter, 'Mantequilla', 'https://img.com/butter.jpg'),
(@Eggs, 'Huevos', 'https://img.com/eggs.jpg'),
(@Milk, 'Leche', 'https://img.com/milk.jpg'),
(@Chocolate, 'Chocolate', 'https://img.com/chocolate.jpg'),
(@Yeast, 'Levadura', 'https://img.com/yeast.jpg'),
(@Salt, 'Sal', 'https://img.com/salt.jpg');


-- =========================================
-- RECETA 1: Sourdough Bread
-- =========================================
DECLARE @R1 UNIQUEIDENTIFIER = NEWID();

INSERT INTO Recipes (Id, Name, ImageUrl, Tag, PrepTime, Yield, Difficulty)
VALUES (
    @R1,
    'Sourdough Bread',
    'https://images.unsplash.com/photo-1608198093002-ad4e005484ec',
    'Artisan',
    '24h',
    '2 loaves',
    'Hard'
);

INSERT INTO RecipeIngredients (RecipeId, IngredientId, Quantity, Units, UnitPrice, PriceCurrency) VALUES
(@R1, @Flour, '0.5', 'Kg', 500, 'USD'),
(@R1, @Salt, '0.01', 'Kg', 50, 'USD'),
(@R1, @Yeast, '0.02', 'Kg', 80, 'USD');


-- =========================================
-- RECETA 2: Chocolate Cake
-- =========================================
DECLARE @R2 UNIQUEIDENTIFIER = NEWID();

INSERT INTO Recipes (Id, Name, ImageUrl, Tag, PrepTime, Yield, Difficulty)
VALUES (
    @R2,
    'Chocolate Cake',
    'https://images.unsplash.com/photo-1578985545062-69928b1d9587',
    'Dessert',
    '1h',
    '8 slices',
    'Medium'
);

INSERT INTO RecipeIngredients VALUES
(NEWID(), @R2, @Flour, '0.3', 'Kg', 500, 'USD'),
(NEWID(), @R2, @Sugar, '0.2', 'Kg', 300, 'USD'),
(NEWID(), @R2, @Chocolate, '0.25', 'Kg', 700, 'USD'),
(NEWID(), @R2, @Eggs, '3', 'Units', 10, 'USD');


-- =========================================
-- RECETA 3: Pancakes
-- =========================================
DECLARE @R3 UNIQUEIDENTIFIER = NEWID();

INSERT INTO Recipes VALUES
(@R3, 'Pancakes', 'https://images.unsplash.com/photo-1587735243615-c03f25aaff15', 'Breakfast', '20min', '6 units', 'Easy', GETDATE());

INSERT INTO RecipeIngredients VALUES
(NEWID(), @R3, @Flour, '0.2', 'Kg', 500, 'USD'),
(NEWID(), @R3, @Milk, '0.3', 'L', 200, 'USD'),
(NEWID(), @R3, @Eggs, '2', 'Units', 10, 'USD'),
(NEWID(), @R3, @Sugar, '0.05', 'Kg', 300, 'USD');


-- =========================================
-- RECETA 4: Butter Cookies
-- =========================================
DECLARE @R4 UNIQUEIDENTIFIER = NEWID();

INSERT INTO Recipes VALUES
(@R4, 'Butter Cookies', 'https://images.unsplash.com/photo-1604908177522-4028c0c6b1f4', 'Snack', '40min', '20 cookies', 'Easy', GETDATE());

INSERT INTO RecipeIngredients VALUES
(NEWID(), @R4, @Flour, '0.25', 'Kg', 500, 'USD'),
(NEWID(), @R4, @Butter, '0.2', 'Kg', 600, 'USD'),
(NEWID(), @R4, @Sugar, '0.15', 'Kg', 300, 'USD');


-- =========================================
-- RECETA 5: Sweet Bread
-- =========================================
DECLARE @R5 UNIQUEIDENTIFIER = NEWID();

INSERT INTO Recipes VALUES
(@R5, 'Sweet Bread', 'https://images.unsplash.com/photo-1608198093002-ad4e005484ec', 'Bakery', '2h', '1 loaf', 'Medium', GETDATE());

INSERT INTO RecipeIngredients VALUES
(NEWID(), @R5, @Flour, '0.4', 'Kg', 500, 'USD'),
(NEWID(), @R5, @Sugar, '0.1', 'Kg', 300, 'USD'),
(NEWID(), @R5, @Butter, '0.1', 'Kg', 600, 'USD'),
(NEWID(), @R5, @Yeast, '0.02', 'Kg', 80, 'USD');