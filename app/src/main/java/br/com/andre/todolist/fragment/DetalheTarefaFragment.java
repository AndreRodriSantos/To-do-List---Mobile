package br.com.andre.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.text.SimpleDateFormat;

import br.com.andre.todolist.R;
import br.com.andre.todolist.databinding.FragmentDetalheTarefaBinding;
import br.com.andre.todolist.model.Tarefa;

public class DetalheTarefaFragment extends Fragment {
    private FragmentDetalheTarefaBinding binding;
    private Tarefa tarefa;

    //interface para o clique na tarefa
    public interface OnTarefaClickListener {
        void onClick(View view, Tarefa tarefa);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalheTarefaBinding.inflate(inflater, container, false);

        binding.btnAddSub.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("tarefa", tarefa);
            NavHostFragment.findNavController(DetalheTarefaFragment.this).navigate(R.id.action_detalheTarefaFragment_to_cadSubTarefaFragment, bundle);
        });

        //verifica se existe algo sendo passado no bundle
        if(getArguments() !=null){
            tarefa = (Tarefa) getArguments().getSerializable("tarefa");
            //popula os campos com as informações da tarefa
            binding.titulo.setText(tarefa.getTitulo());
            binding.descricao.setText(tarefa.getDescricao());
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            binding.data.setText(formatador.format(tarefa.getDataPrevista()));
            if(tarefa.isFinalizada()){
                binding.titulo.setBackgroundColor(getResources().getColor(R.color.green));
            }else{
                binding.titulo.setBackgroundColor(getResources().getColor(R.color.light_orange));
            }
        }
        return binding.getRoot();
    }
}