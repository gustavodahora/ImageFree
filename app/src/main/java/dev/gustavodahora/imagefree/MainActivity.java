package dev.gustavodahora.imagefree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Only Light Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        RecyclerView rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new LinearLayoutManager(this));

        List<MainItem> mainItems = new ArrayList<>();

        mainItems.add(new MainItem(1, R.drawable.insta_1));
        mainItems.add(new MainItem(2, R.drawable.insta_2));
        mainItems.add(new MainItem(3, R.drawable.insta_3));
        mainItems.add(new MainItem(4, R.drawable.insta_9));
        mainItems.add(new MainItem(5, R.drawable.insta_5));
        mainItems.add(new MainItem(6, R.drawable.insta_6));
        mainItems.add(new MainItem(7, R.drawable.insta_7));
        mainItems.add(new MainItem(8, R.drawable.insta_8));
        mainItems.add(new MainItem(9, R.drawable.insta_4));

        // Java slowing.
//        mainItems.add(new MainItem(10, R.drawable.insta_10));
//        mainItems.add(new MainItem(11, R.drawable.insta_11));
//        mainItems.add(new MainItem(12, R.drawable.insta_12));

        MainAdapter adapter = new MainAdapter(mainItems, getApplicationContext());

        rvMain.setAdapter(adapter);

//        rvMain.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
        private final List<MainItem> mainItems;
        private final Context context;

        public MainAdapter(List<MainItem> mainItems, Context context) {
            this.mainItems = mainItems;
            this.context = context;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.image_view_feed, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            MainItem mainItemCurrent = mainItems.get(position);
            holder.bind(mainItemCurrent, context);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(MainItem item, Context context) {
            ImageView currentImage = itemView.findViewById(R.id.img_main);

            // To use glide or picasso for compress a file or to get a file from URL.
            // Do not use to compress.
            Glide.with(context)
                    .load(Uri.parse("android.resource://dev.gustavodahora.imageFree" + item.getImage()))
                    .centerCrop()
                    .placeholder(item.getImage())
                    .into(currentImage);

//            currentImage.setImageResource(item.getImage());
        }
    }
}