package yte.ypbs.ypbs_2024_ge3.user.controller.request;

public record UsersDeneyimRequest(String kurumAdi,
                                  String pozisyon,
                                  String calismaSekli,
                                  String baslamaTarihi,
                                  String bitisTarihi,
                                  String istenAyrilmaNedeni
                                  ) {
}