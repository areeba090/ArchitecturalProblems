package Example.DataAccess;



import Example.Model.Payment;

public class PaymentRepository {
    // Simulates saving the payment status
    public void savePayment(Payment payment) {
        System.out.println("Payment status saved: " + payment.getStatus());
    }
}

