package Tingeso2Microservices.clockservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadTimestampsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void saveFile(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String folder = "clock-service//src//main//resources//static//uploads//";
                Path path = Paths.get(folder + file.getOriginalFilename());
                Files.write(path, bytes);
                logger.info("Archivo guardado.");
            } catch (Exception e) {
                logger.error("Error al guardar el archivo.");
            }
        }
    }
}
