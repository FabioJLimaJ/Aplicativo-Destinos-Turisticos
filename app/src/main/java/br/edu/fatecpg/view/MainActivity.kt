package br.edu.fatecpg.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.R
import br.edu.fatecpg.model.Usuario

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nome = findViewById<EditText>(R.id.edt_nome)
        val senha = findViewById<EditText>(R.id.edt_senha)

        val btnLogar = findViewById<Button>(R.id.btn_logar)
        val irCadastro = findViewById<Button>(R.id.btn_cadastro)
        btnLogar.setOnClickListener{
            val nomenome = nome.text.toString()
            val senhasenha = senha.text.toString()
            val usuario = Usuario()
            if(nomenome.isNotEmpty() && senhasenha.isNotEmpty()){

                if(nomenome == usuario.nome && senhasenha == usuario.senha){
                    val intent = Intent(this, CadastrarDestinoActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Login incorreto", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "Campos vazios", Toast.LENGTH_SHORT).show()
            }

        }
        irCadastro.setOnClickListener{
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}