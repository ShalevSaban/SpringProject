package com.handson.basic.model;
public enum StudentSortField {
    id("s.id") ,
    createdAt ("s.created_at"),
    fullName ("s.fullname"),
    birthDate ("s.birth_date"),
    satScore ("s.at_score"),
    graduationScore ("s.graduation_score"),
    phone ("s.phone"),
    email("s.email"),
    profilepicture ("s.profile_picture"),
    avgScore (" (select avg(sg.course_score) from  student_grade sg where sg.student_id = s.id ) ");


    public final String fieldName;
    private StudentSortField(String fieldName) {
        this.fieldName = fieldName;
    }

    public static StudentSortField fromString(String value) {
        for (StudentSortField field : StudentSortField.values()) {
            if (field.name().equalsIgnoreCase(value)) {
                return field;
            }
        }
        throw new IllegalArgumentException("Invalid sort field: " + value);
    }

}