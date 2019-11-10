package br.com.bandtec.borapesquisa.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bandtec.borapesquisa.models.EventosModel;
import br.com.bandtec.borapesquisa.repository.EventosRepositorio;
import br.com.bandtec.borapesquisa.service.EventosService;
import lombok.RequiredArgsConstructor;

/**
 * AnimaisController
 */

@RestController
@RequestMapping("/api/eventos/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventosController {

    private final EventosService service;
    private final EventosRepositorio repositorio;


    @GetMapping
    public ResponseEntity<List<EventosModel>> buscarEventos() {
        return ResponseEntity.ok(repositorio.findAll());
    }

    // @GetMapping("{text}")
    // public ResponseEntity<List<EventosModel>> pesquisa(@PathVariable(value = "text") String text)
    // {
    // return ResponseEntity.ok().body(service.busca(text));
    // // return ResponseEntity.ok().body(repositorio.findAllBy(textCriteria, model));

    // }

    @GetMapping("{text}")
    public ResponseEntity<List<EventosModel>> teste(@PathVariable(value = "text") String text) {
        List<EventosModel> result = service.busca(text);
        if (result.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return ResponseEntity.ok().body(service.busca(text));
    }
}
