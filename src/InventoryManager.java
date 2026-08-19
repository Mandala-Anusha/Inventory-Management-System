public class InventoryManager {

    private static int transactionCount = 0;

    // Final constant
    public static final String COMPANY_NAME =
            "SRITW Inventory Solutions";

    // --------------------------------------------------------
    // Method Overloading - insert()
    // --------------------------------------------------------

    public void insert(
            String id,
            String name,
            double price,
            int quantity,
            Supplier supplier,
            Warehouse warehouse) {

        Item item = new Item(
            id,
            name,
            price,
            quantity,
            supplier,
            warehouse
        );

        insert(item);
    }

    public void insert(Item item) {

        if (item == null) {

            System.out.println(
                "Cannot insert null item."
            );

            return;
        }

        transactionCount++;

        System.out.println(
            "Item inserted successfully:"
        );

        System.out.println(item);
    }

    // --------------------------------------------------------
    // Method Overloading - addStock()
    // --------------------------------------------------------

    public void addStock(
            Item item,
            int quantity)
            throws InvalidStockException {

        item.addStock(quantity);

        transactionCount++;
    }

    public void addStock(Item item)
            throws InvalidStockException {

        addStock(item, 1);
    }

    // --------------------------------------------------------
    // Polymorphism
    // --------------------------------------------------------

    public void displayItem(
            InventoryEntity entity) {

        System.out.println(
            entity.getDetails()
        );
    }

    // --------------------------------------------------------
    // Update
    // --------------------------------------------------------

    public void update(Item item) {

        System.out.println(
            "Updated item: " +
            item
        );
    }

    // --------------------------------------------------------
    // Delete
    // --------------------------------------------------------

    public void delete(String itemId) {

        System.out.println(
            "Deleted item with ID: " +
            itemId
        );
    }

    // --------------------------------------------------------
    // Static Method
    // --------------------------------------------------------

    public static int getTransactionCount() {

        return transactionCount;
    }
}