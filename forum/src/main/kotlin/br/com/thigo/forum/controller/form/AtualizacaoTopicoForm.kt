package br.com.thigo.forum.controller.form

import br.com.thigo.forum.modelo.Topico
import br.com.thigo.forum.repository.TopicoRepository
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class AtualizacaoTopicoForm {

    @NotNull @NotEmpty @Size(min = 5)
    val titulo: String? = null
    @NotNull @NotEmpty @Size(min = 10)
    var mensagem: String? = null

    fun atualizar(id: Long, topicoRepository: TopicoRepository?): Topico {
        val topico = topicoRepository!!.getById(id)
        topico.titulo = titulo
        topico.mensagem = mensagem

        return topico
    }
}
