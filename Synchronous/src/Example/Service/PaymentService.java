package Example.Service;

import Example.DataAccess.PaymentRepository;
import Example.Model.Payment;

import java.util.concurrent.TimeUnit;

public class PaymentService {
    // Simulates processing the payment
    public String processPayment() {
        try {
            // Simulating delay of 3 seconds
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Payment Processed";
    }
}

