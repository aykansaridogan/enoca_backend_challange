import javax.persistence.*;
import java.util.List;

@Entity
public class Sirket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adi;

    // Diğer özellikler ve ilişkiler

    // Getter ve Setter'lar
}
