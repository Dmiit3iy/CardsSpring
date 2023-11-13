package org.dmit3iy.controllers;

import org.dmit3iy.dto.ResponseResult;
import org.dmit3iy.model.Card;
import org.dmit3iy.model.Category;
import org.dmit3iy.service.CardService;
import org.dmit3iy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/card")

public class CardController {

    private CardService cardService;

    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(path = "/{categoryId}")
    public ResponseEntity<ResponseResult<Card>> add(@PathVariable long categoryId, @RequestBody Card card) {
        try {
            this.cardService.add(categoryId, card);
            return new ResponseEntity<>(new ResponseResult<>(null, card), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseResult<Card>> get(@PathVariable long id) {
        try {
            Card card = this.cardService.get(id);
            return new ResponseEntity<>(new ResponseResult<>(null, card), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/card/{id}")
    public ResponseEntity<ResponseResult<List<Card>>> getByIdCategory(@PathVariable long id) {
        try {
            List<Card> cards = this.cardService.getByIdCategory(id);
            return new ResponseEntity<>(new ResponseResult<>(null, cards), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    // @GetMapping(path = "/card/user/{id}")
    @GetMapping(path = "/user/{id}")
    public ResponseEntity<ResponseResult<List<Card>>> getByIdUser(@PathVariable long id) {
        try {
            List<Card> cards = this.cardService.getByIdUser(id);
            return new ResponseEntity<>(new ResponseResult<>(null, cards), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseResult<List<Card>>> get() {
        List<Card> cards = this.cardService.get();
        return new ResponseEntity<>(new ResponseResult<>(null, cards), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseResult<Card>> put(@RequestBody Card card) {
        try {
            Card updateCard = this.cardService.update(card);
            return new ResponseEntity<>(new ResponseResult<>(null, updateCard), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult<Card>> delete(@PathVariable long id) {
        try {
            Card card = this.cardService.delete(id);
            return new ResponseEntity<>(new ResponseResult<>(null, card), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

}

