package pl.training.microservices.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    public Payment process(PaymentRequest paymentRequest) {
        // processing...
        Payment payment = Payment.builder()
                .status(PaymentStatus.STARTED)
                .timestamp(Instant.now())
                .build();
        return paymentsRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }

}
