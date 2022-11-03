package Tingeso2Microservices.clockservice.repository;

import Tingeso2Microservices.clockservice.entity.ClockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClockRepository extends JpaRepository<ClockEntity, Long> {
    ClockEntity findByDateAndIdEmployee(String date, Long id);

    @Query(value = "SELECT discount FROM clock WHERE id_employee = ?1", nativeQuery = true)
    List<Integer> findDiscountById(Long id);
}
