package user;


import jakarta.persistence.*;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @GeneratedValue
    @Id
    private Long id;

    private String isim;
    private String soyisim;

    // Email annotation
    private String email;
    private String telefon;
    private String arac_plakasi;

    private String acil_durum_kisi;
    private String acil_durum_telefon;
    private String adres;

    private String akademik_unvan;
    // Will add annotation for tckimlikno
    private long tcKimlikNo;

    @Enumerated(EnumType.STRING)
    private Cinsiyet cinsiyet;



    private LocalDate dogumTarihi;

    private KanGrubu kanGrubu;

    @OneToMany
    Set<Proje> dahilOlduguProjeler = new HashSet<>();
    @OneToMany
    Set<Egitim> egitim = new HashSet<>();
    @OneToMany
    Set<Katki> katkilar = new HashSet<>();
    @OneToMany
    Set<Dosya> dosyalar = new HashSet<>();


    public void AddProject(Proje proje){
        dahilOlduguProjeler.add(proje);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public long getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(long tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Cinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getAkademik_unvan() {
        return akademik_unvan;
    }

    public void setAkademik_unvan(String akademik_unvan) {
        this.akademik_unvan = akademik_unvan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(LocalDate dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public KanGrubu getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(KanGrubu kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getArac_plakasi() {
        return arac_plakasi;
    }

    public void setArac_plakasi(String arac_plakasi) {
        this.arac_plakasi = arac_plakasi;
    }

    public String getAcil_durum_kisi() {
        return acil_durum_kisi;
    }

    public void setAcil_durum_kisi(String acil_durum_kisi) {
        this.acil_durum_kisi = acil_durum_kisi;
    }

    public String getAcil_durum_telefon() {
        return acil_durum_telefon;
    }

    public void setAcil_durum_telefon(String acil_durum_telefon) {
        this.acil_durum_telefon = acil_durum_telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
