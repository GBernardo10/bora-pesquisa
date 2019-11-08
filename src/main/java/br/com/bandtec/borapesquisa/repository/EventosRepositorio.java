package br.com.bandtec.borapesquisa.repository;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.bandtec.borapesquisa.models.EventosModel;

/**
 * AnimaisRepositorio
 */

 @Repository
public interface EventosRepositorio extends MongoRepository<EventosModel, String> {
}
