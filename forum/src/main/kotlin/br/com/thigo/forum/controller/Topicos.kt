package br.com.thigo.forum.controller

import br.com.thigo.forum.controller.dto.TopicoDto
import br.com.thigo.forum.modelo.Curso
import br.com.thigo.forum.modelo.Topico
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Topicos {

    @RequestMapping("/topicos")
    fun lista(): List<TopicoDto> {
        val topico = Topico("Dúvida Hard",
            "Dúvida com Spring",
            Curso("Spring", "Programação"))

        return TopicoDto.converter(listOf(topico, topico, topico))
    }
}

