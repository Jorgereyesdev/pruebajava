package app.entities;

public class Student {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private boolean state = true;
    private Integer idCourse;
    private Integer idGrade;

    //Constructors
    public Student() {
    }

    public Student(Integer id, String name, String lastname, String email, boolean state, Integer idCourse, Integer idGrade) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.state = state;
        this.idCourse = idCourse;
        this.idGrade = idGrade;
    }

    public Student(String name, String lastname, String email, boolean state) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.state = state;
    }

    public Student(int id, String name, String lastname, String email, boolean state) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.state = state;
    }

    public Student(String name, String lastname, String email, boolean state, int idCourse, int idGrade) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.state = state;
        this.idCourse = idCourse;
        this.idGrade = idGrade;
    }


    // Getters and Setters...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name=" + name +
                ", lastname=" + lastname +
                ", email=" + email +
                ", state=" + state +
                ", idCourse=" + idCourse +
                ", idGrade=" + idGrade + '}';
    }
}
