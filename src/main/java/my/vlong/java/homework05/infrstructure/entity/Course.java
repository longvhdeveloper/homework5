package my.vlong.java.homework05.infrstructure.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class Course implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Student> students;

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", students=" + students.size() + '}';
    }

}
