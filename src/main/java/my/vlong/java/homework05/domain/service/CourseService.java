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
            throw new AddException("Data of course to add is not valid");
        }
        Course course = CourseMapper.INSTANCE.toEntity(courseDTO);
        
        Optional<Course> courseOption = courseRepository.add(course);
        
        if (!courseOption.isPresent()) {
            throw new AddException("Can not add course");
        }
        
        return CourseMapper.INSTANCE.toDTO(courseOption.get());
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
        
        return CourseMapper.INSTANCE.toDTO(courseOption.get());
    }
    
    public CourseDTO getCourse(int id) throws ResultNotFoundException {
        Optional<Course> courseOptional = courseRepository.findByOne(id);
        
        if (!courseOptional.isPresent()) {
            throw new ResultNotFoundException("Course not found");
        }
        return CourseMapper.INSTANCE.toDTO(courseOptional.get());
    }
    
    public boolean delete(int id) throws DeleteException {
        boolean isSucces = false;
        
        if (id == 0) {
            return isSucces;
        }
        isSucces = courseRepository.delete(id);
        
        return isSucces;
    }
    
    public List<CourseDTO> findAll() throws ResultNotFoundException {
        List<Course> courses = new ArrayList<>();
        courses = courseRepository.findAll();
        return courses.stream().map(CourseMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }
    
    public List<CourseDTO> search(String keyWord) throws ResultNotFoundException {
        List<Course> courses = courseRepository.findByNameContaining(keyWord);
        if (courses.isEmpty()) {
            throw new ResultNotFoundException("Result list is empty");
        }
        //return courses.stream().map(courseFactory::toDTO).collect(Collectors.toList());
        return courses.stream().map(CourseMapper.INSTANCE::toDTO).collect(Collectors.toList());
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
