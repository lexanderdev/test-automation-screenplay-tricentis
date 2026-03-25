package co.com.stricentis.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CategoriesMenu extends PageObject {

    public static Target category(String name) {
        return Target.the("categoria " + name).located(By.linkText(name));
    }

    public static final Target PAGE_TITLE = Target.the("titulo de pagina").located(By.cssSelector(".page-title h1"));
}
