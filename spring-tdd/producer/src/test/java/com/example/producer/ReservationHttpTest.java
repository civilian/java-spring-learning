package com.example.producer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@RunWith(SpringRunner.class)
public class ReservationHttpTest {
    
    @Autowired
    private WebTestClient client; 

    @Test
    public void getAllReservations() throws Exception {
        this.client
        .get()
        .uri("/reservations")
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
        .expectBody()
            .jsonPath("@.[0].name").isEqualTo("Jane")
            .jsonPath("@.[1].name").isEqualTo("Joe");
        

    }

}