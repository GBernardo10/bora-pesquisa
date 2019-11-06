package br.com.bandtec.borapesquisa.repository;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.bandtec.borapesquisa.models.AnimaisModel;

/**
 * AnimaisRepositorio
 */

 @Repository
public interface AnimaisRepositorio extends MongoRepository<AnimaisModel, String> {
    AnimaisModel findBy_id(ObjectId _id);
    List<AnimaisModel> findByNome(String nome);
}
