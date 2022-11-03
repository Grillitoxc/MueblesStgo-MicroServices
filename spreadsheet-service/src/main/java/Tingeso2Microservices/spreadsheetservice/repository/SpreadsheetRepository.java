package Tingeso2Microservices.spreadsheetservice.repository;

import Tingeso2Microservices.spreadsheetservice.entity.SpreadsheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpreadsheetRepository extends JpaRepository<SpreadsheetEntity, Long> {
    SpreadsheetEntity findByRut(String rut);
}
