// SirketController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sirketler")
public class SirketController {

    private final SirketService sirketService;

    @Autowired
    public SirketController(SirketService sirketService) {
        this.sirketService = sirketService;
    }

    @GetMapping
    public ResponseEntity<List<Sirket>> getAllSirketler() {
        List<Sirket> sirketler = sirketService.getAllSirketler();
        return new ResponseEntity<>(sirketler, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sirket> getSirketById(@PathVariable Long id) {
        Optional<Sirket> sirket = sirketService.getSirketById(id);
        return sirket.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Sirket> createSirket(@RequestBody Sirket sirket) {
        Sirket createdSirket = sirketService.createSirket(sirket);
        return new ResponseEntity<>(createdSirket, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sirket> updateSirket(@PathVariable Long id, @RequestBody Sirket sirket) {
        Sirket updatedSirket = sirketService.updateSirket(id, sirket);
        if (updatedSirket != null) {
            return new ResponseEntity<>(updatedSirket, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSirket(@PathVariable Long id) {
        boolean deleted = sirketService.deleteSirketById(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
