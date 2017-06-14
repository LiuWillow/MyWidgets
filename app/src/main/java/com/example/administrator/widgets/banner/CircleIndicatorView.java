package com.example.administrator.widgets.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.administrator.widgets.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class CircleIndicatorView extends View implements ViewPager.OnPageChangeListener {

    private static final String[] LETTERS = new String[]{
      "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };
    private int mSelectColor;
    private Paint mCirclePaint;
    private Paint mTextPaint;
    private int mCount; // indicator 的数量
    private int mRadius;//半径
    private int mStrokeWidth;//border


    private int mTextColor;// 小圆点中文字的颜色


    private int mDotNormalColor;// 小圆点默认颜色
    private int mSpace = 0;// 圆点之间的间距
    private List<Indicator> mIndicators;
    private int mSelectPosition = 0; // 选中的位置
    private FillMode mFillMode = FillMode.NONE;// 默认只有小圆点
    private ViewPager mViewPager;

    public CircleIndicatorView(Context context) {
        this(context, null);
    }

    public CircleIndicatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        init();
    }


    private void init(){
        mCirclePaint = new Paint();
        mCirclePaint.setDither(true);
        mCirclePaint.setAntiAlias(true);
        //默认值
        mCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        mTextPaint = new Paint();
        mTextPaint.setDither(true);
        mTextPaint.setAntiAlias(true);

        mIndicators = new ArrayList<>();
        initPaint();
    }

    private void initPaint(){
        mCirclePaint.setColor(mDotNormalColor);
        mCirclePaint.setStrokeWidth(mStrokeWidth);

        mTextPaint.setTextSize(mRadius * 3 / 2);
        mTextPaint.setColor(mTextColor);
    }

    private void initAttrs(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleIndicatorView);
        mRadius = typedArray.getInt(R.styleable.CircleIndicatorView_indicatorRadius, 6);
        mSpace = typedArray.getDimensionPixelSize(R.styleable.CircleIndicatorView_indicatorSpace, dp2px(5));

        mTextColor = typedArray.getColor(R.styleable.CircleIndicatorView_textColor, Color.WHITE);
        mSelectColor = typedArray.getColor(R.styleable.CircleIndicatorView_indicatorSelectColor, Color.WHITE);
        mDotNormalColor = typedArray.getColor(R.styleable.CircleIndicatorView_indicatorColor, Color.GRAY);



        int fillMode = typedArray.getInt(R.styleable.CircleIndicatorView_fill_mode, 2);
        if(fillMode == 0){
            mFillMode = FillMode.LETTER;
        }else if(fillMode ==1){
            mFillMode = FillMode.NUMBER;
        }else{
            mFillMode = FillMode.NONE;
        }
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = (mRadius + mStrokeWidth) * 2 * mCount + mSpace * (mCount -1);
        int height = 2* mRadius + 2* mStrokeWidth;

        setMeasuredDimension(width, height);

        measureIndicators();
    }
    private void measureIndicators(){
        mIndicators.clear();
        float cy = getMeasuredHeight() / 2;
        for(int i = 0; i < mCount; i ++){
            Indicator indicator = new Indicator();
            float cx = (mRadius + mStrokeWidth) * (i * 2 + 1) + mSpace * i;
            indicator.cx = cx;
            indicator.cy = cy;
            mIndicators.add(indicator);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(int i =0; i < mCount; i++){
            Indicator indicator = mIndicators.get(i);
            float x = indicator.cx;
            float y = indicator.cy;

            //画原点
            if(i == mSelectPosition){
                mCirclePaint.setColor(mSelectColor);
                mCirclePaint.setStyle(Paint.Style.FILL);
            }else {
                mCirclePaint.setColor(mDotNormalColor);
                mCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
            }
            canvas.drawCircle(x, y, mRadius, mCirclePaint);

            //画文字

            if(mFillMode != FillMode.NONE){
                String text = "";
                if(mFillMode == FillMode.NUMBER){
                    text += (i + 1);
                }
                if(mFillMode == FillMode.LETTER){
                    text += LETTERS[i];
                }
                Rect bound = new Rect();
                mTextPaint.getTextBounds(text, 0, text.length(), bound);

                canvas.drawText(text, x - bound.width() / 2, y + bound.height() / 2, mTextPaint);
            }

        }

    }

    public void setUpWithViewPager(ViewPager viewPager){
        releaseViewPager();
        if(viewPager == null){
            return;
        }
        mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(this);
        int count = mViewPager.getAdapter().getCount();
        setCount(count);
    }

    //重置ViewPager
    private void releaseViewPager(){
        if(mViewPager != null){
            mViewPager.removeOnPageChangeListener(this);
            mViewPager = null;
        }
    }

    private void setCount(int count){
        mCount = count;
    }

    public void setBorderWidth(int borderWidth){
        mStrokeWidth = borderWidth;
        initPaint();
    }


    public void setTextColor(int textColor) {
        mTextColor = textColor;
        initPaint();
    }


    public void setSelectColor(int selectColor) {
        mSelectColor = selectColor;
    }


    public void setDotNormalColor(int dotNormalColor) {
        mDotNormalColor = dotNormalColor;
        initPaint();
    }


    public void setSelectPosition(int selectPosition) {
        mSelectPosition = selectPosition;
    }


    public void setFillMode(FillMode fillMode) {
        mFillMode = fillMode;
    }


    public void setRadius(int radius) {
        mRadius = radius;
        initPaint();
    }

    public void setSpace(int space) {
        mSpace = space;
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mSelectPosition = position;
        invalidate();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    public static class Indicator{
        public float cx;
        public float cy;
    }
    public enum FillMode{
        LETTER,
        NUMBER,
        NONE
    }
    public int dp2px(float dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                getResources().getDisplayMetrics());
    }


}
