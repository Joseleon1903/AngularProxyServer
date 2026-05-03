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

CREATE TABLE Sales (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    SaleDate DATE NOT NULL,
    ReferenceNumber VARCHAR(20) NOT NULL,
    CustomerName VARCHAR(100) NOT NULL,
    ProductDescription VARCHAR(255),
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(10,2) NOT NULL,
    TotalAmount AS (Quantity * UnitPrice) PERSISTED,
    PaymentMethod VARCHAR(50) NOT NULL,
    CreatedAt DATETIME DEFAULT GETDATE()
);

CREATE TABLE dbo.Customers (
    Id INT IDENTITY(1,1) PRIMARY KEY,

    CustomerType CHAR(1) NOT NULL, -- 'F' = Físico, 'M' = Moral

    Phone VARCHAR(20) NOT NULL,
    Email VARCHAR(100) NULL,

    CreatedAt DATETIME2 DEFAULT GETDATE(),
    IsActive BIT DEFAULT 1,

    CONSTRAINT CK_Customers_Type CHECK (CustomerType IN ('F','M'))
);

CREATE TABLE dbo.CustomerPhysical (
    CustomerId INT PRIMARY KEY,

    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    IdentificationNumber VARCHAR(30) NULL,

    CONSTRAINT FK_CustomerPhysical_Customers
        FOREIGN KEY (CustomerId) REFERENCES dbo.Customers(Id)
        ON DELETE CASCADE
);

CREATE TABLE dbo.CustomerMoral (
    CustomerId INT PRIMARY KEY,

    BusinessName VARCHAR(150) NOT NULL,
    RNC VARCHAR(20) NOT NULL,

    CONSTRAINT FK_CustomerMoral_Customers
        FOREIGN KEY (CustomerId) REFERENCES dbo.Customers(Id)
        ON DELETE CASCADE
);


---tablas para manejo de notificaciones
CREATE TABLE Notifications (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT NOT NULL, -- Usuario destinatario

    Title VARCHAR(150) NOT NULL,
    Message VARCHAR(500) NOT NULL,

    Type VARCHAR(20) NOT NULL,
    -- Ej: 'INFO', 'SUCCESS', 'WARNING', 'ERROR'

    IsRead BIT DEFAULT 0,

    CreatedAt DATETIME DEFAULT GETDATE(),
    ReadAt DATETIME NULL,

    ReferenceId INT NULL,
    -- ID opcional relacionado (ej: OrderId, ProductId)

    ReferenceType VARCHAR(50) NULL
    -- Ej: 'ORDER', 'PRODUCT', etc.
);

CREATE TABLE NotificationSettings (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT NOT NULL,

    EmailEnabled BIT DEFAULT 1,
    PushEnabled BIT DEFAULT 1,
    SmsEnabled BIT DEFAULT 0,

    CreatedAt DATETIME DEFAULT GETDATE()
);

CREATE TABLE NotificationLogs (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    NotificationId INT NOT NULL,

    Status VARCHAR(20), -- SENT, FAILED
    ErrorMessage VARCHAR(500) NULL,

    SentAt DATETIME DEFAULT GETDATE(),

    FOREIGN KEY (NotificationId) REFERENCES Notifications(Id)
);




