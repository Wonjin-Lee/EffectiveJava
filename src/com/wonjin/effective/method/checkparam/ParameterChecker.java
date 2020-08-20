package src.com.wonjin.effective.method.checkparam;

import java.util.Objects;

public class ParameterChecker {
    public static void main(String[] args) {
        // java.util.Objects.requireNonNull 메서드를 사용해서 null 검사를 할 수 있다.
        try {
            String firstArgument = Objects.requireNonNull(args[0]);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
