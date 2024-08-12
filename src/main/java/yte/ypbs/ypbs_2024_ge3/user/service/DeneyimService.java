package yte.ypbs.ypbs_2024_ge3.user.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersDeneyimRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDeneyimResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Deneyim;
import yte.ypbs.ypbs_2024_ge3.user.enums.CalismaSekli;
import yte.ypbs.ypbs_2024_ge3.user.mapper.DeneyimMapper;
import yte.ypbs.ypbs_2024_ge3.user.repository.DeneyimRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static yte.ypbs.ypbs_2024_ge3.user.mapper.DeneyimMapper.toDeneyimEntity;
import static yte.ypbs.ypbs_2024_ge3.user.mapper.DeneyimMapper.toNewDeneyim;

@Service
public class DeneyimService {

    private final UserService userService;
    private final DeneyimRepository deneyimRepository;

    public DeneyimService(UserService userService, DeneyimRepository deneyimRepository) {
        this.userService = userService;
        this.deneyimRepository = deneyimRepository;
    }

    public List<UsersDeneyimResponse> getUserDeneyim(){
        Set<Deneyim> deneyimSet = userService.getUser().getDeneyimler();
        return deneyimSet.stream().map(DeneyimMapper::toUsersDeneyimResponse).toList();
    }

    public List<String> getDeneyimEnums(){
        return Stream.of(CalismaSekli.values()).map(Enum::name).toList();
    }

    @Transactional
    public void updateUserDeneyim(Long id, UsersDeneyimRequest deneyimRequest){
        Deneyim deneyim = deneyimRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Deneyim not found"));
        toDeneyimEntity(deneyim, deneyimRequest);
        deneyimRepository.save(deneyim);
    }

    @Transactional
    public void deleteUserDeneyim(Long id){
        userService.getUser().removeDeneyim(deneyimRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Deneyim not found")));
        deneyimRepository.deleteById(id);
    }

    @Transactional
    public void addUserDeneyim(UsersDeneyimRequest deneyimRequest){
        Deneyim newDeneyim = toNewDeneyim(deneyimRequest);
        deneyimRepository.save(newDeneyim);
        userService.getUser().addDeneyim(newDeneyim);
    }
}
