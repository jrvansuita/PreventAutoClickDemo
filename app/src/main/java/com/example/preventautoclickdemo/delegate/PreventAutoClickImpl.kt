package com.example.preventautoclickdemo.delegate

import android.app.Application
import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.example.preventautoclickdemo.R
import com.example.preventautoclickdemo.extension.findInstalledPackages

class PreventAutoClickImpl : PreventAutoClick, LifecycleEventObserver {

	private lateinit var activity: ComponentActivity

	override fun register(activity: ComponentActivity) {
		this.activity = activity
		activity.lifecycle.addObserver(this)
	}

	private fun Application.thereIsSomeSuspiciousApp() = findInstalledPackages().any {
		blockedTerms.any { name ->
			it.contains(name)
		}
	}

	override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
		when (event) {
			Lifecycle.Event.ON_RESUME -> detect()
			else -> Unit
		}
	}

	private fun detect() {
		if (activity.application.thereIsSomeSuspiciousApp())
			activity.setContentView(R.layout.auto_click_empty_state)
	}
}

private val blockedTerms = listOf("autoclick", "automatictap", "autotap", "clicker", "touchmacro")