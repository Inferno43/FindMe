package com.inferno43.findme.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;

import com.inferno43.findme.R;

/**
 * Created by ${USER_NAME} on 2/10/17.
 */

public class ArcLayout extends FrameLayout {
    private static final String TAG = "ArcLayout";

    private ArcLayoutSettings settings;

    private int height = 0;

    private int width = 0;

    private Path clipPath;

    public ArcLayout(Context context) {
        super(context);
        init(context, null);
    }

    public ArcLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        settings = new ArcLayoutSettings(context, attrs);
        settings.setElevation(ViewCompat.getElevation(this));

        /**
         * If hardware acceleration is on (default from API 14), clipPath worked correctly
         * from API 18.
         *
         * So we will disable hardware Acceleration if API < 18
         *
         * https://developer.android.com/guide/topics/graphics/hardware-accel.html#unsupported
         * Section #Unsupported Drawing Operations
         */
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    private Path createClipPath() {
        final Path path = new Path();

        float arcHeight = settings.getArcHeight();
        if (settings.isDirectionBottom()) {
            if (settings.isCropConvex()) {
                path.moveTo(0, 0);
                path.lineTo(0, height - arcHeight);
                path.quadTo(width / 2, height + arcHeight, width, height - arcHeight);
                path.lineTo(width, 0);
                path.close();
            } else {
                path.moveTo(0, 0);
                path.lineTo(0, height);
                path.quadTo(width / 2, height - 2 * arcHeight, width, height);
                path.lineTo(width, 0);
                path.close();
            }
        } else {
            if (settings.isCropConvex()) {
                path.moveTo(0, arcHeight);
                path.lineTo(0, height);
                path.lineTo(width, height);
                path.lineTo(width, arcHeight);
                path.quadTo(width / 2, (-1 * arcHeight), 0, arcHeight);
                path.close();
            } else {
                path.moveTo(0, 0);
                path.lineTo(0, height);
                path.lineTo(width, height);
                path.lineTo(width, 0);
                path.quadTo(width / 2, 2 * arcHeight, 0, 0);
                path.close();
            }
        }
        return path;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout() called with: changed = [" + changed + "], left = [" + left + "], top = [" + top + "], right = [" + right + "], bottom = [" + bottom + "]");
        if (changed) {
            calculateLayout();
        }
    }

    private void calculateLayout() {
        if (settings == null) {
            return;
        }
        height = getMeasuredHeight();
        width = getMeasuredWidth();
        if (width > 0 && height > 0) {

            clipPath = createClipPath();
            ViewCompat.setElevation(this, settings.getElevation());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && settings.isCropConvex()) {
                ViewCompat.setElevation(this, settings.getElevation());
                setOutlineProvider(new ViewOutlineProvider() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void getOutline(View view, Outline outline) {
                        outline.setConvexPath(clipPath);
                    }
                });
            }
        }
    }

    public ArcLayoutSettings getSettings() {
        return settings;
    }

    public void setSettings(final ArcLayoutSettings settings) {
        this.settings = settings;
        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.d(TAG, "dispatchDraw() called with: canvas = [" + canvas + "]");
        canvas.save();

        canvas.clipPath(clipPath);
        super.dispatchDraw(canvas);

        canvas.restore();
    }

    public class ArcLayoutSettings {
        private static final String TAG = "ArcLayoutSettings";

        public final static int CROP_CONVEX = 1;
        public final static int CROP_CONCAVE = 2;
        public final static int DIRECTION_BOTTOM = 1;
        public final static int DIRECTION_TOP = 2;

        private static final int DEFAULT_ARC_HEIGHT = 32;

        private boolean cropConvex = true;
        private boolean directionBottom = true;
        private float arcHeight;
        private float elevation;

        private  float dpToPx(Context context, int dp) {
            Resources r = context.getResources();
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        }

        ArcLayoutSettings(Context context, AttributeSet attrs) {
            TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ArcHeader, 0, 0);
            arcHeight = styledAttributes.getDimension(R.styleable.ArcHeader_arc_height, dpToPx(context, DEFAULT_ARC_HEIGHT));

            final int cropDirection = styledAttributes.getInt(R.styleable.ArcHeader_arc_cropCurve, CROP_CONVEX);
            cropConvex = (cropDirection & CROP_CONVEX) == CROP_CONVEX;

            final int arcPosition = styledAttributes.getInt(R.styleable.ArcHeader_arc_position, DIRECTION_BOTTOM);
            directionBottom = (arcPosition & DIRECTION_BOTTOM) == DIRECTION_BOTTOM;

            styledAttributes.recycle();
        }

        public float getElevation() {
            return elevation;
        }

        public void setElevation(float elevation) {
            this.elevation = elevation;
        }

        public boolean isCropConvex() {
            return cropConvex;
        }

        public void setIsCropConvex(final boolean cropConvex) {
            this.cropConvex = cropConvex;
        }

        public void setIsDirectionBottom(final boolean directionBottom) {
            this.directionBottom = directionBottom;
        }

        public boolean isDirectionBottom() {
            return directionBottom;
        }

        public float getArcHeight() {
            return arcHeight;
        }
        public void setArcHeight(int arcHeight) {
            this.arcHeight = arcHeight;
        }
    }
}