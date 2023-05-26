package ru.mirea.rulev.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.rulev.lesson6.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPref = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if(!sharedPref.getString("group", "unknown").equals("unknown") || !sharedPref.getString("number", "unknown").equals("unknown") || !sharedPref.getString("serial", "unknown").equals("unknown"))
        {
            binding.editTextTextPersonName.setText(sharedPref.getString("group", "unknown"));
            binding.editTextTextPersonName2.setText(sharedPref.getString("number", "unknown"));
            binding.editTextTextPersonName3.setText(sharedPref.getString("serial", "unknown"));
        }


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("group", binding.editTextTextPersonName.getText().toString());
                editor.putString("number", binding.editTextTextPersonName2.getText().toString());
                editor.putString("serial", binding.editTextTextPersonName3.getText().toString());
                editor.apply();
            }
        });
    }
}