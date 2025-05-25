package com.paymentsystem.pay;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private final List<Payment> authorizedPayments = new ArrayList<>();

    public void addAuthorizedPayment(Payment payment) {
        authorizedPayments.add(payment);
    }

    public List<Payment> getAuthorizedPayments() {
        return new ArrayList<>(authorizedPayments);
    }

    public void clearAuthorizedPayments() {
        authorizedPayments.clear();
    }
    
}
