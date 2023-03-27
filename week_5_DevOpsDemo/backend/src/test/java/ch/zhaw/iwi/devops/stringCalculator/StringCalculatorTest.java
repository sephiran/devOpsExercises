package ch.zhaw.iwi.devops.stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    
    @Test
    public void Test_Add_Numbers1And2() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(3, stringCalculator.Add("1,2"));
    }

    @Test
    public void Test_Add_Numbers15And58() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(73, stringCalculator.Add("15,58"));
    }

    @Test
    public void Test_Add_Numbers15And58and113and4() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(190, stringCalculator.Add("15,58,113,4"));
    }

    @Test()
    public void Test_Add_Numbers15And58withNewLineDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(73, stringCalculator.Add("15\n58"));
    }

    @Test()
    public void Test_Add_Numbers15And58withNewLineDelimiterAndComma() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(78, stringCalculator.Add("15\n58,5"));
    }

    @Test()
    public void Test_Add_NegativeNumbersToThrowException() {
        StringCalculator stringCalculator = new StringCalculator();
        Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            stringCalculator.Add("-15\n58");
        });
    
        String expectedMessage = "No negative numbers allowed";
        String actualMessage = exception.getMessage();
    
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test()
    public void Test_Add_IgnoreNumbersGreaterThan1000() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(3, stringCalculator.Add("1010,3"));
    }

    @Test()
    public void Test_Add_IgnoreNumbersGreaterThan1000MultipleInputs() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(20, stringCalculator.Add("1010,3,5,12"));
    }

    @Test()
    public void Test_Add_ReturnSingleInputNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(3, stringCalculator.Add("3"));
    }

    @Test()
    public void Test_Add_ReturnZeroWhenSingleInputNumberIsOver1000() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(0, stringCalculator.Add("1003"));
    }
}
