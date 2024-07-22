package yte.ypbs.ypbs_2024_ge3.Organization;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organization")
public class Organization extends BaseEntity {
    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> users = new ArrayList<>();

    @ManyToOne
    private Organization top;

}

