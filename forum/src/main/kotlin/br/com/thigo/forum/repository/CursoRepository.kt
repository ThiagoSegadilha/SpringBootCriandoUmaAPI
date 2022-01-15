package br.com.thigo.forum.repository

import br.com.thigo.forum.modelo.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
    fun findByNome(nome: String): Curso
}
