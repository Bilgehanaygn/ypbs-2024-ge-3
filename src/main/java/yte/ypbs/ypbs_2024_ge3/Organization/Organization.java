package yte.ypbs.ypbs_2024_ge3.Organization;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organization")
public class Organization extends BaseEntity {
    private String name;

    @ManyToOne
    private Organization top;

}

