package yte.ypbs.ypbs_2024_ge3.user.mapper;

import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersProjeRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersProjeResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjeMapper {
    public static UsersProjeResponse toUsersProjeResponse(Proje proje) {
        return new UsersProjeResponse(
                proje.getId(),
                proje.getProjeAdi(),
                proje.getTakim(),
                proje.getGorev(),
                proje.getBaslangicTarihi().toString(),
                proje.getBitisTarihi().toString());
    }

    public static void toProjeEntity(Proje proje, UsersProjeRequest projeRequest) {
        proje.setProjeAdi(projeRequest.projeAdi());
        proje.setTakim(projeRequest.takim());
        proje.setGorev(projeRequest.gorev());
        proje.setBaslangicTarihi(LocalDate.parse(projeRequest.baslangicTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        proje.setBitisTarihi(LocalDate.parse(projeRequest.bitisTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public static Proje toNewProje(UsersProjeRequest projeRequest) {
        return new Proje(
                projeRequest.projeAdi(),
                projeRequest.takim(),
                projeRequest.gorev(),
                LocalDate.parse(projeRequest.baslangicTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                LocalDate.parse(projeRequest.bitisTarihi(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        );
    }
}
