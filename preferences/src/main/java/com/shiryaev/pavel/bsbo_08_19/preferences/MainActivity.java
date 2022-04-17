package com.shiryaev.pavel.bsbo_08_19.preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private EditText name, university;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonLoad = findViewById(R.id.buttonLoad);
        name = findViewById(R.id.name);
        university = findViewById(R.id.university);
        tvResult = findViewById(R.id.textViewResult);
        sharedPreferences = getPreferences(MODE_PRIVATE);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", name.getText().toString());
                editor.putString("Univ", university.getText().toString());
                editor.apply();
            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = sharedPreferences.getString("Name", null);
                String placeOfStudy = sharedPreferences.getString("Univ", "null");
                tvResult.setText("Имя: " + name + ". Универ: " + placeOfStudy);
            }
        });
    }
}