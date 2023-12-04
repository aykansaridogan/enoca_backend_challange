// SirketService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SirketService {

    private final SirketRepository sirketRepository;

    @Autowired
    public SirketService(SirketRepository sirketRepository) {
        this.sirketRepository = sirketRepository;
    }

    public List<Sirket> getAllSirketler() {
        return sirketRepository.findAll();
    }

    public Optional<Sirket> getSirketById(Long id) {
        return sirketRepository.findById(id);
    }

    public Sirket createSirket(Sirket sirket) {
        return sirketRepository.save(sirket);
    }

    public boolean deleteSirketById(Long id) {
        if (sirketRepository.existsById(id)) {
            sirketRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Sirket updateSirket(Long id, Sirket newSirket) {
        if (sirketRepository.existsById(id)) {
            newSirket.setId(id);
            return sirketRepository.save(newSirket);
        }
        return null;
    }
}
