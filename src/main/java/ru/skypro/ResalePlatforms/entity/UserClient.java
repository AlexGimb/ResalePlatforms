package ru.skypro.ResalePlatforms.entity;

import ru.skypro.ResalePlatforms.dto.Role;
import ru.skypro.ResalePlatforms.dto.UserDTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserClient extends UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String password;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String lastName;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String phone;

    @Column(nullable = true, columnDefinition = "VARCHAR(255)")
    private String image;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private Role role;

    public UserClient(int id, String username, String password, String firstName,
                      String lastName, String phone, String image, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.image = image;
        this.role = role;
    }

    public UserClient() {

    }

    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserClient userClient = (UserClient) o;
        return id == userClient.id && Objects.equals(username, userClient.username) && Objects.equals(password, userClient.password) && Objects.equals(firstName, userClient.firstName) && Objects.equals(lastName, userClient.lastName) && Objects.equals(phone, userClient.phone) && Objects.equals(image, userClient.image) && role == userClient.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, phone, image, role);
    }
}
