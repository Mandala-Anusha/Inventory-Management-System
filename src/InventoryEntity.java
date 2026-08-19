public abstract class InventoryEntity {

    private String id;
    private String name;

    static String organization;

    // Static Block
    static {
        organization = "SRITW Inventory Solutions";
        System.out.println(
            "Static block executed. Organization initialized."
        );
    }

    public InventoryEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method
    public abstract String getDetails();
}