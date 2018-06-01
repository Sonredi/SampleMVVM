package com.example.jcp.samplemvvm.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jcp.samplemvvm.R;
import com.example.jcp.samplemvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(this);
        mainViewModel.initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainViewModel.destroy();
    }
}
