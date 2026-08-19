public class MainApp {

    public static void main(String[] args) {

        System.out.println(
            "=============================================="
        );

        System.out.println(
            "       INVENTORY MANAGEMENT SYSTEM"
        );

        System.out.println(
            "=============================================="
        );

        // ----------------------------------------------------
        // Create Address
        // ----------------------------------------------------

        Address warehouseAddress =
                new Address(
                    "Warangal",
                    "Telangana",
                    "506001"
                );

        // ----------------------------------------------------
        // Create Supplier
        // ----------------------------------------------------

        Supplier supplier =
                new Supplier(
                    "SUP001",
                    "Tech Supplies Pvt Ltd",
                    "9876543210"
                );

        // ----------------------------------------------------
        // Create Warehouse
        // ----------------------------------------------------

        Warehouse warehouse =
                new Warehouse(
                    "WH001",
                    "Main Warehouse",
                    warehouseAddress
                );

        System.out.println(
            "\nWarehouse Details:"
        );

        System.out.println(warehouse);

        System.out.println(
            "\nSupplier Details:"
        );

        System.out.println(supplier);

        // ----------------------------------------------------
        // Create Item
        // ----------------------------------------------------

        Item laptop =
                new Item(
                    "IT001",
                    "Laptop",
                    55000,
                    20,
                    supplier,
                    warehouse
                );

        // ----------------------------------------------------
        // Create Perishable Item
        // ----------------------------------------------------

        PerishableItem milk =
                new PerishableItem(
                    "IT002",
                    "Milk Packets",
                    50,
                    15,
                    supplier,
                    warehouse,
                    "25-08-2026"
                );

        // ----------------------------------------------------
        // Create Electronic Item
        // ----------------------------------------------------

        ElectronicItem mobile =
                new ElectronicItem(
                    "IT003",
                    "Smartphone",
                    25000,
                    30,
                    supplier,
                    warehouse,
                    12
                );

        // ----------------------------------------------------
        // Create Manager
        // ----------------------------------------------------

        InventoryManager manager =
                new InventoryManager();

        try {

            // ------------------------------------------------
            // Insert Items
            // ------------------------------------------------

            System.out.println(
                "\n--- INSERTING ITEMS ---"
            );

            manager.insert(laptop);
            manager.insert(milk);
            manager.insert(mobile);

            // ------------------------------------------------
            // Polymorphism
            // ------------------------------------------------

            System.out.println(
                "\n--- POLYMORPHISM ---"
            );

            InventoryEntity entity1 = milk;
            InventoryEntity entity2 = mobile;

            manager.displayItem(entity1);
            manager.displayItem(entity2);

            // ------------------------------------------------
            // Add Stock
            // ------------------------------------------------

            System.out.println(
                "\n--- ADDING STOCK ---"
            );

            manager.addStock(laptop, 5);

            System.out.println(
                "Current Laptop Stock: " +
                laptop.getStock()
            );

            // ------------------------------------------------
            // Remove Stock
            // ------------------------------------------------

            System.out.println(
                "\n--- REMOVING STOCK ---"
            );

            laptop.removeStock(16);

            System.out.println(
                "Current Laptop Stock: " +
                laptop.getStock()
            );

            // ------------------------------------------------
            // Inner Class
            // ------------------------------------------------

            System.out.println(
                "\n--- INNER CLASS ---"
            );

            Item.StockDetails details =
                    laptop.new StockDetails(
                        10,
                        100
                    );

            details.displayStockLimits();

            // ------------------------------------------------
            // Copy Constructor
            // ------------------------------------------------

            System.out.println(
                "\n--- COPY CONSTRUCTOR ---"
            );

            Item copiedLaptop =
                    new Item(laptop);

            System.out.println(
                "Copied Item:"
            );

            System.out.println(copiedLaptop);

            // ------------------------------------------------
            // Update
            // ------------------------------------------------

            System.out.println(
                "\n--- UPDATE ---"
            );

            manager.update(laptop);

            // ------------------------------------------------
            // Delete
            // ------------------------------------------------

            System.out.println(
                "\n--- DELETE ---"
            );

            manager.delete("IT003");

            // ------------------------------------------------
            // Static Methods
            // ------------------------------------------------

            System.out.println(
                "\n--- STATIC METHODS ---"
            );

            System.out.println(
                "Total Items Created: " +
                Item.getItemCount()
            );

            System.out.println(
                "Total Warehouses Created: " +
                Warehouse.getWarehouseCount()
            );

            System.out.println(
                "Total Transactions: " +
                InventoryManager.getTransactionCount()
            );

            // ------------------------------------------------
            // Final Keyword
            // ------------------------------------------------

            System.out.println(
                "Company Name: " +
                InventoryManager.COMPANY_NAME
            );

        } catch (InvalidStockException e) {

            // ------------------------------------------------
            // Exception Handling
            // ------------------------------------------------

            System.out.println(
                "ERROR: " +
                e.getMessage()
            );
        }

        System.out.println(
            "\n=============================================="
        );

        System.out.println(
            "          PROGRAM COMPLETED"
        );

        System.out.println(
            "=============================================="
        );
    }
}