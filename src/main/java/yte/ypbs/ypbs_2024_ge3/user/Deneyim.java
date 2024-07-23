package yte.ypbs.ypbs_2024_ge3.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.user.enums.CalismaSekli;

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
    @Column(nullable = true)
    private LocalDate bitisTarihi;
    private String istenAyrilmaNedeni;

    public Deneyim(String sirket, String pozisyon, LocalDate baslamaTarihi, LocalDate bitisTarihi ) {
        this.kurumAdi = sirket;
        this.pozisyon = pozisyon;
        this.baslamaTarihi = baslamaTarihi;
        this.bitisTarihi = bitisTarihi;

    }
}
