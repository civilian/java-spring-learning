package com.example.producer;

import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class ReservationPojoTest {

    @Test
    public void create() throws Exception {
        Reservation re = new Reservation("1", "Jane");
        Assert.assertEquals(re.getName(), "Jane");
        Assert.assertThat(re.getName(), Matchers.equalToIgnoringCase("jane"));
        
        Assert.assertThat(re.getName(), new BaseMatcher <String> (){
            @Override
            public boolean matches(Object item){
                return Character.isUpperCase(((String) item).charAt(0) );
            }

            @Override
            public void describeTo(Description description){
                description.appendText("the name should be valid uppercase!");
            }
        });

        Assertions.assertThat(re.getName()).isEqualToIgnoringCase("jane");
    }
}