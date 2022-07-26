package com.pepsiwyl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assumptions.*;

/**
 * @author by pepsi-wyl
 * @date 2022-03-15 16:47
 */

@DisplayName("前置条件")
public class AssumptionsTest {

    private final String environment = "DEV";

    @DisplayName("simple")
    @Test
    public void simpleAssume() {
        assumeTrue(Objects.equals(this.environment, "DEV"));
        assumeFalse(() -> Objects.equals(this.environment, "PROD"));
    }

    @DisplayName("assume then do")
    @Test
    public void assumeThenDo() {
        assumingThat(
                Objects.equals(this.environment, "DEV"),
                () -> System.out.println("In DEV")
        );
    }
}
