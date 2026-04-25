-- =========================================
-- TABLA: RECIPES
-- =========================================
CREATE TABLE Recipes (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),

    Name NVARCHAR(150) NOT NULL,
    ImageUrl NVARCHAR(500),
    Tag NVARCHAR(50),
    PrepTime NVARCHAR(50),
    Yield NVARCHAR(50),
    Difficulty NVARCHAR(20),

    CreatedAt DATETIME2 DEFAULT GETDATE()
);

-- =========================================
-- TABLA: INGREDIENTS (CATÁLOGO)
-- =========================================
CREATE TABLE Ingredients (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),

    Name NVARCHAR(100) NOT NULL,
    UrlImage NVARCHAR(500),

    CreatedAt DATETIME2 DEFAULT GETDATE()
);

-- =========================================
-- TABLA: RECIPE INGREDIENTS
-- (Aquí va TU objeto Ingredient completo)
-- =========================================
CREATE TABLE RecipeIngredients (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),

    RecipeId UNIQUEIDENTIFIER NOT NULL,
    IngredientId UNIQUEIDENTIFIER NOT NULL,

    Quantity NVARCHAR(50) NOT NULL,     -- "0.5"
    Units NVARCHAR(20) NOT NULL,        -- "Kg"
    UnitPrice DECIMAL(10,2) NOT NULL,   -- 500.00
    PriceCurrency NVARCHAR(10) NOT NULL, -- USD

    CONSTRAINT FK_RecipeIngredients_Recipe
        FOREIGN KEY (RecipeId) REFERENCES Recipes(Id)
        ON DELETE CASCADE,

    CONSTRAINT FK_RecipeIngredients_Ingredient
        FOREIGN KEY (IngredientId) REFERENCES Ingredients(Id)
);