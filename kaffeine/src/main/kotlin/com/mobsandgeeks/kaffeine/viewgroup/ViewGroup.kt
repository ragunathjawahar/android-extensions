package com.mobsandgeeks.kaffeine.viewgroup

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(layout: Int) = LayoutInflater.from(getContext()).inflate(layout, this, false)