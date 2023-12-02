package danielkaiser.spring;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.jetbrains.annotations.NotNull;

@Route
public class MainView extends VerticalLayout {

    private final CalcBean bean;

    private final TextArea area = new TextArea();

    public MainView(CalcBean bean) {
        var text = new Text("Number");
        var input = new Input();
        var button = new Button("Start calculation", e -> area.setValue(handleClick(input)));

        add(text);
        add(input);
        add(button);
        add(area);
        this.bean = bean;
    }

    private String handleClick(@NotNull Input input) {
        String value = "";
        try {
            value = input.getValue();
            final int number = Integer.parseInt(value);
            return bean.calculate(number);
        } catch (NumberFormatException exception) {
            return "The number " + value + " could not be handled.";
        }
    }
}
