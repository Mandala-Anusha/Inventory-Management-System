public class Address {

    private String city;
    private String state;
    private String pincode;

    public Address(
            String city,
            String state,
            String pincode) {

        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    @Override
    public String toString() {
        return city + ", " +
               state + " - " +
               pincode;
    }
}