package br.com.andre.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.andre.todolist.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}