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
    fun lista(): List<TopicoDto> {
        val topicos = topicoRepository!!.findAll().toList()

        return TopicoDto.converter(topicos as List<Topico>)
    }
}

