package cw.yunussimulya.gmail.com.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import cw.yunussimulya.gmail.com.library.R;

public class LoadingButton extends RelativeLayout {

    AppCompatTextView tvText;
    ProgressBar pbLoading;

    public LoadingButton(Context context) {
        super(context);
        init(context, null);
    }

    public LoadingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LoadingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(getContext(), R.layout.button_loading, this);
        pbLoading = findViewById(R.id.pbLoading);
        tvText = findViewById(R.id.tvText);
        String text = "";
        int textColor = Color.BLACK;
        float textSize = 14;
        int loadingColor = Color.WHITE;
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LoadingButton, 0, 0);
            try {
                text = ta.getString(R.styleable.LoadingButton_lbText);
                textColor = ta.getColor(R.styleable.LoadingButton_lbTextColor, Color.BLACK);
                textSize = ta.getDimensionPixelSize(R.styleable.LoadingButton_lbTextSize, 14);
                loadingColor = ta.getColor(R.styleable.LoadingButton_lbLoadingColor, Color.WHITE);
            } finally {
                ta.recycle();
            }
        }
        tvText.setText(text);
        tvText.setTextColor(textColor);
        Log.e("textSize", textSize + "");
        tvText.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        pbLoading.getIndeterminateDrawable().setColorFilter(loadingColor, PorterDuff.Mode.MULTIPLY);
        stopLoading();
    }

    public void setText(@NonNull String text) {
        tvText.setText(text);
    }

    public String getText() {
        return tvText.getText().toString();
    }

    public void startLoading() {
        tvText.setVisibility(View.GONE);
        pbLoading.setVisibility(View.VISIBLE);
    }

    public void stopLoading() {
        tvText.setVisibility(View.VISIBLE);
        pbLoading.setVisibility(View.GONE);
    }
}