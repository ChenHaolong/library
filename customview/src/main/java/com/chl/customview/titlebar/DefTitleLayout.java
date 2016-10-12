package com.chl.customview.titlebar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chl.customview.R;

/**
 * 自定义titleBar
 */
public class DefTitleLayout extends LinearLayout implements View.OnClickListener {

    private final float DEF_SIZE = 16.0f;
    private final int DEF_COLOR = Color.BLACK;
    private Context mContext;
    //所有显示的文本
    private TextView leftView, middleView, rightView;

    //文本的大小
    private float leftTextSize = DEF_SIZE, middleTextSize = DEF_SIZE, rightTextSize = DEF_SIZE;

    //文本颜色
    private int leftTextColor = DEF_COLOR, middleTextColor = DEF_COLOR, rightTextColor = DEF_COLOR;
    //显示文本
    private String leftText, middleText, rightText;
    //显示图片
    private Drawable leftViewDrawable, rightViewDrawable;
    private LeftViewListener mLeftViewListener;
    private RightViewListener mRightViewListener;

    public DefTitleLayout(Context context) {
        this(context, null);
    }
    public DefTitleLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DefTitleLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init(attrs, defStyle);
    }

    /**
     * 设置左边按钮的图片
     * @param leftDrawId
     */
    public void setLeftDrawId(int leftDrawId) {
        if (leftDrawId > 0) {
            leftViewDrawable = mContext.getResources().getDrawable(leftDrawId);
        }
    }

    /**
     * 设置右边按钮显示的图片
     * @param rightDrawId
     */
    public void setRightDrawId(int rightDrawId) {
        if (rightDrawId > 0) {
            rightViewDrawable = mContext.getResources().getDrawable(rightDrawId);
        }
    }

    /**
     * 设置左边的文字
     * @param leftText
     */
    public void setLeftText(String leftText) {
        this.leftText = leftText;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置左边文字颜色
     * @param leftTextColor
     */
    public void setLeftTextColor(int leftTextColor) {
        this.leftTextColor = leftTextColor;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置左边文字大小
     * @param leftTextSize
     */
    public void setLeftTextSize(float leftTextSize) {
        this.leftTextSize = leftTextSize;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置左边的图片
     * @param leftViewDrawable
     */
    public void setLeftViewDrawable(Drawable leftViewDrawable) {
        this.leftViewDrawable = leftViewDrawable;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置标题
     * @param middleText
     */
    public void setMiddleText(String middleText) {
        this.middleText = middleText;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置标题颜色
     * @param middleTextColor
     */
    public void setMiddleTextColor(int middleTextColor) {
        this.middleTextColor = middleTextColor;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置标题文字大小
     * @param middleTextSize
     */
    public void setMiddleTextSize(float middleTextSize) {
        this.middleTextSize = middleTextSize;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置右边按钮文字
     * @param rightText
     */
    public void setRightText(String rightText) {
        this.rightText = rightText;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置右边按钮文字颜色
     * @param rightTextColor
     */
    public void setRightTextColor(int rightTextColor) {
        this.rightTextColor = rightTextColor;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置右边按钮文字尺寸
     * @param rightTextSize
     */
    public void setRightTextSize(float rightTextSize) {
        this.rightTextSize = rightTextSize;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * 设置右边按钮图片
     * @param rightViewDrawable
     */
    public void setRightViewDrawable(Drawable rightViewDrawable) {
        this.rightViewDrawable = rightViewDrawable;
        invalidateTextPaintAndMeasurements();
    }

    private void init(AttributeSet attrs, int defStyle) {
        //加载布局
        View view = LayoutInflater.from(getContext()).inflate(R.layout.def_title_layout, this);
        leftView = (TextView) view.findViewById(R.id.leftView);
        middleView = (TextView) view.findViewById(R.id.middleView);
        rightView = (TextView) view.findViewById(R.id.rightView);

        // Load attributes
        final TypedArray typedArray = getContext().obtainStyledAttributes(
                attrs, R.styleable.DefTitleLayout, defStyle, 0);

        leftText = typedArray.getString(R.styleable.DefTitleLayout_def_leftText);
        middleText = typedArray.getString(R.styleable.DefTitleLayout_def_middleText);
        rightText = typedArray.getString(R.styleable.DefTitleLayout_def_rightText);

        leftTextSize = typedArray.getDimension(R.styleable.DefTitleLayout_def_leftTextSize, DEF_SIZE);
        middleTextSize = typedArray.getDimension(R.styleable.DefTitleLayout_def_middleTextSize, DEF_SIZE);
        rightTextSize = typedArray.getDimension(R.styleable.DefTitleLayout_def_rightTextSize, DEF_SIZE);

        leftTextColor = typedArray.getColor(R.styleable.DefTitleLayout_def_leftTextColor, DEF_COLOR);
        middleTextColor = typedArray.getColor(R.styleable.DefTitleLayout_def_middleTextColor, DEF_COLOR);
        rightTextColor = typedArray.getColor(R.styleable.DefTitleLayout_def_rightTextColor, DEF_COLOR);

        leftViewDrawable = typedArray.getDrawable(R.styleable.DefTitleLayout_def_leftDrawable);
        rightViewDrawable = typedArray.getDrawable(R.styleable.DefTitleLayout_def_rightDrawable);

        typedArray.recycle();

        leftView.setOnClickListener(this);
        rightView.setOnClickListener(this);

        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
        //设置属性
        leftView.setTextColor(leftTextColor);
        leftView.setTextSize(leftTextSize);
        leftView.setText(leftText);
        middleView.setTextColor(middleTextColor);
        middleView.setTextSize(middleTextSize);
        middleView.setText(middleText);
        rightView.setTextColor(rightTextColor);
        rightView.setTextSize(rightTextSize);
        rightView.setText(rightText);

        drawableCompound();
    }

    /**
     * 设置左边控件显示隐藏
     * @param visible View.GONE or View.VISIBILITY
     */
    public void setLeftVisibility(int visible){
        if (visible==INVISIBLE) visible=GONE;
        leftView.setVisibility(visible);
    }

    /**
     * 设置右边控件显示隐藏
     * @param visible View.GONE or View.VISIBILITY
     */
    public void setRightVisibility(int visible){
        if (visible==INVISIBLE) visible=GONE;
        rightView.setVisibility(visible);
    }


    private void drawableCompound() {
        if (leftViewDrawable != null) {
            leftViewDrawable.setBounds(0, 0, leftViewDrawable.getMinimumWidth(), leftViewDrawable.getMinimumHeight());
            leftView.setCompoundDrawables(leftViewDrawable, null, null, null);
        }

        if (rightViewDrawable != null) {
            rightViewDrawable.setBounds(0, 0, rightViewDrawable.getMinimumWidth(), rightViewDrawable.getMinimumHeight());
            rightView.setCompoundDrawables(null, null, rightViewDrawable, null);
        }
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        if (vId == R.id.leftView) {
            if (mLeftViewListener != null) mLeftViewListener.leftViewClick();
            else ((Activity) mContext).finish();

        } else if (vId == R.id.rightView) {
            if (mRightViewListener != null) mRightViewListener.rightViewClick();

        }
    }

    public void setOnLeftViewListener(LeftViewListener leftViewListener) {
        this.mLeftViewListener = leftViewListener;
    }

    public void setOnRightViewListener(RightViewListener rightViewListener) {
        this.mRightViewListener = rightViewListener;
    }

    /**
     * 左边按钮监听，默认是activity 的finish()
     */
    interface LeftViewListener {
        void leftViewClick();
    }

    /**
     * 右边按钮监听
     */
    interface RightViewListener {
        void rightViewClick();
    }

}
