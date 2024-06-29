package sondev.hibernate_mysql.service;

import java.util.List;

public interface IService<T>{

    // Save operation
    T save(T item);

    // Read operation
    List<T> fetchList();

    // Update operation
    T update(T t, Long id);

    // Delete operation
    void deleteById(Long id);
}
