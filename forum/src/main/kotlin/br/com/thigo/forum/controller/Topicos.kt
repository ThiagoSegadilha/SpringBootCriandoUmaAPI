package br.com.thigo.forum.controller

import br.com.thigo.forum.controller.dto.TopicoDto
import br.com.thigo.forum.modelo.Topico
import br.com.thigo.forum.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class Topicos {

    @Autowired
    private var topicoRepository: TopicoRepository? = null

    @RequestMapping("/topicos")
    fun lista(nomeCurso: String?): List<TopicoDto> {
        if (nomeCurso === null) {
            val topicos = topicoRepository!!.findAll()

            return TopicoDto.converter(topicos as List<Topico>)
        } else {
            val topicos = topicoRepository!!.findByCurso_Nome(nomeCurso) // findByCurso_Nome: O "_" indica um relacionamento

            return TopicoDto.converter(topicos)
        }
    }
}

