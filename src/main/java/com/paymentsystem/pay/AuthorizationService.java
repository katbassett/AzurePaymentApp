
package com.paymentsystem.pay;
import java.util.*;

import org.springframework.stereotype.Service;


@Service
public class AuthorizationService {
    
    private final List<PaymentAuthorization> authorizedPayments = new ArrayList<>();

    public void authorizePayment(PaymentAuthorization payment) {
        authorizedPayments.add(payment);
    }

    public List<PaymentAuthorization> getAuthorizedPayments() {
        return new ArrayList<>(authorizedPayments);
    }

    public void clearAuthorizedPayments() {
        authorizedPayments.clear();
    }


}
