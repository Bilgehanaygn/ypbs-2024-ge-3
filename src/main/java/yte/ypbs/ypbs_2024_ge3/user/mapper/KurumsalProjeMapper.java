package yte.ypbs.ypbs_2024_ge3.user.mapper;

import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersProjeRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersProjeResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.KurumsalProje;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KurumsalProjeMapper {
    public static UsersProjeResponse toUsersProjeResponse (KurumsalProje kurumsalProje) {
        return new UsersProjeResponse(
                kurumsalProje.getId(),
                kurumsalProje.getProje().getProjeAdi(),
                kurumsalProje.getProje().getTakim(),
                kurumsalProje.getGorev(),
                kurumsalProje.getProje().getBaslangicTarihi().toString(),
                kurumsalProje.getProje().getBitisTarihi().toString()
        );
    }

    public static void toKurumsalProjeEntity(KurumsalProje kurumsalProje, UsersProjeRequest projeRequest){
        kurumsalProje.setGorev(projeRequest.gorev());
        kurumsalProje.getProje().setProjeAdi(projeRequest.projeAdi());
        kurumsalProje.getProje().setTakim(projeRequest.takim());
        kurumsalProje.getProje().setBaslangicTarihi(LocalDate.parse(projeRequest.baslangicTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        kurumsalProje.getProje().setBitisTarihi(LocalDate.parse(projeRequest.bitisTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }
}
