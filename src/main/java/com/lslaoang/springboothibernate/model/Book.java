package com.lslaoang.springboothibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@JsonIgnoreProperties({"hibernateLazyInitializer"}) //to SKIP serialize
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

}
