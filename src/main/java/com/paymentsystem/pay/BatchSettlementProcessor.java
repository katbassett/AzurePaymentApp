package com.paymentsystem.pay;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
//Test Git Push

@Component
public class BatchSettlementProcessor {

    private final PaymentService paymentService;

    public BatchSettlementProcessor(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Scheduled(fixedRate = 6000) // runs every 6 seconds
    public void processBatch() {
        List<Payment> batch = paymentService.getAuthorizedPayments();

        if (batch.isEmpty()) {
            System.out.println("No payments to process.");
            return;
        }

        System.out.println("= Processing Batch Settlement =");
        for (Payment payment : batch) {
            System.out.println("Settling: " + payment.getCardHolderName() + " - $" + payment.getAmount());
        }

        paymentService.clearAuthorizedPayments();
        System.out.println("= Batch Processing Complete =");
    }
}