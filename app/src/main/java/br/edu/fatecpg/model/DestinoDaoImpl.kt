package br.edu.fatecpg.model

class DestinoDaoImpl: DestinoDao {
    companion object{
        private val destinos = mutableListOf<Destino>()
    }

    override fun adicionarDestino(destino: Destino) {
        Companion.destinos.add(destino)
    }

    override fun exibirDestino(): List<Destino> {
        return  Companion.destinos
    }

    override fun removerDestino(destino: Destino) {
        destinos.remove(destino)
    }


}