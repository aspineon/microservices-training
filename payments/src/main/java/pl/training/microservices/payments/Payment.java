package pl.training.microservices.payments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

    @GeneratedValue
    @Id
    private Long id;
    private PaymentStatus status;
    private Instant timestamp;

}
