package com.paymentsystem.pay;

//* Author: Kat Bassett */

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
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
