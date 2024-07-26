package yte.ypbs.ypbs_2024_ge3.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Egitim extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @NotNull
    private EgitimTuru egitimTuru;

    @NotBlank
    private String okulAdi;
    @NotBlank
    private String bolum;
    @NotNull
    private LocalDate baslangicTarihi;
    @NotNull
    private LocalDate mezuniyetTarihi;

    private String aciklama;
}
