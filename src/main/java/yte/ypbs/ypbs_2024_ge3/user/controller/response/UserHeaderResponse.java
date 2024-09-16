package yte.ypbs.ypbs_2024_ge3.user.controller.response;

public record UserHeaderResponse(Long id,
                                 String name,
                                 String surname,
                                 byte[] photo) {
}
