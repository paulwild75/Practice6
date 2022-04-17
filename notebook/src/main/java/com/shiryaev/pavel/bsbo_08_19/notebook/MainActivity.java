package com.shiryaev.pavel.bsbo_08_19.notebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "text";
    private EditText editTextText;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveButton = findViewById(R.id.buttonSave);
        editTextText = findViewById(R.id.fileText);
        sharedPreferences = getPreferences(MODE_PRIVATE);
        editTextText.setText(sharedPreferences.getString(TAG, null));
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TAG, editTextText.getText().toString());
                editor.apply();
            }
        });

    }
}