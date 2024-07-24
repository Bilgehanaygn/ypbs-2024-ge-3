package yte.ypbs.ypbs_2024_ge3.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;
import yte.ypbs.ypbs_2024_ge3.user.enums.EgitimTuru;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Egitim extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @NotBlank
    private EgitimTuru egitimTuru;

    @NotBlank
    private String okulAdi;
    @NotBlank
    private String bolum;
    @NotBlank
    private LocalDate baslangicTarihi;
    @NotBlank
    private LocalDate mezuniyetTarihi;

    private String aciklama;

    public Egitim(EgitimTuru egitimTuru, String okulAdi, String bolum, LocalDate baslangicTarihi, LocalDate mezuniyetTarihi) {
        this.egitimTuru = egitimTuru;
        this.okulAdi = okulAdi;
        this.bolum = bolum;
        this.baslangicTarihi = baslangicTarihi;
        this.mezuniyetTarihi = mezuniyetTarihi;
    }
}
