package Example.Service;



import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class PaymentService {
    // Asynchronously processes the payment
    public CompletableFuture<String> processPayment() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulating delay of 3 seconds for payment processing
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Payment Processed";
        });
    }
}
