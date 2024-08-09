package yte.ypbs.ypbs_2024_ge3.user.mapper;

import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersKatkiRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersKatkiDetailResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersKatkiFileResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Katki;
import yte.ypbs.ypbs_2024_ge3.user.enums.EtkinlikTuru;

import java.io.IOException;

public class KatkiMapper {
    public static void toKatkiEntity(Katki katki, UsersKatkiRequest katkiRequest) throws IOException {
        katki.setEtkinlikTuru(EtkinlikTuru.valueOf(katkiRequest.etkinlikTuru().toUpperCase()));
        katki.setAciklama(katkiRequest.aciklama());
        katki.setLink(katkiRequest.link());
        katki.setEkAdi(katkiRequest.ekAdi());
        katki.setEk(katkiRequest.ek().getBytes());
    }

    public static UsersKatkiDetailResponse toUsersKatkiDetailResponse(Katki katki) {
        return new UsersKatkiDetailResponse(
                katki.getId(),
                katki.getEtkinlikTuru().toString(),
                katki.getAciklama(),
                katki.getLink(),
                katki.getEkAdi(),
                katki.getYuklenmeTarihi().toString()
        );
    }

    public static Katki toNewKatki(UsersKatkiRequest katkiRequest) throws IOException {
        return new Katki(
                EtkinlikTuru.valueOf(katkiRequest.etkinlikTuru().toUpperCase()),
                katkiRequest.aciklama(),
                katkiRequest.link(),
                katkiRequest.ek().getBytes(),
                katkiRequest.ekAdi()
        );
    }

    public static UsersKatkiFileResponse toUsersKatkiFileResponse(Katki katki) {
        return new UsersKatkiFileResponse(katki.getEkAdi(), katki.getEk());
    }
}
