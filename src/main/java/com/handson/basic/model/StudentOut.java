package com.handson.basic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.handson.basic.util.AWSService;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;


@Entity
@SqlResultSetMapping(name = "StudentOut")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentOut {

    @Id
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdat;

    private String fullname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthdate;

    private Integer satscore;
    private Double graduationscore;
    private String phone;
    private String profilepicture;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getAvgscore() {
        return avgscore;
    }

    private Double avgscore;

    public static StudentOut of(Student student, AWSService awsService) {
        StudentOut res = new StudentOut();
        res.id = student.getId();
        res.createdat = student.getCreatedAt();
        res.fullname = student.getFullname();
        res.birthdate = student.getBirthDate();
        res.satscore = student.getSatScore();
        res.graduationscore = student.getGraduationScore();
        res.phone = student.getPhone();
        res.email = student.getEmail();
        res.profilepicture = awsService.generateLink(student.getProfilePicture());
        res.avgscore = null;
        return res;
    }



    // === Getters ===

    public Long getId() {
        return id;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public String getFullname() {
        return fullname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Integer getSatscore() {
        return satscore;
    }

    public Double getGraduationscore() {
        return graduationscore;
    }

    public String getPhone() {
        return phone;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    // === Setters (רק לפי הצורך, אם אתה טוען את האובייקט ישירות ב-JPA) ===

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setSatscore(Integer satscore) {
        this.satscore = satscore;
    }

    public void setGraduationscore(Double graduationscore) {
        this.graduationscore = graduationscore;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }
}
