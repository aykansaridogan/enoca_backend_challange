import javax.persistence.*;

@Entity
public class Calisan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;

    @ManyToOne
    @JoinColumn(name = "sirket_id")
    private Sirket sirket;

    // Diğer özellikler

    // Getter ve Setter'lar
}
