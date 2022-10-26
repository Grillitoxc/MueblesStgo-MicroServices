package Tingeso2Microservices.employeeservice;

import Tingeso2Microservices.employeeservice.entity.Employee;
import Tingeso2Microservices.employeeservice.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeTest {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void insert() {
		Employee employee = new Employee();
		employee.setName("Vaninaxc");
		employee.setRut("21.014.566-4");
		employeeRepository.save(employee);
	}
}