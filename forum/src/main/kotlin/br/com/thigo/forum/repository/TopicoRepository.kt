package br.com.thigo.forum.repository

import br.com.thigo.forum.modelo.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {
    fun findByCurso_Nome(nomeCurso: String): List<Topico>
}