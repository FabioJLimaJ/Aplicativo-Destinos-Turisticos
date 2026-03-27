package br.edu.fatecpg.model

interface DestinoDao {
    fun adicionarDestino(destino:Destino)
    fun exibirDestino(): List<Destino>
    fun removerDestino(destino: Destino)
}