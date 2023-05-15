package rs.edu.raf.si.bank2.main.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.bank2.main.models.mariadb.Inflation;
import rs.edu.raf.si.bank2.main.repositories.mariadb.InflationRepository;
import rs.edu.raf.si.bank2.main.services.interfaces.InflationServiceInterface;

@Service
public class InflationService implements InflationServiceInterface {
    private final InflationRepository inflationRepository;

    @Autowired
    public InflationService(InflationRepository inflationRepository) {
        this.inflationRepository = inflationRepository;
    }

    @Override
    // @Cacheable(value = "inflations", key = "#currencyId")
    public Optional<List<Inflation>> findAllByCurrencyId(Long currencyId) {
        return Optional.ofNullable(this.inflationRepository.findAllByCurrencyId(currencyId));
    }

    @Override
    // @Cacheable(value = "inflations", key = "{#currencyId, #year}")
    public Optional<List<Inflation>> findByYear(Long currencyId, Integer year) {
        return Optional.ofNullable(this.inflationRepository.findAllByCurrencyIdAndYear(currencyId, year));
    }

    @Override
    // @CachePut(value = "inflation", key = "#inflation.id")
    // @CacheEvict(value = "inflations", allEntries = true)
    public Inflation save(Inflation inflation) {
        // TODO da li update-ovanje inflacije utice na bilo koji drugi model
        //  pa treba dodati i to u @CacheEvict?
        return this.inflationRepository.save(inflation);
    }
}
