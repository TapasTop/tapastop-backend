package tapastop.requests;

import jakarta.persistence.Column;

import java.util.Date;

public class SaveUserRequest {

    private String username;
    private String password;
    private String mail;
    private String name;
    private String surname;
    private Date birthdate;
    private String gender;
    private String address;

    public SaveUserRequest() {
    }

    public SaveUserRequest(String username, String password, String mail, String name, String surname, String gender, String address) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.birthdate = new Date(System.currentTimeMillis());
        this.gender = gender;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
