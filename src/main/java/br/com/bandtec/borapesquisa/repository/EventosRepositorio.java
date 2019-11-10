package br.com.bandtec.borapesquisa.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.bandtec.borapesquisa.models.EventosModel;

/**
 * AnimaisRepositorio
 */

@Repository
public interface EventosRepositorio extends MongoRepository<EventosModel, String> {
    @Query("{$or : [{'nome': { $regex: ?0, $options:'i' }},{'descricao': { $regex: ?0, $options:'i' }},{'participantes': { $regex: ?0, $options:'i' }}, {'organizador': { $regex: ?0, $options:'i' }}]}")
    public List<EventosModel> searchEngine(String text);
}
