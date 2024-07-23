package user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import user.enums.CalismaSekli;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Deneyim {
    @GeneratedValue
    @Id
    private Long id;


    private String kurumAdi;
    private String pozisyon;
    private CalismaSekli calismaSekli;
    private LocalDate baslamaTarihi;
    private LocalDate bitisTarihi; // hala sürüyorsa?
    private String istenAyrilmaNedeni;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Deneyim(User user, String sirket, String pozisyon, LocalDate baslamaTarihi, LocalDate bitisTarihi ) {
        this.user = user;
        this.kurumAdi = sirket;
        this.pozisyon = pozisyon;
        this.baslamaTarihi = baslamaTarihi;
        this.bitisTarihi = bitisTarihi;
    }
}
