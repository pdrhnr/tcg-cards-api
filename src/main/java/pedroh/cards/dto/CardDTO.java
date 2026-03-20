package pedroh.cards.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pedroh.cards.model.entity.Card;

public class CardDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Raridade é obrigatória")
    private Card.Raridade raridade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Card.Raridade getRaridade() {
        return raridade;
    }

    public void setRaridade(Card.Raridade raridade) {
        this.raridade = raridade;
    }
}