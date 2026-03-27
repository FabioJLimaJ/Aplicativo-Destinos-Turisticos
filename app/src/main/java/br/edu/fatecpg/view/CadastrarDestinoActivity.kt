package br.edu.fatecpg.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.R
import br.edu.fatecpg.model.Destino
import br.edu.fatecpg.model.DestinoDao
import br.edu.fatecpg.model.DestinoDaoImpl

class CadastrarDestinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastrar_destino)

        val nm_destino = findViewById<EditText>(R.id.edt_nome_destino)
        val nm_pais_regiao = findViewById<EditText>(R.id.edt_pais_regiao)
        val link_url = findViewById<EditText>(R.id.edt_url)

        val btn_cadastrar_Destino = findViewById<Button>(R.id.btn_cadastrar_destino)
        val btn_ver_lista = findViewById<Button>(R.id.btn_lista)
        btn_cadastrar_Destino.setOnClickListener {
            val destino = nm_destino.text.toString()
            val pais_regiao = nm_pais_regiao.text.toString()
            val url = link_url.text.toString()

            if(destino.isNotEmpty()){
                val dao = DestinoDaoImpl()
                dao.adicionarDestino(Destino(destino, pais_regiao, url))
                Toast.makeText(this, "Destino cadastrado", Toast.LENGTH_SHORT).show()

            }
        }
        btn_ver_lista.setOnClickListener {
            val intent = Intent(this, DestinosActivity::class.java)
            startActivity(intent)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}