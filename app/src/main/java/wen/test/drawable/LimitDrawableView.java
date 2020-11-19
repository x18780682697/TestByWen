package wen.test.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import wen.testbywen.R;

/**
 * Description
 *
 * @author xiandongluo
 * @see
 * @since 2020/11/18
 */
public class LimitDrawableView extends View {

    public LimitDrawableView(Context context) {
        super(context);
    }

    public LimitDrawableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LimitDrawableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Drawable bgDrawable = getResources().getDrawable(R.drawable.home_head_bg);
//        Drawable bgDrawable = new ColorDrawable(getResources().getColor(android.R.color.holo_red_dark));
        bgDrawable.setBounds(0, -300, getWidth(), getHeight()-300);
        bgDrawable.draw(canvas);
        super.dispatchDraw(canvas);
    }
}
