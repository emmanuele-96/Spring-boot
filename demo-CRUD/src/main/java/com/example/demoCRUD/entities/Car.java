package com.example.demoCRUD.entities;




import jakarta.persistence.*;




@Entity
@Table
//@Data // imposta automaticamente i getters e i setters
//@NoArgsConstructor // imposta automaticamente il costruttore vuoto
//@AllArgsConstructor // imposta automaticamente il costruttore con tutti i parametri
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String modelName;
    @Column(nullable = false)
    private String type;


}
