package my.vlong.java.homework05.domain.dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDTO {

    private String id;
    private String name;
    private List<StudentDTO> studentDTOs;

    @Override
    public String toString() {
        return "CourseDTO{" + "id=" + id + ", name=" + name + ", studentDTOs=" + studentDTOs + '}';
    }
}
