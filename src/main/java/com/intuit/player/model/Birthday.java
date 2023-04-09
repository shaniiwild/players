package com.intuit.player.model;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.Data;

// todo not yet used
@Entity
@Table(name = "birthday")
@Data
public class Birthday {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "birth_year")
    @CsvBindByName(column = "birthYear")
    private Long birthYear;

    @Column(name = "birth_month")
    @CsvBindByName(column = "birthMonth")
    private Long birthMonth;
}
