package br.com.andre.todolist.fragment;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Calendar;

import br.com.andre.todolist.database.AppDatabase;
import br.com.andre.todolist.databinding.FragmentCadTarefaBinding;
import br.com.andre.todolist.model.Tarefa;

public class CadTarefaFragment extends Fragment {
    private FragmentCadTarefaBinding binding;
    //variavel para o date picker
    DatePickerDialog datePicker;
    //variaveis para o dia, mês e ano
    int year, month, day;
    //variavel para a data atual
    Calendar dataAtual;
    //variavel para da data formatada
    String dataEscolhida = "";
    //variavel para acessa a database
    AppDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //instaciar a appdatabase
        database = AppDatabase.getDatabase(getActivity());

        binding = FragmentCadTarefaBinding.inflate(inflater, container, false);

        //instancia a data atual
        dataAtual = Calendar.getInstance();

        // descobre a data atual
        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        datePicker = new DatePickerDialog(getContext(), (view, ano, mes, dia) -> {

            year = ano;
            month = mes;
            day = dia;
            //formata a String da dataEscolhida
            dataEscolhida = String.format("%02d/%02d/%04d", day, month, year);
            //jogar a String no botao
            binding.dataButton.setText(dataEscolhida);

        }, year, month ,day);

        //listener do botao de data
        binding.dataButton.setOnClickListener(view -> {
            //abre o DatePicker
            datePicker.show();
        });

        binding.salvarButton.setOnClickListener(view -> {
            //validar os campos
            if(binding.titulo == null || binding.descricao == null || dataEscolhida.isEmpty()){
                Toast.makeText(getActivity().getApplicationContext(), "Preencha os Campos", Toast.LENGTH_SHORT).show();
            }else{
                Tarefa tarefa = new Tarefa();
                //popular a tarefa
                tarefa.setTitulo(binding.titulo.getText().toString());
                tarefa.setDescricao(binding.descricao.getText().toString());
                //cria um calendar e popula com a data que foi selecionado
                Calendar dataRealizacao = Calendar.getInstance();
                dataRealizacao.set(year, month, day);
                //passar para a tarefa os milissegundos da data
                tarefa.setDataPrevista(dataRealizacao.getTimeInMillis());
                //criar um calendar para a data atual
                Calendar dataAtual = Calendar.getInstance();
                tarefa.setDataCricao(dataAtual.getTimeInMillis());
                //salvar a tarefa
                new InsertTarefa().execute(tarefa);
            }
        });
        return binding.getRoot();
    }
    //classe para a task de Inserir Tarefa
    private class InsertTarefa extends AsyncTask<Tarefa, Void, String> {

        @Override
        protected void onPreExecute() {
            Log.w("Passou" ,"no OnProgress");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.w("Passou", "Processando...");
        }

        @Override
        protected String doInBackground(Tarefa... tarefas) {
            Log.w("Passou", "no doInBack");
            //extrair a Tarefa do vetor
            Tarefa t = tarefas[0];
            try {
                database.getTarefaDao().insert(t);
                //retorn ok se deu certo
                return "ok";
            } catch (Exception e) {
                //retorna uma mensagem de erro se deu errado
                e.printStackTrace();
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if(s.equals("ok")){
                Log.w("Resultado", "É tetra!!!");
                //aciona o botao de voltar
                getActivity().onBackPressed();
            }else{
                Log.w("Resultado", "Não foi dessa vez");
            }
            Log.w("Passou", "no Execute");
        }
    }
}