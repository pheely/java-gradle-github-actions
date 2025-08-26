// src/test/java/com/example/greeting/GreetingServiceTest.java
package com.example.greeting;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTest {

    private final GreetingService service = new GreetingService();

    @Test
    void greetsWithProvidedName() {
        assertThat(service.greet("Philip")).isEqualTo("Hello, Philip!");
    }

    @Test
    void trimsAndCapitalizes() {
        assertThat(service.greet("  rio  ")).isEqualTo("Hello, Rio!");
    }

    @Test
    void defaultsToWorldWhenBlank() {
        assertThat(service.greet("   ")).isEqualTo("Hello, World!");
        assertThat(service.greet(null)).isEqualTo("Hello, World!");
    }
}
