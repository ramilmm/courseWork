package com.springapp.mvc.form;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class ReviewFormBean {

    @Size(min = 3, max = 50, message = "ляляля от 3 до 50 символов")
    private String firstName;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Email
    private String email;

    @Size(min = 3,message = "ляляляллялля от 3 символов")
    private String review;

    public ReviewFormBean() {}

    public ReviewFormBean(String firstName, String email, String review) {
        this.firstName = firstName;
        this.email = email;
        this.review = review;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ReviewFormBean{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
