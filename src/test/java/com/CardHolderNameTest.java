package com;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@Story("Create new name of cardHolder")
@RunWith(Parameterized.class)

public class CardHolderNameTest extends FeatureTest {

    private final String name;
    private final boolean expected;

    public CardHolderNameTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index} cardHolderName:{0} {1}")
    public static Object[][] getNameData() {
        return new Object[][]{
                {"Тимофей Орлов", true},
                {"Timoty Orlov", true},
                {"Ан С", true},
                {"Анатолий Криповский", true},
                {"Анатолий Смолянино", true},
                {"А е", true},
                {" Андрей Пирожков ", true},
                {" Андрей Пирожков", true},
                {"Андрей Пирожков ", true},
                {"А ", false},
                {"", false},
                {"Анатолий Смоляниновй", false},
                {"Анатолий Смоляниновййййййй", false},
                {"ТимофейОрлов", false},
                {"123456 123456", false},
                {" ", false},
                {"    ", false},
                {null, false}
        };
    }

    @Test
    @DisplayName("Name check")
    @Description("Create new name and check it")
    public void cardHolderNameTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();

        assertEquals(expected, actual);
    }
}
