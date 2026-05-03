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


-- 1
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0001', 'contacto@panaderialaesperanza.com');
DECLARE @Id11 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id11, 'Panadería La Esperanza', '101000001');

-- 2
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0002', 'info@dulcesabor.com');
DECLARE @Id12 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id12, 'Dulce Sabor SRL', '101000002');

-- 3
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0003', 'ventas@cafedelicias.com');
DECLARE @Id13 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id13, 'Café Delicias', '101000003');

-- 4
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0004', 'contacto@pasteleriabonita.com');
DECLARE @Id14 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id14, 'Pastelería Bonita', '101000004');

-- 5
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0005', 'info@hornoymiel.com');
DECLARE @Id15 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id15, 'Horno y Miel', '101000005');

-- 6
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0006', 'ventas@panexpress.com');
DECLARE @Id16 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id16, 'Pan Express', '101000006');

-- 7
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0007', 'contacto@dulcevida.com');
DECLARE @Id17 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id17, 'Dulce Vida Bakery', '101000007');

-- 8
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0008', 'info@panartesanal.com');
DECLARE @Id18 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id18, 'Pan Artesanal RD', '101000008');

-- 9
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0009', 'ventas@delipan.com');
DECLARE @Id19 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id19, 'DeliPan SRL', '101000009');

-- 10
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('M', '809-600-0010', 'contacto@superpan.com');
DECLARE @Id20 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerMoral VALUES (@Id20, 'Super Pan Dominicana', '101000010');

-- 1
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0001', 'juan.perez@email.com');
DECLARE @Id1 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id1, 'Juan', 'Pérez', '001-0000001-1');

-- 2
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0002', 'maria.gomez@email.com');
DECLARE @Id2 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id2, 'María', 'Gómez', NULL);

-- 3
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0003', 'carlos.lopez@email.com');
DECLARE @Id3 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id3, 'Carlos', 'López', '001-0000003-3');

-- 4
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0004', 'ana.martinez@email.com');
DECLARE @Id4 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id4, 'Ana', 'Martínez', NULL);

-- 5
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0005', 'luis.ramirez@email.com');
DECLARE @Id5 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id5, 'Luis', 'Ramírez', '001-0000005-5');

-- 6
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0006', 'sofia.torres@email.com');
DECLARE @Id6 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id6, 'Sofía', 'Torres', NULL);

-- 7
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0007', 'pedro.castillo@email.com');
DECLARE @Id7 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id7, 'Pedro', 'Castillo', '001-0000007-7');

-- 8
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0008', 'laura.flores@email.com');
DECLARE @Id8 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id8, 'Laura', 'Flores', NULL);

-- 9
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0009', 'jose.santos@email.com');
DECLARE @Id9 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id9, 'José', 'Santos', '001-0000009-9');

-- 10
INSERT INTO dbo.Customers (CustomerType, Phone, Email)
VALUES ('F', '809-555-0010', 'elena.ruiz@email.com');
DECLARE @Id10 INT = SCOPE_IDENTITY();
INSERT INTO dbo.CustomerPhysical VALUES (@Id10, 'Elena', 'Ruiz', NULL);