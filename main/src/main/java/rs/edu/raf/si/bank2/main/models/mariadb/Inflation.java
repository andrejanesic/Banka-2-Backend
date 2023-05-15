package rs.edu.raf.si.bank2.main.models.mariadb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(
        name = "inflations",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
// dodaj posle i currency?
public class Inflation implements Serializable {
    @Serial
    private static final long serialVersionUID = -2455017702141728532L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;
    private Float inflationRate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "currency_id")
    @Reference
    private Currency currency;
}
