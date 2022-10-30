package Tingeso2Microservices.justifierservice.repository;

import Tingeso2Microservices.justifierservice.entity.JustifierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustifierRepository extends JpaRepository<JustifierEntity, Long> {
}
