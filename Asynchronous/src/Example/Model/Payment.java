package Example.Model;



public class Payment {
    private String status;

    // Constructor to initialize payment status
    public Payment(String status) {
        this.status = status;
    }

    // Getter for payment status
    public String getStatus() {
        return status;
    }

    // Setter for payment status
    public void setStatus(String status) {
        this.status = status;
    }
}

