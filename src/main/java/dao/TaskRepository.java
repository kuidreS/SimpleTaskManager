package dao;

import model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitalii on 17.09.2015.
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findByName(String name);

    List<Task> findByStatus(String status);

    List<Task> findByPriority(String priority);

}
