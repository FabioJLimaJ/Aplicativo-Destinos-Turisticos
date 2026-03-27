package br.edu.fatecpg.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.R
import br.edu.fatecpg.adapter.DestinoAdapter
import br.edu.fatecpg.model.DestinoDaoImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DestinosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_destinos)

        val dao = DestinoDaoImpl()
        val listar = dao.exibirDestino()

        val rvDestinos = findViewById<RecyclerView>(R.id.rvDestinos)
        rvDestinos.layoutManager = LinearLayoutManager(this)
        val adapter = DestinoAdapter(listar.toMutableList(), dao)
        rvDestinos.adapter = adapter

        val btn_ir_cadastrar_destino = findViewById<FloatingActionButton>(R.id.fabAddDestino)

        btn_ir_cadastrar_destino.setOnClickListener {
            val intent = Intent(this, CadastrarDestinoActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}