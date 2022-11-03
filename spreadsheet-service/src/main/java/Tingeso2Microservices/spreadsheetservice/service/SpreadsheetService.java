package Tingeso2Microservices.spreadsheetservice.service;

import Tingeso2Microservices.spreadsheetservice.entity.SpreadsheetEntity;
import Tingeso2Microservices.spreadsheetservice.model.ClockModel;
import Tingeso2Microservices.spreadsheetservice.model.EmployeeModel;
import Tingeso2Microservices.spreadsheetservice.model.ExtraHoursModel;
import Tingeso2Microservices.spreadsheetservice.model.JustifierModel;
import Tingeso2Microservices.spreadsheetservice.repository.SpreadsheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SpreadsheetService {
    @Autowired
    private SpreadsheetRepository spreadsheetRepository;

    /*-------------------*/
    /* SALARY CALCULATOR */
    /*-------------------*/
    public void salaryCalculator() {
        // getAllEmployees
        EmployeeModel[] employees = getAllEmployees();
        // print
        for (EmployeeModel employee : employees) {
            /* Definición de variables */
            int yearsBonus;
            int extraHoursMoney;
            int discountsByMissing;
            int totalDiscount;
            double forecastQuote = 0.1;
            double healthQuote = 0.08;
            setFixedSalary(employee);
            double baseSalary = employee.getFixedSalary();

            extraHoursMoney = checkExtraHours(employee);
            yearsBonus = calculateYearsOfServiceBonus(employee);
            discountsByMissing = checkAndSetJustifiers(employee);
            totalDiscount = addDiscounts(employee);

            /* Porcentaje de bonificación por años de servicio */
            double yearsBonusPercentage = formatterDecimals((yearsBonus / 100.0));
            double yearBonusMoney = baseSalary * yearsBonusPercentage;
            /* Descuentos por faltas sin justificar y atrasos */
            double totalDiscountsPercentage = formatterDecimals(((totalDiscount + discountsByMissing) / 100.0));
            double totalDiscountsMoney = baseSalary * totalDiscountsPercentage;
            /* Sueldo bruto */
            double grossSalary = baseSalary + yearBonusMoney + extraHoursMoney;
            /* Cotizaciones */
            double forecastQuoteMoney = baseSalary * forecastQuote;
            double healthQuoteMoney = baseSalary * healthQuote;
            double totalDiscountsMoneyWithQuotes = totalDiscountsMoney + forecastQuoteMoney + healthQuoteMoney;
            /* Sueldo neto (final) */
            double netSalary = grossSalary - totalDiscountsMoneyWithQuotes;

            /* Actualización de datos */
            SpreadsheetEntity spreadsheet = new SpreadsheetEntity();
            spreadsheet.setIdEmployee(findIdByName(employee.getName()));
            spreadsheet.setRut(employee.getRut());
            spreadsheet.setName(employee.getName());
            spreadsheet.setCategory(employee.getCategory());
            spreadsheet.setDateOfAdmission(employee.getDateOfAdmission());
            spreadsheet.setYearsOfService(employee.getYearsOfService());
            spreadsheet.setFixedSalary(employee.getFixedSalary());
            /*-----------------------------------------------------------*/
            spreadsheet.setGrossSalary(grossSalary);
            spreadsheet.setYearsOfServiceBonus(yearBonusMoney);
            spreadsheet.setDiscounts(totalDiscountsMoney);
            spreadsheet.setExtraHoursBonus(extraHoursMoney);
            spreadsheet.setForecastQuote(forecastQuoteMoney);
            spreadsheet.setHealthQuote(healthQuoteMoney);
            spreadsheet.setFinalSalary(netSalary);

            if (spreadsheetRepository.findByRut(spreadsheet.getRut()) == null) {
                spreadsheetRepository.save(spreadsheet);
            } else {
                SpreadsheetEntity spreadsheetTemp = spreadsheetRepository.findByRut(spreadsheet.getRut());
                // delete
                spreadsheetRepository.delete(spreadsheetTemp);
                spreadsheetRepository.save(spreadsheet);
            }
        }
    }

    /*--------------------------*/
    /* STANDARD SERVICE METHODS */
    /*--------------------------*/
    public List<SpreadsheetEntity> getSpreadsheet() {
        return spreadsheetRepository.findAll();
    }

    public int addDiscounts(EmployeeModel employee) {
        int totalDiscount = 0;
        Integer[] discounts = findDiscountsById(findIdByName(employee.getName()));
        for (Integer discount : discounts) {
            totalDiscount += discount;
        }
        return totalDiscount;
    }

    public int checkAndSetJustifiers(EmployeeModel employee) {
        int discountsByMissing = 0;
        for (int i = 17; i < 22; i++) {
            String date = "2022/08/" + i;
            // Sobreescribir descuentos de atraso con justificativo
            if (findByDateAndName(date, employee.getName()) != null) {
                Long idTemp = findIdByName(employee.getName());
                if (findByDateAndEmployeeId(date, idTemp) != null) {
                    ClockModel clockTemp = setDiscountZero(date, findIdByName(employee.getName()));
                }
            }
            // Días donde se faltó y no hay justificativo
            if ((findByDateAndName(date, employee.getName()) == null) &&
                    (findByDateAndEmployeeId(date, findIdByName(employee.getName())) == null)) {
                discountsByMissing += 15;
            }
        }
        return discountsByMissing;
    }

    public int calculateYearsOfServiceBonus(EmployeeModel employee) {
        int years = employee.getYearsOfService();
        int yearsBonus;
        if (years >= 5 && years < 10)
            yearsBonus = 5;
        else if (years >= 10 && years < 15)
            yearsBonus = 8;
        else if (years >= 15 && years < 20)
            yearsBonus = 11;
        else if (years >= 20 && years < 25)
            yearsBonus = 14;
        else if (years >= 25)
            yearsBonus = 17;
        else
            yearsBonus = 0;
        return yearsBonus;
    }

    public int checkExtraHours(EmployeeModel employee) {
        char category = employee.getCategory();
        int multiplier = 1;
        if (findByName(employee.getName()) != null) {
            if (category == 'A')
                multiplier = 25000;
            else if (category == 'B')
                multiplier = 20000;
            else if (category == 'C')
                multiplier = 10000;
            return findByName(employee.getName()).getHours() * multiplier;
        }
        return 0;
    }

    public void setFixedSalary(EmployeeModel employee) {
        char category = employee.getCategory();
        if (category == 'A')
            employee.setFixedSalary(1700000);
        else if (category == 'B')
            employee.setFixedSalary(1200000);
        else if (category == 'C')
            employee.setFixedSalary(800000);
    }

    public Double formatterDecimals(Double numero) {
        return Math.round(numero * Math.pow(10, 2)) / Math.pow(10, 2);

    }

    /*---------------*/
    /* REST TEMPLATE */
    /*---------------*/
    RestTemplate restTemplate = new RestTemplate();

    public EmployeeModel[] getAllEmployees() {
        return restTemplate.getForObject("http://localhost:8080/employee", EmployeeModel[].class);
    }

    public ExtraHoursModel findByName(String name) {
        name = name.replace(" ", "-");
        return restTemplate.getForObject("http://localhost:8080/extrahours/find_by_name/" + name, ExtraHoursModel.class);
    }

    public JustifierModel findByDateAndName(String date, String name) {
        date = date.replace("/", "-");
        name = name.replace(" ", "-");
        return restTemplate.getForObject("http://localhost:8080/justifier/find_by_date_and_name/" + date + "/" + name, JustifierModel.class);
    }

    public ClockModel findByDateAndEmployeeId(String date, Long id) {
        date = date.replace("/", "-");
        return restTemplate.getForObject("http://localhost:8080/clock/find_by_date_and_id/" + date + "/" + id, ClockModel.class);
    }

    public ClockModel setDiscountZero(String date, Long id) {
        date = date.replace("/", "-");
        return restTemplate.getForObject("http://localhost:8080/clock/set_discount_zero/" + date + "/" + id, ClockModel.class);
    }

    public Integer[] findDiscountsById(Long id) {
        return restTemplate.getForObject("http://localhost:8080/clock/find_discounts_by_id/" + id, Integer[].class);
    }

    public Long findIdByName(String name) {
        name = name.replace(" ", "-");
        return restTemplate.getForObject("http://localhost:8080/employee/find_id_by_name/" + name, Long.class);
    }
}
