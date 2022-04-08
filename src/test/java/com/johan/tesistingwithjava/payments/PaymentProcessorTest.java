package com.johan.tesistingwithjava.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.johan.tesistingwithjava.payments.PaymentResponse.PaymentStatus.ERROR;
import static com.johan.tesistingwithjava.payments.PaymentResponse.PaymentStatus.OK;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void init() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void paymentIsCorrect() {
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(OK));
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        boolean result = paymentProcessor.makePayment(1000);
        assertTrue(result);
    }

    @Test
    public void paymentIsWrong() {
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(ERROR));
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        boolean result = paymentProcessor.makePayment(1000);
        assertFalse(result);
    }
}