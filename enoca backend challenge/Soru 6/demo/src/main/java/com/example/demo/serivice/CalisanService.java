// CalisanService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalisanService {

    private final CalisanRepository calisanRepository;

    @Autowired
    public CalisanService(CalisanRepository calisanRepository) {
        this.calisanRepository = calisanRepository;
    }

    public List<Calisan> getAllCalisanlar() {
        return calisanRepository.findAll();
    }

    public Optional<Calisan> getCalisanById(Long id) {
        return calisanRepository.findById(id);
    }

    public Calisan createCalisan(Calisan calisan) {
        return calisanRepository.save(calisan);
    }

    public boolean deleteCalisanById(Long id) {
        if (calisanRepository.existsById(id)) {
            calisanRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Calisan updateCalisan(Long id, Calisan newCalisan) {
        if (calisanRepository.existsById(id)) {
            newCalisan.setId(id);
            return calisanRepository.save(newCalisan);
        }
        return null;
    }
}
