package com.mobsandgeeks.ake

import android.view.View
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.view.View.OnClickListener

public inline fun View.findView<T : View>(id: Int): T? = findViewById(id) as? T
public inline fun View.show(): Unit = if (!this.isShown()) this.setVisibility(View.VISIBLE)
public inline fun View.hide(): Unit = if (this.isShown()) this.setVisibility(View.GONE)
public inline fun View.toggleVisibility(): Unit = if (this.isShown()) this.hide() else this.show()

public inline fun OnTouchListener(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) action: (View?, MotionEvent?) -> Boolean): OnTouchListener {
    return object : OnTouchListener {
        public override fun onTouch(p0: View?, p1: MotionEvent?): Boolean = action.invoke(p0, p1)
    }
}

public inline fun View.setOnTouchListener(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) action: (View?, MotionEvent?) -> Boolean): Unit {
    setOnTouchListener(OnTouchListener(action))
}

public inline fun OnClickListener(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) action: (View?) -> Unit): OnClickListener {
    return object : OnClickListener {
        public override fun onClick(view: View?) {
            action(view)
        }
    }
}

public inline fun View.setOnClickListener(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) action: (View?) -> Unit): Unit {
    setOnClickListener(OnClickListener(action))
}