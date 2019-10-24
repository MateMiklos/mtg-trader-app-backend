package com.codecool.mtgtraderapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Expansion expansion;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private User user;

    @OneToMany(mappedBy = "card", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private List<Location> location = new ArrayList<>();

    private boolean isFoil;

    public String getUserName() {
        return this.user.getName();
    }

    public String getUserEmail() {
        return this.user.getEmail();
    }
}
