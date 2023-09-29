package br.edu.utfpr.turismoapi.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.utfpr.turismoapi.utils.TipoPessoaEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_person")
public class Person extends BaseModel implements UserDetails {
    private String name;

    private String email;

    private String password;

    @Column(nullable = true)
    private LocalDateTime nascimento;

    private TipoPessoaEnum tipo;

    private String cpf;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var papeis = new ArrayList<GrantedAuthority>();
        papeis.add(new SimpleGrantedAuthority(tipo.name()));
        return papeis;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}