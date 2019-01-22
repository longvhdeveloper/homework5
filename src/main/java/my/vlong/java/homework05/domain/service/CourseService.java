package my.vlong.java.homework05.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import my.vlong.java.homework05.application.exception.AddException;
import my.vlong.java.homework05.application.exception.DeleteException;
import my.vlong.java.homework05.application.exception.ResultNotFoundException;
import my.vlong.java.homework05.application.exception.UpdateException;
import my.vlong.java.homework05.domain.dto.CourseDTO;
import my.vlong.java.homework05.domain.dto.StudentDTO;
import my.vlong.java.homework05.domain.repository.ICourseRepository;
import my.vlong.java.homework05.infrstructure.entity.Course;
import my.vlong.java.homework05.infrstructure.entity.Student;
import my.vlong.java.homework05.infrstructure.mapper.CourseMapper;
import my.vlong.java.homework05.infrstructure.repository.CourseRepositoryImplDB;

public class CourseService {

    private final ICourseRepository courseRepository;

    public CourseService() {
        courseRepository = new CourseRepositoryImplDB();
    }

    public CourseDTO add(CourseDTO courseDTO) throws AddException {
        if (!isAddValid(courseDTO)) {
            throw new AddException("Can not add course");
        }
        //Course course = courseFactory.toEntity(courseDTO);
        Course course = null;

        Optional<Course> courseOption = courseRepository.add(course);

        if (!courseOption.isPresent()) {
            throw new AddException("Can not add course");
        }

        //return courseFactory.toDTO(courseOption.get());
        return null;
    }

    public CourseDTO update(int id, CourseDTO courseDTO) throws UpdateException, ResultNotFoundException {
        Optional<Course> courseOptional = courseRepository.findByOne(id);

        if (!courseOptional.isPresent()) {
            throw new ResultNotFoundException("Course not found");
        }

        if (!isUpdateValid(courseDTO)) {
            throw new UpdateException("Can not update course");
        }

        Course courseUpdate = courseOptional.get();
        courseUpdate.setName(courseDTO.getName());

        Optional<Course> courseOption = courseRepository.update(courseUpdate);

        if (!courseOption.isPresent()) {
            throw new UpdateException("Can not update course");
        }

        //return courseFactory.toDTO(courseUpdate);
        return null;
    }

    public boolean delete(int id) {
        boolean isSucces = false;

        if (id == 0) {
            return isSucces;
        }

        try {
            isSucces = courseRepository.delete(id);
        } catch (DeleteException ex) {
            //TODO log here
        }

        return isSucces;
    }

    public List<CourseDTO> findAll() {
        List<Course> courses = new ArrayList<>();
        try {
            courses = courseRepository.findAll();
        } catch (ResultNotFoundException ex) {
            //TODO log here
        }
        System.out.println(courses);
        return courses.stream().map(CourseMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    public List<CourseDTO> search(String keyWord) throws ResultNotFoundException {
        List<Course> courses = courseRepository.findByNameContaining(keyWord);
        if (courses.isEmpty()) {
            throw new ResultNotFoundException("Result list is empty");
        }
        //return courses.stream().map(courseFactory::toDTO).collect(Collectors.toList());
        return null;
    }

    public List<StudentDTO> getStudentOfCourse(int id) throws ResultNotFoundException {
        Optional<Course> course = courseRepository.findByOne(id);
        List<Student> students = courseRepository.getStudentsOfCourse(course);
        if (students.isEmpty()) {
            throw new ResultNotFoundException("Result list is empty");
        }

        //return students.stream().map(studentFactory::toDTO).collect(Collectors.toList());
        return null;
    }

    private boolean isAddValid(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return false;
        }

        if (courseDTO.getName() == null) {
            return false;
        }

        if (courseDTO.getName().equals("")) {
            return false;
        }

        return true;
    }

    private boolean isUpdateValid(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return false;
        }

        if (courseDTO.getName() == null) {
            return false;
        }

        if (courseDTO.getName().equals("")) {
            return false;
        }
        return true;
    }
}
