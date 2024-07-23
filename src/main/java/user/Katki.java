package user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import user.enums.EtkinlikTuru;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Katki {
    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private EtkinlikTuru etkinlikTuru;

    private String aciklama;
    private String link;
    private String ek;
    private LocalDate yuklenmeTarihi;

    public Katki(EtkinlikTuru etkinlikTuru, String link, String ek, LocalDate yuklenmeTarihi) {
        this.etkinlikTuru = etkinlikTuru;
        this.link = link;
        this.ek = ek;
        this.yuklenmeTarihi = yuklenmeTarihi;
    }
}
