package my.vlong.java.homework05.infrstructure.mapper;

import my.vlong.java.homework05.domain.dto.StudentDTO;
import my.vlong.java.homework05.infrstructure.entity.Student;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface StudentMapper extends IMapper<Student, StudentDTO> {
    @Override
    @Mappings({
            @Mapping(target = "gender", expression = "java(my.vlong.java.homework05.domain.dto.Gender.map(student" +
                    ".getGender()))")
    })
    StudentDTO toDTO(Student student);

    @Override
    @Mappings({
            @Mapping(target = "gender", expression = "java(t.getGender().getCode())")
    })
    Student toEntity(StudentDTO t);
}
