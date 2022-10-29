package Tingeso2Microservices.clockservice.service;

import Tingeso2Microservices.clockservice.entity.ClockEntity;
import Tingeso2Microservices.clockservice.repository.ClockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

@Service
public class UploadTimestampsService {

    private Path fileStorageLocation;

    @Autowired
    public void FileStorageService(UploadTimestampsConfig fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new UploadTimestampsException("Could not create the directory where the uploaded files will be stored.");
        }
    }

    // function to store de file
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new UploadTimestampsException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    RestTemplate restTemplate = new RestTemplate();
    public Long findIdByRut(String rut) {
        return restTemplate.getForObject("http://localhost:8080/employee/find_id_by_rut/" + rut, Long.class);
    }

    public int calculateDiscount(String hourImput) {
        int hour = Integer.parseInt(hourImput.substring(0, 2));
        int minutes = Integer.parseInt(hourImput.substring(3, 5));
        if (hour == 8 && minutes > 10 && minutes <= 25)
            return 1;
        else if (hour == 8 && minutes > 25 && minutes <= 45)
            return 3;
        else if ((hour == 8 && minutes > 45 && minutes <= 59) || (hour == 9 && minutes < 10))
            return 6;
        else if (hour > 9)
            return -1;
        else
            return 0;
    }

    // function to read the file
    @Autowired
    private ClockRepository clockRepository;

    public void readFile() {
        // find the route of the file Data.txt
        String filePath = "./src/main/resources/static/uploads/Data.txt";
        File file = new File(filePath);
        String dateTemp = "";
        String checkInTemp = "";
        String rutTemp = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                ClockEntity clockTemp = new ClockEntity();
                String line = scanner.nextLine();
                dateTemp = line.substring(0, 10);
                checkInTemp = line.substring(11, 16);
                rutTemp = line.substring(17, 29);
                if (clockRepository.findByDateAndId(dateTemp, findIdByRut(rutTemp)) == null) {
                    clockTemp.setDate(dateTemp);
                    clockTemp.setCheckInTime(checkInTemp);
                    clockTemp.setIdEmployee(findIdByRut(rutTemp));
                    if (calculateDiscount(checkInTemp) == 0)
                        clockTemp.setDiscount(0);
                    else if (calculateDiscount(checkInTemp) == 1)
                        clockTemp.setDiscount(1);
                    else if (calculateDiscount(checkInTemp) == 3)
                        clockTemp.setDiscount(3);
                    else if (calculateDiscount(checkInTemp) == 6)
                        clockTemp.setDiscount(6);
                    else
                        clockTemp.setDiscount(15);
                    clockRepository.save(clockTemp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
