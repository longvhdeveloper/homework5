package my.vlong.java.homework05.domain.repository;

import java.util.List;
import java.util.Optional;
import my.vlong.java.homework05.infrstructure.entity.Course;
import my.vlong.java.homework05.infrstructure.entity.Student;

public interface ICourseRepository extends IRepository<Course, Integer> {

    List<Student> getStudentsOfCourse(Optional<Course> course);

    List<Course> findByNameContaining(String keyWord);
}
