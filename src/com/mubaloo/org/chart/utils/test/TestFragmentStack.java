/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mubaloo.org.chart.utils.test;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;
import com.mubaloo.org.test.activity.MubalooTestActivity;
import com.mubaloo.org.utils.FragmentStack;
import org.junit.Test;

/**
 * <p>
 * Functional test, Stack object to save all fragments push and pop method can
 * be used to add new fragment or remove last fragment from ArrayList
 * </p>
 *
 * @author Zahid Anwar
 */
public class TestFragmentStack extends ActivityInstrumentationTestCase2<MubalooTestActivity> {
    /*
     * Android activity
     */

    private Activity activity;

    public TestFragmentStack() {
        super("com.mubaloo.org.test.activity", MubalooTestActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp(); //To change body of generated methods, choose Tools | Templates.

        activity = this.getActivity();

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown(); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
     * test push and pop methods
     */

    @Test
    public void testPushAndPop() {
        FragmentStack stack = new FragmentStack();

        assertNotNull(stack);

        stack.clear();
        int numberOfFragment = 10;
        for (int i = 0; i < numberOfFragment; i++) {
            Fragment f = new Fragment();
            stack.push(f);
        }

        assertEquals(numberOfFragment, stack.size());
        stack.pop();
        assertEquals(numberOfFragment - 1, stack.size());
        stack.clear();
    }
}
