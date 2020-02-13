package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import org.junit.jupiter.api.Test;

@DataMongoTest
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository repository;

    @Test
    public void query() throws Exception {
        // Delete everything
        //Create 4 records
        // Query by name and assert count
        Flux<Reservation> reservationFlux = this.repository.deleteAll()
         .thenMany(
            Flux.just("A", "B", "C", "C")
             .map(name -> new Reservation(null, name)).flatMap(r -> this.repository.save(r))
             .thenMany(this.repository.findByName("C"))
         );

        StepVerifier
         .create(reservationFlux)
         .expectNextCount(2)
         .verifyComplete();
        
    }
}