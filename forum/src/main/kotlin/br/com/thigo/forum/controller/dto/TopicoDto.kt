package br.com.thigo.forum.controller.dto

import br.com.thigo.forum.modelo.Topico
import java.time.LocalDateTime
import java.util.stream.Collectors

class TopicoDto(topico: Topico) {
    val id: Long
    val titulo: String
    val mensagem: String
    val dataCriacao: LocalDateTime

    init {
        id = topico.id!!
        titulo = topico.titulo!!
        mensagem = topico.mensagem!!
        dataCriacao = topico.dataCriacao!!
    }

    companion object {
        fun converter(topicos: List<Topico>): List<TopicoDto> {
            return topicos.stream().map { topico: Topico -> TopicoDto(topico) }.collect(Collectors.toList())
        }
    }
}
