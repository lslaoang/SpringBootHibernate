package com.lslaoang.springboothibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@JsonIgnoreProperties({"hibernateLazyInitializer"}) //to SKIP serialize
@Entity
@Table(name = "BOOKS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "id")
    @NonNull
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @Nullable
    @Column(name = "genre")
    private Genre genre;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", genre=").append(genre);
        sb.append('}');
        return sb.toString();
    }
}
