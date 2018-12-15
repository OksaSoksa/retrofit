package com.example.gr683_uoa.qwe;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    List<User> userList = new ArrayList<>();
    ListView userView;
    private static UserApi userApi;
    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userView = findViewById(R.id.listId);
        DataSourse dataSourse = new DataSourse();
        dataSourse.execute();
        try {
            dataSourse.get(1,TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        setUserList(dataSourse.resultJson);
    }

   public void setUserList (String json){
       retrofit = new Retrofit.Builder()
               .baseUrl("http://test.areas.su") //Базовая часть адреса
               .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
               .build();
       userApi = retrofit.create(UserApi.class);
            ArrayAdapter adapter = new UserListAdapter(MainActivity.this,userList);
            userView.setAdapter(adapter);

    }

    public static UserApi getUserApi(){
        return userApi;
    }

    public void send(){

    }
}


