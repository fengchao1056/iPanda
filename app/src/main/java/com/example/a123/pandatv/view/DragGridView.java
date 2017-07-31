package com.example.a123.pandatv.view;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.a123.pandatv.R;


/**
 * Created by Ulez on 2017/2/16.
 * Email：lcy1532110757@gmail.com
 */

public class DragGridView extends GridView {
    private String TAG = "DragGridView";
    private WindowManager windowManager;
    private int touchX;
    private int touchY;
    private int longClickPos = -1;
    private boolean isDraging = false;
    private View dragView = null;//产生的拖动影像
    private WindowManager.LayoutParams windowLayoutParams = null;
    private int mTempPos = -1;
    private int prePos;
    private int lastX;
    private int lastY;
    private int numColumns = -1;
    private int item_width;
    private int item_height;
    private float horizon_div;
    private float vertical_div;
    private String lastAniID;
    private View invisibleView;
    private Vibrator mVibrator;
    private boolean isMoving;//动画是否结束.
    private int windowX;
    private int windowY;


    public DragGridView(Context context) {
        this(context, null);
    }

    public DragGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mVibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        windowX = (int) ev.getX();
        windowY = (int) ev.getY();
        if (numColumns < 0)
            numColumns = getNumColumns();
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            touchX = (int) ev.getX();
            touchY = (int) ev.getY();
            setOnLongClickListener(ev);
        }
        return super.onInterceptTouchEvent(ev);
    }


    private void setOnLongClickListener(final MotionEvent ev) {
        setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                getParent().requestDisallowInterceptTouchEvent(true);
//                mVibrator.vibrate(50);//设置震动时间
                stopDrag();
                longClickPos = position;
                prePos = longClickPos;
                isDraging = true;
                lastX = (int) ev.getRawX();
                lastY = (int) ev.getRawY();
                invisibleView = view;
                invisibleView.setVisibility(INVISIBLE);
                if (dragView == null) {
                    dragView = View.inflate(getContext(), R.layout.category_item, null);
                    TextView tv_text = (TextView) dragView.findViewById(R.id.text_item);
                    tv_text.setText(((TextView) view.findViewById(R.id.text_item)).getText());
                } else {
                    TextView tv_text = (TextView) dragView.findViewById(R.id.text_item);
                    tv_text.setText(((TextView) dragView.findViewById(R.id.text_item)).getText());
                }

                windowLayoutParams = new WindowManager.LayoutParams();
                windowLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
                windowLayoutParams.width = view.getWidth();
                windowLayoutParams.height = view.getHeight();
                windowLayoutParams.x = (int) ev.getRawX() - (windowX - view.getLeft());//view.getX()=view.getLeft()+view.getTranslationX()//偏移一般为0；
                windowLayoutParams.y = (int) ev.getRawY() - (windowY - view.getTop() + 58);// app主题为actionbar时会偏移，// TODO: 2017/2/16
                windowManager.addView(dragView, windowLayoutParams);
                item_width = windowLayoutParams.width;
                item_height = windowLayoutParams.height;
                int div = (getWidth() - item_height * numColumns) / (numColumns - 1);
                int verticalSpacing = getVerticalSpacing();
                int horizontalSpacing = getHorizontalSpacing();
                horizon_div = 1.0f * horizontalSpacing / item_width + 1.0f;
                vertical_div = 1.0f * verticalSpacing / item_height + 1.0f;

                return false;
            }
        });

    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) ev.getRawX();
                lastY = (int) ev.getRawY();
                windowX = (int) ev.getX();
                windowY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE://拖动时判断位置，平移；
                if (isDraging) {
                    updateWindow(ev, (int) ev.getRawX() - lastX, (int) ev.getRawY() - lastY);
                    lastX = (int) ev.getRawX();
                    lastY = (int) ev.getRawY();
                }
                break;
            case MotionEvent.ACTION_UP://拖动时判断位置，平移；
                if (isDraging) {
                    isDraging = true;
                    closeWindow(ev);
                }

                break;
        }
        return super.onTouchEvent(ev);
    }

    private void closeWindow(MotionEvent ev) {
        stopDrag();
        clearChildAnimation();
        for (int i = 0; i < getCount(); i++)
            getChildAt(i).setVisibility(VISIBLE);
        ((DragAdapter) getAdapter()).notifyDataSetChanged();
    }

    private void stopDrag() {
        if (dragView != null) {
            windowManager.removeView(dragView);
            dragView = null;
        }
    }

    /**
     * 更新悬浮窗位置;
     *
     * @param ev
     */
    private void updateWindow(MotionEvent ev, int deltaX, int deltaY) {
        mTempPos = pointToPosition((int) ev.getX(), (int) ev.getY());
        if (mTempPos != AdapterView.INVALID_POSITION && mTempPos != prePos) {
            if (mTempPos > prePos) {
                for (int i = prePos + 1; i <= mTempPos; i++) {
                    Animation moveAnimation;
                    if (i % numColumns == 0) {
                        moveAnimation = getMoveAnimation((numColumns - 1) * horizon_div, -vertical_div);
                    } else {
                        moveAnimation = getMoveAnimation(-horizon_div, 0);
                    }
                    getChildAt(i).startAnimation(moveAnimation);//left.
                    if (i == mTempPos) {
                        lastAniID = moveAnimation.toString();
                    }
                    moveAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            isMoving = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            swap(animation);
                            isMoving = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
            } else {//mTempPos < prePos
                for (int i = prePos - 1; i >= mTempPos; i--) {
                    Animation moveAnimation;
                    if (i % numColumns == numColumns - 1) {
                        moveAnimation = getMoveAnimation(-(numColumns - 1) * horizon_div, vertical_div);
                    } else {
                        moveAnimation = getMoveAnimation(horizon_div, 0);
                    }
                    getChildAt(i).startAnimation(moveAnimation);//left.
                    if (i == mTempPos) {
                        lastAniID = moveAnimation.toString();
                    }
                    moveAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            swap(animation);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
            }
            ((DragAdapter) getAdapter()).swap(prePos, mTempPos);
            prePos = mTempPos;
        }
        windowLayoutParams.x += deltaX;
        windowLayoutParams.y += deltaY;
        windowManager.updateViewLayout(dragView, windowLayoutParams);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    private void swap(Animation animation) {
        if (animation.toString().equals(lastAniID)) {
            if (mTempPos != -1) {
                clearChildAnimation();
                invisibleView.setVisibility(VISIBLE);
                invisibleView = getChildAt(mTempPos);
                if (isDraging)//动画结束调用的，若是没有在拖动了，就无需隐藏当前view
                    invisibleView.setVisibility(INVISIBLE);
                ((DragAdapter) getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private void clearChildAnimation() {
        for (int i = 0; i < getCount(); i++) {
            getChildAt(i).clearAnimation();
        }
    }

    public Animation getMoveAnimation(float toXValue, float toYValue) {
        TranslateAnimation mTranslateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0F,
                Animation.RELATIVE_TO_SELF, toXValue,
                Animation.RELATIVE_TO_SELF, 0.0F,
                Animation.RELATIVE_TO_SELF, toYValue);
        mTranslateAnimation.setFillAfter(true);
        mTranslateAnimation.setDuration(200);
        mTranslateAnimation.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        return mTranslateAnimation;
    }

}
