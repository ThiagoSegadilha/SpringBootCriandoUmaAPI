package br.com.thigo.forum.controller.dto

import br.com.thigo.forum.modelo.Resposta
import java.time.LocalDateTime

class RespostaDto(resposta: Resposta) {

    val id: Long
    val mensagem: String
    val dataCriacao: LocalDateTime
    val nomeAutor: String

    init {
        id = resposta.id!!
        mensagem = resposta.mensagem.toString()
        dataCriacao = resposta.dataCriacao
        nomeAutor = resposta.autor?.nome.toString()
    }
}