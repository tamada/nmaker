package nmaker;

import java.util.ArrayList;
import java.util.List;

public class NMaker3 extends AbstractNMaker{
    private int a, b, c;

    public NMaker3(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String[] solveImpl(Number answer){
        List<String> list = new ArrayList<>();

        NMaker2 nmaker2_1 = new NMaker2(a, b);
        NMaker2 nmaker2_2 = new NMaker2(a, c);
        NMaker2 nmaker2_3 = new NMaker2(b, c);

        check(nmaker2_1, answer.subtract(c), list, "%s+" + c);
        check(nmaker2_1, answer.add(c),      list, "%s-" + c);
        check(nmaker2_1, answer.divide(c),   list, "(%s)*" + c);
        check(nmaker2_1, answer.multiply(c), list, "(%s)/" + c);

        check(nmaker2_2, answer.subtract(b), list, "%s+" + b);
        check(nmaker2_2, answer.add(b),      list, "%s-" + b);
        check(nmaker2_2, answer.divide(b),   list, "(%s)*" + b);
        check(nmaker2_2, answer.multiply(b),  list, "(%s)/" + b);

        check(nmaker2_3, answer.subtract(a), list, "%s+" + a);
        check(nmaker2_3, answer.add(a),      list, "%s-" + a);
        check(nmaker2_3, answer.divide(a),   list, "(%s)*" + a);
        check(nmaker2_3, answer.multiply(a), list, "(%s)/" + a);

        return list.toArray(new String[list.size()]);
    }

    private void check(NMaker2 maker, Number num, List<String> list, String equation){
        String[] target = maker.solve(num);
        if(target.length > 0){
            for(int i = 0; i < target.length; i++){
                list.add(String.format(equation, target[i]));
            }
        }
    }

    public static void main(String[] args){
        if(args.length < 3){
            System.out.println("java NMaker2 <num1> <num2> <num3> [target n]");
        }
        NMaker3 maker = new NMaker3(
            Integer.parseInt(args[0]), Integer.parseInt(args[1]),
            Integer.parseInt(args[2])
        );
        if(args.length == 4){
            int target = Integer.parseInt(args[3]);
            String[] ans = maker.solve(target);
            maker.print(target, ans);
        }
        else{
            maker.solveAndPrint();
        }
    }
}
