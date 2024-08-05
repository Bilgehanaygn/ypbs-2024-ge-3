package yte.ypbs.ypbs_2024_ge3.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "kurumsal_proje")
public class KurumsalProje extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "kurumsal_id")
    private Kurumsal kurumsal;

    @ManyToOne
    @JoinColumn(name = "proje_id")
    private Proje proje;

    @NotBlank
    private String gorev;

    public KurumsalProje(Kurumsal kurumsal, Proje proje, String gorev) {
        this.kurumsal = kurumsal;
        this.proje = proje;
        this.gorev = gorev;
    }
}
