package icedo.hector.popcornfactory_icedohector

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buscar vistas con findViewById
        val ivPeliculaImagen = findViewById<ImageView>(R.id.iv_pelicula_imagen)
        val tvNombrePelicula = findViewById<TextView>(R.id.tv_nombre_pelicula)
        val tvPeliculaDesc = findViewById<TextView>(R.id.tv_pelicula_desc)

        val bundle = intent.extras
        if (bundle != null) {
            ivPeliculaImagen.setImageResource(bundle.getInt("header"))
            tvNombrePelicula.text = bundle.getString("titulo")
            tvPeliculaDesc.text = bundle.getString("sinopsis")
        }
    }
}
