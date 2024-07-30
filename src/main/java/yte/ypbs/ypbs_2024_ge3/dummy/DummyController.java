package yte.ypbs.ypbs_2024_ge3.dummy;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dummy")
public class DummyController {

    @GetMapping("/dummy")
    @ResponseBody
    public List<String> dummies() {
        return List.of("Serkan", "Serdar", "Ali","Onat","Enes","Aybars");
    }
}
