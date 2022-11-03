package Tingeso2Microservices.spreadsheetservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "spreadsheet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpreadsheetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(unique = true, nullable = true)
    private Long id;

    @Getter
    @Setter
    @Column(unique = true, nullable = true)
    private Long idEmployee;

    @Getter
    @Setter
    @Column(unique = true, nullable = true)
    private String rut;

    @Getter
    @Setter
    @Column(nullable = true)
    private String name;

    @Getter
    @Setter
    @Column(nullable = true)
    private char category;

    @Getter
    @Setter
    @Column(nullable = true)
    private String dateOfAdmission;

    @Getter
    @Setter
    @Column(nullable = true)
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
