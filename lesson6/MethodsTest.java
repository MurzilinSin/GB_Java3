package lesson6;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

class MethodsTest {
    private Methods testMeth;

    @BeforeAll
    static void start(){
        System.out.println("ПО КОНЯМ");
    }

    @BeforeEach
    void init() {
         testMeth = new Methods();
        System.out.println("Тест начался");
    }

    @AfterEach
    void end() {
        System.out.println("Конец теста");
    }

    @AfterAll
    static void deadened(){
        System.out.println("ВСЕ КОНЧЕНО");
    }

    static Stream<Arguments> dataZero(){
        return Stream.of(
                Arguments.arguments(new int[]{1,7}, new int[]{1,2,4,4,2,3,4,1,7}),
                Arguments.arguments(new int[]{1,2,2,3,1,7}, new int[]{1,2,2,3,1,7}),
                Arguments.arguments(new int[]{2}, new int[]{}),
                Arguments.arguments(new int[]{1}, new int[]{1,2,4,1,7,4,1})
                );
    }
    @ParameterizedTest
    @MethodSource("dataZero")
    void paramTestOutputAfterFour(int[] compareArr,int[] arr){
        Assertions.assertArrayEquals(compareArr ,testMeth.outputAfterFour(arr));
    }

    @Test
    void testOutputAfterFourThrowError(){
        Assertions.assertThrows(RuntimeException.class, ()->
                Assertions.assertArrayEquals(new int[]{1},testMeth.outputAfterFour(new int[]{}))
                );
    }

    static Stream<Arguments> data(){
        return Stream.of(
                Arguments.arguments(new int[]{1,1,1,4,4,1,4,4}),
                Arguments.arguments(new int[]{1,1,1,1,1,1}),
                Arguments.arguments(new int[]{4,4,4,4}),
                Arguments.arguments(new int[]{1,1,1,4,4,3})
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void paramTestOneAndFour(int[] arr){
        Assertions.assertTrue(testMeth.oneAndFour(arr));
    }
}