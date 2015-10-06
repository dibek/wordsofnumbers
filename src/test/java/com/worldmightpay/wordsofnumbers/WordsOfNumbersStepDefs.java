package com.worldmightpay.wordsofnumbers;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Step definition class for wordsofnumbers feature
 * Created by dibek on 03/10/15.
 */


public class WordsOfNumbersStepDefs {

    List<Long> numbers = new ArrayList<Long>();
    List<String> wordsToTest = new ArrayList<String>();

    @Given("^I have a list of numbers$")
    public void I_have_a_list_of_numbers(List<Long> numberList) throws Throwable {
        numbers.addAll(numberList);
    }

    @And("^I have a list of words$")
    public void I_have_a_list_of_words(List<String> words) throws Throwable {
        wordsToTest.addAll(words);
    }

    @Then("^The transformation of the element in the number list should give the the list in words list$")
    public void The_transformation_of_the_element_in_the_number_list_should_give_the_the_list_in_words_list() throws Throwable {

        NumberTransformer numberTransformer = new NumberTransformerImpl();
       for (Long num:numbers) {
           String wordNumber = numberTransformer.transform(num);
            assertTrue(wordsToTest.contains(wordNumber.trim()));
           System.out.println(num + " tested");
       }
    }

}
