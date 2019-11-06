package br.com.bandtec.borapesquisa.models;

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
public class AnimaisModel {

    @Id
    public ObjectId _id;

    @Indexed(name = "nome")
    public String nome;

    @Indexed(name = "raca")
    public String raca;

    @Indexed(name = "especie")
    public String especie;

    public String get_id() {
        return _id.toHexString();
    }
}
