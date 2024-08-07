package yte.ypbs.ypbs_2024_ge3.common.populator;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.Organization.Organization;
import yte.ypbs.ypbs_2024_ge3.Organization.OrganizationRepository;

import java.util.List;

@Configuration
public class OrganizationPopulator {

    private OrganizationRepository organizationRepository;

    public OrganizationPopulator(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }


    @Transactional
    public void populate() {
        Organization bilgemYK = new Organization("Bilgem YK",null);
        Organization bilgemBaskani = new Organization("Bilgem Başkanı", bilgemYK);
        Organization enstituMuduru = new Organization("Enstitü Müdürü", bilgemBaskani);

        Organization PYO = new Organization("PYO", enstituMuduru);
        Organization isGelistirmeVeSozlesmeBirimi = new Organization("İş Gelistirme ve Sözleşme Birimi",enstituMuduru);
        Organization tesisYonetimi = new Organization("Tesis Yönetimi",enstituMuduru);
        Organization urunlestirmeVeUrunYonetimi = new Organization("Ürünleştirme ve Ürün Yönetimi",enstituMuduru);
        Organization enstituKurulu = new Organization("Enstitü Kurulu",enstituMuduru);
        Organization kurumsalKaynakYonetimi = new Organization("Kurumsal Kaynak Yönetimi",enstituMuduru);
        Organization kaliteVeStratejiYonetimi = new Organization("Kalite ve Strateji Yönetimi",enstituMuduru);
        Organization teknolojiBirlikleriKoordinasyonu = new Organization("Teknoloji Birlikleri Koordinasyonu",enstituMuduru);
        Organization yazilimGelistirmeTeknolojileriEMY = new Organization("Yazılım Geliştirme Teknolojileri EMY",enstituMuduru);
        Organization dijitalDonusumCozumleriEMY = new Organization("Dijital Dönüşüm Çözümleri EMY",enstituMuduru);

        Organization satinAlma = new Organization("Satın Alma" ,  kurumsalKaynakYonetimi);
        Organization insanKaynaklari = new Organization("İnsan Kaynakları" ,  kurumsalKaynakYonetimi);
        Organization egitimVeOrganizasyon = new Organization("Eğitim ve Organizasyon" ,  kurumsalKaynakYonetimi);

        Organization projeYonetimi_YGT = new Organization("Proje Yönetimi",  yazilimGelistirmeTeknolojileriEMY);
        Organization yazilimMimarisiVeAltyapiYonetimi = new Organization("Yazılım Mimarisi ve Altyapı Yönetimi",  yazilimGelistirmeTeknolojileriEMY);
        Organization yazilimGelistirme = new Organization("Yazılım Geliştirme",  yazilimGelistirmeTeknolojileriEMY);
        Organization acikKaynakYazilimTeknolojileri = new Organization("Açık Kaynak Yazılım Teknolojileri",  yazilimGelistirmeTeknolojileriEMY);

        Organization projeYonetimi_DDC = new Organization("Proje Yönetimi",  dijitalDonusumCozumleriEMY);
        Organization dijitalStratejiVeDonusumPlanlama = new Organization("Dijital Strateji ve  Dönüşüm Planlama",  dijitalDonusumCozumleriEMY);
        Organization bilgiBirimi = new Organization("Bilgi Birimi",  dijitalDonusumCozumleriEMY);
        Organization gereksinimMuhendisligiVeKullaniciDeneyimi = new Organization("Gereksinim Mühendisliği ve Kullanıcı Deneyimi",  dijitalDonusumCozumleriEMY);

        organizationRepository.saveAll(List.of(bilgemYK, bilgemBaskani, enstituMuduru,
                PYO, isGelistirmeVeSozlesmeBirimi, tesisYonetimi, urunlestirmeVeUrunYonetimi,
                enstituKurulu, kurumsalKaynakYonetimi, kaliteVeStratejiYonetimi, teknolojiBirlikleriKoordinasyonu,
                yazilimGelistirmeTeknolojileriEMY, dijitalDonusumCozumleriEMY,
                satinAlma, insanKaynaklari, egitimVeOrganizasyon,
                projeYonetimi_YGT,yazilimMimarisiVeAltyapiYonetimi, yazilimGelistirme,acikKaynakYazilimTeknolojileri,
                projeYonetimi_DDC, dijitalStratejiVeDonusumPlanlama, bilgiBirimi, gereksinimMuhendisligiVeKullaniciDeneyimi
        ));


    }


}
