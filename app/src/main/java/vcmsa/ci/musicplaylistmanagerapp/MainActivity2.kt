package vcmsa.ci.musicplaylistmanagerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    //These are empty List (called ArrayList) where we will be storing each songs details

    //Stores the name of the song
    private val songs = arrayListOf<String>()

    //stores the different artist for each song
    private val artistName = arrayListOf<String>()

    //Stores the different ratings for each song
    private val rates = arrayListOf<Int>()

    //Stores extra notes about each song
    private val comments = arrayListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //Declaring all of our variables that we are going to use for this code.

        //input field for the song's name
        val songName = findViewById<EditText>(R.id.songTitleText)

        // input field for the artist name
        val artistName = findViewById<EditText>(R.id.artistText)

        //input field for the song rating
        val songRating = findViewById<EditText>(R.id.ratingText)

        //input field for each song's comments
        val inputComment =findViewById<EditText>(R.id.commentText)

        // A button to add all the information that the user has provided
        val addButton = findViewById<Button>(R.id.addToPlaylistButton)

        val


    }
}