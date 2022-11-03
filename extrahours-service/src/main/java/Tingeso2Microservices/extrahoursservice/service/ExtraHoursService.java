package Tingeso2Microservices.extrahoursservice.service;

import Tingeso2Microservices.extrahoursservice.entity.ExtraHoursEntity;
import Tingeso2Microservices.extrahoursservice.repository.ExtraHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExtraHoursService {
    @Autowired
    ExtraHoursRepository extraHoursRepository;

    /*------------------*/
    /* SAVE EXTRA HOURS */
    /*------------------*/
    public void setExtraHours(ExtraHoursEntity extraHours) {
        if (verifyExtraHours(String.valueOf(extraHours.getHours())) &&
                extraHoursRepository.findByName(extraHours.getName()) == null) {
            int extraHoursInt = extraHours.getHours();
            if (extraHoursInt > 0 && extraHoursInt <= 30)
                extraHoursRepository.save(extraHours);
        }
    }

    /*--------------------------*/
    /* STANDARD SERVICE METHODS */
    /*--------------------------*/
    public boolean verifyExtraHours(String extraHours) {
        if (extraHours.length() > 0 && extraHours.length() < 3) {
            char[] extraHoursArray = extraHours.toCharArray();
            for (char c : extraHoursArray) {
                if (!Character.isDigit(c))
                    return false;
            }
            return Integer.parseInt(extraHours) > 0 && Integer.parseInt(extraHours) <= 12;
        }
        return false;
    }

    public List<ExtraHoursEntity> getAllExtraHours() {
        return extraHoursRepository.findAll();
    }

    public ExtraHoursEntity findByName(String name) {
        return extraHoursRepository.findByName(name);
    }

    /*---------------*/
    /* REST TEMPLATE */
    /*---------------*/
    RestTemplate restTemplate = new RestTemplate();


}
