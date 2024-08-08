package yte.ypbs.ypbs_2024_ge3.user.controller;

import org.springframework.web.bind.annotation.*;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersDeneyimRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDeneyimResponse;
import yte.ypbs.ypbs_2024_ge3.user.service.DeneyimService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeneyimController {

    private final DeneyimService deneyimService;

    public DeneyimController(DeneyimService deneyimService) {
        this.deneyimService = deneyimService;
    }

    @GetMapping("/deneyim")
    public List<UsersDeneyimResponse> getUserDeneyim() {
        return deneyimService.getUserDeneyim();
    }

    @GetMapping("/deneyim/enum")
    public List<String> getDeneyimEnum() {
        return deneyimService.getDeneyimEnums();
    }

    @PostMapping("/deneyim")
    public void addUserDeneyim(@RequestBody UsersDeneyimRequest deneyimRequest) {
        deneyimService.addUserDeneyim(deneyimRequest);
    }

    @PutMapping("/deneyim/{id}")
    public void updateUserDeneyim(@PathVariable Long id, @RequestBody UsersDeneyimRequest deneyimRequest) {
        deneyimService.updateUserDeneyim(id, deneyimRequest);
    }

    @DeleteMapping("/deneyim/{id}")
    public void deleteUserDeneyim(@PathVariable Long id) {
        deneyimService.deleteUserDeneyim(id);
    }
}
