package br.com.thigo.forum.controller.dto

import br.com.thigo.forum.modelo.Resposta
import br.com.thigo.forum.modelo.StatusTopico
import br.com.thigo.forum.modelo.Topico
import java.time.LocalDateTime
import java.util.stream.Collectors


class DetalhesDoTopicoDto(topico: Topico) {

    val id: Long
    val titulo: String
    val mensagem: String
    val dataCriacao: LocalDateTime
    val nomeAutor: String
    val status: StatusTopico
    val respostas: List<RespostaDto>

    init {
        id = topico.id!!
        titulo = topico.titulo!!
        mensagem = topico.mensagem!!
        dataCriacao = topico.dataCriacao!!
        nomeAutor = topico.autor!!.nome.toString()
        status = topico.status
        respostas = ArrayList()
        respostas.addAll(topico.respostas.stream().map { resposta: Resposta -> RespostaDto(resposta) }
            .collect(Collectors.toList()))
    }
}
