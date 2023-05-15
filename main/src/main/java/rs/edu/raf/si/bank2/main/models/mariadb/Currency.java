package rs.edu.raf.si.bank2.main.models.mariadb;

import java.util.List;
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
        name = "currencies",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
// dodaj posle i ostale atribute
public class Currency { // implements Serializable {
    // @Serial
    // private static final long serialVersionUID = 8037905551051265919L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currencyName;
    private String currencyCode;
    private String currencySymbol;
    private String polity;

    @OneToMany(mappedBy = "currency")
    // TODO izostavlja se polje iz rezultata!
    // @JsonIgnore
    // @Reference
    private List<Inflation> inflations;
}
