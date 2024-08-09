package yte.ypbs.ypbs_2024_ge3.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;
import yte.ypbs.ypbs_2024_ge3.user.enums.EtkinlikTuru;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Katki extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private EtkinlikTuru etkinlikTuru;

    private String aciklama;
    private String link;
    @Lob
    private byte[] ek;
    private String ekAdi;

    private LocalDate yuklenmeTarihi = LocalDate.now();

    public Katki(EtkinlikTuru etkinlikTuru, String aciklama, String link, byte[] ek, String ekAdi) {
        this.etkinlikTuru = etkinlikTuru;
        this.aciklama = aciklama;
        this.link = link;
        this.ek = ek;
        this.ekAdi = ekAdi;
    }
}
