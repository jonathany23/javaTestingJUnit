package org.jonathany23.javatests.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before //Antes de ejecutar cada test. Antes ejecuta el metodo setup
    public void setup(){
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void paymentIsCorrect() {
        //Preparacion del ecenario
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        //LLamada al metodo que queremos probar
        boolean result = paymentProcessor.makePayment(1000);

        //Comprobacion de resultado
        assertTrue(result);
    }

    @Test
    public void paymentIsWrong() {
        //Preparacion del ecenario
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        //LLamada al metodo que queremos probar
        boolean result = paymentProcessor.makePayment(1000);

        //Comprobacion de resultado
        assertFalse(result);
    }
}