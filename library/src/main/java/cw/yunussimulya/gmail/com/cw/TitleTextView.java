package cw.yunussimulya.gmail.com.cw;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class TitleTextView extends LinearLayout {

    private AppCompatTextView tvTitle;
    private AppCompatTextView tvContent;
    private AppCompatImageView ivRight;
    private View line;
    private AppCompatTextView tvError;
    private int colorError = Color.RED;
    private int colorTitle = Color.BLACK;
    private int colorContent = Color.BLACK;
    private String textError = "";

    public TitleTextView(Context context) {
        super(context);
    }

    public TitleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TitleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(getContext(), R.layout.title_textview, this);
        tvTitle = findViewById(R.id.tvTitle);
        tvContent = findViewById(R.id.tvContent);
        line = findViewById(R.id.line);
        tvError = findViewById(R.id.tvError);
        ivRight = findViewById(R.id.ivRightIcon);
        String textTitle = "";
        String hint = "";
        Drawable icRight = null;
        Typeface typeface = null;
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleTextView, 0, 0);
            try {
                textError = ta.getString(R.styleable.TitleTextView_ttvTextError);
                textTitle = ta.getString(R.styleable.TitleTextView_ttvTextTitle);
                hint = ta.getString(R.styleable.TitleTextView_ttvTextHint);
                colorTitle = ta.getColor(R.styleable.TitleTextView_ttvColorTitle, Color.BLACK);
                colorError = ta.getColor(R.styleable.TitleTextView_ttvColorError, Color.RED);
                colorContent = ta.getColor(R.styleable.TitleTextView_ttvColorContent, Color.BLACK);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    icRight = ta.getDrawable(R.styleable.TitleTextView_ttvRightIcon);
                } else {
                    final int icId = ta.getResourceId(R.styleable.TitleTextView_ttvRightIcon, -1);
                    if (icId != -1)
                        icRight = AppCompatResources.getDrawable(context, icId);
                }
            } finally {
                ta.recycle();
            }
        }
        tvTitle.setText(textTitle);
        tvTitle.setTextColor(colorTitle);
        tvContent.setTextColor(colorContent);
        line.setBackgroundColor(colorTitle);
        tvError.setTextColor(colorError);
        tvError.setVisibility(View.INVISIBLE);
        if (icRight != null) {
            ivRight.setVisibility(View.VISIBLE);
            ivRight.setImageDrawable(icRight);
        } else {
            ivRight.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(hint)) tvContent.setHint(hint);
        if (textError != null) tvError.setText(textError);
    }

    public void setTitle(@NonNull String title) {
        tvTitle.setText(title);
    }

    public void showError(String text) {
        textError = text;
        tvError.setText(textError);
        tvError.setVisibility(text != null ? View.VISIBLE : View.INVISIBLE);
        tvTitle.setTextColor(text != null ? colorError : colorTitle);
        line.setBackgroundColor(text != null ? colorError : colorTitle);
    }

    public void showError(boolean isShow) {
        tvError.setVisibility(isShow ? View.VISIBLE : View.INVISIBLE);
        tvTitle.setTextColor(isShow ? colorError : colorTitle);
        line.setBackgroundColor(isShow ? colorError : colorTitle);
    }

    public boolean isError() {
        return tvError.getVisibility() == View.VISIBLE;
    }

    public void setContent(@NonNull String content) {
        tvContent.setText(content);
    }

    public AppCompatTextView getContent() {
        return tvContent;
    }

    public void setFont(@NonNull Typeface typeface) {
        tvContent.setTypeface(typeface);
        tvError.setTypeface(typeface);
        tvTitle.setTypeface(typeface);
    }

}
