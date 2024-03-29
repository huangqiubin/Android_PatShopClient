package com.example.patshopclient.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.android_patshopclient.R;


/**
 * Created by guoshaoxin on 2018/6/4.
 */
public class WPTShapeLinearLayout extends LinearLayout {
    private WPTShapeHelper shapeHelper;

    public WPTShapeLinearLayout(Context context) {
        this(context, null);
    }

    public WPTShapeLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WPTShapeLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.WPTShapeLinearLayout, defStyleAttr, 0);
        // 公共
        float radius = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeLinearLayout_ll_radius, 0); // 圆角
        float radiusTopLeft = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeLinearLayout_ll_radius_top_left, 0); // 左上圆角
        float radiusTopRight = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeLinearLayout_ll_radius_top_right, 0); // 右上圆角
        float radiusBottomRight = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeLinearLayout_ll_radius_bottom_right, 0); // 右下圆角
        float radiusBottomLeft = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeLinearLayout_ll_radius_bottom_left, 0); // 左下圆角
        int solidColor = typedArray.getColor(R.styleable.WPTShapeLinearLayout_ll_solidColor, 0); // 填充色
        int strokeWidth = typedArray.getDimensionPixelOffset(R.styleable.WPTShapeLinearLayout_ll_strokeWidth, 0); // 描边宽度
        int strokeColor = typedArray.getColor(R.styleable.WPTShapeLinearLayout_ll_strokeColor, 0); // 描边色
        // 按压
        int pressSolidColor = typedArray.getColor(R.styleable.WPTShapeLinearLayout_ll_pressSolidColor, 0);// 填充色
        // 选中
        int selectedSolidColor = typedArray.getColor(R.styleable.WPTShapeLinearLayout_ll_selectedSolidColor, 0);// 填充色
        int selectedStrokeColor = typedArray.getColor(R.styleable.WPTShapeLinearLayout_ll_selectedStrokeColor, 0);// 描边色

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
        } else {
            shapeHelper.setNormalDrawable();
        }
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (pressed) {
            shapeHelper.setPressDrawable();
        } else if (isSelected()) {
            shapeHelper.setSelectedDrawable();
        } else {
            shapeHelper.setNormalDrawable();
        }
    }

    public void setSolidColor(int color) {
        shapeHelper.setNormalDrawable(shapeHelper.getStrokeColor(), color);
    }
}
