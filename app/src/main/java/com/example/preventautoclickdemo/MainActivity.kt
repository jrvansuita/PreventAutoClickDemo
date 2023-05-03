package com.example.preventautoclickdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.preventautoclickdemo.delegate.PreventAutoClick
import com.example.preventautoclickdemo.delegate.PreventAutoClickImpl

class MainActivity : AppCompatActivity(), PreventAutoClick by PreventAutoClickImpl() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		register(this)
	}
}