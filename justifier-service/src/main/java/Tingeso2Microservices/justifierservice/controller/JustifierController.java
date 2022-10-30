package Tingeso2Microservices.justifierservice.controller;

import Tingeso2Microservices.justifierservice.entity.JustifierEntity;
import Tingeso2Microservices.justifierservice.service.JustifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/justifier")
public class JustifierController {
    @Autowired
    JustifierService justifierService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<JustifierEntity> saveJustifier(@RequestBody JustifierEntity justifier) {
        justifierService.setJustifier(justifier);
        System.out.println(justifier);
        return ResponseEntity.ok(justifier);
    }
}
