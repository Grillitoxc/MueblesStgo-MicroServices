package Tingeso2Microservices.clockservice.controller;

import Tingeso2Microservices.clockservice.service.UploadTimestampsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/clock")
public class ClockController {
    @Autowired
    UploadTimestampsService uploadTimestampsService;

    @PostMapping("/upload")
    public String upload(@RequestParam("archivos") MultipartFile file, RedirectAttributes message) {
        if (file.isEmpty()) {
            message.addFlashAttribute("message", "Por favor seleccione un archivo.");
        } else {
            uploadTimestampsService.saveFile(file);
            message.addFlashAttribute("message", "Archivo subido correctamente.");
        }
        return "redirect:/";
    }
}
