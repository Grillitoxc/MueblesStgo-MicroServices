package Tingeso2Microservices.employeeservice;

import Tingeso2Microservices.employeeservice.entity.EmployeeEntity;
import Tingeso2Microservices.employeeservice.repository.EmployeeRepository;
import Tingeso2Microservices.employeeservice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeTest {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void insert() {
		int actualYear = 2022;
		EmployeeEntity employee1 = new EmployeeEntity();
		employee1.setRut("21.024.191-4");
		employee1.setName("Christopher Alejandro Torres Aceituno");
		employee1.setCategory('A');
		employee1.setDateOfAdmission("2005/01/01");
		employee1.setYearsOfService(actualYear - (Integer.parseInt(employee1.getDateOfAdmission().substring(0, 4))));
		employeeRepository.save(employee1);
		EmployeeEntity employee2 = new EmployeeEntity();
		employee2.setRut("21.014.566-4");
		employee2.setName("Vanina Antonia Correa Chávez");
		employee2.setCategory('A');
		employee2.setDateOfAdmission("2010/01/01");
		employee2.setYearsOfService(actualYear - (Integer.parseInt(employee2.getDateOfAdmission().substring(0, 4))));
		employeeRepository.save(employee2);
		EmployeeEntity employee3 = new EmployeeEntity();
		employee3.setRut("22.223.596-3");
		employee3.setName("Josed Aguilar Lopez Gutiérrez");
		employee3.setCategory('B');
		employee3.setDateOfAdmission("2015/01/01");
		employee3.setYearsOfService(actualYear - (Integer.parseInt(employee3.getDateOfAdmission().substring(0, 4))));
		employeeRepository.save(employee3);
		EmployeeEntity employee4 = new EmployeeEntity();
		employee4.setRut("20.123.456-7");
		employee4.setName("Pablo Enrique Román Aserjo");
		employee4.setCategory('C');
		employee4.setDateOfAdmission("2018/01/01");
		employee4.setYearsOfService(actualYear - (Integer.parseInt(employee4.getDateOfAdmission().substring(0, 4))));
		employeeRepository.save(employee4);
	}
}