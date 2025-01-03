package Example.DataAccess;

import Example.Model.Payment;

public class PaymentRepository {
    public String savePayment(Payment payment) {
        // Simulates saving payment status (mock implementation)
        return payment.getStatus();
    }
}

