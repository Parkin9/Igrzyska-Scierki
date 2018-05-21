package pl.parkin9.IgrzyskaScierki.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.model.Task;
import pl.parkin9.IgrzyskaScierki.repository.TaskRepository;
import pl.parkin9.IgrzyskaScierki.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

////////////////////////////////////////////////////////////////////

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> findAllTasks(PlayerGroup playerGroup) {
        return taskRepository.findAllByPlayerGroup(playerGroup);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public Task findOneById(Long id) {
        return taskRepository.getOne(id);
    }
}
