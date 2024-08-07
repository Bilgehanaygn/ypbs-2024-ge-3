package yte.ypbs.ypbs_2024_ge3.user.mapper;

import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersProjeResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;

public class ProjeMapper {
    public static UsersProjeResponse toUsersProjeResponse(Proje proje) {
        return new UsersProjeResponse(
                proje.getId(),
                proje.getProjeAdi(),
                proje.getTakim(),
                proje.getGorev(),
                proje.getBaslangicTarihi().toString(),
                proje.getBitisTarihi().toString());
    }
}
