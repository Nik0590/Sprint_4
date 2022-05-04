package com;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.*;

@Story("Create ne of cardHolder")
public class CardHolderNameTest extends FeatureTest{


@Test
@DisplayName("TrueName check")
@Description("Create new name and check it")
    public void cardHolderNameIsCorrect15SymbolsTest(){

    Account account = new Account("Тимофей Орлов");

    assertTrue(account.checkNameToEmboss());

}

    @Test
    @DisplayName("TrueName with latin symbols check")
    @Description("Create new name with latin symbols and check it")
    public void cardHolderNameWithLatinSymbolsTest(){

        Account account = new Account("Timoty Orlov");

        assertTrue(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check min length 3 symbols name")
    @Description("Create new name with min length and check it")
    public void cardHolderNameInclude3SymbolsTest(){

        Account account = new Account("А е");

        assertTrue(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check 4 length name")
    @Description("Create new name with 4 length and check it")
    public void cardHolderNameInclude4SymbolsTest(){

        Account account = new Account("Ан С");

        assertTrue(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check 2 length name")
    @Description("Create new name with 2 length and check it")
    public void cardHolderNameInclude2SymbolsTest(){

        Account account = new Account("А ");

        assertFalse(account.checkNameToEmboss());

    }


    @Test
    @DisplayName("Check max length 19 symbols name")
    @Description("Create new name with max length and check it")
    public void cardHolderNameInclude19SymbolsTest(){

        Account account = new Account("Анатолий Криповский");

        assertTrue(account.checkNameToEmboss());

    }



    @Test
    @DisplayName("Check 20 length name")
    @Description("Create new name with 20 length and check it")
    public void cardHolderNameInclude20SymbolsTest(){

        Account account = new Account("Анатолий Смоляниновй");

        assertFalse(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check 18 length name")
    @Description("Create new name with 18 length and check it")
    public void cardHolderNameInclude18SymbolsTest(){

        Account account = new Account("Анатолий Смолянино");

        assertTrue(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check 25 length name")
    @Description("Create new name with 25 length and check it")
    public void cardHolderNameInclude25SymbolsTes(){

        Account account = new Account("Анатолий Смоляниновййййййй");

        assertFalse(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check name without whitespace")
    @Description("Create new name without whitespace and check it")
    public void cardHolderNameWithoutWhitespaceTest(){

        Account account = new Account("ТимофейОрлов");

        assertFalse(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check name with only one whitespace")
    @Description("Create new name with only one whitespace and check it")
    public void cardHolderNameIncludeOneWhitespaceTest(){

        Account account = new Account(" ");

        assertFalse(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check name with only whitespaces")
    @Description("Create new name with only whitespaces and check it")
    public void cardHolderNameIncludeWhitespacesTest(){

        Account account = new Account("     ");

        assertFalse(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check name with only numbers ")
    @Description("Create new name with only numbers and check it")
    public void cardHolderNameIncludeOnlyNumbersTest(){

        Account account = new Account("123456 123456");

        assertFalse(account.checkNameToEmboss());

    }




    @Test
    @DisplayName("Check with whitespace at the end and start")
    @Description("Create new name with whitespace at the end and start and check it")
    public void cardHolderNameWithWhitespaceAtTheEndAndStartTest(){

        Account account = new Account(" Андрей Пирожков ");

        assertTrue(account.checkNameToEmboss());

    }

   @Test
    @DisplayName("Check with null")
    @Description("Create new name with null and check it")
    public void cardHolderNameWithNullTest() throws NullPointerException {
       try {
           String name = null;
           Account account = new Account(name);
           account.checkNameToEmboss();
           fail("Expected NullPointerException");
       } catch (NullPointerException ex) {
           assertNull(ex.getMessage());
       }
   }

    @Test
    @DisplayName("Check with whitespace at the end")
    @Description("Create new name with whitespace at the end and check it")
    public void cardHolderNameWithWhitespaceAtTheEndTest(){

        Account account = new Account("Андрей Пирожков ");

        assertTrue(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check with whitespace at the start")
    @Description("Create new name with whitespace at the start and check it")
    public void cardHolderNameWithWhitespaceAtTheStartTest(){

        Account account = new Account(" Андрей Пирожков");

        assertTrue(account.checkNameToEmboss());

    }

    @Test
    @DisplayName("Check name is empty")
    @Description("Create new name empty and check it")
    public void cardHolderNameEmptyTest(){

        Account account = new Account("");

        assertFalse(account.checkNameToEmboss());

    }
}
