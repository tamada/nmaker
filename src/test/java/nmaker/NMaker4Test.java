package nmaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NMaker4Test{
    @Test
    public void testBasic1(){
        NMaker4 maker = new NMaker4(1, 6, 8, 5);

        String[][] answers = maker.solve();

        assertThat(answers[0].length, is(0));
        assertThat(answers[1].length, is(not(0)));
        assertThat(answers[2].length, is(not(0)));
        assertThat(answers[3].length, is(not(0)));
        assertThat(answers[4].length, is(not(0)));
        assertThat(answers[5].length, is(not(0)));
        assertThat(answers[6].length, is(not(0)));
        assertThat(answers[7].length, is(not(0)));
        assertThat(answers[8].length, is(not(0)));
    }

    @Test
    public void testBasic2(){
        NMaker4 maker = new NMaker4(2, 7, 9, 8);

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
