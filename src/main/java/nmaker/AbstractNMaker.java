package nmaker;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractNMaker{
    private Map<Integer, String[]> cache = new HashMap<>();
    
    public String[] solve(int target){
        return solve(new Number(target));
    }

    public String[] solve(Number number){
        if(number.isFraction()){
            return solveImpl(number);
        }
        else if(cache.get(number.getValue()) == null){
            String[] answer = solveImpl(number);
            cache.put(number.getValue(), answer);
        }
        return cache.get(number.getValue());
        
    }

    protected abstract String[] solveImpl(Number target);

    public void solveAndPrint(){
        String[][] answers = solve();

        for(int i = 0; i < answers.length; i++){
            print(i + 1, answers[i]);
        }
    }

    public void print(int value, String[] answer){
        System.out.print(value);
        for(int i = 0; i < answer.length; i++){
            System.out.print(",");
            System.out.print(answer[i]);
        }
        System.out.println();
    }

    public String[][] solve(){
        String[][] answers = new String[9][];

        for(int i = 1; i <= 9; i++){
            answers[i - 1] = solve(i);
        }
        return answers;
    }
}
