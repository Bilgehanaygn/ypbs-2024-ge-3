package yte.ypbs.ypbs_2024_ge3.user.controller.request;

import org.springframework.web.multipart.MultipartFile;

public record EgitimRequest(String egitimTuru,
                            String okulAdi,
                            String bolum,
                            String baslangicTarihi,
                            String mezuniyetTarihi,
                            String aciklama,
                            MultipartFile dosya) {
}
