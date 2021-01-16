package com.webadmin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lijichen
 * @date 2021/1/15 - 20:11
 */
@DisplayName("测试Junit5单元测试")
public class TestJunit5 {


    // 参数化测试
    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5,6})
    void testParameterized(int i) {
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("参数化测试")
    @MethodSource(value = "testMethodSource")
    void testParameterized2(String i) {
        System.out.println(i);
    }

    // 需要是静态的方法
    static Stream testMethodSource() {
        return Stream.of("123","qwe","aaaaa");
    }


    @Test
    @DisplayName("测试Assumptions")
    void testAssumptions() {
        Assumptions.assumeTrue(false,"结果部位true, 打印测试报告时会直接跳过!");
    }


    @DisplayName("所有都成功断言")
    @Test
    void testAssertions() {
        assertAll("testAll",
                ()-> assertEquals(1,1,"两个值不想等"),
                ()-> assertArrayEquals(new byte[]{1,2},new byte[]{1,2},"两个数组不相等"));

        System.out.println("========");
    }

    @Test
    @DisplayName("异常断言,一定会出现异常")
    void testAssertions2() {
        assertThrows(ArithmeticException.class,
                ()-> System.out.println(1/0),"1不可能除0成功!");
    }
    @Test
    @DisplayName("超时断言")
    void testAssertions3() {
        if (1==1) {
            fail("直接失败!!!!!");
        }
    }




    @Test
    @DisplayName("测试DisplayName")
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @RepeatedTest(value = 4)
    void testDisplayName() {
        System.out.println("-");
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("方法执行之前..");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("方法执行之后..");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有方法执行之前..");
    }
    @AfterAll
    static void testAfterAll() {
        System.out.println("所有方法执行之后..");
    }

    @Test
    @Disabled
    void test() {

    }
}
