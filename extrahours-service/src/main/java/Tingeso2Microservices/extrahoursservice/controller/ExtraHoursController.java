package Tingeso2Microservices.extrahoursservice.controller;

import Tingeso2Microservices.extrahoursservice.entity.ExtraHoursEntity;
import Tingeso2Microservices.extrahoursservice.service.ExtraHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extrahours")
public class ExtraHoursController {
    @Autowired
    ExtraHoursService extraHoursService;

    @PostMapping
    public ResponseEntity<ExtraHoursEntity> saveExtraHours(@RequestBody ExtraHoursEntity extraHours) {
        extraHoursService.setExtraHours(extraHours);
        System.out.println(extraHours);
        return ResponseEntity.ok(extraHours);
    }

    @GetMapping
    public List<ExtraHoursEntity> getExtraHours() {
        return extraHoursService.getAllExtraHours();
    }

    @GetMapping("/find_by_name/{name}")
    public ResponseEntity<ExtraHoursEntity> findExtraHoursByName(@PathVariable("name") String name) {
        name = name.replace("-", " ");
        ExtraHoursEntity extraHours = extraHoursService.findByName(name);
        return ResponseEntity.ok(extraHours);
    }
}
