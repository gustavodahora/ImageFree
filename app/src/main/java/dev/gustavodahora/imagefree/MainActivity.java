package dev.gustavodahora.imagefree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
        mainItems.add(new MainItem(4, R.drawable.insta_4));
        mainItems.add(new MainItem(5, R.drawable.insta_5));
        mainItems.add(new MainItem(6, R.drawable.insta_6));

        MainAdapter adapter = new MainAdapter(mainItems);

        rvMain.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
        private final List<MainItem> mainItems;

        public MainAdapter(List<MainItem> mainItems) {
            this.mainItems = mainItems;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.image_view_feed, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            MainItem mainItemCurrent = mainItems.get(position);
            holder.bind(mainItemCurrent);
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

        public void bind(MainItem item) {
            ImageView currentImage = itemView.findViewById(R.id.img_main);

            currentImage.setImageResource(item.getImage());
        }
    }
}