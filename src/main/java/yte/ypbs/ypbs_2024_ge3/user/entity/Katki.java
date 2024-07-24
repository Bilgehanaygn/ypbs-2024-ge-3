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
    @NotBlank
    private EtkinlikTuru etkinlikTuru;

    private String aciklama;
    private String link;
    private String ek;
    private LocalDate yuklenmeTarihi;

    public Katki(EtkinlikTuru etkinlikTuru, String link, String ek, LocalDate yuklenmeTarihi) {
        this.etkinlikTuru = etkinlikTuru;
        this.link = link;
        this.ek = ek;
        this.yuklenmeTarihi = yuklenmeTarihi;
    }
}
