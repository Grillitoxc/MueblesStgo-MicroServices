package Tingeso2Microservices.employeeservice.controller;

import Tingeso2Microservices.employeeservice.entity.EmployeeEntity;
import Tingeso2Microservices.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    @RolesAllowed("rrhh")
    public ResponseEntity<List<EmployeeEntity>> getAll() {
        List<EmployeeEntity> employees = employeeService.getAllEmployees();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/find_id_by_rut/{rut}")
    @RolesAllowed("rrhh")
    public ResponseEntity<Long> findIdByRut(@PathVariable("rut") String rut) {
        Long id = employeeService.findIdByRut(rut);
        if (id == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(id);
    }

    @GetMapping("/find_id_by_name/{name}")
    @RolesAllowed("rrhh")
    public ResponseEntity<Long> findIdByName(@PathVariable("name") String name) {
        name = name.replace("-", " ");
        Long id = employeeService.findIdByName(name);
        if (id == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(id);
    }

    @GetMapping("/insert")
    @RolesAllowed("rrhh")
    public ResponseEntity<String> insert() {
        employeeService.insertEmployees();
        return ResponseEntity.ok("Insertados");
    }
}
