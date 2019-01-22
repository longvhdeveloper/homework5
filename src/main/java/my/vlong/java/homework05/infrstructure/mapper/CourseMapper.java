package my.vlong.java.homework05.infrstructure.mapper;

import my.vlong.java.homework05.domain.dto.CourseDTO;
import my.vlong.java.homework05.infrstructure.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public interface CourseMapper extends IMapper<Course, CourseDTO> {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Override
    @Mappings({
            @Mapping(target = "studentDTOs", source = "course.students")
    })
    CourseDTO toDTO(Course course);

    @Override
    @Mappings({
            @Mapping(target = "students", source = "t.studentDTOs")
    })
    Course toEntity(CourseDTO t);
}
