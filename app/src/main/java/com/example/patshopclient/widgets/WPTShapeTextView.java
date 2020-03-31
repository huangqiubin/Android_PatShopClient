package com.example.patshopclient.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.android_patshopclient.R;


/**
 * WPTShapeTextView
 * Created by guoshaoxin on 2018/6/4.
 */
public class WPTShapeTextView extends AppCompatTextView {
    private WPTShapeHelper shapeHelper;
    private int selectedTextColor;
    private int normalTextColor;
    private int strokeColor;
    private int solidColor;

    public WPTShapeTextView(Context context) {
        this(context, null);
    }

    public WPTShapeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WPTShapeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.WPTShapeTextView, defStyleAttr, 0);
        // 公共
        float radius = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeTextView_tv_radius, 0); // 圆角
        float radiusTopLeft = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeTextView_tv_radius_top_left, 0); // 左上圆角
        float radiusTopRight = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeTextView_tv_radius_top_right, 0); // 右上圆角
        float radiusBottomRight = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeTextView_tv_radius_bottom_right, 0); // 右下圆角
        float radiusBottomLeft = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeTextView_tv_radius_bottom_left, 0); // 左下圆角
        solidColor = typedArray.getColor(R.styleable.WPTShapeTextView_tv_solidColor, 0); // 填充色
        int strokeWidth = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeTextView_tv_strokeWidth, 0); // 描边宽度
        strokeColor = typedArray.getColor(R.styleable.WPTShapeTextView_tv_strokeColor, 0); // 描边色
        // 按压
        int pressSolidColor = typedArray.getColor(R.styleable.WPTShapeTextView_tv_pressSolidColor, 0);// 填充色
        // 选中
        int selectedSolidColor = typedArray.getColor(R.styleable.WPTShapeTextView_tv_selectedSolidColor, 0);// 填充色
        int selectedStrokeColor = typedArray.getColor(R.styleable.WPTShapeTextView_tv_selectedStrokeColor, 0);// 描边色
        setGravity(Gravity.CENTER);
        //字体颜色
        normalTextColor = getCurrentTextColor();
        selectedTextColor = typedArray.getColor(R.styleable.WPTShapeTextView_tv_selectedTextColor, 0);
        selectedTextColor = selectedTextColor == 0 ? normalTextColor : selectedTextColor;
        typedArray.recycle();

        shapeHelper = new WPTShapeHelper(this)
                .setRadius(new float[]{radiusTopLeft, radiusTopLeft, radiusTopRight, radiusTopRight, radiusBottomRight, radiusBottomRight, radiusBottomLeft, radiusBottomLeft})
                .setRadius(radius).setStrokeWidth(strokeWidth)
                .setNormalDrawable(strokeColor, solidColor)
                .setPressDrawable(0, pressSolidColor)
                .setSelectedDrawable(selectedStrokeColor, selectedSolidColor);
        shapeHelper.setNormalDrawable();
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            shapeHelper.setSelectedDrawable();
            setTextColor(selectedTextColor);
        } else {
            shapeHelper.setNormalDrawable();
            setTextColor(normalTextColor);
        }
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (pressed) {
            shapeHelper.setPressDrawable();
        }
    }

    public void setSolidColor(int color) {
        this.solidColor = color;
        shapeHelper.setNormalDrawable(strokeColor, color);
    }

    public void setStrokeColor(int color) {
        this.strokeColor = color;
        shapeHelper.setNormalDrawable(color, getSolidColor());
    }

    public void setStrokeAndSolidColor(int sColor, int soColor) {
        this.strokeColor = sColor;
        this.solidColor = soColor;
        shapeHelper.setNormalDrawable(sColor, soColor);
    }

}
