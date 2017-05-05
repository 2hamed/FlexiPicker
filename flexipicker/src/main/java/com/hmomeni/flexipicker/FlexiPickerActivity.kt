package com.hmomeni.flexipicker

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.hmomeni.flexipicker.data.MediaLoader


class FlexiPickerActivity : AppCompatActivity() {

	var recyclerView: RecyclerView? = null
	val MY_PERMISSIONS_REQUEST_READ_CONTACTS: Int = 56

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_flexi_picker)

		recyclerView = findViewById(R.id.recyclerView) as RecyclerView?

		requestPermission()
	}

	fun requestPermission() {
		val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
		if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
			permissionGranted()
		} else {
			if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
				showPermissionRationale()
			} else {
				ActivityCompat.requestPermissions(this,
						arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
						MY_PERMISSIONS_REQUEST_READ_CONTACTS);
			}
		}
	}

	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
		if (requestCode == MY_PERMISSIONS_REQUEST_READ_CONTACTS) {
			if (grantResults.isNotEmpty()
					&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				permissionGranted()
			} else {
				permissionDenied()
			}
		}
	}

	fun showPermissionRationale() {
		AlertDialog.Builder(this)
				.setMessage(R.string.read_storate_permission_rationale)
				.setPositiveButton(R.string.grant, { dialog, which ->
					ActivityCompat.requestPermissions(this,
							arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
							MY_PERMISSIONS_REQUEST_READ_CONTACTS)
				})
				.setNegativeButton(R.string.nope, { dialog, which -> permissionDenied() })
				.show()
	}

	fun permissionGranted() {

	}

	fun permissionDenied() {

	}
}
