public interface StockOperations {

    void addStock(int quantity)
            throws InvalidStockException;

    void removeStock(int quantity)
            throws InvalidStockException;

    int getStock();

    // Default Interface Method
    default void log(String message) {
        System.out.println(
            "STOCK LOG: " + message
        );
    }
}