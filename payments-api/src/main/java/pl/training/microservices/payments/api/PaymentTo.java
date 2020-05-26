package pl.training.microservices.payments.api;

import lombok.Data;

import java.time.Instant;

@Data
public class PaymentTo {

    private Long id;
    private PaymentStatusTo status;
    private Instant timestamp;

}
