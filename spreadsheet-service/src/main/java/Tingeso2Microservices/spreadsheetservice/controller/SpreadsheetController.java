package Tingeso2Microservices.spreadsheetservice.controller;

import Tingeso2Microservices.spreadsheetservice.entity.SpreadsheetEntity;
import Tingeso2Microservices.spreadsheetservice.service.SpreadsheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/spreadsheet")
public class SpreadsheetController {
    @Autowired
    SpreadsheetService spreadsheetService;

    @GetMapping
    @RolesAllowed("rrhh")
    public ResponseEntity<List<SpreadsheetEntity>> getSpreadsheet() {
        spreadsheetService.salaryCalculator();
        List<SpreadsheetEntity> spreadsheet = spreadsheetService.getSpreadsheet();
        return ResponseEntity.ok(spreadsheet);
    }
}
