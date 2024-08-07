package yte.ypbs.ypbs_2024_ge3.user.controller.request;

import org.springframework.web.multipart.MultipartFile;

public record UsersDosyaRequest(String dosyaTuru,
                                String dosyaAdi,
                                String aciklama,
                                MultipartFile dosya
                                ) {
}
