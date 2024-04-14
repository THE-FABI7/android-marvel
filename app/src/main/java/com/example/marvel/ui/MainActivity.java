package com.example.marvel.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marvel.R;
import com.example.marvel.data.remote.MarvelApi;
import com.example.marvel.domain.model.Result;
import com.example.marvel.domain.model.Welcome4;
import com.google.gson.GsonBuilder;

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
      imgPoster = findViewById(R.id.imgPoster);
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

        marvelApi.requestMovieInfo(personajeName, text -> {
            GsonBuilder gsonBuilder = new GsonBuilder();
            // ... (estrategia personalizada de nombres de campos)
            try {
                Welcome4 welcome = gsonBuilder.create().fromJson(text, Welcome4.class);
                Result[] results = welcome.getData().getResults();

                if (results.length > 0) {
                    Result result = results[0];
                    if (result.getName() != null) {
                        Log.d("data", result.getName());
                        requestImage(result);
                    }
                } else if (results.length < 0){
                    runOnUiThread(() -> {
                        Toast.makeText(MainActivity.this, "Película no encontrada", Toast.LENGTH_SHORT).show();
                    });
                }
            } catch (Exception e) {
                Log.e("error", "Error parsing JSON response", e);
            }
        }, errorCode -> {
            Log.d("error", String.valueOf(errorCode));
        });
    }

    public void showMovieInfo(Result info, Bitmap image) {
         labTittle.setText("Nombre: " + info.getName());
         labDescripcion.setText("Descripción: " + info.getDescription());
         imgPoster.setImageBitmap(image);
    }

    public void requestImage(Result info) {
        String imageUrl = info.getThumbnail().getPath() + "." + info.getThumbnail().getExtension();
        Log.d("urlimagen", imageUrl);
        marvelApi.requestImage(imageUrl, image -> {
            if (image != null) { // Check if image is downloaded successfully
                runOnUiThread(() -> showMovieInfo(info, image));
            } else {
                // Handle failed image download (e.g., show error message)
                Log.e("error", "Failed to download image");
            }
        }, errorCode -> {
            Log.d("error", String.valueOf(errorCode));
        });
    }

}