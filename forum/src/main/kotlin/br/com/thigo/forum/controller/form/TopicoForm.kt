package br.com.thigo.forum.controller.form

import br.com.thigo.forum.modelo.Topico
import br.com.thigo.forum.repository.CursoRepository
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class TopicoForm {

    @NotNull @NotEmpty @Size(min = 5)
    val titulo: String? = null
    @NotNull @NotEmpty @Size(min = 10)
    var mensagem: String? = null
    @NotNull @NotEmpty
    var nomeCurso: String? = null

    fun converter(cursoRepository: CursoRepository): Topico {
        val curso = cursoRepository.findByNome(nomeCurso!!)
        return Topico(titulo, mensagem, curso)
    }
}