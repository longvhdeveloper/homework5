package my.vlong.java.homework05.infrstructure.mapper;

import java.util.List;

public interface IMapper<T, DTO> {

    public DTO toDTO(T t);

    public T toEntity(DTO t);
    
    List<T> toEntities(List<DTO> dtos);

    List<DTO> toDTOs(List<T> entities);
}
