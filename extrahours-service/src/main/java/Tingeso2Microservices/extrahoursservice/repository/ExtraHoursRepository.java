package Tingeso2Microservices.extrahoursservice.repository;

import Tingeso2Microservices.extrahoursservice.entity.ExtraHoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraHoursRepository extends JpaRepository<ExtraHoursEntity, Long> {
    ExtraHoursEntity findByName(String name);
}
