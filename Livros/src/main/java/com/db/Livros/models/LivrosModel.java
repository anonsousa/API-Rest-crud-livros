package com.db.Livros.models;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_LIVROS")
@Data
public class LivrosModel implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduct;
    private String name;
    private String author;
    private String publisher;
    private String language;
    private int numberPages;
    private String publicationDate;
    private BigDecimal value;

}
