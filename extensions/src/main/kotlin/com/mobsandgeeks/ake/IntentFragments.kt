package com.mobsandgeeks.ake

import android.content.Intent
import android.app.Activity
import android.app.Service
import android.os.Bundle
import android.app.Fragment
import android.content.Context

public fun Fragment.flags(flag: Int, vararg flags: Int): Int {
    var orFlags = flag;
    for (i in flags) {
        orFlags = orFlags or i
    }
    return orFlags
}

inline public fun <reified T : Activity> Fragment.startActivity() {
    this.startActivity(getIntent<T>())
}

inline public fun <reified T : Activity> Fragment.startActivity(flags: Int) {
    this.startActivity(getIntent<T>(flags))
}

inline public fun <reified T: Activity> Fragment.startActivity(extras: Bundle) {
    this.startActivity(getIntent<T>(extras))
}

inline public fun <reified T: Activity> Fragment.startActivity(extras: Bundle, flags: Int) {
    this.startActivity(getIntent<T>(extras, flags))
}

inline public fun <reified T : Activity> Fragment.startActivityForResult(requestCode: Int) {
    this.startActivityForResult(getIntent<T>(), requestCode)
}

inline public fun <reified T : Activity> Fragment.startActivityForResult(requestCode: Int, flags: Int) {
    this.startActivityForResult(getIntent<T>(flags), requestCode)
}

inline public fun <reified T : Activity> Fragment.startActivityForResult(extras: Bundle, requestCode: Int) {
    this.startActivityForResult(getIntent<T>(extras), requestCode)
}

inline public fun <reified T : Activity> Fragment.startActivityForResult( extras: Bundle, requestCode: Int, flags: Int) {
    this.startActivityForResult(getIntent<T>(extras, flags), requestCode)
}

inline public fun <reified T: Service> Fragment.startService() {
    getActivity().startService(getIntent<T>())
}

inline public fun <reified T: Service> Fragment.startService(flags: Int) {
    getActivity().startService(getIntent<T>(flags))
}

inline public fun <reified T: Service> Fragment.startService(extras: Bundle) {
    getActivity().startService(getIntent<T>(extras))
}

inline public fun <reified T: Service> Fragment.startService(extras: Bundle, flags: Int) {
    getActivity().startService(getIntent<T>(extras, flags))
}

inline public fun <reified T: Context> Fragment.getIntent(): Intent {
    return Intent(getActivity(), javaClass<T>())
}

inline public fun <reified T: Context> Fragment.getIntent(flags: Int): Intent {
    val intent = getIntent<T>()
    intent.setFlags(flags)
    return intent
}

inline public fun <reified T: Context> Fragment.getIntent(extras: Bundle): Intent {
    return getIntent<T>(extras, 0)
}

inline public fun <reified T: Context> Fragment.getIntent(extras: Bundle, flags: Int): Intent {
    val intent = getIntent<T>(flags)
    intent.putExtras(extras)
    return intent
}