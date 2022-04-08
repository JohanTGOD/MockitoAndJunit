package com.johan.tesistingwithjava.payments;

import static com.johan.tesistingwithjava.payments.PaymentResponse.PaymentStatus.OK;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        PaymentResponse paymentResponse = paymentGateway.requestPayment(new PaymentRequest(amount));
        return paymentResponse.getPaymentStatus() == OK;
    }
}
