package com.db.Livros.controllers;


import com.db.Livros.dtos.LivrosRecordDTO;
import com.db.Livros.models.LivrosModel;
import com.db.Livros.repositories.LivrosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LivrosController {

    @Autowired
    LivrosRepository livrosRepository;

    @PostMapping("/livros")
    public ResponseEntity<LivrosModel> saveProduct(@RequestBody @Valid LivrosRecordDTO livrosRecordDto) {
        var livrosModel = new LivrosModel();
        BeanUtils.copyProperties(livrosRecordDto, livrosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(livrosRepository.save(livrosModel));
    }

    @GetMapping("/livros")
    public ResponseEntity<List<LivrosModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(livrosRepository.findAll());
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id) {
        Optional<LivrosModel> livro = livrosRepository.findById(id);
        if (livro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(livro.get());
    }

    @PutMapping("/livros/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid LivrosRecordDTO livrosRecordDto) {
        Optional<LivrosModel> livro = livrosRepository.findById(id);
        if(livro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        var livrosModel = livro.get();
        BeanUtils.copyProperties(livrosRecordDto, livrosModel);
        return ResponseEntity.status(HttpStatus.OK).body(livrosRepository.save(livrosModel));
    }

    @DeleteMapping("/livros/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
        Optional<LivrosModel> livro = livrosRepository.findById(id);
        if(livro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        livrosRepository.delete(livro.get());
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully.");
    }
}
