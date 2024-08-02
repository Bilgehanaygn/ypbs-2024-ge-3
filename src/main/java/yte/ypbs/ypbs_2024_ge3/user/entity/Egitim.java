package yte.ypbs.ypbs_2024_ge3.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;
import yte.ypbs.ypbs_2024_ge3.user.enums.EgitimTuru;
import yte.ypbs.ypbs_2024_ge3.user.request.EgitimRequest;
import yte.ypbs.ypbs_2024_ge3.user.response.EgitimResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    public void setFromEgitimRequest(EgitimRequest egitimRequest) {
        this.egitimTuru = EgitimTuru.valueOf(egitimRequest.egitimTuru().toUpperCase());
        this.okulAdi = egitimRequest.okulAdi();
        this.bolum = egitimRequest.bolum();
        this.baslangicTarihi = LocalDate.parse(egitimRequest.baslangicTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.mezuniyetTarihi = LocalDate.parse(egitimRequest.mezuniyetTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.aciklama = egitimRequest.aciklama();
    }

    public EgitimResponse toEgitimResponse() {
        return new EgitimResponse(id ,egitimTuru.toString(), okulAdi, bolum, baslangicTarihi.toString(), mezuniyetTarihi.toString(), aciklama);
    }
}
