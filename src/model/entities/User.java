package model.entities;

import java.sql.Date;

public class User {
    private String name;
    private String email;
    private String birthDate;
    private Integer age;

    public User(String name, String email, String birthDate, Integer age) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Email: %s | Data de Nascimento: %s | Idade: %d\n", name, email, birthDate, age);
    }
}
