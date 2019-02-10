package net.serenitybdd.tutorials.ui;

import net.serenitybdd.tutorials.model.Category;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CategoryNavigationBar extends PageObject {
    public void selectCategory(Category category) {
        $("//*[@class='hl-cat-nav__container']").find(By.linkText(category.name())).click();
    }
}
