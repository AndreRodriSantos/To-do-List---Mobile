package br.com.andre.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import br.com.andre.todolist.databinding.FragmentDetalheTarefaBinding;

public class DetalheTarefaFragment extends Fragment {
    private FragmentDetalheTarefaBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalheTarefaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}