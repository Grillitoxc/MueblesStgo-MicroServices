package Tingeso2Microservices.clockservice.controller;

import Tingeso2Microservices.clockservice.entity.ClockEntity;
import Tingeso2Microservices.clockservice.service.FileResponse;
import Tingeso2Microservices.clockservice.service.UploadTimestampsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/clock")
public class ClockController {
    @Autowired
    UploadTimestampsService uploadTimestampsService;

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
}
