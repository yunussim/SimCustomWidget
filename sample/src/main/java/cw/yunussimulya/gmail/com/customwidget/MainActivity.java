package cw.yunussimulya.gmail.com.customwidget;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cw.yunussimulya.gmail.com.cw.LoadingButton;
import cw.yunussimulya.gmail.com.cw.TitleTextView;

public class MainActivity extends AppCompatActivity {

    LoadingButton loadingButton;
    TitleTextView ttv;
    Button bClearTTV, bFillTTV, bErrorTTV;

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

        ttv = findViewById(R.id.ttv);

        bClearTTV = findViewById(R.id.bClearTTV);
        bFillTTV = findViewById(R.id.bFillTTV);
        bErrorTTV = findViewById(R.id.bErrorTTV);
        bClearTTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ttv.setContent("");
            }
        });

        bFillTTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ttv.setContent("Content is here");
            }
        });

        bErrorTTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ttv.showError(!ttv.isError());
            }
        });
    }
}
