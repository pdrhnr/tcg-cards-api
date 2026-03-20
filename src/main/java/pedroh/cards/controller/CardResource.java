package pedroh.cards.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import pedroh.cards.dto.CardDTO;
import pedroh.cards.model.entity.Card;
import pedroh.cards.model.repositories.CardRepository;

@RestController
@RequestMapping("/cards")
public class CardResource {
    private CardRepository cardRepository;

    public CardResource(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public ResponseEntity<List<Card>> get() {
        return ResponseEntity.ok(cardRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Card> create(@RequestBody @Valid CardDTO dto) {
        Card card = new Card();
        card.setNome(dto.getNome());
        card.setRaridade(dto.getRaridade());
        cardRepository.save(card);
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody @Valid Card card) {
        Optional<Card> optional = cardRepository.findById(id);
        if (!optional.isPresent()) {
            return new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
        }
        Card cardEdit = optional.get();
        cardEdit.setNome(card.getNome());
        cardEdit.setRaridade(card.getRaridade());
        cardRepository.save(cardEdit);
        return new ResponseEntity<Card>(cardEdit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> delete(@PathVariable Long id) {
        Optional<Card> optional = cardRepository.findById(id);
        if (!optional.isPresent()) {
            return new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
        }
        cardRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}