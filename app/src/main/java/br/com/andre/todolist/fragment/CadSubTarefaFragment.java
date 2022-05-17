package br.com.andre.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;

import br.com.andre.todolist.R;
import br.com.andre.todolist.databinding.FragmentCadSubTarefaBinding;
import br.com.andre.todolist.model.Tarefa;

public class CadSubTarefaFragment extends Fragment {
    private FragmentCadSubTarefaBinding binding;
    private Tarefa tarefa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadSubTarefaBinding.inflate(inflater, container, false);

        if(getArguments() !=null){
            tarefa = (Tarefa) getArguments().getSerializable("tarefa");
            //popula os campos com as informações da tarefa
//            binding.titulo.setText(tarefa.getTitulo());
        }

        return binding.getRoot();
    }
}