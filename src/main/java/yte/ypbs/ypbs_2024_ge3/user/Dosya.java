package yte.ypbs.ypbs_2024_ge3.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.Common.BaseEntity;
import yte.ypbs.ypbs_2024_ge3.user.enums.DosyaTuru;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dosya extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private DosyaTuru dosyaTuru;
    private String dosyaAdi;
    private String bolum;


    private LocalDate yuklenmeTarihi;

    public Dosya(DosyaTuru dosyaTuru, String dosyaAdi, String bolum) {
        this.dosyaTuru = dosyaTuru;
        this.dosyaAdi = dosyaAdi;
        this.bolum = bolum;
    }
}
