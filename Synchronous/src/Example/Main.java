package Example;

import Example.DataAccess.PaymentRepository;
import Example.Service.PaymentService;
import Example.Service.OrderService;

public class Main {
    public static void main(String[] args) {
        // Initialize services and repository
        PaymentService paymentService = new PaymentService();
        PaymentRepository paymentRepository = new PaymentRepository();
        OrderService orderService = new OrderService(paymentService, paymentRepository);

        long startTime = System.currentTimeMillis();

        // Place an order
        String paymentStatus = orderService.placeOrder();

        // Display payment status and completion
        System.out.println(paymentStatus);
        System.out.println("Order Placement Completed.");

        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken: " + (endTime - startTime) + "ms");
    }
}
