public interface AlertService {

    void sendAlert(String message);

    // Default Interface Method
    default void alertLog(String message) {
        System.out.println(
            "ALERT LOG: " + message
        );
    }
}
