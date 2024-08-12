package yte.ypbs.ypbs_2024_ge3.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;
import yte.ypbs.ypbs_2024_ge3.user.enums.CalismaSekli;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Deneyim extends BaseEntity {

    private String kurumAdi;
    private String pozisyon;
    private CalismaSekli calismaSekli;
    private LocalDate baslamaTarihi;
    @Column(nullable = true)
    private LocalDate bitisTarihi;
    private String istenAyrilmaNedeni;

    public Deneyim(String kurumAdi, String pozisyon, CalismaSekli calismaSekli, LocalDate baslamaTarihi, LocalDate bitisTarihi, String istenAyrilmaNedeni) {
        this.kurumAdi = kurumAdi;
        this.pozisyon = pozisyon;
        this.calismaSekli = calismaSekli;
        this.baslamaTarihi = baslamaTarihi;
        this.bitisTarihi = bitisTarihi;
        this.istenAyrilmaNedeni = istenAyrilmaNedeni;
    }
}
