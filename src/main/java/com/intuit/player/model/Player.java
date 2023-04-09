package com.intuit.player.model;

import com.intuit.player.util.CustomDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

/**
 * Represents table players
 */
@Entity
@Table(name = "players")
@Data
public class Player {
    @Id
    @CsvBindByName(column = "playerID")
    private String playerID;

   /*  todo - use FK and split to tables for reuse
    @ManyToOne(cascade = CascadeType.ALL)
    private Birthday birthday; */

    @Column(name = "birth_year")
    @CsvBindByName(column = "birthYear")
    private Long birthYear;

    @Column(name = "birth_month")
    @CsvBindByName(column = "birthMonth")
    private Long birthMonth;

    @Column(name = "birth_day")
    @CsvBindByName(column = "birthDay")
    private Integer birthDay;

    @Column(name = "birth_country")
    @CsvBindByName(column = "birthCountry")
    private String birthCountry;

    @Column(name = "birth_state")
    @CsvBindByName(column = "birthState")
    private String birthState;

    @Column(name = "birth_city")
    @CsvBindByName(column = "birthCity")
    private String birthCity;

    @Column(name = "death_year")
    @CsvBindByName(column = "deathYear")
    private Long deathYear;

    @Column(name = "death_month")
    @CsvBindByName(column = "deathMonth")
    private Long deathMonth;

    @Column(name = "death_day")
    @CsvBindByName(column = "deathDay")
    private Integer deathDay;

    @Column(name = "death_country")
    @CsvBindByName(column = "deathCountry")
    private String deathCountry;

    @Column(name = "death_state")
    @CsvBindByName(column = "deathState")
    private String deathState;

    @Column(name = "death_city")
    @CsvBindByName(column = "deathCity")
    private String deathCity;

    @Column(name = "name_first")
    @CsvBindByName(column = "nameFirst")
    private String nameFirst;

    @Column(name = "name_last")
    @CsvBindByName(column = "nameLast")
    private String nameLast;

    @Column(name = "name_given")
    @CsvBindByName(column = "nameGiven")
    private String nameGiven;

    @Column(name = "weight")
    @CsvBindByName(column = "weight")
    private Long weight;

    @Column(name = "bats")
    @CsvBindByName(column = "bats")
    private String bats;

    @Column(name = "throws")
    @CsvBindByName(column = "throws")
    private String throwss;

    @Column(name = "debut")
    @CsvCustomBindByName(column = "debut", converter = CustomDateConverter.class)
    private Date debut;

    @Column(name = "final_game")
    @CsvCustomBindByName(column = "finalGame", converter = CustomDateConverter.class)
    private Date finalGame;

    @Column(name = "retro_ID")
    @CsvBindByName(column = "retroID")
    private String retroID;

    @Column(name = "bbref_ID")
    @CsvBindByName(column = "bbrefID")
    private String bbrefID;
}
