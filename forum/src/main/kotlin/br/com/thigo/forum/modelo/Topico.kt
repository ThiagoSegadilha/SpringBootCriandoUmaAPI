package br.com.thigo.forum.modelo

import java.time.LocalDateTime


class Topico(var titulo: String, var mensagem: String, curso: Curso) {

    var id: Long? = null
    var dataCriacao = LocalDateTime.now()
    var status = StatusTopico.NAO_RESPONDIDO
    var autor: Usuario? = null
    private var curso: Curso
    var respostas: List<Resposta> = ArrayList()

    override fun hashCode(): Int {
        val prime = 31
        var result = 1

        result = prime * result + if (id == null) 0 else id.hashCode()

        return result
    }

    override fun equals(obj: Any?): Boolean {

        if (this === obj) return true

        if (obj == null) return false

        if (javaClass != obj.javaClass) return false

        val other = obj as Topico
        if (id == null) {
            if (other.id != null) return false
        } else if (id != other.id) return false

        return true
    }

    fun getCurso(): Curso {
        return curso
    }

    fun setCurso(curso: Curso) {
        this.curso = curso
    }

    init {
        this.curso = curso
    }
}
