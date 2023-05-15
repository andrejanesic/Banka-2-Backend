package rs.edu.raf.si.bank2.main.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.bank2.main.exceptions.CurrencyNotFoundException;
import rs.edu.raf.si.bank2.main.models.mariadb.Currency;
import rs.edu.raf.si.bank2.main.repositories.mariadb.CurrencyRepository;
import rs.edu.raf.si.bank2.main.services.interfaces.CurrencyServiceInterface;

@Service
public class CurrencyService implements CurrencyServiceInterface {
    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    @Cacheable(value = "currencies")
    public List<Currency> findAll() {
        return this.currencyRepository.findAll();
    }

    @Override
    @Cacheable(value = "currency", key="#currencyId")
    public Optional<Currency> findById(Long currencyId) {
        Optional<Currency> currency = this.currencyRepository.findById(currencyId);
        if (currency.isPresent()) {
            return currency;
        } else {
            throw new CurrencyNotFoundException(currencyId);
        }
    }

    @Override
    @Cacheable(value = "currency", key="#currencyCode")
    public Optional<Currency> findByCurrencyCode(String currencyCode) {
        Optional<Currency> currency = this.currencyRepository.findCurrencyByCurrencyCode(currencyCode);
        if (currency.isPresent()) {
            return currency;
        } else {
            throw new CurrencyNotFoundException(currencyCode);
        }
    }

    @Override
    @Cacheable(value = "currency", key="#currencyCode")
    public Optional<Currency> findCurrencyByCurrencyCode(String currencyCode) {
        // TODO da li je ovo isti metod kao #findByCurrencyCode?
        return currencyRepository.findCurrencyByCurrencyCode(currencyCode);
    }
}
