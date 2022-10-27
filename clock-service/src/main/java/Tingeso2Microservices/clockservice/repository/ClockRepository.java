package Tingeso2Microservices.clockservice.repository;

import Tingeso2Microservices.clockservice.entity.ClockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockRepository extends JpaRepository<ClockEntity, Long> {

}
