package com.motivation.rico.restcalls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.pagination_list);


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://52.14.69.107:8080/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubClient client = retrofit.create(GitHubClient.class);
        //Call<List<GitHubRepo>> call = client.reposForUser("Ginowine");
        Call<List<MotivateMsgs>> call = client.getMsgs();

        call.enqueue(new Callback<List<MotivateMsgs>>() {
            @Override
            public void onResponse(Call<List<MotivateMsgs>> call, Response<List<MotivateMsgs>> response) {
                Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                List<MotivateMsgs> repos = response.body();
                listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, repos));
//                TextView view = (TextView) findViewById(R.id.tvoutput);
//                view.setText(repos.toString());

            }

            @Override
            public void onFailure(Call<List<MotivateMsgs>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
