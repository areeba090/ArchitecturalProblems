package Example.Model;

// Represents a payment object (if needed for future extension)
public class Payment {
    private String status;

    public Payment(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
