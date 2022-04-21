package br.com.andre.todolist.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

import br.com.andre.todolist.databinding.FragmentCadTarefaBinding;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadTarefaBinding.inflate(inflater, container, false);

        //instancia a data atual
        dataAtual = Calendar.getInstance();

        // descobre a data atual
        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        datePicker = new DatePickerDialog(getContext(), (view, ano, mes, dia) -> {

        }, year, month ,day);

        //listener do botao de data
        binding.dataButton.setOnClickListener(view -> {
            //abre o DatePicker
            datePicker.show();
        });

        return binding.getRoot();
    }
}