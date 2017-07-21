package com.starwars.batch.processor;

import com.starwars.batch.domain.People;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by jaro on 21/07/17.
 */
@Component
public class PeopleProcessor implements ItemProcessor<People, People>{
    @Override
    public People process(People people) throws Exception {

        //filter object which age = 30
        if(people.getGender().equals("n/a")) people.setGender("Droid");

        return people;
    }
}
