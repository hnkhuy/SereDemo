package net.serenitybdd.tutorials.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.tutorials.model.Category;

/**
 * Created by huy.huynh on 12/05/2018.
 */
public class NavigationBar {
    public static Target category(Category category) {
        return Target.the(category.name() + " category")
                .locatedBy("//td[contains(@class,'cat')]/a[contains(text(),'{0}')]").of(category.name());
    }
}
