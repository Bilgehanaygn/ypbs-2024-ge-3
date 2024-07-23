/*
 Bu class User entity gelene kadar kullanılacak bir class. User entity oluşturulduktan sonra bu class silinecek.
 */
package yte.ypbs.ypbs_2024_ge3.User.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
public class User extends BaseEntity {


    private String name;
    private String surname;

    private LocalDate birthDate;

    @Lob
    @Column(name = "image", columnDefinition="BLOB")
    private byte[] image;

    public User(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.image = null;
    }

}
