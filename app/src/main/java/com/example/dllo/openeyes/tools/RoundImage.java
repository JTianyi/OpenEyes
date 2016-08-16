package com.example.dllo.openeyes.tools;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.dllo.openeyes.R;

/**
 * Created by dllo on 16/6/20.
 */
public class RoundImage extends ImageView {
    //判断我所加入的图片是否让其变成圆形图片
    private boolean isRound = false;

    public RoundImage(Context context) {
        super(context);
    }

    public RoundImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 从布局文件的属性中取出我们想要的属性值
        // 规定的写法
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundImage);
        isRound = typedArray.getBoolean(R.styleable.RoundImage_is_round, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (isRound){
            // 这个drawable就是布局文件中加入的图片
            Drawable drawable=getDrawable();
            if (drawable !=null){
                // 我们将drawable转化为bitmap
                Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();

                // 这个是我输出的Bitmap
                Bitmap outBitmap=getCircleBitmap(bitmap);
                outBitmap=createBitmapThumbnail(outBitmap);
                // 接下我们将要输出的Bitmap绘制在画布上
                Paint paint=new Paint();
                Rect rect=new Rect(0,0,outBitmap.getWidth(),outBitmap.getHeight());
                canvas.drawBitmap(outBitmap,rect,rect,paint);
            }
        }else {
            // 如果is_round属性为false那么我们就使用原先的图片
            // 而不做任何处理
            super.onDraw(canvas);
        }
    }

    /**
     * 获取圆形图片的方法
     * @param bitmap 目标bitmap
     * @return
     */

    public Bitmap getCircleBitmap(Bitmap bitmap) {
        // 首先我要创建一个空的bitmap,用作最后所输出的结果
        // 其大小和我们想要放入的bitmap图片大小相同
        //createBitmap参数
        // 第一个 宽
        // 第二个 高
        // 第三个 图片质量
        Bitmap outBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        // 定义一个画布,大小就是图片大小
        Canvas canvas = new Canvas(outBitmap);
        // 定义画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        // 判断宽高 我们取出来短的来设置直径
        int dim = bitmap.getWidth() <= bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight();
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, dim / 3, paint);
        //设置下一图层的叠放模式,SRC_IN代表的是显示前景图片
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //接下来我们把目标的bitmap绘制在我们的画布上
        // 首先指定绘制的区域
        Rect rect=new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
        // 绘制bitmap
        // 第一个参数是 目标bitmap
        //第二个参数是我们前景绘制区域
        // 第三个参数是我们背景绘制区域
        // 注意:我们要将这两个参数保持一致 如果不一致 图片会失真,变形
        // 最后参数 就是画笔
        canvas.drawBitmap(bitmap,rect,rect,paint);
        return outBitmap;
    }
     public Bitmap createBitmapThumbnail(Bitmap bitMap) {
         int width = bitMap.getWidth();
         int height = bitMap.getHeight();
             // 设置想要的大小
            int newWidth = 180;
             int newHeight = 180;
             // 计算缩放比例
             float scaleWidth = ((float) newWidth) / width;
             float scaleHeight = ((float) newHeight) / height;
             // 取得想要缩放的matrix参数
             Matrix matrix = new Matrix();
             matrix.postScale(scaleWidth, scaleHeight);
             // 得到新的图片
             Bitmap newBitMap = Bitmap.createBitmap(bitMap, 0, 0, width, height,matrix, true);
             return newBitMap;
         }
}

