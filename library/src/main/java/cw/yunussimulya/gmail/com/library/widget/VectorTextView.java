package cw.yunussimulya.gmail.com.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import cw.yunussimulya.gmail.com.library.R;

public class VectorTextView extends AppCompatTextView {

    public VectorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public VectorTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray attributeArray = context.obtainStyledAttributes(attrs, R.styleable.VectorTextView);

            Drawable drawableLeft = null;
            Drawable drawableRight = null;
            Drawable drawableBottom = null;
            Drawable drawableTop = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                drawableLeft = attributeArray.getDrawable(R.styleable.VectorTextView_vtvDrawableLeft);
                drawableRight = attributeArray.getDrawable(R.styleable.VectorTextView_vtvDrawableRight);
                drawableBottom = attributeArray.getDrawable(R.styleable.VectorTextView_vtvDrawableBottom);
                drawableTop = attributeArray.getDrawable(R.styleable.VectorTextView_vtvDrawableTop);
            } else {
                final int drawableLeftId = attributeArray.getResourceId(R.styleable.VectorTextView_vtvDrawableLeft, -1);
                final int drawableRightId = attributeArray.getResourceId(R.styleable.VectorTextView_vtvDrawableRight, -1);
                final int drawableBottomId = attributeArray.getResourceId(R.styleable.VectorTextView_vtvDrawableBottom, -1);
                final int drawableTopId = attributeArray.getResourceId(R.styleable.VectorTextView_vtvDrawableTop, -1);

                if (drawableLeftId != -1)
                    drawableLeft = AppCompatResources.getDrawable(context, drawableLeftId);
                if (drawableRightId != -1)
                    drawableRight = AppCompatResources.getDrawable(context, drawableRightId);
                if (drawableBottomId != -1)
                    drawableBottom = AppCompatResources.getDrawable(context, drawableBottomId);
                if (drawableTopId != -1)
                    drawableTop = AppCompatResources.getDrawable(context, drawableTopId);
            }
            setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);
            attributeArray.recycle();
        }
    }
}
