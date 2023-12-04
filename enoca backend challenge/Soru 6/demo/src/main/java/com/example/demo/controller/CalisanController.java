// CalisanController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calisanlar")
public class CalisanController {

    private final CalisanService calisanService;

    @Autowired
    public CalisanController(CalisanService calisanService) {
        this.calisanService = calisanService;
    }

    @GetMapping
    public ResponseEntity<List<Calisan>> getAllCalisanlar() {
        List<Calisan> calisanlar = calisanService.getAllCalisanlar();
        return new ResponseEntity<>(calisanlar, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calisan> getCalisanById(@PathVariable Long id) {
        Optional<Calisan> calisan = calisanService.getCalisanById(id);
        return calisan.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Calisan> createCalisan(@RequestBody Calisan calisan) {
        Calisan createdCalisan = calisanService.createCalisan(calisan);
        return new ResponseEntity<>(createdCalisan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calisan> updateCalisan(@PathVariable Long id, @RequestBody Calisan calisan) {
        Calisan updatedCalisan = calisanService.updateCalisan(id, calisan);
        if (updatedCalisan != null) {
            return new ResponseEntity<>(updatedCalisan, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalisan(@PathVariable Long id) {
        boolean deleted = calisanService.deleteCalisanById(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
