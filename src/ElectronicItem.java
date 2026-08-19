public class ElectronicItem extends Item {

    private int warrantyMonths;

    public ElectronicItem(
            String id,
            String name,
            double price,
            int quantity,
            Supplier supplier,
            Warehouse warehouse,
            int warrantyMonths) {

        super(
            id,
            name,
            price,
            quantity,
            supplier,
            warehouse
        );

        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getDetails() {

        return super.getDetails() +
               ", Warranty: " +
               warrantyMonths +
               " months";
    }
}