package yte.ypbs.ypbs_2024_ge3.login.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import yte.ypbs.ypbs_2024_ge3.common.entity.BaseEntity;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authority")
public class Authority extends BaseEntity implements GrantedAuthority {

    private String authority;

    @ManyToMany
    private List<CustomUser> users;

    public Authority(String authority) {
        super();
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
