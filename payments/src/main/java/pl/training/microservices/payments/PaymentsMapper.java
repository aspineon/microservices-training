package pl.training.microservices.payments;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import pl.training.microservices.payments.api.CreditCardTo;
import pl.training.microservices.payments.api.PaymentRequestTo;
import pl.training.microservices.payments.api.PaymentStatusTo;
import pl.training.microservices.payments.api.PaymentTo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentsMapper {

    @Mapping(source = "expiration", target = "expirationDate")
    CreditCard toCreditCard(CreditCardTo creditCardTo);

    @ValueMapping(source = "STARTED", target = "NOT_CONFIRMED")
    PaymentStatusTo toPaymentStatusTo(PaymentStatus paymentStatus);

    PaymentRequest toPaymentRequest(PaymentRequestTo paymentRequestTo);

    PaymentTo toPaymentTo(Payment payment);

    List<PaymentTo> toPaymentTos(List<Payment> payments);

}
