package yte.ypbs.ypbs_2024_ge3.user.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Proje extends BaseEntity {

    @NotBlank
    private String projeAdi;
    @NotBlank
    private String takim;
    @NotBlank
    private String gorev;
    @NotBlank
    private LocalDate baslangicTarihi;
    @Column(nullable = true)
    private LocalDate bitisTarihi;

    public Proje(String projeAdi, String takim, String gorev, LocalDate baslangicTarihi) {
        this.projeAdi = projeAdi;
        this.takim = takim;
        this.gorev = gorev;
        this.baslangicTarihi = baslangicTarihi;
    }

}