package health.singular.viewer3cr.sdk.android.example

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import health.singular.viewer3cr.sdk.android.example.ui.theme.Example3CRAndroidTheme


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(
            Intent(
            this,
                MyNewActivityWithThe3crViewer::class.java
        )
        )

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Example3CRAndroidTheme {
        Greeting("Android")
    }
}