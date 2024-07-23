package user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Egitim {
    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private EgitimTuru egitimTuru;

    @NotBlank
    private String okulAdi;
    @NotBlank
    private String bolum;
    @NotBlank
    private LocalDate baslangicTarihi;
    @NotBlank
    private LocalDate mezuniyetTarihi;

    private String aciklama;

    public Egitim(EgitimTuru egitimTuru, String okulAdi, String bolum, LocalDate baslangicTarihi, LocalDate mezuniyetTarihi) {
        this.egitimTuru = egitimTuru;
        this.okulAdi = okulAdi;
        this.bolum = bolum;
        this.baslangicTarihi = baslangicTarihi;
        this.mezuniyetTarihi = mezuniyetTarihi;
    }
}
