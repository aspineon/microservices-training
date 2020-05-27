package pl.training.microservices.orders.payments;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.ValueMapping;
import pl.training.microservices.payments.api.CreditCardTo;
import pl.training.microservices.payments.api.PaymentStatusTo;
import pl.training.microservices.payments.api.PaymentTo;
import pl.training.microservices.payments.api.PaymentRequestTo;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PaymentsMapper {

    Payment toPayment(PaymentTo paymentTo);

    @ValueMapping(source = "NOT_CONFIRMED", target = "STARTED")
    PaymentStatus toPaymentStatus(PaymentStatusTo paymentStatusTo);

    PaymentRequestTo toPaymentRequestTo(PaymentsRequest paymentsRequest);

    CreditCardTo toCreditCardTo(CreditCard creditCard);

}
