package br.com.andre.todolist.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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
        //instancia o database
        database = AppDatabase.getDatabase(getActivity());

        //define o layout manager do recycler view
        binding.recicleTarefas.setLayoutManager(new LinearLayoutManager(getContext()));

        //executa a async task
        new ReadTarefa().execute();

        return binding.getRoot();
    }
    class ReadTarefa extends AsyncTask<Void, Void, List<Tarefa>>{

        @Override
        protected List<Tarefa> doInBackground(Void... voids) {
            //guarda na variavel tarefas, as tarefas do banco de dados
            tarefas = database.getTarefaDao().getAll();
            //retorna a lista de tarefas
            return  tarefas;
        }

        @Override
        protected void onPostExecute(List<Tarefa> tarefas) {
            //instancia o adapter
            adapter = new TarefaAdapter(tarefas, getActivity(), ListenerTarefa);
            //aplica o adapter no recycleview
            binding.recicleTarefas.setAdapter(adapter);
        }
    }


    //implementacao da interface OnTarefaClickListener
    private TarefaAdapter.OnTarefaClickListener ListenerTarefa = (view, tarefa) -> {
        Bundle bundle = new Bundle();
        //colocar a tarefa no pacote
        bundle.putSerializable("tarefa", tarefa);
        //navega para o próximo fragment enviando o bundle
        NavHostFragment.findNavController(PrincipalFragment.this).navigate(R.id.action_principalFragment_to_detalheTarefaFragment, bundle);
    };
}