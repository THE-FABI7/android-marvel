package com.example.marvel.data.remote;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import cafsoft.foundation.URLComponents;
import cafsoft.foundation.URLQueryItem;
import cafsoft.foundation.URLSession;


public class MarvelApi extends RemoteDataSource {
    private final String BASE_URL = "http://gateway.marvel.com/v1/public/characters";
    private final String API_KEY = "13977f0967de4387afcc0e28c8098b5f";

    private final String HASH = "dc1b084f62cec1c34c3f1060f58f3cc9";

    private final String ts = "1712458514";

    public  void requestMovieInfo(String name, TextCompletionHandler textCompletionHandler, ErrorCodeCompletionHandler errorCodeCompletionHandler) {
        var comp = new URLComponents(BASE_URL);
        comp.setQueryItems(new URLQueryItem[]{
                new URLQueryItem("name", name),
                new URLQueryItem("apiKey", API_KEY),
                new URLQueryItem("hash", HASH),
                new URLQueryItem("ts", ts),
        });

        //Generate the URL from the components
        var url = comp.getURL();

        //Get Default URLsession
        var session = URLSession.getShared();


        //create a network task for the GET request
        var task = createDataTask(url, session, (errorCode, data) -> {
            if (errorCode == 200) {
                var text = (String) null;
                if (data != null)
                    text = data.toText();
                textCompletionHandler.run(text);

            } else {
                errorCodeCompletionHandler.run(errorCode);
            }
        });

        task.resume();
    }

    public void requestImage(String stringURL, ImageCompletionHandler imageCompletionHandler, ErrorCodeCompletionHandler errorCodeCompletionHandler) {

        var components = new URLComponents(stringURL);
        components.setScheme("https");

        //Generate the URL from the components
        var url = components.getURL();

        //Get default URLsession
        var session = URLSession.getShared();

        //create a network task for the GET request
        var task = createDataTask(url, session, (errorCode, data) -> {
            if (errorCode == 200) {
                var bitmap = (Bitmap) null;
                if (data != null)
                    bitmap = BitmapFactory.decodeByteArray(data.toBytes(), 0, data.length());
                imageCompletionHandler.run(bitmap);
            } else {
                errorCodeCompletionHandler.run(errorCode);
            }
        });
        //start the task
        task.resume();
    }
}
