package br.com.thigo.forum.controller.form

import br.com.thigo.forum.modelo.Topico
import br.com.thigo.forum.repository.CursoRepository
import javax.validation.constraints.NotEmpty


class TopicoForm {

    val titulo: String? = null
    var mensagem: String? = null
    var nomeCurso: String? = null

    fun converter(cursoRepository: CursoRepository): Topico {
        val curso = cursoRepository.findByNome(nomeCurso!!)
        return Topico(titulo, mensagem, curso)
    }
}