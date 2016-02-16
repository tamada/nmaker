package nmaker;

import java.util.ArrayList;
import java.util.List;

public class NMaker4 extends AbstractNMaker{
    private int a, b, c, d;

    public NMaker4(int a, int b, int c, int d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String[] solveImpl(Number answer){
        List<String> list = new ArrayList<>();

        NMaker3 nmaker3_1 = new NMaker3(a, b, c);
        NMaker3 nmaker3_2 = new NMaker3(a, b, d);
        NMaker3 nmaker3_3 = new NMaker3(a, c, d);
        NMaker3 nmaker3_4 = new NMaker3(b, c, d);

        check(nmaker3_1, answer.subtract(d), list, "%s+" + d);
        check(nmaker3_1, answer.add(d),      list, "%s-" + d);
        check(nmaker3_1, answer.divide(d),   list, "(%s)*" + d);
        check(nmaker3_1, answer.multiply(d), list, "(%s)/" + d);

        check(nmaker3_2, answer.subtract(c), list, "%s+" + c);
        check(nmaker3_2, answer.add(c),      list, "%s-" + c);
        check(nmaker3_2, answer.divide(c),   list, "(%s)*" + c);
        check(nmaker3_2, answer.multiply(c), list, "(%s)/" + c);

        check(nmaker3_3, answer.subtract(b), list, "%s+" + b);
        check(nmaker3_3, answer.add(b),      list, "%s-" + b);
        check(nmaker3_3, answer.divide(b),   list, "(%s)*" + b);
        check(nmaker3_3, answer.multiply(b), list, "(%s)/" + b);

        check(nmaker3_4, answer.subtract(a), list, "%s+" + a);
        check(nmaker3_4, answer.add(a),      list, "%s-" + a);
        check(nmaker3_4, answer.divide(a),   list, "(%s)*" + a);
        check(nmaker3_4, answer.multiply(a), list, "(%s)/" + a);

        return list.toArray(new String[list.size()]);
    }

    private void check(NMaker3 maker, Number num, List<String> list, String equation){
        String[] target = maker.solve(num);
        if(target.length > 0){
            for(int i = 0; i < target.length; i++){
                list.add(String.format(equation, target[i]));
            }
        }
    }

    public static void main(String[] args){
        if(args.length < 4){
            System.out.println("java NMaker2 <num1> <num2> <num3> <num4> [target n]");
        }
        NMaker4 maker = new NMaker4(
            Integer.parseInt(args[0]), Integer.parseInt(args[1]),
            Integer.parseInt(args[2]), Integer.parseInt(args[3])
        );
        if(args.length == 5){
            int target = Integer.parseInt(args[4]);
            String[] ans = maker.solve(target);
            maker.print(target, ans);
        }
        else{
            maker.solveAndPrint();
        }
    }
}
