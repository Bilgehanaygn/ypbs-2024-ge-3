package yte.ypbs.ypbs_2024_ge3.user.response;

import java.util.List;

public record UserDataResponse(String isimSoyisim,
                               String birim,
                               String unvan,
                               List<GorevVeProje> gorevVeProje,
                               String email,
                               String telefon) {
}
