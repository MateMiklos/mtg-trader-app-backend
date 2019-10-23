package com.codecool.mtgtraderapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private City city;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Card card;

    private String name;

    private String address;
}
