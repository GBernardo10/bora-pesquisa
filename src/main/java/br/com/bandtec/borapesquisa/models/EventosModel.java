package br.com.bandtec.borapesquisa.models;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

/**
 * AnimaisModel
 */

@Data
@Document
public class EventosModel {

    @Id
    public ObjectId _id;

    @Field("OrderID")
    @TextIndexed(weight=2)
    private Integer orderID;

    @Indexed(name = "nome")
    @TextIndexed
    public String nome;

    @Indexed(name = "descricao")
    @TextIndexed
    public String descricao;

    @Indexed(name = "participantes")
    @TextIndexed
    public List<String> participantes;

    @Indexed(name = "organizador")
    @TextIndexed
    public String organizador;

    public String get_id() {
        return _id.toHexString();
    }
}
