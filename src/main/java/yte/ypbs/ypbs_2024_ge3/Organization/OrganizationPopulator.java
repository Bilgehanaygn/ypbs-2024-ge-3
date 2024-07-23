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
        Organization bilgemyk = new Organization("Bilgem YK",null);
        Organization bilgembaskani = new Organization("Bilgem Başkanı", bilgemyk);
        Organization enstitumuduru = new Organization("Enstitü Müdürü", bilgembaskani);

        Organization pyo = new Organization("PYO", enstitumuduru);
        Organization isgelistirmevesozlesmebirimi = new Organization("İş Gelistirme ve Sözleşme Birimi",enstitumuduru);
        Organization tesisyonetimi = new Organization("Tesis Yönetimi",enstitumuduru);
        Organization urunlestirmeveurunyonetimi = new Organization("Ürünleştirme ve Ürün Yönetimi",enstitumuduru);
        Organization enstitukurulu = new Organization("Enstitü Kurulu",enstitumuduru);
        Organization kurumsalkaynakyonetimi = new Organization("Kurumsal Kaynak Yönetimi",enstitumuduru);
        Organization kalitevestratejiyonetimi = new Organization("Kalite ve Strateji Yönetimi",enstitumuduru);
        Organization teknolojibirliklerikoordinasyonu = new Organization("Teknoloji Birlikleri Koordinasyonu",enstitumuduru);
        Organization yazilimgelistirmeteknolojileriemy = new Organization("Yazılım Geliştirme Teknolojileri EMY",enstitumuduru);
        Organization dijitaldonusumcozumleriemy = new Organization("Dijital Dönüşüm Çözümleri EMY",enstitumuduru);

        Organization satinalma = new Organization("Satın Alma" ,  kurumsalkaynakyonetimi);
        Organization insankaynaklari = new Organization("İnsan Kaynakları" ,  kurumsalkaynakyonetimi);
        Organization egitimveorganizasyon = new Organization("Eğitim ve Organizasyon" ,  kurumsalkaynakyonetimi);

        Organization projeyonetimi_ygt = new Organization("Proje Yönetimi",  yazilimgelistirmeteknolojileriemy);
        Organization yazilimmimarisivealtyapiyonetimi = new Organization("Yazılım Mimarisi ve Altyapı Yönetimi",  yazilimgelistirmeteknolojileriemy);
        Organization yazilimgelistirme = new Organization("Yazılım Geliştirme",  yazilimgelistirmeteknolojileriemy);
        Organization acikkaynakyazilimteknolojileri = new Organization("Açık Kaynak Yazılım Teknolojileri",  yazilimgelistirmeteknolojileriemy);

        Organization projeyonetimi_ddc = new Organization("Proje Yönetimi",  dijitaldonusumcozumleriemy);
        Organization dijitalstratejivedonusumplanlama = new Organization("Dijital Strateji ve  Dönüşüm Planlama",  dijitaldonusumcozumleriemy);
        Organization bilgibirimi = new Organization("Bilgi Birimi",  dijitaldonusumcozumleriemy);
        Organization gereksinimmuhendisligivekullanicideneyimi = new Organization("Gereksinim Mühendisliği ve Kullanıcı Deneyimi",  dijitaldonusumcozumleriemy);

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
