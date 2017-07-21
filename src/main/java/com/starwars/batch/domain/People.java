package com.starwars.batch.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jaro on 21/07/17.
 */
@Data
@Entity
@XmlRootElement(name = "people")
public class People {
    @Id
    private String name;

    private String birthYear;
    private String gender;
    private String height;
    private String mass;
    private String eyeColor;
    private String hairColor;
    private String skinColor;
}
