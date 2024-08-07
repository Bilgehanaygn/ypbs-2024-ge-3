package yte.ypbs.ypbs_2024_ge3.user.controller.response;

public record UsersDosyaDetailResponse(Long id,
                                       String dosyaTuru,
                                       String dosyaAdi,
                                       String yuklenmeTarihi,
                                       String aciklama
                                 ) {
}
