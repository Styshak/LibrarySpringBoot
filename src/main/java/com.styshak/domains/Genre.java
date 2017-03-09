package com.styshak.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class Genre implements Serializable {

    private static final long serialVersionUID = 4537396577756236377L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;
}
