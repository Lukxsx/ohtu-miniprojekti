/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

import recommendation_library.dao.InMemoryRecommendationDao;
import recommendation_library.dao.RecommendationDao;
import recommendation_library.UserInterface;
import recommendation_library.io.StubIO;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author jenni.makinen
 */
public class Stepdefs {
    
    List<String> inputLines;
    StubIO io;
    UserInterface ui;
    RecommendationDao dao;
    
    @Before
    public void setup(){
        this.inputLines = new ArrayList<String>();
    }

    @Given("^command add is selected")
    public void commandAddSelected() {
        inputLines.add("1");
    }
    
    @Given("^command list is selected")
    public void commandEditSelected() {
        inputLines.add("2");
    }
    
    @When("^command exit is entered")
    public void commandExitSelected() {
        inputLines.add("3");
        io = new StubIO(inputLines);
        dao = new InMemoryRecommendationDao();
        ui = new UserInterface(io, dao);
        ui.run();
    }
    
    @When("title {string} is entered")
    public void titleIsAdded(String title) {
        inputLines.add(title);
    }
    
    @When("author {string} is entered")
    public void authorIsAdded(String author) {
        inputLines.add(author);
    }
    
    @When("description {string} is entered")
    public void descriptionIsAdded(String description) {
        inputLines.add(description);
    }

    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        io.getPrints().contains(expectedOutput);
    }
    
}
