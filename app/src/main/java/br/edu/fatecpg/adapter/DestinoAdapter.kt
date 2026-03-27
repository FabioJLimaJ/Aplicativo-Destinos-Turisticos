package br.edu.fatecpg.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.R
import br.edu.fatecpg.model.Destino
import br.edu.fatecpg.model.DestinoDao
import br.edu.fatecpg.view.WebActivity

class DestinoAdapter(
    private val destinos: MutableList<Destino>,
    private val dao: DestinoDao
) : RecyclerView.Adapter<DestinoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNomeDestino: TextView = itemView.findViewById(R.id.textView_nomeDestino)
        val textViewPaisRegiao: TextView = itemView.findViewById(R.id.textView_paisRegiao)
        val textViewUrl: TextView = itemView.findViewById(R.id.textView_url)
        val btnRemover: ImageButton = itemView.findViewById(R.id.btn_remover)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_destino, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = destinos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val destino = destinos[position]
        holder.textViewNomeDestino.text = destino.nome
        holder.textViewPaisRegiao.text = destino.pais
        holder.textViewUrl.text = destino.url


        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, WebActivity::class.java)
            intent.putExtra("URL_DESTINO", destino.url)
            context.startActivity(intent)
        }


        holder.btnRemover.setOnClickListener {
            val currentPosition = holder.adapterPosition

            if (currentPosition != RecyclerView.NO_POSITION) {
                val destinoParaRemover = destinos[currentPosition]


                dao.removerDestino(destinoParaRemover)


                destinos.removeAt(currentPosition)


                notifyItemRemoved(currentPosition)
                notifyItemRangeChanged(currentPosition, destinos.size)
            }
        }
    }
}