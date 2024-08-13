package yte.ypbs.ypbs_2024_ge3.user.controller.request;

import org.springframework.web.multipart.MultipartFile;

public record UsersKatkiRequest(String etkinlikTuru,
                                String aciklama,
                                String link,
                                String ekAdi,
                                MultipartFile ek
                                ) {
}
