package danielkaiser.spring;

import org.springframework.stereotype.Service;

@Service
public class CalcBean {

    String calculate(int number) {

        String result = "Die Teiler sind: ";
        boolean vorher = false;
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                number /= i;
                if (vorher)
                    result += ", ";
                vorher = true;
                result += String.valueOf(i);
            }
        }
        result += ".";

        return result;
    }
}
