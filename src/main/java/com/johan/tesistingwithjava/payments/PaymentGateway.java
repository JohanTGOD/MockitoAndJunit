package com.johan.tesistingwithjava.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
