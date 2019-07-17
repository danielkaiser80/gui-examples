package danielkaiser.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CalcBean {

    String calculate(int number) {

        final var results = new ArrayList<Integer>();

        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                number /= i;

                results.add(i);
            }
        }


        return "Die Teiler sind: " + results.stream().map(Object::toString).collect(Collectors.joining(", ")) + ".";
    }
}
