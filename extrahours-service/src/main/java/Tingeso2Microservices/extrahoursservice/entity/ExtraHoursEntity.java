package Tingeso2Microservices.extrahoursservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "extra_hours")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraHoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private int hours;
}
