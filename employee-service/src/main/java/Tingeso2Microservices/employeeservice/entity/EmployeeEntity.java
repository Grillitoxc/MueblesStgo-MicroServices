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
}
