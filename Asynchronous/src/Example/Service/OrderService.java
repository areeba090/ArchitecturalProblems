package Example.Service;



import Example.DataAccess.PaymentRepository;
import Example.Model.Payment;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OrderService {
    private PaymentService paymentService;
    private PaymentRepository paymentRepository;

    // Constructor to initialize PaymentService and PaymentRepository
    public OrderService(PaymentService paymentService, PaymentRepository paymentRepository) {
        this.paymentService = paymentService;
        this.paymentRepository = paymentRepository;
    }

    // Method to place an order asynchronously
    public void placeOrder() throws ExecutionException, InterruptedException {
        System.out.println("Order Placement Started...");

        // Process payment asynchronously
        CompletableFuture<String> paymentFuture = paymentService.processPayment();

        // Do other tasks if necessary, e.g., preparing the order or inventory management
        // (For this case, we are not doing additional tasks)

        // Wait for the payment to complete
        String paymentStatus = paymentFuture.get();  // Blocks until payment is processed

        // Create Payment object and save the status
        Payment payment = new Payment(paymentStatus);
        paymentRepository.savePayment(payment);

        System.out.println(paymentStatus);
        System.out.println("Order Placement Completed.");
    }
}
