package pl.training.microservices.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Log
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
        Payment savedPayment = paymentsRepository.save(payment);
        log.info("New payment: " + savedPayment);
        return savedPayment;
    }

    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }

}
