package com.example.patshopclient.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;


/**
 * Created by guoshaoxin on 2018/7/13.
 */
public class WPTShapeHelper {
    private View shapeView;
    private Drawable normalDrawable;
    private Drawable pressDrawable;
    private Drawable selectedDrawable;
    private float radius;
    private float[] radiusArray;
    private int solidColor;
    private int strokeWidth;
    private int strokeColor;

    public WPTShapeHelper(View shapeView) {
        this.shapeView = shapeView;
    }

    private void setBackground(Drawable drawable) {
        if (drawable != null) shapeView.setBackground(drawable);
    }

    /**
     * 根据xml属性设置各种状态下的
     *
     * @param drawable
     * @param strokeColor
     * @param solidColor
     * @return
     */
    private Drawable setDrawable(Drawable drawable, int strokeColor, int solidColor) {
        if (solidColor == 0 && strokeColor == 0) return drawable;
        if (!(drawable instanceof GradientDrawable)) {
            drawable = new GradientDrawable();
        }
        if (radius > 0) {
            ((GradientDrawable) drawable).setCornerRadius(radius);
        } else if (radiusArray != null && radiusArray.length == 8) {
            ((GradientDrawable) drawable).setCornerRadii(radiusArray);
        }
        solidColor = solidColor == 0 ? this.solidColor : solidColor;
        strokeColor = strokeColor == 0 ? this.strokeColor : strokeColor;
        ((GradientDrawable) drawable).setStroke(strokeWidth, strokeColor);
        ((GradientDrawable) drawable).setColor(solidColor);
        return drawable;
    }

    public WPTShapeHelper setNormalDrawable(GradientDrawable gradientDrawable){
        this.normalDrawable = gradientDrawable;
        return this;
    }

    public WPTShapeHelper setNormalDrawable(int strokeColor, int solidColor) {
        this.strokeColor = strokeColor;
        this.solidColor = solidColor;
        normalDrawable = setDrawable(normalDrawable, strokeColor, solidColor);
        return this;
    }

    public WPTShapeHelper setPressDrawable(int strokeColor, int solidColor) {
        pressDrawable = setDrawable(pressDrawable, strokeColor, solidColor);
        return this;
    }

    public WPTShapeHelper setSelectedDrawable(int strokeColor, int solidColor) {
        selectedDrawable = setDrawable(selectedDrawable, strokeColor, solidColor);
        return this;
    }

    public void setNormalDrawable(Drawable drawable) {
        if (drawable == null) return;
        this.normalDrawable = drawable;
        setBackground(normalDrawable);
    }

    public void setPressDrawable(Drawable drawable) {
        if (drawable == null) return;
        this.pressDrawable = drawable;
        setBackground(pressDrawable);
    }

    public void setSelectedDrawable(Drawable drawable) {
        if (drawable == null) return;
        this.selectedDrawable = drawable;
        setBackground(selectedDrawable);
    }


    public void setNormalDrawable() {
        setNormalDrawable(normalDrawable);
    }

    public void setPressDrawable() {
        setPressDrawable(pressDrawable);
    }

    public void setSelectedDrawable() {
        setSelectedDrawable(selectedDrawable);
    }


    public Drawable getNormalDrawable() {
        return normalDrawable;
    }

    public Drawable getPressDrawable() {
        return pressDrawable;
    }

    public Drawable getSelectedDrawable() {
        return selectedDrawable;
    }

    public float getRadius() {
        return radius;
    }

    public WPTShapeHelper setRadius(float radius) {
        this.radius = radius;
        return this;
    }

    public WPTShapeHelper setRadius(float[] radiusArray) {
        this.radiusArray = radiusArray;
        return this;
    }

    public float[] getRadiusArray() {
        return radiusArray;
    }

    public int getSolidColor() {
        return solidColor;
    }

    public WPTShapeHelper setSolidColor(int solidColor) {
        this.solidColor = solidColor;
        return this;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public WPTShapeHelper setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        return this;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public WPTShapeHelper setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        return this;
    }

    /**
     * dp 转 px
     *
     * @param dpValue dp 值
     * @return px 值
     */
    public static int dp2px(Context context, final float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
