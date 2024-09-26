package yte.ypbs.ypbs_2024_ge3.user.controller.response;

import yte.ypbs.ypbs_2024_ge3.user.enums.Cinsiyet;
import yte.ypbs.ypbs_2024_ge3.user.enums.KanGrubu;

import java.time.LocalDate;

public record UserKisiselResponse(Long id,
                                  String isim,
                                  String soyisim,
                                  long tcKimlikNo,
                                  Cinsiyet cinsiyet,
                                  String akademikUnvan,
                                  String email,
                                  LocalDate dogumTarihi,
                                  KanGrubu kanGrubu,
                                  String telefon,
                                  String aracPlakasi,
                                  String acilDurumKisi,
                                  String acilDurumTelefon,
                                  String adres,
                                  byte[] photo
) {
}
