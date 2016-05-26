package mvc.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String secondname;
    private String email;
    private String subject;

    public Feedback() {}

    public Feedback(Long id, String firstname, String secondname, String email, String subject) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.subject = subject;
    }

    public Feedback(String firstname, String secondname, String email, String subject) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
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
}
