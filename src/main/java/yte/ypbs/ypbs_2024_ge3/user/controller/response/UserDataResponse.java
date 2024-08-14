package yte.ypbs.ypbs_2024_ge3.user.controller.response;

import java.util.List;

public record UserDataResponse(String isimSoyisim,
                               String birim,
                               String unvan,
                               List<yte.ypbs.ypbs_2024_ge3.user.controller.response.GorevVeProje> gorevVeProje,
                               String email,
                               String telefon) {
}
