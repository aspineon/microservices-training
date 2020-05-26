package pl.training.microservices.payments.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("payments")
public interface Payments {

    @PostMapping
    ResponseEntity<PaymentTo> process(PaymentRequestTo paymentRequestTo);

    @GetMapping
    List<PaymentTo> getPayments();

}
