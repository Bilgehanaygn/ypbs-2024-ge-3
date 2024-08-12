package yte.ypbs.ypbs_2024_ge3.user.mapper;

import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersDosyaRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDosyaDetailResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDosyaFileResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Dosya;
import yte.ypbs.ypbs_2024_ge3.user.enums.DosyaTuru;

import java.io.IOException;

public class DosyaMapper {
    public static UsersDosyaDetailResponse toUsersDosyaDetailResponse(Dosya dosya) {
        return new UsersDosyaDetailResponse(
                dosya.getId(),
                dosya.getDosyaTuru().toString(),
                dosya.getDosyaAdi(),
                dosya.getYuklenmeTarihi().toString(),
                dosya.getAciklama());
    }

    public static Dosya toNewDosya(UsersDosyaRequest usersDosyaRequest) throws IOException {
        return new Dosya(
                DosyaTuru.valueOf(usersDosyaRequest.dosyaTuru().toUpperCase()),
                usersDosyaRequest.dosyaAdi(),
                usersDosyaRequest.aciklama(),
                usersDosyaRequest.dosya().getBytes());

    }

    public static UsersDosyaFileResponse toUsersDosyaFileResponse(Dosya dosya) {
        return new UsersDosyaFileResponse(dosya.getDosyaAdi(), dosya.getDosya());
    }
}
