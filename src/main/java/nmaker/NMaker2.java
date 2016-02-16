package nmaker;

import java.util.ArrayList;
import java.util.List;

public class NMaker2 extends AbstractNMaker{
    protected int a, b;

    public NMaker2(int a, int b){
        this.a = a;
        this.b = b;
    }

    protected String[] solveImpl(Number answer){
        List<String> list = new ArrayList<>();

        check(answer, new Number(a + b),   list, a + "+" + b);
        check(answer, new Number(a - b),   list, a + "-" + b);
        check(answer, new Number(b - a),   list, b + "-" + a);
        check(answer, new Number(a * b),   list, a + "*" + b);
        check(answer, Number.create(a, b), list, a + "/" + b);
        check(answer, Number.create(b, a), list, b + "/" + a);

        return list.toArray(new String[list.size()]);
    }

    private void check(Number ans, Number num, List<String> list, String equation){
        if(ans.is(num)){
            list.add(equation);
        }
    }

    public static void main(String[] args){
        if(args.length < 2){
            System.out.println("java NMaker2 <num1> <num2> [target n]");
        }
        NMaker2 maker = new NMaker2(
            Integer.parseInt(args[0]), Integer.parseInt(args[1])
        );
        if(args.length == 3){
            int target = Integer.parseInt(args[2]);
            String[] ans = maker.solve(target);
            maker.print(target, ans);
        }
        else{
            maker.solveAndPrint();
        }
    }
}
