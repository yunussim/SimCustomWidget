package cw.yunussimulya.gmail.com.customwidget;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cw.yunussimulya.gmail.com.cw.LoadingButton;

public class MainActivity extends AppCompatActivity {

    LoadingButton loadingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingButton = findViewById(R.id.loadingButton);

        loadingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingButton.startLoading();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingButton.stopLoading();
                    }
                }, 1000);
            }
        });
    }
}
