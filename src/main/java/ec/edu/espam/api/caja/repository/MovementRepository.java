package ec.edu.espam.api.caja.repository;

import ec.edu.espam.api.caja.domain.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
    List<Movement> findByAccountId(Long accountId);
    @Query("select SUM(m.amount) from Movement m where m.account.id = ?1 and m.date = ?2 and m.type = ?3")
    BigDecimal getAllAmountByAccountIdAndDateAndType(Long accountId, LocalDate data, Movement.Type type);
    @Query(nativeQuery = true, value = "SELECT TOP 1 * FROM MOVEMENT WHERE ACCOUNT_ID = :accountId ORDER BY DATE, ID DESC")
    Optional<Movement> findByAccountOrderByDateDesc(Long accountId);
}
