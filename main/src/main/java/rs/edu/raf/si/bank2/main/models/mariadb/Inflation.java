package rs.edu.raf.si.bank2.main.models.mariadb;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(
        name = "inflations",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
// dodaj posle i currency?
public class Inflation { // implements Serializable {
    // @Serial
    // private static final long serialVersionUID = -2455017702141728532L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;
    private Float inflationRate;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    // @JsonIgnore
    // @Reference
    private Currency currency;
}
