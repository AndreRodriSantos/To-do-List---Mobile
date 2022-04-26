package br.com.andre.todolist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tarefa {
    @PrimaryKey(autoGenerate = true)
    private Long idTarefa;
    private String titulo;
    private String descricao;
    private long dataCricao;
    private  long dataPrevista;
    private long dataFinalizada;

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(long dataCricao) {
        this.dataCricao = dataCricao;
    }

    public long getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(long dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public long getDataFinalizada() {
        return dataFinalizada;
    }

    public void setDataFinalizada(long dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }
}
