package com.bollywood.dreacas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.bollywood.dreacas.databinding.ActivityGameOneBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GameOneActivity extends AppCompatActivity {
    private final List<Integer> scrollImagesList = new ArrayList<>();
    private YourViewModel yourViewModel;
    private final Random random = new Random();
    private final int min = 35, max = 50;

    private int position1 = random.nextInt((max - min)) + 1 + min;
    private int position2 = random.nextInt((max - min)) + 1 + min;
    private int position3 = random.nextInt((max - min)) + 1 + min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        yourViewModel = new YourViewModel(getApplication());
        ActivityGameOneBinding binding = ActivityGameOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final ScrollViewsAdapter scrollViewsAdapter1 = new ScrollViewsAdapter();
        final ScrollViewsAdapter scrollViewsAdapter2 = new ScrollViewsAdapter();
        final ScrollViewsAdapter scrollViewsAdapter3 = new ScrollViewsAdapter();

        binding.recyclerView1.setLayoutManager(new GridLayoutManager(this.getBaseContext(), 1));
        binding.recyclerView1.setAdapter(scrollViewsAdapter1);

        binding.recyclerView2.setLayoutManager(new GridLayoutManager(this.getBaseContext(), 1));
        binding.recyclerView2.setAdapter(scrollViewsAdapter2);

        binding.recyclerView3.setLayoutManager(new GridLayoutManager(this.getBaseContext(), 1));
        binding.recyclerView3.setAdapter(scrollViewsAdapter3);

        scrollImagesList.add(R.drawable.roll_image_1);
        scrollImagesList.add(R.drawable.roll_image_2);
        scrollImagesList.add(R.drawable.roll_image_3);
        scrollImagesList.add(R.drawable.roll_image_4);
        scrollImagesList.add(R.drawable.roll_image_5);

        scrollViewsAdapter1.setItem(scrollImagesList);
        scrollViewsAdapter2.setItem(scrollImagesList);
        scrollViewsAdapter3.setItem(scrollImagesList);

        binding.recyclerView1.smoothScrollToPosition(position1);
        binding.recyclerView2.smoothScrollToPosition(position2);
        binding.recyclerView3.smoothScrollToPosition(position3);

        yourViewModel.getBalance().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.balanceG1.setText(String.valueOf(integer));
            }
        });

        binding.buttonSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScrollRV.scrollingThreads(binding.recyclerView1, binding.recyclerView2, binding.recyclerView3, position1, position2, position3);

                yourViewModel.balanceCalculation(
                        getCurrentItemIndex(binding.recyclerView1),
                        getCurrentItemIndex(binding.recyclerView2),
                        getCurrentItemIndex(binding.recyclerView3)
                );

                position1 = changePosition(position1);
                position2 = changePosition(position2);
                position3 = changePosition(position3);

            }
        });
    }

    public int getCurrentItem(RecyclerView recyclerView) {
        return ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    }

    public int getCurrentItemIndex(RecyclerView recyclerView) {
        return getCurrentItem(recyclerView) % 5;
    }

    public int changePosition(int position) {
        return position + random.nextInt((max - min) + 1 + min);
    }
}
