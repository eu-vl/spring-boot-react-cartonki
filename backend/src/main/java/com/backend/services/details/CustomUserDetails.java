package com.backend.services.details;

import com.backend.models.Role;
import com.backend.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails implements UserDetails {
    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails() {
    }

    public static CustomUserDetails build(User user) {
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.id = user.getId();
        userDetails.firstName = user.getFirstName();
        userDetails.secondName = user.getSecondName();
        userDetails.email = user.getEmail();
        userDetails.password = user.getPassword();
        userDetails.authorities = buildGrantedAuthority(user.getRoles());
        return userDetails;
    }

    private static List<GrantedAuthority> buildGrantedAuthority(Set<Role> roles) {
        Set<GrantedAuthority> setAuthorities = new HashSet<>();

        for (Role role : roles) {
            setAuthorities.add(new SimpleGrantedAuthority(role.getTitle()));
        }
        return new ArrayList<>(setAuthorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
