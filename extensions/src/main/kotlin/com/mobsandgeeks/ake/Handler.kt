package com.mobsandgeeks.ake

import android.os.Handler
import com.yoavst.util.r
import android.os.Message

public fun Handler.post(action: () -> Unit): Boolean = post(r(action))
public fun Handler.postAtFrontOfQueue(action: () -> Unit): Boolean = postAtFrontOfQueue(r(action))
public fun Handler.postAtTime(uptimeMillis: Long, action: () -> Unit): Boolean = postAtTime(r(action), uptimeMillis)
public fun Handler.postDelayed(delayMillis: Long, action: () -> Unit): Boolean = postDelayed(r(action), delayMillis)

public fun Handler(handleMessage: (Message) -> Boolean): Handler {
    return android.os.Handler(object : Handler.Callback {
        public override fun handleMessage(p0: Message?) = if (p0 == null) false else handleMessage(p0)
    })
}
