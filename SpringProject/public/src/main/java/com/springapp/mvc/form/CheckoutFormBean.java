package com.springapp.mvc.form;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

public class CheckoutFormBean {

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String area;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String city;

    private Long flat;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String house;

    @AssertTrue(message = "Вы !!!СОГЛАСНЫ!!! на обработку своих данных")
    private Boolean accept;

    @Size(min = 6,max = 6)
    private String post_index;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String street;


    public CheckoutFormBean () {}

    public CheckoutFormBean(String area, String city, Long flat, String house, Boolean accept, String post_index, String street) {
        this.area = area;
        this.city = city;
        this.flat = flat;
        this.house = house;
        this.accept = accept;
        this.post_index = post_index;
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getFlat() {
        return flat;
    }

    public void setFlat(Long flat) {
        this.flat = flat;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Boolean getAccept() {
        return accept;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    public String getPost_index() {
        return post_index;
    }

    public void setPost_index(String post_index) {
        this.post_index = post_index;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    @Override
    public String toString() {
        return "CheckoutFormBean{" +
                "area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", flat=" + flat +
                ", house=" + house +
                ", accept=" + accept +
                ", post_index='" + post_index + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
