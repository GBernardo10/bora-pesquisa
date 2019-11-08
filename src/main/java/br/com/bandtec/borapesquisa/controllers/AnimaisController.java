package br.com.bandtec.borapesquisa.controllers;

import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bandtec.borapesquisa.models.EventosModel;
import br.com.bandtec.borapesquisa.repository.EventosRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * AnimaisController
 */

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AnimaisController {

    private final EventosRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<EventosModel>> buscarEventos() {
        return ResponseEntity.ok(repositorio.findAll());
    }
}
