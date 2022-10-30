package Tingeso2Microservices.justifierservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "justifier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JustifierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String date;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;
}
