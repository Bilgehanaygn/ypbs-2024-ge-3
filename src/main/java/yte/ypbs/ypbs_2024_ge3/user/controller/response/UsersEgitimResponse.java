package yte.ypbs.ypbs_2024_ge3.user.controller.response;

public record UsersEgitimResponse(Long id,
                                  String egitimTuru,
                                  String okulAdi,
                                  String bolum,
                                  String baslangicTarihi,
                                  String mezuniyetTarihi,
                                  String aciklama) {
}
