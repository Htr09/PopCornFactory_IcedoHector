package icedo.hector.popcornfactory_icedohector

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val movie_header:ImageView = findViewById(R.id.movie_header)
        val movie_title_detail: TextView = findViewById(R.id.movie_title_detail)
        val movie_summary:TextView= findViewById(R.id.movie_summary)
        val seatsLeft:TextView=findViewById(R.id.seatsLeft)
        val buyTickets:Button=findViewById(R.id.buyTickets)

        val bundle = intent.extras
        var ns=0
        var id =-1
        var title =""

        if(bundle!=null){

            ns = bundle.getInt("numberSeats")
            title= bundle.getString("titulo")!!
            movie_header.setImageResource(bundle.getInt("header"))
            movie_title_detail.setText(bundle.getString("titulo"))
            movie_summary.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("$ns seats avaliable")
            id = bundle.getInt("pos")



        }

        if(ns==0){
            buyTickets.isEnabled=false
        }else{
            buyTickets.isEnabled=true
            buyTickets.setOnClickListener{
                val intent:Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id",id)
                intent.putExtra("name",title)

                this.startActivity(intent)
            }
        }


    }
}