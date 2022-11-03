package Tingeso2Microservices.clockservice.controller;

import Tingeso2Microservices.clockservice.entity.ClockEntity;
import Tingeso2Microservices.clockservice.service.ClockService;
import Tingeso2Microservices.clockservice.service.FileResponse;
import Tingeso2Microservices.clockservice.service.UploadTimestampsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/clock")
public class ClockController {
    @Autowired
    UploadTimestampsService uploadTimestampsService;
    @Autowired
    ClockService clockService;

    @PostMapping
    public ResponseEntity<FileResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = uploadTimestampsService.storeFile(file);
        FileResponse fileResponse = new FileResponse(fileName, file.getContentType(), file.getSize());
        return new ResponseEntity<FileResponse>(fileResponse, HttpStatus.OK);
    }

    @GetMapping("find_by_date_and_id/{date}/{id}")
    public ResponseEntity<ClockEntity> findByDateAndEmployeeId(@PathVariable("date") String date, @PathVariable("id") Long id) {
        date = date.replace("-", "/");
        ClockEntity clock = uploadTimestampsService.findByDateAndIdEmployee(date, id);
        return ResponseEntity.ok(clock);
    }

    @GetMapping("set_discount_zero/{date}/{id}")
    public ResponseEntity<ClockEntity> setDiscountZero(@PathVariable("date") String date, @PathVariable("id") Long id) {
        date = date.replace("-", "/");
        ClockEntity clock = clockService.setDiscountZero(date, id);
        return ResponseEntity.ok(clock);
    }

    @GetMapping("find_discounts_by_id/{id}")
    public ResponseEntity<List> getDiscountById(@PathVariable("id") Long id) {
        List discount = clockService.findDiscountById(id);
        return ResponseEntity.ok(discount);
    }
}
