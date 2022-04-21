package br.com.andre.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.andre.todolist.databinding.FragmentCadSubTarefaBinding;

public class CadSubTarefaFragment extends Fragment {
    private FragmentCadSubTarefaBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadSubTarefaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}