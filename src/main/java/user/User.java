package user;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import user.annotations.Plaka;
import user.annotations.TCKimlikNo;
import user.annotations.Telefon;
import user.enums.Cinsiyet;
import user.enums.KanGrubu;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @GeneratedValue
    @Id
    private Long userId;

    @NotBlank
    private String isim;
    @NotBlank
    private String soyisim;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;

    // Annotation'a gerek var mı? @Telefon
    @NotBlank
    @Telefon
    private String telefon;

    @Enumerated(EnumType.STRING)
    private Cinsiyet cinsiyet;

    @TCKimlikNo
    private long tcKimlikNo;

    private String akademik_unvan;

    @Plaka
    private String arac_plakasi;

    private String acil_durum_kisi;

    @Telefon
    private String acil_durum_telefon;

    private String adres;

    private LocalDate dogumTarihi;

    @Enumerated(EnumType.STRING)
    private KanGrubu kanGrubu;

    @OneToOne
    private Kurumsal kurumsal;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Proje> dahilOlduguProjeler = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Egitim> egitim = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Deneyim> deneyimler = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Katki> katkilar = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Dosya> dosyalar = new HashSet<>();


    public User(String isim, String soyisim, String password, String email, String telefon) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
        this.telefon = telefon;
        this.password = password;
    }

    public void AddProje(Proje proje){
        dahilOlduguProjeler.add(proje);
    }
    public void RemoveProje(Proje proje){
        dahilOlduguProjeler.remove(proje);
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
