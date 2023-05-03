package com.example.preventautoclickdemo.extension

import android.app.Application

fun Application.findInstalledPackages() =
	this.packageManager.getInstalledPackagesCompat().map { it.packageName }.filter { it != this.packageName  }

