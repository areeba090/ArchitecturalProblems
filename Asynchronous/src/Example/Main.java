package Example;

import Example.DataAccess.PaymentRepository;
import Example.Service.PaymentService;
import Example.Service.OrderService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Initialize services and repository
        PaymentService paymentService = new PaymentService();
        PaymentRepository paymentRepository = new PaymentRepository();
        OrderService orderService = new OrderService(paymentService, paymentRepository);

        // Use ExecutorService for better thread management
        ExecutorService executorService = Executors.newFixedThreadPool(5);  // More threads for concurrency

        long startTime = System.currentTimeMillis();

        // Simulate placing multiple orders concurrently
        CompletableFuture<Void> order1 = CompletableFuture.runAsync(() -> {
            try {
                orderService.placeOrder();
            } catch (Exception e) {
                System.out.println("Error processing payment for order 1: " + e.getMessage());
            }
        }, executorService);

        CompletableFuture<Void> order2 = CompletableFuture.runAsync(() -> {
            try {
                orderService.placeOrder();
            } catch (Exception e) {
                System.out.println("Error processing payment for order 2: " + e.getMessage());
            }
        }, executorService);

        CompletableFuture<Void> order3 = CompletableFuture.runAsync(() -> {
            try {
                orderService.placeOrder();
            } catch (Exception e) {
                System.out.println("Error processing payment for order 3: " + e.getMessage());
            }
        }, executorService);

        // Wait for all orders to be processed
        try {
            CompletableFuture.allOf(order1, order2, order3).get();  // Wait for all orders to complete
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error waiting for the tasks to complete: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken: " + (endTime - startTime) + "ms");

        // Shutdown the executor
        executorService.shutdown();
    }
}
