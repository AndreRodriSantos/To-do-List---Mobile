package br.com.andre.todolist.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.andre.todolist.model.Tarefa;

@Dao
public interface TarefaDao {
    @Insert
    void insert(Tarefa t);

    @Update
    void atualizar(Tarefa t);

    @Delete
    void deletar(Tarefa t);

    @Query("select * from tarefa")
    List<Tarefa> getAll();
}
