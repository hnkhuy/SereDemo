package net.serenitybdd.tutorials.steps;

import net.serenitybdd.tutorials.model.Category;
import net.serenitybdd.tutorials.ui.CategoryNavigationBar;
import net.serenitybdd.tutorials.ui.CurrentPage;
import net.serenitybdd.tutorials.ui.EbayHomePage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigatingUser {

    EbayHomePage ebayHomePage;
    CurrentPage currentPage;
    CategoryNavigationBar categoryNavigationBar;

    @Step
    public void isOnHomePage() {
        ebayHomePage.open();
    }

    @Step
    public void navigatesToCategory(Category category) {
        categoryNavigationBar.selectCategory(category);
    }

    @Step
    public void shouldSeePageTitleContaining(String expectedTitle) {
        assertThat(currentPage.getTitle()).containsIgnoringCase(expectedTitle);
//        System.out.println(currentPage.getTitle());
    }
}
