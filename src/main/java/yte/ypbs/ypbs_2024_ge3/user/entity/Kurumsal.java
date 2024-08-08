package yte.ypbs.ypbs_2024_ge3.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.Organization.Organization;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;
import yte.ypbs.ypbs_2024_ge3.user.enums.CalismaDurumu;
import yte.ypbs.ypbs_2024_ge3.user.enums.CalismaTuru;
import yte.ypbs.ypbs_2024_ge3.user.enums.PersonelTuru;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Kurumsal extends BaseEntity {

    @OneToOne
    private User user;

    private LocalDate iseGirisTarihi;
    private long sicilNo;
    private String kadro;
    private String unvan;

    @ManyToOne
    private Organization birim;

    @OneToMany(mappedBy = "kurumsal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KurumsalProje> kurumsalProjeler;

    @Enumerated(EnumType.STRING)
    private PersonelTuru personelTuru;
    private CalismaTuru calismaTuru;
    private CalismaDurumu calismaDurumu;
    private boolean servisKullanimi;
    private String dahiliNumara;
    private Integer odaNumara;

    public Kurumsal(User user, String unvan, Organization birim, List<KurumsalProje> kurumsalProjeler) {
        this.user = user;
        this.unvan = unvan;
        this.birim = birim;
        this.kurumsalProjeler = kurumsalProjeler;
    }
}
