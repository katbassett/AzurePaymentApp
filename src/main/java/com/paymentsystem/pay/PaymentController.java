package com.paymentsystem.pay;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpServletResponse;


@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/")
    public void redirectToPaymentPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/payment.html");
}

    @PostMapping("/make-payment")
    public ResponseEntity<String> handlePayment(@ModelAttribute Payment payment, HttpServletResponse response) throws IOException {
        double amount = Double.parseDouble(payment.getAmount());

        if (amount > 1000) {
            response.sendRedirect("/declined.html");
            return ResponseEntity.status(302).header("Location", "/declined.html").body("Redirecting to declined page");
        } else {
            paymentService.addAuthorizedPayment(payment);

            response.sendRedirect("/confirmation.html");
            return ResponseEntity.status(302).header("Location", "/confirmation.html").body("Redirecting to confirmation page");
        }
    }
}