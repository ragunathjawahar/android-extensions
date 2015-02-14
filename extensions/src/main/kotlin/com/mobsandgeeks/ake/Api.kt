package com.mobsandgeeks.ake

import android.os.Build


public fun Any?.preLollipop(): Boolean = isOlderVersionThen(21)
public fun Any?.lollipopOrNewer(): Boolean = isOnVersionOrNewer(21)
public fun Any?.preKitkat(): Boolean = isOlderVersionThen(19)
public fun Any?.KitkatOrNewer(): Boolean = isOnVersionOrNewer(19)
public fun Any?.preIcs(): Boolean = isOlderVersionThen(14)
public fun Any?.IcsOrNewer(): Boolean = isOnVersionOrNewer(14)
public fun Any?.preVersion(version: Int): Boolean = isOlderVersionThen(version)
public fun Any?.versionOrNewer(version: Int): Boolean = isOnVersionOrNewer(version)
/*
 * -----------------------------------------------------------------------------
 *  Private methods
 * -----------------------------------------------------------------------------
 */
private fun isOlderVersionThen(version: Int) = Build.VERSION.SDK_INT < version
private fun isOnVersionOrNewer(version: Int) = Build.VERSION.SDK_INT >= version