package co.com.stricentis.tasks;

import co.com.stricentis.userinterface.CategoriesMenu;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectSubCategory implements Task {

    private final String category;
    private final String subCategory;

    public SelectSubCategory(String category, String subCategory) {
        this.category = category;
        this.subCategory = subCategory;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CategoriesMenu.category(category)),
                Click.on(CategoriesMenu.category(subCategory))
        );
    }

    public static SelectSubCategory withName(String category, String subCategory) {
        return Tasks.instrumented(SelectSubCategory.class, category, subCategory);
    }
}
