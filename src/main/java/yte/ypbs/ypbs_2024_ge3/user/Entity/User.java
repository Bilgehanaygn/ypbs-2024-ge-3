
package yte.ypbs.ypbs_2024_ge3.user.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;
import yte.ypbs.ypbs_2024_ge3.user.Enums.Cinsiyet;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
public class User extends BaseEntity {

    @Lob
    @Column(name = "image", columnDefinition="BLOB")
    private byte[] image;

    @NotBlank
    private String isim;
    @NotBlank
    private String soyisim;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @yte.ypbs.ypbs_2024_ge3.user.Annotations.Telefon
    private String telefon;

    @Enumerated(EnumType.STRING)
    private Cinsiyet cinsiyet;

    @yte.ypbs.ypbs_2024_ge3.user.Annotations.TCKimlikNo
    private long tcKimlikNo;

    private String akademikUnvan;

    @yte.ypbs.ypbs_2024_ge3.user.Annotations.Plaka
    private String aracPlakasi;

    private String acilDurumKisi;

    @yte.ypbs.ypbs_2024_ge3.user.Annotations.Telefon
    private String acilDurumTelefon;

    private String adres;

    private LocalDate dogumTarihi;

    @Enumerated(EnumType.STRING)
    private yte.ypbs.ypbs_2024_ge3.user.Enums.KanGrubu kanGrubu;

    @JoinTable(name="user_egitim",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="egitim_id"))
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Egitim> egitim = new HashSet<>();

    @JoinTable(name="user_deneyim",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="deneyim_id"))
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Deneyim> deneyimler = new HashSet<>();

    @JoinTable(name="user_katki",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="katki_id"))
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Katki> katkilar = new HashSet<>();

    @JoinTable(name="user_dosya",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="dosya_id"))
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Dosya> dosyalar = new HashSet<>();


    public User(String isim, String soyisim, String password, String email, String telefon) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
        this.telefon = telefon;
        this.password = password;
    }

    public User(String isim, String soyisim, LocalDate dogumTarihi){
        this.isim = isim;
        this.soyisim = soyisim;
        this.dogumTarihi = dogumTarihi;
    }

    public void addEgitim(Egitim egitim1){
        egitim.add(egitim1);
    }
    public void addDeneyim(Deneyim deneyim){
        deneyimler.add(deneyim);
    }
    public void removeDeneyim(Deneyim deneyim){
        deneyimler.remove(deneyim);
    }
    public void RemoveEgitim(Egitim egitim1){
        egitim.remove(egitim1);
    }
    public void addKatki(Katki katki){
        katkilar.add(katki);
    }
    public void removeKatki(Katki katki){
        katkilar.remove(katki);
    }
    public void addDosya(Dosya dosya){
        dosyalar.add(dosya);
    }
    public void removeDosya(Dosya dosya){
        dosyalar.remove(dosya);
    }
}
