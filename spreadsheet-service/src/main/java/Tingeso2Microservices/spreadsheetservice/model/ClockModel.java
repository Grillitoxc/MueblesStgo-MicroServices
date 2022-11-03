package Tingeso2Microservices.spreadsheetservice.model;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClockModel {
    @Getter
    @Setter
    @Column(nullable = false)
    private Long idEmployee;

    @Getter
    @Setter
    @Column(nullable = false)
    private String date;

    @Getter
    @Setter
    @Column(nullable = false)
    private String checkInTime;

    @Getter
    @Setter
    @Column(nullable = false)
    private int discount;
}
