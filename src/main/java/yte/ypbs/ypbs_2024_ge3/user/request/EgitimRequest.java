package yte.ypbs.ypbs_2024_ge3.user.request;

import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;
import yte.ypbs.ypbs_2024_ge3.user.enums.EgitimTuru;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record EgitimRequest(String egitimTuru,
                            String okulAdi,
                            String bolum,
                            String baslangicTarihi,
                            String mezuniyetTarihi,
                            String aciklama) {

    public Egitim toNewEgitim(){
        return new Egitim(
                EgitimTuru.valueOf(egitimTuru.toUpperCase()),
                okulAdi,
                bolum,
                LocalDate.parse(baslangicTarihi, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                LocalDate.parse(mezuniyetTarihi, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                aciklama);
    }
}
