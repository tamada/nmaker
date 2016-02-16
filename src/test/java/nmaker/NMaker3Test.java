package nmaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NMaker3Test{
    @Test
    public void testBasic1(){
        NMaker3 maker = new NMaker3(1, 2, 3);

        String[][] answers = maker.solve();

        assertThat(answers[0].length, is(not(0)));
        assertThat(answers[1].length, is(not(0)));
        assertThat(answers[2].length, is(not(0)));
        assertThat(answers[3].length, is(not(0)));
        assertThat(answers[4].length, is(not(0)));
        assertThat(answers[5].length, is(not(0)));
        assertThat(answers[6].length, is(not(0)));
        assertThat(answers[7].length, is(not(0)));
        assertThat(answers[8].length, is(not(0)));
    }
}
