package br.com.thigo.forum.controller

//import org.springframework.validation.annotation.Validated

import br.com.thigo.forum.controller.dto.DetalhesDoTopicoDto
import br.com.thigo.forum.controller.dto.TopicoDto
import br.com.thigo.forum.controller.form.AtualizacaoTopicoForm
import br.com.thigo.forum.controller.form.TopicoForm
import br.com.thigo.forum.modelo.Topico
import br.com.thigo.forum.repository.CursoRepository
import br.com.thigo.forum.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import javax.validation.Valid


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

    @GetMapping("/{id}")
    fun detalhar(@PathVariable id: Long): ResponseEntity<DetalhesDoTopicoDto> {
        val topico: Optional<Topico> = topicoRepository!!.findById(id)

        return if (topico.isPresent) {
            ResponseEntity.ok(DetalhesDoTopicoDto(topico.get()))
        } else {
            ResponseEntity.notFound().build<DetalhesDoTopicoDto>()
        }

    }

    @PostMapping
    @Transactional
    fun cadastrar(
        @RequestBody @Valid topicoForm: TopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoDto> {  // @RequestBody: Indicar ao Spring que os parâmetros enviados no corpo da requisição devem ser atribuídos ao parâmetro do método
        val topico = topicoForm.converter(cursoRepository!!)
        topicoRepository!!.save(topico)

        val uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.id).toUri()
        return ResponseEntity.created(uri).body(TopicoDto(topico))
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody @Valid atualizacaoTopicoForm: AtualizacaoTopicoForm
    ): ResponseEntity<TopicoDto> {
        val optional: Optional<Topico> = topicoRepository!!.findById(id)

        return if (optional.isPresent) {
            val topico: Topico = atualizacaoTopicoForm.atualizar(id, topicoRepository)

            ResponseEntity.ok(TopicoDto(topico))
        } else {
            ResponseEntity.notFound().build<TopicoDto>()

        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    fun remover(@PathVariable id: Long): ResponseEntity<*> {
        val optional: Optional<Topico> = topicoRepository!!.findById(id)

        return if (optional.isPresent) {
            topicoRepository!!.deleteById(id)
            ResponseEntity.ok().build<Any>()
        } else {
            ResponseEntity.notFound().build<Any>()
        }

    }
}

