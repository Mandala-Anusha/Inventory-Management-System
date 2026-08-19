public class Supplier {

    private String supplierId;
    private String supplierName;
    private String contact;

    public Supplier(
            String supplierId,
            String supplierName,
            String contact) {

        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contact = contact;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return supplierName +
               " (" + supplierId +
               "), Contact: " +
               contact;
    }
}