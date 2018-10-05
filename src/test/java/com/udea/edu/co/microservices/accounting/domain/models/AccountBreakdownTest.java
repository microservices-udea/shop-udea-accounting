package com.udea.edu.co.microservices.accounting.domain.models;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountBreakdownTest {

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenAccountBreakdownHasInvalidArgumentsTest() {


        assertThrows(IllegalArgumentException.class,
                ()-> {
                    AccountBreakdown accountBreakdown = new AccountBreakdown(null,"123", new BigDecimal(25.65),1);
                });

        assertThrows(IllegalArgumentException.class,
                ()-> {
                    AccountBreakdown accountBreakdown = new AccountBreakdown("","123", new BigDecimal(25.65),1);
                });
    }
}
