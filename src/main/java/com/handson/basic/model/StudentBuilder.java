package com.handson.basic.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public final class StudentBuilder {
    private Long id;
    private @NotNull Date createdAt;
    private @NotEmpty @Length(max = 60) String fullname;
    private Date birthDate;
    private @Min(100) @Max(800) Integer satScore;
    private @Min(30) @Max(110) Double graduationScore;
    private @Length(max = 20) String phone;
    private @Length(max = 500) String profilePicture;

    private StudentBuilder() {
    }

    public static StudentBuilder aStudent() {
        return new StudentBuilder();
    }

    public StudentBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public StudentBuilder createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public StudentBuilder fullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public StudentBuilder birthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public StudentBuilder satScore(Integer satScore) {
        this.satScore = satScore;
        return this;
    }

    public StudentBuilder graduationScore(Double graduationScore) {
        this.graduationScore = graduationScore;
        return this;
    }

    public StudentBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public StudentBuilder profilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public Student build() {
        Student student = new Student();
        student.setId(id);
        student.setCreatedAt(createdAt);
        student.setFullname(fullname);
        student.setBirthDate(birthDate);
        student.setSatScore(satScore);
        student.setGraduationScore(graduationScore);
        student.setPhone(phone);
        student.setProfilePicture(profilePicture);
        return student;
    }
}
