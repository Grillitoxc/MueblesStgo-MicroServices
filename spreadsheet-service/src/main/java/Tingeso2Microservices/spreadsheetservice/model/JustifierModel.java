package Tingeso2Microservices.spreadsheetservice.model;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JustifierModel {
    @Getter
    @Setter
    @Column(nullable = false)
    private String date;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;
}
