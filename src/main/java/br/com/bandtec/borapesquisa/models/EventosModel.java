package br.com.bandtec.borapesquisa.models;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * AnimaisModel
 */

@Data
@Document
public class EventosModel {

    @Id
    public ObjectId _id;

    @Indexed(name = "nome")
    public String nome;

    @Indexed(name = "descricao")
    public String descricao;

    @Indexed(name = "participantes")
    public List<Usuarios> participantes;

    public String get_id() {
        return _id.toHexString();
    }
}
