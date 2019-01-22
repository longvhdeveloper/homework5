package my.vlong.java.homework05.domain.repository;

import java.util.List;
import my.vlong.java.homework05.infrstructure.entity.Student;

public interface IStudentRepository extends IRepository<Student, Integer> {

    List<Student> findByNameContaining(String keyWord);
}
