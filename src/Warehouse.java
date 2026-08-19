public class Warehouse {

    private String warehouseId;
    private String warehouseName;

    // Composition
    private Address address;

    private static int warehouseCount = 0;

    public Warehouse(
            String warehouseId,
            String warehouseName,
            Address address) {

        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.address = address;

        warehouseCount++;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public Address getAddress() {
        return address;
    }

    // Static method
    public static int getWarehouseCount() {
        return warehouseCount;
    }

    @Override
    public String toString() {
        return warehouseName +
               " (" + warehouseId +
               "), Location: " +
               address;
    }
}