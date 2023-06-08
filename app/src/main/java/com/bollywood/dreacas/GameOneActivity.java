package com.bollywood.dreacas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.bollywood.dreacas.databinding.ActivityGameOneBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameOneActivity extends AppCompatActivity {
    private ActivityGameOneBinding binding;
    private final List<Integer> scrollImagesList = new ArrayList<>();
    private final ScrollViewsAdapter scrollViewsAdapter1 = new ScrollViewsAdapter();
    private final ScrollViewsAdapter scrollViewsAdapter2 = new ScrollViewsAdapter();
    private final ScrollViewsAdapter scrollViewsAdapter3 = new ScrollViewsAdapter();
    private final int min = 35, max = 50;
    private final Random random = new Random();
    private int balance = 0, rate = 100;
    private int position1 = random.nextInt((max - min)) + 1 + min;
    private int position2 = random.nextInt((max - min)) + 1 + min;
    private int position3 = random.nextInt((max - min)) + 1 + min;

    private CalculatedDatabase calculatedDatabase;
    private CalculationData calculationData = new CalculationData(1, balance, rate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        calculatedDatabase = CalculatedDatabase.getInstance(getApplication());

        calculatedDatabase.calculationsDao().add(calculationData);

        binding.buttonSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScrollRV.scrollingThreads(binding.recyclerView1, binding.recyclerView2, binding.recyclerView3, position1, position2, position3);

                position1 = changePosition(position1);
                position2 = changePosition(position2);
                position3 = changePosition(position3);

                int index1 = getCurrentItem(binding.recyclerView1) % 5;
                int index2 = getCurrentItem(binding.recyclerView2) % 5;
                int index3 = getCurrentItem(binding.recyclerView3) % 5;

                if (index1 == index2 && index2 == index3) {
                    balance += rate * 5;
                    calculationData.setBalance(balance);
                    calculatedDatabase.calculationsDao().add(calculationData);
                } else if (index1 == index2 || index2 == index3) {
                    balance += rate * 2;
                    calculationData.setBalance(balance);
                    calculatedDatabase.calculationsDao().add(calculationData);
                } else {
                    balance -= rate;
                    calculationData.setBalance(balance);
                    calculatedDatabase.calculationsDao().add(calculationData);
                    int balanceTest = calculatedDatabase.calculationsDao().getBalance();
                    System.out.println(balanceTest);
                }
                binding.balanceG1.setText(String.valueOf(calculatedDatabase.calculationsDao().getBalance()));
            }
        });
    }

    public int changePosition(int position) {
        return position + random.nextInt((max - min) + 1 + min);
    }

    public int getCurrentItem(RecyclerView recyclerView) {
        return ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    }
}
