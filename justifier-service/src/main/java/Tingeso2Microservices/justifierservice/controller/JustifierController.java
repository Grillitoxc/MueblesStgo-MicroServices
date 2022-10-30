package Tingeso2Microservices.justifierservice.controller;

import Tingeso2Microservices.justifierservice.entity.JustifierEntity;
import Tingeso2Microservices.justifierservice.service.JustifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/justifier")
public class JustifierController {
    @Autowired
    JustifierService justifierService;

    @PostMapping
    public ResponseEntity<JustifierEntity> saveJustifier(@RequestBody JustifierEntity justifier) {
        justifierService.setJustifier(justifier);
        System.out.println(justifier);
        return ResponseEntity.ok(justifier);
    }

    @GetMapping
    public ResponseEntity<List<JustifierEntity>> getJustifier() {
        List<JustifierEntity> justifier = justifierService.getAllJustifiers();
        if (justifier == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(justifier);
    }
}
