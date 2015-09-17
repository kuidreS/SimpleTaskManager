import dao.TaskRepository;
import model.Task;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitalii on 17.09.2015.
 */
public class Application {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TaskRepository taskRepository = context.getBean(TaskRepository.class);

        //set Task data
        Task task1 = new Task();
        task1.setName("Shopping");
        task1.setDescription("Buy: water, cheese, bread");
        task1.setPriority("Normal");
        task1.setStatus("Resolved");
        task1.setDate(new Date());

        Task task2 = new Task();
        task2.setName("Meeting");
        task2.setDescription("Project meeting");
        task2.setPriority("High");
        task2.setStatus("Open");
        task2.setDate(new Date());

        Task task3 = new Task();
        task3.setName("Lunch");
        task3.setPriority("Normal");
        task3.setStatus("Open");
        task3.setDate(new Date());

        //save Task data in task_manager database
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);

        //find data in task_manager database using JPA
        Task task = taskRepository.findByName("Meeting");
        List<Task> allTasks = (List<Task>)taskRepository.findAll();
        List<Task> tasksByStatus = taskRepository.findByStatus("Open");
        List<Task> tasksByPriority = taskRepository.findByPriority("High");

        //output data
        System.out.println(task);
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Task t : allTasks) {
            System.out.println(t);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Task t : tasksByStatus) {
            System.out.println(t);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Task t : tasksByPriority) {
            System.out.println(t);
        }

    }

}
