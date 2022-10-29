package Tingeso2Microservices.employeeservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String rut;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private char category;

    @Getter
    @Setter
    @Column(nullable = false)
    private String dateOfAdmission;

    @Getter
    @Setter
    @Column(nullable = false)
    private int yearsOfService;

    @Getter
    @Setter
    @Column(nullable = true)
    private double fixedSalary;

    @Getter
    @Setter
    @Column(nullable = true)
    private double yearsOfServiceBonus;

    @Getter
    @Setter
    @Column(nullable = true)
    private double extraHoursBonus;

    @Getter
    @Setter
    @Column(nullable = true)
    private double discounts;

    @Getter
    @Setter
    @Column(nullable = true)
    private double grossSalary;

    @Getter
    @Setter
    @Column(nullable = true)
    private double forecastQuote;

    @Getter
    @Setter
    @Column(nullable = true)
    private double healthQuote;

    @Getter
    @Setter
    @Column(nullable = true)
    private double finalSalary;
}
