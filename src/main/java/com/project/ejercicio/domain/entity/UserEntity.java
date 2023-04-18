package com.project.ejercicio.domain.entity;

import com.project.ejercicio.common.validator.ValidatePassword;
import com.project.ejercicio.domain.model.TokenModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty
    @ValidatePassword
    private String password;

    @ElementCollection(fetch= FetchType.EAGER)
    @CollectionTable(name="phone_number", joinColumns = @JoinColumn(name = "id"))
    private List<PhoneEntity> phones;

    private String created;

    private String modified;

    private String last_login;

    private TokenModel token;

    private boolean isActive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public TokenModel getToken() {
        return token;
    }

    public void setToken(TokenModel token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}