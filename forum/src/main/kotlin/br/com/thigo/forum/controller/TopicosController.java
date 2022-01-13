package br.com.thigo.forum.controller;

import br.com.thigo.forum.controller.dto.TopicoDta;
import br.com.thigo.forum.controller.dto.TopicoDto;
import br.com.thigo.forum.modelo.Curso;
import br.com.thigo.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

//    @RequestMapping("/topicoss")
//    public List<TopicoDto> lista() {
//        Topico topico = new Topico("Dúvida Hard", "Dúvida com Spring", new Curso("Spring", "Programação"));
//
//        return TopicoDta.converter(Arrays.asList(topico, topico, topico));
//    }

}