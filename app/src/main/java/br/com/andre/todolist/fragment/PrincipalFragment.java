package br.com.andre.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.andre.todolist.R;
import br.com.andre.todolist.adapter.TarefaAdapter;
import br.com.andre.todolist.database.AppDatabase;
import br.com.andre.todolist.databinding.FragmentPrincipalBinding;
import br.com.andre.todolist.model.Tarefa;

public class PrincipalFragment extends Fragment {
    private FragmentPrincipalBinding binding;
    //variavel para a database
    private AppDatabase database;
    //variavel para o adapter
    private TarefaAdapter adapter;
    //variavel para lista
    private List<Tarefa> tarefas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPrincipalBinding.inflate(inflater, container, false);

        binding.btnAdd.setOnClickListener(v -> {
            NavHostFragment.findNavController(PrincipalFragment.this).navigate(R.id.action_principalFragment_to_cadTarefaFragment);
        });
        return binding.getRoot();
    }
}