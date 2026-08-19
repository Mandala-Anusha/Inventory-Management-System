public class Item extends InventoryEntity
        implements StockOperations, AlertService {

    private double price;
    private int quantity;

    // Composition
    private Supplier supplier;
    private Warehouse warehouse;

    private static int itemCount = 0;

    // Final constant
    public static final int LOW_STOCK_LIMIT = 10;

    // --------------------------------------------------------
    // Inner Class
    // --------------------------------------------------------
    class StockDetails {

        private int minimumStock;
        private int maximumStock;

        public StockDetails(
                int minimumStock,
                int maximumStock) {

            this.minimumStock = minimumStock;
            this.maximumStock = maximumStock;
        }

        public void displayStockLimits() {

            System.out.println(
                "Minimum Stock: " +
                minimumStock
            );

            System.out.println(
                "Maximum Stock: " +
                maximumStock
            );
        }
    }

    // --------------------------------------------------------
    // Constructor
    // --------------------------------------------------------
    public Item(
            String id,
            String name,
            double price,
            int quantity,
            Supplier supplier,
            Warehouse warehouse) {

        super(id, name);

        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.warehouse = warehouse;

        itemCount++;
    }

    // --------------------------------------------------------
    // Copy Constructor
    // --------------------------------------------------------
    public Item(Item item) {

        super(
            item.getId(),
            item.getName()
        );

        this.price = item.price;
        this.quantity = item.quantity;
        this.supplier = item.supplier;
        this.warehouse = item.warehouse;

        itemCount++;
    }

    // --------------------------------------------------------
    // Getters and Setters
    // --------------------------------------------------------

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    // --------------------------------------------------------
    // Method Overriding
    // --------------------------------------------------------

    @Override
    public String getDetails() {

        return "Item: " +
               getName() +
               ", ID: " +
               getId() +
               ", Price: ₹" +
               price +
               ", Quantity: " +
               quantity +
               ", Supplier: " +
               supplier.getSupplierName() +
               ", Warehouse: " +
               warehouse.getWarehouseName();
    }

    // --------------------------------------------------------
    // Stock Operations
    // --------------------------------------------------------

    @Override
    public void addStock(int quantity)
            throws InvalidStockException {

        if (quantity <= 0) {

            throw new InvalidStockException(
                "Stock quantity must be greater than zero."
            );
        }

        this.quantity += quantity;

        log(
            quantity +
            " units added to " +
            getName()
        );
    }

    @Override
    public void removeStock(int quantity)
            throws InvalidStockException {

        if (quantity <= 0) {

            throw new InvalidStockException(
                "Removal quantity must be greater than zero."
            );
        }

        if (quantity > this.quantity) {

            throw new InvalidStockException(
                "Insufficient stock available."
            );
        }

        this.quantity -= quantity;

        log(
            quantity +
            " units removed from " +
            getName()
        );

        // Low stock alert
        if (this.quantity <= LOW_STOCK_LIMIT) {

            sendAlert(
                "Low stock alert for " +
                getName() +
                ". Current stock: " +
                this.quantity
            );
        }
    }

    @Override
    public int getStock() {
        return quantity;
    }

    // --------------------------------------------------------
    // Alert Service
    // --------------------------------------------------------

    @Override
    public void sendAlert(String message) {

        System.out.println(
            "ALERT: " + message
        );

        alertLog(message);
    }

    // --------------------------------------------------------
    // Static Method
    // --------------------------------------------------------

    public static int getItemCount() {
        return itemCount;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}