package yte.ypbs.ypbs_2024_ge3.Authority;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authority extends BaseEntity {

    private String authority;

//    @ManyToMany(mappedBy = "authorities")
//    private List<User> users;

}
