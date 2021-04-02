package com.prvz.task4;

import com.prvz.task3.QuickSortJava;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class QuickSortJavaTests {

    QuickSortJava qs = new QuickSortJava();

    @ParameterizedTest(name = "Array {0} should be sorted {1}")
    @ValueSource(strings = {
        "3,2,1",
        "5,4,3,2,1",
        "1,0,2,9,3,8,4,7,4,6,5"
    })
    public void shouldSort() {

    }

}
