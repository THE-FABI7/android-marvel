package com.example.marvel.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.icu.text.IDNA;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marvel.R;
import com.example.marvel.data.remote.MarvelApi;
import com.example.marvel.domain.model.Root;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cafsoft.foundation.HTTPURLResponse;
import cafsoft.foundation.URLComponents;
import cafsoft.foundation.URLQueryItem;
import cafsoft.foundation.URLRequest;
import cafsoft.foundation.URLSession;

public class MainActivity extends AppCompatActivity {

    private Button btnSearch = null;
    private TextView labTittle = null;
    private TextView labDescripcion = null;
    private EditText editTextMovieName;

    private ImageView imgPoster = null;

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
        String personajeName = editTextMovieName.getText().toString();
        if (personajeName.isEmpty()) {
            // Mostrar mensaje de error si el campo está vacío
            Toast.makeText(MainActivity.this, "Por favor ingrese el nombre del personaje", Toast.LENGTH_SHORT).show();
            return;
        }

        marvelApi.requestMovieInfo(personajeName, text ->{
            GsonBuilder gsonBuilder = new GsonBuilder();
            var root = gsonBuilder.create().fromJson(text, Root.class);
            if (root.getName() != null && !root.getName().isEmpty()) {
                Log.d("data", root.getName());
                requestImage(root);
            } else {
                // Mostrar mensaje de error
                runOnUiThread(() -> {
                    Toast.makeText(MainActivity.this, "Personaje no encontrado", Toast.LENGTH_SHORT).show();
                });
            }
        }, errorCode -> {
            Log.d("error", String.valueOf(errorCode));
        });
    }

    public void showMovieInfo(Root info, Bitmap image) {
         labTittle.setText("Nombre: " + info.getName());
         labDescripcion.setText("Descripción: " + info.getDescription());
         imgPoster.setImageBitmap(image);
    }

    public void requestImage(Root info) {
        String imageUrl = info.getThumbnail().getPath() + "." + info.getThumbnail().getExtension();
        marvelApi.requestImage(imageUrl, image -> {
            runOnUiThread(() -> showMovieInfo(info, image));
        }, errorCode -> {
            Log.d("error", String.valueOf(errorCode));
        });
    }
}