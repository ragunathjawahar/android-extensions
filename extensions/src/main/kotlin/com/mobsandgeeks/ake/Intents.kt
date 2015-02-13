package com.mobsandgeeks.ake

import android.content.Context
import android.content.Intent
import android.app.Activity
import android.app.Service
import android.os.Bundle


public fun Context.flags(flag: Int, vararg flags: Int): Int {
    var orFlags = flag;
    for (i in flags) {
        orFlags = orFlags or i
    }
    return orFlags
}

inline public fun <reified T : Activity> Activity.startActivity() {
    this.startActivity(getIntent<T>())
}

inline public fun <reified T : Activity> Activity.startActivity(flags: Int) {
    this.startActivity(getIntent<T>(flags))
}

inline public fun <reified T: Activity> Activity.startActivity(extras: Bundle) {
    this.startActivity(getIntent<T>(extras))
}

inline public fun <reified T: Activity> Activity.startActivity(extras: Bundle, flags: Int) {
    this.startActivity(getIntent<T>(extras, flags))
}

inline public fun <reified T : Activity> Activity.startActivityForResult(requestCode: Int) {
    this.startActivityForResult(getIntent<T>(), requestCode)
}

inline public fun <reified T : Activity> Activity.startActivityForResult(
        requestCode: Int, flags: Int) {
    this.startActivityForResult(getIntent<T>(flags), requestCode)
}

inline public fun <reified T : Activity> Activity.startActivityForResult(
        extras: Bundle, requestCode: Int) {
    this.startActivityForResult(getIntent<T>(extras), requestCode)
}

inline public fun <reified T : Activity> Activity.startActivityForResult(
        extras: Bundle, requestCode: Int, flags: Int) {
    this.startActivityForResult(getIntent<T>(extras, flags), requestCode)
}

inline public fun <reified T : Activity> Service.startActivity() {
    this.startActivity(getIntent<T>(Intent.FLAG_ACTIVITY_NEW_TASK))
}

inline public fun <reified T : Activity> Service.startActivity(flags: Int) {
    this.startActivity(getIntent<T>(flags))
}

inline public fun <reified T: Activity> Service.startActivity(extras: Bundle) {
    this.startActivity(getIntent<T>(extras, Intent.FLAG_ACTIVITY_NEW_TASK))
}

inline public fun <reified T: Activity> Service.startActivity(extras: Bundle, flags: Int) {
    this.startActivity(getIntent<T>(extras, flags))
}

inline public fun <reified T: Service> Context.startService() {
    this.startService(getIntent<T>())
}

inline public fun <reified T: Service> Context.startService(flags: Int) {
    this.startService(getIntent<T>(flags))
}

inline public fun <reified T: Service> Context.startService(extras: Bundle) {
    this.startService(getIntent<T>(extras))
}

inline public fun <reified T: Service> Context.startService(extras: Bundle, flags: Int) {
    this.startService(getIntent<T>(extras, flags))
}

inline public fun <reified T: Context> Context.getIntent(): Intent {
    return Intent(this, javaClass<T>())
}

inline public fun <reified T: Context> Context.getIntent(flags: Int): Intent {
    val intent = getIntent<T>()
    intent.setFlags(flags)
    return intent
}

inline public fun <reified T: Context> Context.getIntent(extras: Bundle): Intent {
    return getIntent<T>(extras, 0)
}

inline public fun <reified T: Context> Context.getIntent(extras: Bundle, flags: Int): Intent {
    val intent = getIntent<T>(flags)
    intent.putExtras(extras)
    return intent
}
