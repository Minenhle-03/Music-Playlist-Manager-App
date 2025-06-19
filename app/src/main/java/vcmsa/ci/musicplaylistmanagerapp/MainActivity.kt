package vcmsa.ci.musicplaylistmanagerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //get reference to the "Get Started" button by its ID from the XML layout
        val startButton = findViewById<Button>(R.id.startButton)

        // set on click listener on the button respond to the user interaction
        startButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            // this will trigger the screen to move to the next screen.
            startActivity(intent)
        }

    }
}