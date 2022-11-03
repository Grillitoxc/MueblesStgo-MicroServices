package Tingeso2Microservices.justifierservice.service;

import Tingeso2Microservices.justifierservice.entity.JustifierEntity;
import Tingeso2Microservices.justifierservice.model.ClockModel;
import Tingeso2Microservices.justifierservice.repository.JustifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JustifierService {
    @Autowired
    private JustifierRepository justifierRepository;

    /*-----------------*/
    /* SAVE JUSTIFIERS */
    /*-----------------*/
    public void setJustifier(JustifierEntity justifier) {
        if (verifyDate(justifier.getDate()) && (findByDateAndEmployeeId(justifier.getDate(), findIdByName(justifier.getName())) == null) ||
                (findByDateAndEmployeeId(justifier.getDate(), findIdByName(justifier.getName())).getDiscount() == 15)) {
            if (checkIfExist(justifier.getName(), justifier.getDate())) {
                justifierRepository.save(justifier);
            }
        }
    }

    /*--------------------------*/
    /* STANDARD SERVICE METHODS */
    /*--------------------------*/
    public boolean checkIfExist(String name, String date) {
        return findByDateAndName(date, name) == null;
    }

    public boolean verifyDate(String dateImput) {
        if (dateImput.length() != 10)
            return false;
        char firstSlash = dateImput.charAt(4);
        char secondSlash = dateImput.charAt(7);
        if (firstSlash != '/' || secondSlash != '/')
            return false;
        char[] date = (dateImput.substring(0, 4) + dateImput.substring(5, 7) + dateImput.substring(8, 10)).toCharArray();
        if (!verifyDigits(date))
            return false;
        return verifyInts(dateImput);
    }

    public boolean verifyDigits(char[] date) {
        for (char c : date) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    public boolean verifyInts(String date) {
        int yearInt = Integer.parseInt(date.substring(0, 4));
        int monthInt = Integer.parseInt(date.substring(5, 7));
        int dayInt = Integer.parseInt(date.substring(8, 10));
        return yearInt >= 2022 && monthInt >= 1 && monthInt <= 12 && dayInt >= 1 && dayInt <= 31;
    }

    public List<JustifierEntity> getAllJustifiers() {
        return justifierRepository.findAll();
    }

    public JustifierEntity findByDateAndName(String date, String name) {
        return justifierRepository.findByDateAndName(date, name);
    }

    /*---------------*/
    /* REST TEMPLATE */
    /*---------------*/
    RestTemplate restTemplate = new RestTemplate();

    public Long findIdByName(String name) {
        name = name.replace(" ", "-");
        return restTemplate.getForObject("http://localhost:8080/employee/find_id_by_name/" + name, Long.class);
    }

    public ClockModel findByDateAndEmployeeId(String date, Long id) {
        date = date.replace("/", "-");
        return restTemplate.getForObject("http://localhost:8080/clock/find_by_date_and_id/" + date + "/" + id, ClockModel.class);
    }
}