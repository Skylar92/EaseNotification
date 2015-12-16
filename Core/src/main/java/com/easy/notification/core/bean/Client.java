package com.easy.notification.core.bean;

import com.easy.notification.core.anotation.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by skylar on 10.12.15.
 */
@Entity
@Table(name = "Client")
@NamedQueries({
        @NamedQuery(name = "Client.findByEmail", query = "select c from Client as c where c.email = :email")
})
public class Client {

    @Id
    @SequenceGenerator(name = "sql_user_sequence", sequenceName = "hibernate_user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sql_user_sequence")
    @Column(name = "id")
    private int id;

    @NotNull
    @Size(min = 2, max = 32, message = "Invalid username. Name must be between {min} and {max} characters long")
    private String name;

    @NotNull
    @Size(min = 2, max = 32, message = "Invalid lastName. Last name must be between {min} and {max} characters long")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email(message = "Invalid email")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Size(min = 8, max = 96, message = "Invalid password. Password must be between {min} and {max} characters long")
    @Column(name = "password")
    private String password;

    //auto generation field
    @Column(name = "salt")
    private String salt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client user = (Client) o;

        if (id != user.id) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (salt != null ? !salt.equals(user.salt) : user.salt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
