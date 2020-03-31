package com.example.patshopclient.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

import com.example.android_patshopclient.R;


/**
 * Created by guoshaoxin on 2018/6/4.
 */
public class WPTShapeEditText extends AppCompatEditText {
    private WPTShapeHelper shapeHelper;

    public WPTShapeEditText(Context context) {
        this(context, null);
    }

    public WPTShapeEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WPTShapeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.WPTShapeEditText, defStyleAttr, 0);
        // 公共
        int radius = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeEditText_et_radius, 0); // 圆角
        int solidColor = typedArray.getColor(R.styleable.WPTShapeEditText_et_solidColor, 0); // 填充色
        int strokeWidth = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeEditText_et_strokeWidth, 0); // 描边宽度
        int strokeColor = typedArray.getColor(R.styleable.WPTShapeEditText_et_strokeColor, 0); // 描边色

        typedArray.recycle();

        shapeHelper = new WPTShapeHelper(this)
                .setRadius(radius).setStrokeWidth(strokeWidth)
                .setNormalDrawable(strokeColor, solidColor);
        shapeHelper.setNormalDrawable();
    }
}
