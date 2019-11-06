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
import br.com.bandtec.borapesquisa.models.AnimaisModel;
import br.com.bandtec.borapesquisa.repository.AnimaisRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * AnimaisController
 */

@RestController
@RequestMapping("/api/animais")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AnimaisController {

    private final AnimaisRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<AnimaisModel>> buscarAnimais() {
        return ResponseEntity.ok(repositorio.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<AnimaisModel> buscarPeloId(@PathVariable(value = "id") ObjectId _id) {
        return ResponseEntity.ok(repositorio.findBy_id(_id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizarPeloId(@PathVariable(value = "id") ObjectId _id,
            @Valid @RequestBody AnimaisModel animaisModel) {
        animaisModel.set_id(_id);
        repositorio.save(animaisModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarAnimal(@Valid @RequestBody AnimaisModel animaisModel) {
        repositorio.save(animaisModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> apagarAnimal(@PathVariable(value = "id")ObjectId _id){
        repositorio.delete(repositorio.findBy_id(_id));
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
