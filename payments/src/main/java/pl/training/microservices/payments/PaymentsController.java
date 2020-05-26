package pl.training.microservices.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.training.microservices.payments.api.PaymentRequestTo;
import pl.training.microservices.payments.api.PaymentTo;
import pl.training.microservices.payments.api.Payments;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PaymentsController implements Payments {

    private final PaymentsService paymentsService;
    private final PaymentsMapper paymentsMapper;

    @Override
    public ResponseEntity<PaymentTo> process(PaymentRequestTo paymentRequestTo) {
        PaymentRequest paymentRequest = paymentsMapper.toPaymentRequest(paymentRequestTo);
        Payment payment = paymentsService.process(paymentRequest);
        return ResponseEntity.accepted()
                .body(paymentsMapper.toPaymentTo(payment));
    }

    @Override
    public List<PaymentTo> getPayments() {
        return paymentsMapper.toPaymentTos(paymentsService.getAllPayments());
    }

}
