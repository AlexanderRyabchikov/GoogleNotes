package com.client.googlenotes.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.CycleInterpolator
import android.view.animation.Transformation
import androidx.core.content.ContextCompat
import com.client.googlenotes.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Created by Konstantin Aleksashin on 22/11/2018.
 */
class ProgressFab : FloatingActionButton {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var isInProgress: Boolean = false
    private var animation: AlphaAnimation? = null
    private var transformation: Transformation? = null
    private var progressDrawable: Drawable? = null

    companion object {
        private const val MAX_LEVEL = 10000
    }

    init {
        transformation = Transformation()
        animation = AlphaAnimation(0.0f, 1.0f)
        animation?.repeatMode = AlphaAnimation.RESTART
        animation?.repeatCount = Animation.INFINITE
        animation?.duration = 5000
        animation?.interpolator = CycleInterpolator(1f)
        animation?.startTime = Animation.START_ON_FIRST_FRAME.toLong()
        progressDrawable = ContextCompat.getDrawable(context, R.drawable.fab_progress)
    }

    fun showProgress() {
        if (visibility != View.VISIBLE || windowVisibility != View.VISIBLE) {
            return
        }

        isInProgress = true
        animation?.reset()
        postInvalidate()
    }

    fun hideProgress() {
        isInProgress = false
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (isInProgress) {
            drawProgrees(canvas)
        }
    }

    private fun drawProgrees(c: Canvas?) {
        val time = drawingTime
        animation?.getTransformation(time, transformation)
        val scale = transformation?.alpha ?: 0f
        c?.let {
            val count = it.save()
            it.rotate(scale * 360, measuredWidth / 2f, measuredHeight / 2f)
            progressDrawable?.setBounds(0, 0, measuredWidth, measuredHeight)
            progressDrawable?.level = (scale * MAX_LEVEL).toInt()
            progressDrawable?.draw(it)
            it.restoreToCount(count)
        }
        postInvalidateOnAnimation()
    }
}