package app.entities;

public class Registration {
    private Integer id;
    private Integer idStudent;
    private Integer idCourse;

    public Registration() {
    }

    public Registration(Integer id, Integer idStudent, Integer idCourse) {
        this.id = id;
        this.idStudent = idStudent;
        this.idCourse = idCourse;
    }

    public Registration(int courseId, int studentId) {
        this.idCourse = courseId;
        this.idStudent = studentId;
    }

    // Getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public String toString() {
        return "Registrations{" +
                "id=" + id +
                ", idStudent=" + idStudent +
                ", idCourse=" + idCourse +
                '}';
    }
}
