package Example.Service;

import Example.DataAccess.PaymentRepository;
import Example.Model.Payment;

public class OrderService {
    private PaymentService paymentService;
    private PaymentRepository paymentRepository;

    public OrderService(PaymentService paymentService, PaymentRepository paymentRepository) {
        this.paymentService = paymentService;
        this.paymentRepository = paymentRepository;
    }

    public String placeOrder() {
        System.out.println("Order Placement Started...");

        // Process payment
        String paymentStatus = paymentService.processPayment();
        Payment payment = new Payment(paymentStatus);

        // Save payment status
        paymentRepository.savePayment(payment);

        return paymentStatus;
    }
}