package danielkaiser.spring;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {

    private final TextArea area = new TextArea();

    public MainView(@Autowired CalcBean bean) {
        var text = new Text("Number");
        var input = new Input();
        var button = new Button("Start calculation",
                e -> area.setValue(bean.calculate(Integer.parseInt(input.getValue()))));

        add(text);
        add(input);
        add(button);
        add(area);
    }

}
