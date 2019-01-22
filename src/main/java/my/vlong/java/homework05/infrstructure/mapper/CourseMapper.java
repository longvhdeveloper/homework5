package my.vlong.java.homework05.infrstructure.mapper;

import my.vlong.java.homework05.domain.dto.CourseDTO;
import my.vlong.java.homework05.infrstructure.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper extends IMapper<Course, CourseDTO> {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
}
