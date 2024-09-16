package yte.ypbs.ypbs_2024_ge3.user.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;
import yte.ypbs.ypbs_2024_ge3.image.entity.Image;
import yte.ypbs.ypbs_2024_ge3.login.entity.Authority;
import yte.ypbs.ypbs_2024_ge3.user.annotation.Plaka;
import yte.ypbs.ypbs_2024_ge3.user.annotation.TCKimlikNo;
import yte.ypbs.ypbs_2024_ge3.user.annotation.Telefon;
import yte.ypbs.ypbs_2024_ge3.user.enums.Cinsiyet;
import yte.ypbs.ypbs_2024_ge3.user.enums.KanGrubu;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.GorevVeProje;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserDataResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserHeaderResponse;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
public class User extends BaseEntity implements UserDetails {

    @NotBlank
    private String isim;
    @NotBlank
    private String soyisim;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Telefon
    private String telefon;

    @Enumerated(EnumType.STRING)
    private Cinsiyet cinsiyet;

    @TCKimlikNo
    private long tcKimlikNo;

    private String akademikUnvan;

    @Plaka
    private String aracPlakasi;

    private String acilDurumKisi;

    @Telefon
    private String acilDurumTelefon;

    private String adres;

    private LocalDate dogumTarihi;

    private int dogumTarihiAyDegeri;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Image photo;  // Add this field to link the user's profile photo

    @Enumerated(EnumType.STRING)
    private KanGrubu kanGrubu;

    private boolean accountNonExpired =true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private List<Authority> authorities;


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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Kurumsal kurumsal;

    public User(String isim, String soyisim, String username, String password, String email, String telefon, List<Authority> authorities) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.telefon = telefon;
    }


    public User(String isim, String soyisim, String username, String password, String email, String telefon, LocalDate dogumTarihi, byte[] image, Set<Dosya> dosyalar) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefon = telefon;
        this.dogumTarihi = dogumTarihi;
        this.dogumTarihiAyDegeri=dogumTarihi.getMonthValue();
        this.dosyalar=dosyalar;
    }

    public User(Set<Egitim> egitim, String isim, String soyisim, String username, String password, String email, String telefon, List<Authority> authorities) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.telefon = telefon;
        this.egitim = egitim;
    }


    @Override
    public List<Authority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    public void setDogumTarihi(LocalDate date){
        this.dogumTarihi = date;
        this.dogumTarihiAyDegeri=date.getMonthValue();
    }

    public void addEgitim(Egitim egitim1){
        egitim.add(egitim1);
    }
    public void removeEgitim(Egitim egitim1){
        egitim.remove(egitim1);
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


    public UserDataResponse toUserDataResponse() {
        return new UserDataResponse(
                (isim + " " + soyisim),
                this.getKurumsal().getBirim().getName(),
                this.getKurumsal().getUnvan(),
                this.getKurumsal().getKurumsalProjeler().stream().map(
                        kurumsalProje -> new GorevVeProje(
                                kurumsalProje.getGorev(),
                                kurumsalProje.getProje().getProjeAdi()
                        )
                ).collect(Collectors.toList()),
                email,
                telefon
        );
    }

    public UserHeaderResponse toUserHeaderResponse() {
        byte[] photoData = (photo != null) ? photo.getData() : null;
        return new UserHeaderResponse(id, isim, soyisim, photoData);
    }
}
