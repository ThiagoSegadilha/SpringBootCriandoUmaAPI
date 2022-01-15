package br.com.thigo.forum.controller

import br.com.thigo.forum.controller.dto.TopicoDto
import br.com.thigo.forum.controller.form.TopicoForm
import br.com.thigo.forum.modelo.Topico
import br.com.thigo.forum.repository.CursoRepository
import br.com.thigo.forum.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
//import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
//import javax.validation.Valid


@RestController
@RequestMapping("/topicos")
class TopicosController {

    @Autowired
    private val topicoRepository: TopicoRepository? = null

    @Autowired
    private val cursoRepository: CursoRepository? = null

    @GetMapping
    fun lista(nomeCurso: String?): List<TopicoDto> {
        return if (nomeCurso == null) {
            val topicos = topicoRepository!!.findAll()
            TopicoDto.converter(topicos as List<Topico>)
        } else {
            val topicos: List<Topico> = topicoRepository!!.findByCurso_Nome(nomeCurso)
            TopicoDto.converter(topicos)
        }
    }

    @PostMapping
    fun cadastrar(@RequestBody topicoForm: TopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoDto> {  // @RequestBody: Indicar ao Spring que os parâmetros enviados no corpo da requisição devem ser atribuídos ao parâmetro do método
        val topico = topicoForm.converter(cursoRepository!!)
        topicoRepository!!.save(topico)

        val uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.id).toUri()
        return ResponseEntity.created(uri).body(TopicoDto(topico))
    }
}

