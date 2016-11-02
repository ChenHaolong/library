package com.chl.customview.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.chl.customview.R;

/**
 * Name ScaleImageView
 * Created by chenhaolong on 2016/11/2.
 * 类介绍: 按比例展示View大小
 */

public class ScaleImageView extends ImageView {

    private static final int DEF_SCALE=0;

    private int scaleX=DEF_SCALE;
    private int scaleY=DEF_SCALE;

    public ScaleImageView(Context context) {
        this(context, null);
    }

    public ScaleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ScaleImageView, defStyleAttr, 0);
        if (ta.hasValue(R.styleable.ScaleImageView_scaleX)) {
            scaleX=ta.getInteger(R.styleable.ScaleImageView_scaleX, 1);
        }if (ta.hasValue(R.styleable.ScaleImageView_scaleY)) {
            scaleY=ta.getInteger(R.styleable.ScaleImageView_scaleY, 1);
        }
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        if (scaleX!=0 && scaleY!=0)
            height= width*scaleY/scaleX;
        setMeasuredDimension(width, height);
    }

    public void setScaleX(int scaleX){
        this.scaleX=scaleX;
        requestLayout();
    }
    public void setScaleY(int scaleY){
        this.scaleY=scaleY;
        requestLayout();
    }
}
