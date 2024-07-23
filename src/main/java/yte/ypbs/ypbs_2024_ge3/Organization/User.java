package yte.ypbs.ypbs_2024_ge3.Organization;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor
@Table(name="_user")
public class User extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name="organization_id")
    private Organization organization;
}