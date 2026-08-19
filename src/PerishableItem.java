public class PerishableItem extends Item {

    private String expiryDate;

    public PerishableItem(
            String id,
            String name,
            double price,
            int quantity,
            Supplier supplier,
            Warehouse warehouse,
            String expiryDate) {

        super(
            id,
            name,
            price,
            quantity,
            supplier,
            warehouse
        );

        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String getDetails() {

        return super.getDetails() +
               ", Expiry Date: " +
               expiryDate;
    }
}
