package com.dawn.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void check10DigitsValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first value", result);
        result = validator.checkISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void tenDigitsISBNNumberEndingWithXIsValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void check10DigitsInValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void nonDigitCharactersISBNAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("helloworld"); //10 characters
        validator.checkISBN("helloworld123"); //13 characters
    }

    @Test
    public void checkValid13DigitsISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780544903210");
        assertTrue("first value", result);
        result = validator.checkISBN("9781501180989");
        assertTrue("second value", result);
    }

    @Test
    public void check13DigitsInValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780544903211");
        assertFalse(result);
    }

}