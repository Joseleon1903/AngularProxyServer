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
-- INSERT Category
-- =========================================
INSERT INTO [WebApp].[Categories]
(
    IsActive,
    IsDeleted,
    CreatedAtUtc,
    DeletedAtUtc,
    Id,
    UpdatedAtUtc,
    TenantId,
    Description,
    Name
)
VALUES
(1, 0, GETUTCDATE(), '1900-01-01', 1, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Panes elaborados diariamente.', 'Panes'),

(1, 0, GETUTCDATE(), '1900-01-01', 2, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Pasteles para cumpleaños y celebraciones.', 'Pasteles'),

(1, 0, GETUTCDATE(), '1900-01-01', 3, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Galletas artesanales de distintos sabores.', 'Galletas'),

(1, 0, GETUTCDATE(), '1900-01-01', 4, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Postres tradicionales y gourmet.', 'Postres'),

(1, 0, GETUTCDATE(), '1900-01-01', 5, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Cupcakes decorados para eventos.', 'Cupcakes'),

(1, 0, GETUTCDATE(), '1900-01-01', 6, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Donas glaseadas, rellenas y especiales.', 'Donas'),

(1, 0, GETUTCDATE(), '1900-01-01', 7, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Empanadas dulces y saladas.', 'Empanadas'),

(1, 0, GETUTCDATE(), '1900-01-01', 8, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Bebidas frías y calientes.', 'Bebidas'),

(1, 0, GETUTCDATE(), '1900-01-01', 9, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Productos de temporada y promociones.', 'Especiales'),

(1, 0, GETUTCDATE(), '1900-01-01', 10, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Accesorios e insumos para repostería.', 'Accesorios');

-- =========================================
-- INSERT Units
-- =========================================
INSERT INTO [WebApp].[Units]
(
    ConversionFactorToBase,
    IsBaseUnit,
    Id,
    Code,
    Name,
    UnitType
)
VALUES
-- Peso
(1.00,    1, 1,  'KG',  'Kilogramo',       'WEIGHT'),
(0.001,   0, 2,  'G',   'Gramo',           'WEIGHT'),
(1000.00, 0, 3,  'TON', 'Tonelada',        'WEIGHT'),

-- Volumen
(1.00,    1, 4,  'L',   'Litro',           'VOLUME'),
(0.001,   0, 5,  'ML',  'Mililitro',       'VOLUME'),
(3.785,   0, 6,  'GAL', 'Galón',           'VOLUME'),

-- Cantidad
(1.00,    1, 7,  'UND', 'Unidad',          'QUANTITY'),
(12.00,   0, 8,  'DOC', 'Docena',          'QUANTITY'),
(24.00,   0, 9,  'CJ',  'Caja (24 uds)',   'QUANTITY'),
(100.00,  0, 10, 'PK',  'Paquete (100)',   'QUANTITY');

-- =========================================
-- INSERT ProductTypes
-- =========================================
INSERT INTO [WebApp].[ProductTypes]
(
    IsActive,
    IsDefault,
    IsDeleted,
    CreatedAtUtc,
    DeletedAtUtc,
    Id,
    UpdatedAtUtc,
    TenantId,
    Description,
    Name
)
VALUES
(1, 1, 0, GETUTCDATE(), '1900-01-01', 1, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Tipo de producto predeterminado.', 'General'),

(1, 0, 0, GETUTCDATE(), '1900-01-01', 2, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Productos horneados diariamente.', 'Panadería'),

(1, 0, 0, GETUTCDATE(), '1900-01-01', 3, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Productos de repostería fina.', 'Repostería'),

(1, 0, 0, GETUTCDATE(), '1900-01-01', 4, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Postres fríos y calientes.', 'Postres'),

(1, 0, 0, GETUTCDATE(), '1900-01-01', 5, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Bebidas para acompañar los productos.', 'Bebidas'),

(1, 0, 0, GETUTCDATE(), '1900-01-01', 6, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Productos preparados bajo pedido.', 'Personalizados'),

(1, 0, 0, GETUTCDATE(), '1900-01-01', 7, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Productos de temporada.', 'Temporada'),

(1, 0, 0, GETUTCDATE(), '1900-01-01', 8, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Productos premium con ingredientes especiales.', 'Premium'),

(1, 0, 0, GETUTCDATE(), '1900-01-01', 9, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Productos congelados para hornear.', 'Congelados'),

(1, 0, 0, GETUTCDATE(), '1900-01-01', 10, GETUTCDATE(), '11111111-1111-1111-1111-111111111111', 'Complementos y accesorios.', 'Complementos');

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

--- categpory insert
INSERT INTO [Catalog].[Categories]
(
    Id,
    CreatedAtUtc,
    DeletedAtUtc,
    Description,
    IsActive,
    IsDeleted,
    Name,
    TenantId,
    UpdatedAtUtc
)
VALUES
(NEWID(), GETUTCDATE(), '1900-01-01', 'Panes tradicionales y artesanales.', 1, 0, 'Panes', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Bizcochos y pasteles para toda ocasión.', 1, 0, 'Pasteles', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Galletas dulces y saladas.', 1, 0, 'Galletas', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Postres individuales.', 1, 0, 'Postres', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Bebidas frías y calientes.', 1, 0, 'Bebidas', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Empanadas y productos horneados salados.', 1, 0, 'Empanadas', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Sandwiches y bocadillos.', 1, 0, 'Sandwiches', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Productos preparados para desayuno.', 1, 0, 'Desayunos', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Productos de temporada.', 1, 0, 'Temporada', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Dulces y golosinas.', 1, 0, 'Dulces', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Ingredientes para producción.', 1, 0, 'Ingredientes', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Harinas y mezclas especiales.', 1, 0, 'Harinas', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Rellenos y coberturas.', 1, 0, 'Rellenos', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Productos congelados.', 1, 0, 'Congelados', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Panes integrales y saludables.', 1, 0, 'Saludables', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Productos sin azúcar.', 1, 0, 'Sin Azúcar', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Productos sin gluten.', 1, 0, 'Sin Gluten', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Promociones y ofertas especiales.', 1, 0, 'Promociones', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Accesorios y utensilios.', 1, 0, 'Accesorios', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Otros productos.', 1, 0, 'Otros', '00000000-0000-0000-0000-000000000000', GETUTCDATE());

--- product type
INSERT INTO [Catalog].[ProductTypes]
(
    Id,
    CreatedAtUtc,
    DeletedAtUtc,
    Description,
    IsActive,
    IsDefault,
    IsDeleted,
    Name,
    TenantId,
    UpdatedAtUtc
)
VALUES
(NEWID(), GETUTCDATE(), '1900-01-01', 'Producto terminado listo para la venta.', 1, 1, 0, 'Producto Terminado', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Ingrediente utilizado en la elaboración de productos.', 1, 0, 0, 'Ingrediente', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Materia prima utilizada en producción.', 1, 0, 0, 'Materia Prima', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Producto semielaborado pendiente de finalizar.', 1, 0, 0, 'Producto Semielaborado', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Bebida preparada para la venta.', 1, 0, 0, 'Bebida', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Postre elaborado.', 1, 0, 0, 'Postre', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Pan elaborado.', 1, 0, 0, 'Pan', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Pastel o bizcocho.', 1, 0, 0, 'Pastel', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Producto congelado.', 1, 0, 0, 'Congelado', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Producto empacado para distribución.', 1, 0, 0, 'Empacado', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Accesorio o utensilio para la venta.', 1, 0, 0, 'Accesorio', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Servicio ofrecido por el negocio.', 1, 0, 0, 'Servicio', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Producto promocional.', 1, 0, 0, 'Promoción', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Producto de temporada.', 1, 0, 0, 'Temporada', '00000000-0000-0000-0000-000000000000', GETUTCDATE()),

(NEWID(), GETUTCDATE(), '1900-01-01', 'Producto personalizado por encargo.', 1, 0, 0, 'Personalizado', '00000000-0000-0000-0000-000000000000', GETUTCDATE());

