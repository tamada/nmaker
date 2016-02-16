package nmaker;

public class Fraction extends Number{
    private int parent;
    private double actual;

    public Fraction(int child, int parent){
        super(child);
        this.parent = parent;
        actual = (double)child / parent;
    }

    public boolean isFraction(){
        return true;
    }

    @Override
    public int hashCode(){
        return (int)(actual * 100000);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getValue()).append("/").append(parent);
        return new String(sb);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Fraction){
            Fraction f = (Fraction)o;

            return Math.abs(actual - f.actual) < 1E-6;
        }
        else if(o instanceof Number){
            return getValue() == (((Number)o).getValue() * parent);
        }
        return false;
    }

    @Override
    public Number add(Number num){
        return create(getValue() + num.getValue() * parent, parent);
    }

    @Override
    public Number subtract(Number num){
        return create(getValue() - num.getValue() * parent, parent);
    }

    @Override
    public Number multiply(Number num){
        return create(getValue() * num.getValue(), parent);
    }

    @Override
    public Number divide(Number num){
        if(num instanceof Fraction){
            Fraction frac = (Fraction)num;
            return create(getValue() * frac.parent, parent * frac.getValue());
        }
        return create(getValue(), parent * num.getValue());
    }
}
