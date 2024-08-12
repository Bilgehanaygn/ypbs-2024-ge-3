package yte.ypbs.ypbs_2024_ge3.Organization;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organization")
public class Organization extends BaseEntity {
    private String name;

    @ManyToOne
    private Organization top;

    @OneToMany(mappedBy = "birim")
    private Set<Kurumsal> kurumsals;

    public Organization(String name, Organization top) {
        this.name = name;
        this.top = top;
    }
}

