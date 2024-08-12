package yte.ypbs.ypbs_2024_ge3.born_this_month.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.born_this_month.response.UserBornThisMonthResponse;
import yte.ypbs.ypbs_2024_ge3.born_this_month.service.BornThisMonthService;


import java.util.List;

@RestController
@RequestMapping("/api/bornToday")
public class BornThisMonthController {

    @Autowired
    private BornThisMonthService bornThisMonthService;

    @GetMapping
    public List<UserBornThisMonthResponse> getUsersBornToday() {
        return bornThisMonthService.getUsersBornToday();
    }
}
