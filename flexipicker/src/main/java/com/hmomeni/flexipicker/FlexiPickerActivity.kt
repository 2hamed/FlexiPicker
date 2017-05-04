package com.hmomeni.flexipicker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView

class FlexiPickerActivity : AppCompatActivity() {

	var recyclerView: RecyclerView? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_flexi_picker)

		recyclerView = findViewById(R.id.recyclerView) as RecyclerView?
	}
}
