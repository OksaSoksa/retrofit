package com.example.gr683_uoa.qwe;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataSourse extends AsyncTask<Void,Void,String> {
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson ="";
    URL tyta;


    @Override
    protected String doInBackground(Void... voids) {

            try {
                tyta = new URL("http://test.areas.su/api/users");
                urlConnection = (HttpURLConnection) tyta.openConnection();
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine())!=null){
                    buffer.append(line);
                }
                resultJson = buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return resultJson;
    }
}
