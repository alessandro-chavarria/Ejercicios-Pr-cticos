package enrique.chavarria.ejercicio2

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
        val num2 = findViewById<EditText>(R.id.txtNum2)
        val calcular = findViewById<Button>(R.id.btnCalcular)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        val objCalcularArea = CalcularArea()

        calcular.setOnClickListener {
            val result =objCalcularArea.calcularArea(num1.text.toString(). toInt(), num2.text.toString(). toInt())
            Toast.makeText(this, "El area es de, $result", Toast.LENGTH_LONG).show()

            resultado.text = "El area es de, $result"
        }
    }
}