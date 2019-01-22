package my.vlong.java.homework05.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDTO {
    private String id;
    private String name;
    private Gender gender;
    private String dateOfBirth;
    private CourseDTO courseDTO;

    @Override
    public String toString() {
        return "StudentDTO{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", course=" + courseDTO + '}';
    }
    
    
}
