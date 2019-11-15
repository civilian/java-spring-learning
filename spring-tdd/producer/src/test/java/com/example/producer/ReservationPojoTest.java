package com.example.producer;

import org.junit.Test;
import org.junit.Assert;

public class ReservationPojoTest {
    @Test
    public void create() throws Exception {
        Reservation re = new Reservation("1", "Jane");
        Assert.assertEquals(re.getName(), "Jane");
    }
}