package danielkaiser.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

@Route
@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Project Base")
public class MainView extends VerticalLayout {

    private TextArea area = new TextArea();

    public MainView(@Autowired CalcBean bean) {
        Label label = new Label("Number");
        Input input = new Input();
        Button button = new Button("Start calculation",
                e -> area.setValue(bean.calculate(Integer.valueOf(input.getValue()))));

        add(label);
        add(input);
        add(button);
        add(area);
    }

}
