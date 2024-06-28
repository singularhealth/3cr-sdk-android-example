package health.singular.viewer3cr.sdk.android.example

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import health.singular.viewer3cr.android.sdk.FrontEndInterfaces
import health.singular.viewer3cr.android.sdk.FrontEndPayload
import health.singular.viewer3cr.android.sdk.ViewerSdkActivity

const val sampleScanPayload = "{" +
    "\"Url\":\"https://webgl-3dr.singular.health/test_scans/01440d4e-8b04-4b90-bb2c-698535ce16d6/CHEST.3vxl\"," +
    "\"DecryptionKey\":{" +
        "\"Iv\":\"XEloSh+OcO7TG77au6HjPw==\"," +
        "\"Key\":\"KUc722X1y4w42M+jCf9a3+6EGz66z7UMWK3m2aMqGxM=\"" +
    "}" +
"}"

class MyNewActivityWithThe3crViewer : ViewerSdkActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        printOpenGLVersion()

        val showMainButton = Button(this).apply {
            text = "LOAD SCAN"
            x = 10f
            y = 500f

            setOnClickListener {
                loadSampleScan()
            }
        }
        addView(showMainButton)

    }

    private fun loadSampleScan() {
        // Call this function whenever you would like 3CR to perform an action
        // You will need to supply different arguments based on the documentation
        executePayload(
            FrontEndPayload(
                FrontEndInterfaces.FILE_MANAGEMENT,
                "fm_01",
                sampleScanPayload,
                "1.0.0",
            )
        )
    }

    // This function will be called every time 3CR emits a message to the Front End.
    // override it so you can process the results from 3CR.
    override fun onPayload(jsonPayload: FrontEndPayload?) {
        super.onPayload(jsonPayload)

        println(jsonPayload)
        // ... Do something with payload.
    }

    private fun printOpenGLVersion() {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager;
        val configurationInfo = activityManager.deviceConfigurationInfo
        println("Device Supported OpenGL ES Version = " + configurationInfo.getGlEsVersion())
    }
}
