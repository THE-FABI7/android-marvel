package com.example.marvel.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marvel.R;
import com.example.marvel.data.remote.MarvelApi;
import com.example.marvel.domain.model.Root;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    private Button btnSearch = null;
    private TextView labTittle = null;
    private TextView labDescripcion = null;
    private EditText editTextMovieName;
    private MarvelApi marvelApi = new MarvelApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();

    }

    public void initViews() {
      btnSearch = findViewById(R.id.btnSearch);
      labTittle = findViewById(R.id.labTittle);
      labDescripcion = findViewById(R.id.labDescripcion);
      editTextMovieName = findViewById(R.id.editTextMovieName);

    }

    public void initEvents() {
        btnSearch.setOnClickListener(view -> {
            requestMovieInfo();
        });
    }

    public void requestMovieInfo() {
        String movieName = editTextMovieName.getText().toString();
        if (movieName.isEmpty()) {
            // Mostrar mensaje de error si el campo está vacío
            Toast.makeText(MainActivity.this, "Por favor ingrese el nombre del personaje", Toast.LENGTH_SHORT).show();
            return;
        }




    }

    public void showMovieInfo(Root info, Bitmap image) {

    }

    public void requestImage(Root info) {

    }

}