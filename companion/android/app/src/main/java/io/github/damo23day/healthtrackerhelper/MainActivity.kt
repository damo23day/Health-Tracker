package io.github.damo23day.healthtrackerhelper

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private lateinit var status: TextView
    private val notifications get() = getSystemService(NotificationManager::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifications.createNotificationChannel(
            NotificationChannel(CHANNEL, "Health Tracker", NotificationManager.IMPORTANCE_DEFAULT)
        )
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            val padding = (24 * resources.displayMetrics.density).toInt()
            setPadding(padding, padding, padding, padding)
        }
        layout.addView(TextView(this).apply {
            text = "Health Tracker Helper"
            textSize = 24f
        })
        status = TextView(this)
        layout.addView(status)
        layout.addView(Button(this).apply {
            text = "Send Test Notification"
            setOnClickListener { sendTest() }
        })
        setContentView(layout)
    }

    override fun onResume() {
        super.onResume()
        updateStatus()
    }

    private fun permissionGranted() = Build.VERSION.SDK_INT < 33 ||
        checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED

    private fun updateStatus() {
        status.text = "Notification permission: " + when {
            !permissionGranted() -> "Not granted"
            !notifications.areNotificationsEnabled() -> "Disabled in Settings"
            notifications.getNotificationChannel(CHANNEL)?.importance == NotificationManager.IMPORTANCE_NONE ->
                "Health Tracker channel disabled"
            else -> "Granted"
        }
    }

    private fun sendTest() {
        if (!permissionGranted()) {
            requestPermissions(arrayOf(Manifest.permission.POST_NOTIFICATIONS), PERMISSION_REQUEST)
            return
        }
        if (!notifications.areNotificationsEnabled() ||
            notifications.getNotificationChannel(CHANNEL)?.importance == NotificationManager.IMPORTANCE_NONE) {
            offerSettings()
            return
        }
        val launch = packageManager.getLaunchIntentForPackage(CHATGPT_PACKAGE)
        if (launch == null) {
            AlertDialog.Builder(this)
                .setMessage("Install or enable the official ChatGPT app, then send the test notification again.")
                .setPositiveButton("OK", null).show()
            return
        }
        val pendingLaunch = PendingIntent.getActivity(
            this, 0, launch, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val notification = Notification.Builder(this, CHANNEL)
            .setSmallIcon(R.drawable.ic_health_tracker)
            .setContentTitle("Health Tracker Update")
            .setContentText("Open ChatGPT to update your Health Tracker.")
            .setContentIntent(pendingLaunch)
            .setAutoCancel(true)
            .addAction(Notification.Action.Builder(
                android.graphics.drawable.Icon.createWithResource(this, R.drawable.ic_health_tracker),
                "Update Health Tracker", pendingLaunch
            ).build())
            .build()
        try {
            notifications.notify(NOTIFICATION_ID, notification)
            Toast.makeText(this, "Test notification sent", Toast.LENGTH_SHORT).show()
        } catch (_: SecurityException) {
            offerSettings()
        }
        updateStatus()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST) {
            updateStatus()
            if (grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED) sendTest()
            else offerSettings()
        }
    }

    private fun offerSettings() {
        AlertDialog.Builder(this)
            .setMessage("Allow notifications and enable the Health Tracker channel in Android Settings, then retry.")
            .setPositiveButton("Open Settings") { _, _ ->
                startActivity(Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                    .putExtra(Settings.EXTRA_APP_PACKAGE, packageName))
            }
            .setNegativeButton("Cancel", null).show()
    }

    companion object {
        private const val CHANNEL = "health_tracker"
        private const val CHATGPT_PACKAGE = "com.openai.chatgpt"
        private const val NOTIFICATION_ID = 1
        private const val PERMISSION_REQUEST = 1
    }
}
