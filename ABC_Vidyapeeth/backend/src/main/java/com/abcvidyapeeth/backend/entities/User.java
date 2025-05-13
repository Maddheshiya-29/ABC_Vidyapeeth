package com.abcvidyapeeth.backend.entities;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="user")
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="user_name", nullable=false)
	private String userName;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@JsonIgnore
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="deleted", nullable=false)
	private Boolean deleted=false;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="mobile", nullable=false)
	private String mobile;
	
	@Enumerated(EnumType.STRING)
    @ElementCollection(fetch=FetchType.EAGER)
    private Set<Role> roles;
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // Access roles from the user entity
        // Set<Role> roles = user.getRoles();
        // Convert roles to GrantedAuthority objects
        for (Role role : roles) {
            //	String roleName = role.getRoleName().toUpperCase();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
            authorities.add(authority);
        }
        return authorities;
    }

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
}
