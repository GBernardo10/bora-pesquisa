package br.com.bandtec.borapesquisa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;
import br.com.bandtec.borapesquisa.models.EventosModel;
import br.com.bandtec.borapesquisa.repository.EventosRepositorio;
import lombok.RequiredArgsConstructor;

/**
 * EventosService
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventosService {

    private final MongoOperations operations;
    private final EventosRepositorio repositorio;

    private List<EventosModel> buscaRepositorio(String text) {
        if (repositorio.searchEngine(text).isEmpty());
            
        return repositorio.searchEngine(text);
    }

    public List<EventosModel> busca(String text) {
        TextQuery textQuery = TextQuery.queryText(new TextCriteria().matchingAny(text));
        List<EventosModel> result = operations.find(textQuery, EventosModel.class, "eventosModel");

        if (result.isEmpty())
            return buscaRepositorio(text);

        return result;
    }
}
