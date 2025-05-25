package com.paymentsystem.pay;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BatchSettlementProcessor {

    private final AuthorizationService authorizationService;

    public BatchSettlementProcessor(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Scheduled(fixedRate = 60000)  // every 60 seconds
    public void processBatch() {
        List<PaymentAuthorization> batch = authorizationService.getAuthorizedPayments();

        if (batch.isEmpty()) {
            System.out.println("No payments to process.");
            return;
        }

        System.out.println("Processing batch of " + batch.size() + " payments...");

        for (PaymentAuthorization auth : batch) {
            System.out.println("Settling: " + auth.getCardNumber() + " - $" + auth.getAmount());
        }

        authorizationService.clearAuthorizedPayments();
    }
}

