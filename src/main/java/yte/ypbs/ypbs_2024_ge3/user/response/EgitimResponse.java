package yte.ypbs.ypbs_2024_ge3.user.response;

import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;

import java.util.Set;

public record EgitimResponse(Long id,
                             String egitimTuru,
                             String okulAdi,
                             String bolum,
                             String baslangicTarihi,
                             String mezuniyetTarihi,
                             String aciklama) {
}
