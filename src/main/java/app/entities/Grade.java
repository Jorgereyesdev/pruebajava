package app.entities;

import app.utils.GradesType;

public class Grade {
    private Integer id;
    private Float grade;
    private Enum<GradesType> description;
    private Integer idCourse;

    public Grade() {
    }

    public Grade(Integer id, Float grade, Enum<GradesType> gradestype, Integer idCourse) {
        this.id = id;
        this.grade = grade;
        this.description = gradestype;
        this.idCourse = idCourse;
    }

    public Grade(float updatedGrade, GradesType updatedDescription) {

    }

    public Grade(float grade, GradesType description, int courseId) {
        this.grade = grade;
        this.description = description;
        this.idCourse = courseId;
    }

    // Getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Enum<GradesType> getDescription() {
        return description;
    }

    public void setDescription(Enum<GradesType> gradestype) {
        this.description = gradestype;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", grade=" + grade +
                ", gradestype=" + description +
                ", idCourse=" + idCourse +
                '}';
    }
}
