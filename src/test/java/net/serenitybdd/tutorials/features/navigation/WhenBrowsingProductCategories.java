package net.serenitybdd.tutorials.features.navigation;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.tutorials.steps.NavigatingUser;
import net.serenitybdd.tutorials.tasks.NavigateTo;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.tutorials.model.Category.Motors;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenBrowsingProductCategories {

    @Steps
    NavigatingUser mark;

    @Managed
    WebDriver webDriver;
    //run with firefox
    // run ok with version 46.0.1

    @Test
    public void shouldBeAbleToNavigateToTheMotorsCategory() throws InterruptedException {
        //Given
        mark.isOnHomePage();

        //When
        mark.navigatesToCategory(Motors);

        Thread.sleep(5000);
        //Then
        mark.shouldSeePageTitleContaining("Auto Parts and Vehicles | eBay");
    }

    @Test
    public void shouldBeAbleToNavigateToTheMotorsProducts() throws InterruptedException {
        Actor mike = Actor.named("Mike");
        mike.can(BrowseTheWeb.with(webDriver));

        when(mike).attemptsTo(NavigateTo.theCategory(Motors));

        Thread.sleep(5000);

        then(mike).should(seeThat(TheWebPage.title(), containsString("Auto Parts and Vehicles | eBay")));

    }
}
