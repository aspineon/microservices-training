package pl.training.microservices.payments.api;

import lombok.Data;

@Data
public class PaymentRequestTo {

    private Long amount;
    private CreditCardTo creditCard;

}
