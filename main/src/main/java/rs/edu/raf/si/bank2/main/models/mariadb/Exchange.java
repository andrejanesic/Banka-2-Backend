package rs.edu.raf.si.bank2.main.models.mariadb;

import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.index.Indexed;

@Data
// @Builder
@AllArgsConstructor
// @RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "exchange",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"acronym", "micCode"}),
        })
public class Exchange { // implements Serializable {

    // @Serial
    // private static final long serialVersionUID = 2055316560326652442L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exchangeName;

    @Indexed
    private String acronym;

    @NotNull
    @Indexed
    private String micCode;

    private String polity;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    // @Fetch(FetchMode.SELECT)
    // @Reference
    private Currency currency;

    private String timeZone;
    private String openTime;
    private String closeTime;

    @ElementCollection
    @CollectionTable(name = "exchange_calendar", joinColumns = @JoinColumn(name = "exchange_id"))
    // TODO izostavlja se polje iz rezultata!
    // @JsonIgnore
    @Column(name = "calendar_value")
    private Collection<String> calendar;

    public Exchange(
            String exchangeName,
            String acronym,
            String micCode,
            String polity,
            Currency currency,
            String timeZone,
            String openTime,
            String closeTime) {
        this.exchangeName = exchangeName;
        this.acronym = acronym;
        this.micCode = micCode;
        this.polity = polity;
        this.currency = currency;
        this.timeZone = timeZone;
        this.openTime = openTime;
        this.closeTime = closeTime;
        //        this.calendar = calendar;
    }
}
