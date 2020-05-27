package pl.training.microservices.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentsRepository extends JpaRepository<Payment, Long> {

    @Query("select p from Payment p where p.status = :status")
    List<Payment> getByStatus(@Param("status") PaymentStatus status);

}
