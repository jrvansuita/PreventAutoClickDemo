package com.example.preventautoclickdemo.extension

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build

fun PackageManager.getInstalledPackagesCompat(flags: Int = PackageManager.GET_ACTIVITIES): List<PackageInfo> {
	kotlin.runCatching {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
			return getInstalledPackages(PackageManager.PackageInfoFlags.of(flags.toLong()))

		@Suppress("DEPRECATION")
		return getInstalledPackages(flags)
	}
	return emptyList()
}