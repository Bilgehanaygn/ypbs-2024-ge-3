package user;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Kurumsal {
    @OneToOne
    private User user;

    private LocalDate iseGirisTarihi;
    private long sicilNo;
    private String kadro; // Enum da olabilir emin degilim
    private String unvan;
    private String birim;
    private String proje;
    private String gorev;
    private String soyad; // user'da da var??

    @Enumerated(EnumType.STRING)
    private PersonelTuru personelTuru; // Enum
    private CalismaTuru calismaTuru; // Enum
    private CalismaDurumu calismaDurumu; // Enum
    private boolean servisKullanimi; // Emin degilim
    private String dahiliNumara;
    private Integer odaNumara;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(LocalDate iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public long getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(long sicilNo) {
        this.sicilNo = sicilNo;
    }

    public String getKadro() {
        return kadro;
    }

    public void setKadro(String kadro) {
        this.kadro = kadro;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getProje() {
        return proje;
    }

    public void setProje(String proje) {
        this.proje = proje;
    }

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public PersonelTuru getPersonelTuru() {
        return personelTuru;
    }

    public void setPersonelTuru(PersonelTuru personelTuru) {
        this.personelTuru = personelTuru;
    }

    public CalismaTuru getCalismaTuru() {
        return calismaTuru;
    }

    public void setCalismaTuru(CalismaTuru calismaTuru) {
        this.calismaTuru = calismaTuru;
    }

    public CalismaDurumu getCalismaDurumu() {
        return calismaDurumu;
    }

    public void setCalismaDurumu(CalismaDurumu calismaDurumu) {
        this.calismaDurumu = calismaDurumu;
    }

    public boolean isServisKullanimi() {
        return servisKullanimi;
    }

    public void setServisKullanimi(boolean servisKullanimi) {
        this.servisKullanimi = servisKullanimi;
    }

    public String getDahiliNumara() {
        return dahiliNumara;
    }

    public void setDahiliNumara(String dahiliNumara) {
        this.dahiliNumara = dahiliNumara;
    }

    public Integer getOdaNumara() {
        return odaNumara;
    }

    public void setOdaNumara(Integer odaNumara) {
        this.odaNumara = odaNumara;
    }
}
