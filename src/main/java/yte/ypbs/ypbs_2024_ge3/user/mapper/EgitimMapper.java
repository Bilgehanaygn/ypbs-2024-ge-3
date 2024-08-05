package yte.ypbs.ypbs_2024_ge3.user.mapper;

import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;
import yte.ypbs.ypbs_2024_ge3.user.enums.EgitimTuru;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.EgitimRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.EgitimResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EgitimMapper {
    public static void toEgitimEntity(Egitim egitim, EgitimRequest egitimRequest) {
        egitim.setEgitimTuru(EgitimTuru.valueOf(egitimRequest.egitimTuru().toUpperCase()));
        egitim.setOkulAdi(egitimRequest.okulAdi());
        egitim.setBolum(egitimRequest.bolum());
        egitim.setBaslangicTarihi(LocalDate.parse(egitimRequest.baslangicTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        egitim.setMezuniyetTarihi(LocalDate.parse(egitimRequest.mezuniyetTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        egitim.setAciklama(egitimRequest.aciklama());
    }

    public static EgitimResponse toEgitimResponse(Egitim egitim) {
        return new EgitimResponse(
                egitim.getId(),
                egitim.getEgitimTuru().toString(),
                egitim.getOkulAdi(),
                egitim.getBolum(),
                egitim.getBaslangicTarihi().toString(),
                egitim.getMezuniyetTarihi().toString(),
                egitim.getAciklama()
        );
    }

    public static Egitim toNewEgitim(EgitimRequest egitimRequest){
        return new Egitim(
                EgitimTuru.valueOf(egitimRequest.egitimTuru().toUpperCase()),
                egitimRequest.okulAdi(),
                egitimRequest.bolum(),
                LocalDate.parse(egitimRequest.baslangicTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                LocalDate.parse(egitimRequest.mezuniyetTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                egitimRequest.aciklama());
    }
}
