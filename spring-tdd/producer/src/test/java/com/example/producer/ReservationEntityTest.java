package com.example.producer;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

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
            .expectNextMatches(new Predicate<Reservation>() {
                @Override
                public boolean test(Reservation reservation) {
                    return reservation.getName().equalsIgnoreCase("a") &&
                        reservation.getId() == null;
                }
            });
    }
}