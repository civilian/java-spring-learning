package com.example.producer;

import java.util.function.Predicate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ReservationEntityTest {

    @Autowired
    private ReactiveMongoTemplate template;

    @Test
    public void persist () throws Exception {
        Reservation reservation = new Reservation(null, "jane");
        Mono<Reservation> save = this.template.save(reservation);
        StepVerifier
            .create(save)
            .expectNextMatches(new Predicate<Reservation>{
                @Override
                public boolean test(Reservation reservation) {
                    return false;
                }
            })
    }
}