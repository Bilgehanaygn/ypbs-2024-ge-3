package yte.ypbs.ypbs_2024_ge3.Organization;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OrganizationPopulator {

    private OrganizationRepository organizationRepository;

    public OrganizationPopulator(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @PostConstruct
    public void populate() {
        Organization bilgemyk = new Organization("Bilgem YK", null,null);
        Organization bilgembaskani = new Organization("Bilgem Başkanı", null, bilgemyk);
        Organization enstitumuduru = new Organization("Enstitü Müdürü", null, bilgembaskani);

        Organization pyo = new Organization("PYO", null, enstitumuduru);
        Organization isgelistirmevesozlesmebirimi = new Organization("İş Gelistirme ve Sözleşme Birimi", null,enstitumuduru);
        Organization tesisyonetimi = new Organization("Tesis Yönetimi", null,enstitumuduru);
        Organization urunlestirmeveurunyonetimi = new Organization("Ürünleştirme ve Ürün Yönetimi", null,enstitumuduru);
        Organization enstitukurulu = new Organization("Enstitü Kurulu", null,enstitumuduru);
        Organization kurumsalkaynakyonetimi = new Organization("Kurumsal Kaynak Yönetimi", null,enstitumuduru);
        Organization kalitevestratejiyonetimi = new Organization("Kalite ve Strateji Yönetimi", null,enstitumuduru);
        Organization teknolojibirliklerikoordinasyonu = new Organization("Teknoloji Birlikleri Koordinasyonu", null,enstitumuduru);
        Organization yazilimgelistirmeteknolojileriemy = new Organization("Yazılım Geliştirme Teknolojileri EMY", null,enstitumuduru);
        Organization dijitaldonusumcozumleriemy = new Organization("Dijital Dönüşüm Çözümleri EMY", null,enstitumuduru);

        Organization satinalma = new Organization("Satın Alma" , null , kurumsalkaynakyonetimi);
        Organization insankaynaklari = new Organization("İnsan Kaynakları" , null , kurumsalkaynakyonetimi);
        Organization egitimveorganizasyon = new Organization("Eğitim ve Organizasyon" , null , kurumsalkaynakyonetimi);

        Organization projeyonetimi_ygt = new Organization("Proje Yönetimi", null , yazilimgelistirmeteknolojileriemy);
        Organization yazilimmimarisivealtyapiyonetimi = new Organization("Yazılım Mimarisi ve Altyapı Yönetimi", null , yazilimgelistirmeteknolojileriemy);
        Organization yazilimgelistirme = new Organization("Yazılım Geliştirme", null , yazilimgelistirmeteknolojileriemy);
        Organization acikkaynakyazilimteknolojileri = new Organization("Açık Kaynak Yazılım Teknolojileri", null , yazilimgelistirmeteknolojileriemy);

        Organization projeyonetimi_ddc = new Organization("Proje Yönetimi", null , dijitaldonusumcozumleriemy);
        Organization dijitalstratejivedonusumplanlama = new Organization("Dijital Strateji ve  Dönüşüm Planlama", null , dijitaldonusumcozumleriemy);
        Organization bilgibirimi = new Organization("Bilgi Birimi", null , dijitaldonusumcozumleriemy);
        Organization gereksinimmuhendisligivekullanicideneyimi = new Organization("Gereksinim Mühendisliği ve Kullanıcı Deneyimi", null , dijitaldonusumcozumleriemy);

        organizationRepository.saveAll(List.of(bilgemyk, bilgembaskani, enstitumuduru,
                pyo, isgelistirmevesozlesmebirimi, tesisyonetimi, urunlestirmeveurunyonetimi,
                enstitukurulu, kurumsalkaynakyonetimi, kalitevestratejiyonetimi, teknolojibirliklerikoordinasyonu,
                yazilimgelistirmeteknolojileriemy, dijitaldonusumcozumleriemy,
                satinalma, insankaynaklari, egitimveorganizasyon,
                projeyonetimi_ygt,yazilimmimarisivealtyapiyonetimi, yazilimgelistirme,acikkaynakyazilimteknolojileri,
                projeyonetimi_ddc, dijitalstratejivedonusumplanlama, bilgibirimi, gereksinimmuhendisligivekullanicideneyimi
        ));


    }


}
