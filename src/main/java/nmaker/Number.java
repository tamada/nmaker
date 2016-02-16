package nmaker;

public class Number{
    private int value;

    protected Number(int value){
        this.value = value;
    }

    public boolean is(Number number){
        return this.equals(number);
    }

    @Override
    public int hashCode(){
        return getValue();
    }

    @Override
    public String toString(){
        return Integer.toString(getValue());
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Fraction){
            return ((Fraction)o).equals(this);
        }
        else if(o instanceof Number){
            return getValue() == ((Number)o).getValue();
        }
        return false;
    }

    public int getValue(){
        return value;
    }

    public static Number create(int num1, int num2){
        if(num2 == 0){
            throw new ArithmeticException("divide 0");
        }
        if(num1 % num2 == 0){
            return new Number(num1 / num2);
        }
        return new Fraction(num1, num2);
    }

    public boolean isFraction(){
        return false;
    }


    public Number add(int number){
        return add(new Number(number));
    }

    public Number subtract(int number){
        return subtract(new Number(number));
    }

    public Number multiply(int number){
        return multiply(new Number(number));
    }

    public Number divide(int number){
        return divide(new Number(number));
    }

    public Number add(Number number){
        return new Number(getValue() + number.getValue());
    }

    public Number subtract(Number number){
        return new Number(getValue() - number.getValue());
    }

    public Number multiply(Number number){
        return new Number(getValue() * number.getValue());
    }

    public Number divide(Number number){
        return create(getValue(), number.getValue());
    }
}
