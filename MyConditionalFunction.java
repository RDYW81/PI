import java.util.function.IntPredicate;
/**
 * Write a description of interface MyFunctionDefaultM here.
 *
 * @author Roland Daidone, Michael Linn
 * @version 1.0
 */
public interface MyConditionalFunction extends MyFunction
{
    default public MyConditionalFunction conditionateInput(IntPredicate ip) {
        return (int i) -> {
            if (ip.test(i)) {
                return apply(i);
            } else {
                return 0;
            }
        };
    }

    default public MyConditionalFunction conditionateOutput(IntPredicate ip) {
        return (int i) -> {
            if (ip.test(apply(i))) {
                return apply(i);
            } else {
                return 0;
            }
        };
    }
}

