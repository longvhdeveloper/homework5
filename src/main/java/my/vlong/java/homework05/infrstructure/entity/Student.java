package my.vlong.java.homework05.infrstructure.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "date_of_birth", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "gender")
    private int gender;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fullname=" + fullname + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender +
                ", course=" + course + '}';
    }

}
