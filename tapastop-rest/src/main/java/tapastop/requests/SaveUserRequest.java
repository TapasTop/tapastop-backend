package tapastop.requests;

import jakarta.persistence.Column;

import java.util.Date;

public class SaveUserRequest {

    private String username;
    private String password;
    private String mail;
    private String name;
    private String surname;
    private String birthdate;

    public SaveUserRequest() {
    }

    public SaveUserRequest(String username, String password, String mail, String name, String surname, String birthdate) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
