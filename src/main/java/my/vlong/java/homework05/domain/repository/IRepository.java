package my.vlong.java.homework05.domain.repository;

import java.util.List;
import java.util.Optional;
import my.vlong.java.homework05.application.exception.AddException;
import my.vlong.java.homework05.application.exception.DeleteException;
import my.vlong.java.homework05.application.exception.ResultNotFoundException;
import my.vlong.java.homework05.application.exception.UpdateException;

public interface IRepository<T, K> {

    Optional<T> add(T t) throws AddException;

    Optional<T> update(T t) throws UpdateException;

    boolean delete(K k) throws DeleteException;

    Optional<T> findByOne(K k) throws ResultNotFoundException;

    List<T> findAll() throws ResultNotFoundException;
}
