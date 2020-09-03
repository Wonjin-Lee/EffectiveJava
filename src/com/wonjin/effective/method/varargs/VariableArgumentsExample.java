package src.com.wonjin.effective.method.varargs;

public class VariableArgumentsExample {
    /*
        가변인수 메서드를 호출하면, 가장 먼저 인수의 개수와 길이가 같은 배열을 만들고
        인수들을 이 배열에 저장하여 가변인수 메서드에 건네준다.

        가변인수 메서드는 호출될 때마다 배열을 새로 하나 할당하고 초기화한다.
     */
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }

    /*
        # 잘못 구현한 예 #
        인수를 0개만 넣어 호출하면 런타임에 실패한다는 문제가 있음.
        게다가 인수의 유효성 검사를 명시적으로 해야 한다.
     */
    static int min(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("인수가 1개 이상 필요합니다.");
        int min = args[0];
        for (int i = 1; i < args.length; i++)
            if (args[i] < min)
                min = args[i];

        return min;
    }

    /*
        # 개선한 예 #
        첫 번째로는 평범한 매개변수를 받고, 가변인수는 두 번째로 받아 위의 문제를 해결
     */
    static int min(int firstArg, int... remainArgs) {
        int min = firstArg;
        for (int arg : remainArgs)
            if (arg < min)
                min = arg;
        return min;
    }
}
