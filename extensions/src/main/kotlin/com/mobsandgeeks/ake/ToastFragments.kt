package com.mobsandgeeks.ake

import android.widget.Toast
import android.view.View
import android.app.Fragment


public fun Fragment.showShortToast(messageResId: Int) {
    shortToast(messageResId).show()
}

public fun Fragment.showLongToast(messageResId: Int) {
    longToast(messageResId).show()
}

public fun Fragment.showShortToast(message: String) {
    shortToast(message).show()
}

public fun Fragment.showLongToast(message: String) {
    longToast(message).show()
}

public fun Fragment.showShortToast(view: View) {
    shortToast(view).show()
}

public fun Fragment.showLongToast(view: View) {
    longToast(view).show()
}

public fun Fragment.shortToast(messageResId: Int): Toast {
    return shortToast(getString(messageResId))
}

public fun Fragment.longToast(messageResId: Int): Toast {
    return longToast(getString(messageResId))
}

public fun Fragment.shortToast(message: String?): Toast {
    return createToast(this, message, Toast.LENGTH_SHORT)
}

public fun Fragment.longToast(message: String?): Toast {
    return createToast(this, message, Toast.LENGTH_LONG)
}

public fun Fragment.shortToast(view: View): Toast {
    return createToast(this, view, Toast.LENGTH_SHORT)
}

public fun Fragment.longToast(view: View): Toast {
    return createToast(this, view, Toast.LENGTH_LONG)
}

/*
 * -----------------------------------------------------------------------------
 *  Private methods
 * -----------------------------------------------------------------------------
 */
private fun createToast(Fragment: Fragment, message: String?, length: Int): Toast {
    return Toast.makeText(Fragment.getActivity(), message, length)
}

private fun createToast(Fragment: Fragment, view: View, length: Int): Toast {
    val toast = Toast(Fragment.getActivity())
    toast.setView(view)
    toast.setDuration(length)
    return toast
}
