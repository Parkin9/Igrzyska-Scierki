package pl.parkin9.IgrzyskaScierki.service;

import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.model.Task;

import java.util.List;

public interface TaskService {

    void saveTask(Task task);

    List<Task> findAllTasks(PlayerGroup playerGroup);

    Task findOneById(Long id);

    void deleteTask(Task task);


    /*TODO Metoda do sprawdzania czy dana nazwa zadania, nie istnieje juz w bazie.(PlayerGroup playergroup)*/
}
