package Tingeso2Microservices.employeeservice.service;

import Tingeso2Microservices.employeeservice.entity.EmployeeEntity;
import Tingeso2Microservices.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Long findIdByRut(String rut) {
        return employeeRepository.findIdByRut(rut);
    }

    public Long findIdByName(String name) { return employeeRepository.findIdByName(name);
    }
}
