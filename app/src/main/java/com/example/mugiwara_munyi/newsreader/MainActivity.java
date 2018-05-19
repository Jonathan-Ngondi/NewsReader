package com.example.mugiwara_munyi.newsreader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<NewsItem> newsStories = new ArrayList<>();

    SQLiteDatabase articlesDB;

    RecyclerView recyclerView;
    ProgressBar progressBar;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        mContext = this;

        articlesDB = this.openOrCreateDatabase("Articles", MODE_PRIVATE, null);
        articlesDB.execSQL("CREATE TABLE IF NOT EXISTS articles (id INTEGER PRIMARY KEY, title VARCHAR, content VARCHAR)");


        DownloadTask task = new DownloadTask();

        try {
            task.execute("https://newsapi.org/v2/top-headlines?country=us&apiKey=957bc5786f714285863f6729d5ce6f0d");
        } catch (Exception e){

        }
        Log.i("List Size", String.valueOf(newsStories.size()));

    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progressBar = findViewById(R.id.progressBar);

        }



        @Override
        protected String doInBackground(String... strings) {
            String result ="";
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream is = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(is);
                int data = reader.read();
                while (data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                //Log.i("JSON Response", result);
                JSONObject jsonObject = new JSONObject(result);
                JSONArray articles = jsonObject.getJSONArray("articles");


                for (int i = 0; i < articles.length();i++){
                    Gson gson = new Gson();
                    NewsItem nI = gson.fromJson(articles.get(i).toString(), NewsItem.class );
                    newsStories.add(nI);

                }
            Log.i("News Stories Size", String.valueOf(newsStories.size()));

            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.INVISIBLE);
            CustomAdapter adapter = new CustomAdapter(newsStories, mContext);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));


        }
    }
}
