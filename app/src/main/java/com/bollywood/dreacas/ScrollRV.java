package com.bollywood.dreacas;

import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScrollRV {

    static void scrollingThreads(RecyclerView recyclerView1, RecyclerView recyclerView2, RecyclerView recyclerView3, int position1, int position2, int position3) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(new Thread(new Runnable() {
            @Override
            public void run() {
                recyclerView1.smoothScrollToPosition(position1);
            }
        }));

        executorService.execute(new Thread(new Runnable() {
            @Override
            public void run() {
                recyclerView2.smoothScrollToPosition(position2);
            }
        }));

        executorService.execute(new Thread(new Runnable() {
            @Override
            public void run() {
                recyclerView3.smoothScrollToPosition(position3);
            }
        }));
        executorService.shutdown();

    }
}
