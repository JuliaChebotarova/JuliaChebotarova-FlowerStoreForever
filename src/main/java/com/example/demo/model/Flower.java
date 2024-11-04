package com.example.demo.model;

// public class Flower {
//     private String name;
//     private String color;

//     public Flower(String name, String color) {
//         this.name = name;
//         this.color = color;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getColor() {
//         return color;
//     }
// }
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flower")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    private String flower;
    private String color;
    private double price;
    private boolean available;

}
