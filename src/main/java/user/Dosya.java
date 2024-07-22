package user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dosya {
    @GeneratedValue
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private DosyaTuru dosyaTuru;
    private String dosyaAdi;
    private String bolum;


    private LocalDate yuklenmeTarihi;

    public Dosya(DosyaTuru dosyaTuru, String dosyaAdi, String bolum) {
        this.dosyaTuru = dosyaTuru;
        this.dosyaAdi = dosyaAdi;
        this.bolum = bolum;
    }
}
