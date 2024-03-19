package Enrique.Chavarria.ejercicio1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val num1 = findViewById<EditText>(R.id.txtNum1)
        val Enviar = findViewById<Button>(R.id.btnEnviar)
        val edad = findViewById<TextView>(R.id.txtAño)

        val objCalcularEdad = CalcularEdad()

        Enviar.setOnClickListener{
            val result = objCalcularEdad.calcularEdad(num1.text.toString(). toInt())
            Toast.makeText(this, "Tu edad es, $result", Toast.LENGTH_LONG).show()

            edad.text = "Tu edad es de, $result"
        }
    }
}