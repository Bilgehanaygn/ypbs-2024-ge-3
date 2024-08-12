package yte.ypbs.ypbs_2024_ge3.born_this_month.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.born_this_month.repository.BornThisMonthRepository;
import yte.ypbs.ypbs_2024_ge3.born_this_month.response.UserBornThisMonthResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BornThisMonthService {

    @Autowired
    private BornThisMonthRepository bornThisMonthRepository;

    public List<UserBornThisMonthResponse> getUsersBornToday() {
        LocalDate today = LocalDate.now();
        int todayMonth = today.getMonthValue();

        return bornThisMonthRepository.findByDogumTarihiAyDegeri(todayMonth)
                .stream()
                .map(user -> {
                    byte[] photoData = user.getPhoto() != null ? user.getPhoto().getData() : null;
                    return new UserBornThisMonthResponse(user.getIsim(), user.getSoyisim(), photoData, user.getDogumTarihi());
                })
                .collect(Collectors.toList());
    }
}
