package com.example.allan.newsappexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter {

    Context context;
    ArrayList<NewsArticle> objects;
    int resource;

    public NewsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NewsArticle> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(resource, parent, false);
        }

        TextView author = convertView.findViewById(R.id.author);
        TextView title = convertView.findViewById(R.id.title);
        ImageView image = convertView.findViewById(R.id.image);

        NewsArticle newsArticle = objects.get(position);

        author.setText(newsArticle.getAuthor());
        title.setText(newsArticle.getTitle());
        Picasso.get().load(newsArticle.getImage()).into(image);

        return convertView;
    }
}
