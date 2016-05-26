package com.springapp.mvc.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class FeedbackFormBean {

    @Size(min = 3, max = 50, message = "ляляля от 3 до 50 символов")
    private String firstName;

    @Size(min = 3, max = 50, message = "ляляля от 3 до 50 символов")
    private String secondName;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Email
    private String email;

    @Size(min = 30,message = "ляляляллялля от 30 символов")
    private String subject;

    public FeedbackFormBean(){}


    public FeedbackFormBean(String firstName, String secondName, String email, String subject) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "FeedbackFormBean{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}