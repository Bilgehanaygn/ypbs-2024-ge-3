package yte.ypbs.ypbs_2024_ge3.user.mapper;

import jakarta.persistence.Column;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersDeneyimRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDeneyimResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Deneyim;
import yte.ypbs.ypbs_2024_ge3.user.enums.CalismaSekli;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeneyimMapper {

    public static void toDeneyimEntity(Deneyim deneyim, UsersDeneyimRequest deneyimRequest){
        deneyim.setKurumAdi(deneyimRequest.kurumAdi());
        deneyim.setPozisyon(deneyimRequest.pozisyon());
        deneyim.setCalismaSekli(CalismaSekli.valueOf(deneyimRequest.calismaSekli().toUpperCase()));
        deneyim.setBaslamaTarihi(LocalDate.parse(deneyimRequest.baslamaTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        deneyim.setBitisTarihi(LocalDate.parse(deneyimRequest.bitisTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        deneyim.setIstenAyrilmaNedeni(deneyimRequest.istenAyrilmaNedeni());
    }

    public static UsersDeneyimResponse toUsersDeneyimResponse(Deneyim deneyim){
        return new UsersDeneyimResponse(
                deneyim.getId(),
                deneyim.getKurumAdi(),
                deneyim.getPozisyon(),
                deneyim.getCalismaSekli().toString(),
                deneyim.getBaslamaTarihi().toString(),
                deneyim.getBitisTarihi().toString(),
                deneyim.getIstenAyrilmaNedeni()
        );
    }

    public static Deneyim toNewDeneyim(UsersDeneyimRequest deneyimRequest){
        return new Deneyim(
                deneyimRequest.kurumAdi(),
                deneyimRequest.pozisyon(),
                CalismaSekli.valueOf(deneyimRequest.calismaSekli()),
                LocalDate.parse(deneyimRequest.baslamaTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                LocalDate.parse(deneyimRequest.bitisTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                deneyimRequest.istenAyrilmaNedeni());
    }
}