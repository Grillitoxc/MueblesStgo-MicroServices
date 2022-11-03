package Tingeso2Microservices.clockservice.service;

import Tingeso2Microservices.clockservice.entity.ClockEntity;
import Tingeso2Microservices.clockservice.repository.ClockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockService {
    @Autowired
    ClockRepository clockRepository;

    public ClockEntity setDiscountZero(String date, Long id) {
        ClockEntity clock = clockRepository.findByDateAndIdEmployee(date, id);
        clock.setDiscount(0);
        clockRepository.save(clock);
        return clock;
    }

    public List<Integer> findDiscountById(Long id) {
        return clockRepository.findDiscountById(id);
    }
}
