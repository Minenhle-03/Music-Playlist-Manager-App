package vcmsa.ci.musicplaylistmanagerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
        val inputArtist = findViewById<EditText>(R.id.artistText)

        //input field for the song rating
        val songRating = findViewById<EditText>(R.id.ratingText)

        //input field for each song's comments
        val inputComment =findViewById<EditText>(R.id.commentText)

        // A button to add all the information that the user has provided
        val addButton = findViewById<Button>(R.id.addToPlaylistButton)

        // a button to add go to the  detail summary screen
        val viewDetailsButton = findViewById<Button>(R.id.viewDetailsScreenButton)

        // a button to exit the app
        val exitButton  = findViewById<Button>(R.id.exitButton)


        // when the add button is clicked....
        addButton.setOnClickListener {
            //stores the users information from each text box into a temporary variable
            val song = songName.text.toString()
            val artist = inputArtist.text.toString()
            val rate = songRating.text.toString()
            val comment = inputComment.text.toString()

            // Checking if any of the required inputs are empty
            if (song.isBlank() || artist.isBlank() || rate.isBlank()){

                // show a message on the screen telling the user to fill in all field
                Toast.makeText(this,"Please fill in all blank spaces." , Toast.LENGTH_SHORT).show()

                //Exit this click event early so that it does not add invalid data
                return@setOnClickListener

            }

            //Try to change the ratings fields
            val rating = rate.toIntOrNull()
            if (rating == null || rating <= 0){

                //if the is rating number is equals to zero or invalid show this on screen
                Toast.makeText(this,"Rate Number is invalid", Toast.LENGTH_SHORT).show()

                // click the exit button to avoid saving invalid ratings
                return@setOnClickListener
            }


            //if all the information that the user has provided is correct.
            //add song into the song list
            songs.add(song)

            //add artist name to arist list
            artistName.add(artist)

            //add song rates
            rates.add(rating)

            //add song comment
            comments.add(comment)

            //let the user know that their information has been added
            Toast.makeText(this, "Successfully Added!", Toast.LENGTH_SHORT).show()

            //Clear all input boxes so the the user can add more songs

            songName.text.clear()
            inputArtist.text.clear()
            songRating.text.clear()
            inputComment.text.clear()


        }

        viewDetailsButton.setOnClickListener {
            // create a new screen to move to the details summary
            val intent = Intent(this,MainActivity3::class.java)

            // attach all the "extra" data to send to the next screen
            intent.putStringArrayListExtra("song",songs)
            intent.putStringArrayListExtra("artists",artistName)
            intent.putIntegerArrayListExtra("rating",rates)
            intent.putStringArrayListExtra("comment",comments)

            //start the next activity and switch to the next screen
            startActivity(intent)
        }

        // when the user clicks on "exit app" the exit button is trigger
        exitButton.setOnClickListener {
            finish() //closes the app
        }


    }
}