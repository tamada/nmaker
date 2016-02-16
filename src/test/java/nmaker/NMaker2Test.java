package nmaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NMaker2Test{
    @Test
    public void testBasic1(){
        NMaker2 maker = new NMaker2(2, 1);

        String[][] answers = maker.solve();

        assertThat(answers[0].length, is(1));
        assertThat(answers[1].length, is(2));
        assertThat(answers[2].length, is(1));
        assertThat(answers[3].length, is(0));
        assertThat(answers[4].length, is(0));
        assertThat(answers[5].length, is(0));
        assertThat(answers[6].length, is(0));
        assertThat(answers[7].length, is(0));
        assertThat(answers[8].length, is(0));
    }

    @Test
    public void testBasic2(){
        NMaker2 maker = new NMaker2(4, 8);

        String[][] answers = maker.solve();

        assertThat(answers[0].length, is(0));
        assertThat(answers[1].length, is(1));
        assertThat(answers[2].length, is(0));
        assertThat(answers[3].length, is(1));
        assertThat(answers[4].length, is(0));
        assertThat(answers[5].length, is(0));
        assertThat(answers[6].length, is(0));
        assertThat(answers[7].length, is(0));
        assertThat(answers[8].length, is(0));
    }
}
