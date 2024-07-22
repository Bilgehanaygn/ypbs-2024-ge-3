package user;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import user.annotations.TCKimlikNo;


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
    private Long id;

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
    private String telefon;

    // Annotation'a gerek var mı? @Plaka
    private String arac_plakasi;


    private String acil_durum_kisi;

    private String acil_durum_telefon;

    private String adres;

    private String akademik_unvan;

    @TCKimlikNo
    private long tcKimlikNo;


    @Enumerated(EnumType.STRING)
    private Cinsiyet cinsiyet;

    private LocalDate dogumTarihi;

    @Enumerated(EnumType.STRING)
    private KanGrubu kanGrubu;

    @OneToMany
    Set<Proje> dahilOlduguProjeler = new HashSet<>();
    @OneToMany
    Set<Egitim> egitim = new HashSet<>();
    @OneToMany
    Set<Katki> katkilar = new HashSet<>();
    @OneToMany
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
