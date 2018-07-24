package com.example.allan.newsappexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        try {
            JSONObject root = new JSONObject(JSON.json);
            JSONArray articles = root.getJSONArray("articles");

            ArrayList<NewsArticle> newsArticleArrayList = new ArrayList<>();

            String title;
            String author;
            String image;

            for (int i = 0; i < articles.length(); i++) {
                JSONObject element = articles.getJSONObject(i);
                title = element.getString("title");
                author = element.getString("author");
                image = element.getString("urlToImage");

                newsArticleArrayList.add(new NewsArticle(author, title, image));


            }

            NewsAdapter newsAdapter = new NewsAdapter(this, R.layout.list_item, newsArticleArrayList);

            listView.setAdapter(newsAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
