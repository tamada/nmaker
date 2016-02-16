package nmaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NumberTest{

    @Test
    public void testBasic1(){
        Number num1 = new Number(4);
        Number num2 = new Number(2);

        assertThat(num1.add(num2),      is(new Number(6)));
        assertThat(num1.subtract(num2), is(new Number(2)));
        assertThat(num1.multiply(num2), is(new Number(8)));
        assertThat(num1.divide(num2),   is(new Number(2)));
    }

    @Test
    public void testBasic2(){
        Number num1 = new Number(2);
        Number num2 = new Number(3);

        assertThat(num1.add(num2), is(new Number(5)));
        assertThat(num1.subtract(num2), is(new Number(-1)));
        assertThat(num1.multiply(num2), is(new Number(6)));
        assertThat(num1.divide(num2), is(new Fraction(2, 3)));
    }
}
