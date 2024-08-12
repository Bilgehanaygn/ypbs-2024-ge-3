package yte.ypbs.ypbs_2024_ge3.user.controller.response;

public record UsersDeneyimResponse(Long id,
                                   String kurumAdi,
                                   String pozisyon,
                                   String calismaSekli,
                                   String baslamaTarihi,
                                   String bitisTarihi,
                                   String istenAyrilmaNedeni) {
}
