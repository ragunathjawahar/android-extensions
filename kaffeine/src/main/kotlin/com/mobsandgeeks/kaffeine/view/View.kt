/*
 * Copyright (C) 2015 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mobsandgeeks.kaffeine.view

import android.app.Activity
import android.view.View


inline fun <reified T : View> View.find(id: Int): T = this.findViewById(id) as T

inline fun <reified T : View> Activity.find(id: Int): T = this.findViewById(id) as T

fun View.onClick(action: () -> Unit) = setOnClickListener { action() }

fun View.beVisible(): Unit { setVisibility(View.VISIBLE) }

fun View.beGone(): Unit { setVisibility(View.GONE) }

fun View.beInvisible(): Unit { setVisibility(View.INVISIBLE) }

fun View.beVisibleIf(condition: Boolean): Unit = if(condition) beVisible() else beGone()
