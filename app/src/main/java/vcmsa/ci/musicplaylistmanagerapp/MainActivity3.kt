package vcmsa.ci.musicplaylistmanagerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Integer.sum

class MainActivity3 : AppCompatActivity() {

    //declaring the screen elements
    private lateinit var allSongs:TextView
    private lateinit var averageRates:TextView
    private lateinit var returnButton:Button
    private lateinit var averageButton:Button
    private lateinit var detailsButton:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        // combine all the variables together
        allSongs = findViewById(R.id.playlistText)
        averageRates = findViewById(R.id.averageText)
        returnButton = findViewById(R.id.returnButton)
        averageButton = findViewById(R.id.calcAverageButton)
        detailsButton = findViewById(R.id.playListButton)

        // Receive data from the previous screen
        val songs = intent.getStringArrayListExtra("song") ?: arrayListOf()
        val artistName = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val rates = intent.getIntegerArrayListExtra("rating") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comment") ?: arrayListOf()

        //when the user clicks on display this happens
        detailsButton.setOnClickListener {
            val list = songs.indices.joinToString("\n") {

                // create a string that's going to know what where to save
                "${songs[it]} (${artistName[it]} - ${rates[it]}: ${comments[it]}"
            }
            // show all these information in this textView
            allSongs.text = list.ifBlank { "No Songs Were added" }

            //show the average in the text box
            averageButton.setOnClickListener {
                val averageText = songs.indices.joinToString("\n"){
                    //show only songs name and its rating
                    "${songs[it]} rate:${rates[it]}"
                }
                // show average here on this text
                averageRates.text= averageText.ifBlank { "No rates has been provided" }

            }

            // when the user click the return button this happen
            returnButton.setOnClickListener {
                finish() // closes the app
            }
        }
    }
}