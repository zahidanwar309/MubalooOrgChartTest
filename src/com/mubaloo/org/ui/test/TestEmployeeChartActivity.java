/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mubaloo.org.ui.test;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import com.mubaloo.org.activity.EmployeeChartActivity;
import com.mubaloo.org.bean.TeamMember;
import com.mubaloo.org.db.EmployeeDbHelper;
import com.mubaloo.org.db.MubalooDatabase;
import com.mubaloo.org.fragments.EmployeeChartListFragment;
import com.mubaloo.proxy.cache.HTTPProxyRequest;
import java.util.ArrayList;
import static junit.framework.Assert.assertNotNull;

/**
 * <p>
 * Test to get data from server, process and populate Will extend more in future
 * and add more tests for UI
 * </p>
 *
 * @author Zahid Anwar
 */
public class TestEmployeeChartActivity extends ActivityInstrumentationTestCase2<EmployeeChartActivity> {
    /*
     * Android activity
     */

    private EmployeeChartActivity activity;
    /*
     * UI fragment to test process and populate method
    *  We can pass db as a parameter and save few lines of code here (unecessary and duplicate lines of code to populate data)
    *  Will implement it in future
     */
    private EmployeeChartListFragment fragment = new EmployeeChartListFragment();

    public TestEmployeeChartActivity(String pkg, Class<EmployeeChartActivity> activityClass) {
        super(pkg, activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        try {
            this.activity = this.getActivity();

            Intent intent = new Intent(getInstrumentation().getTargetContext(), EmployeeChartActivity.class);
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @UiThreadTest
    public void testPopulate() throws Exception {

        assertNotNull(activity);

        String url = "http://mubaloo.com/dev/developerTestResources/team.json";
        HTTPProxyRequest request = new HTTPProxyRequest(url);

        String httpResponse = request.httpGET().getResponseText();

        assertNotNull(httpResponse);
        assertNotNull(fragment);

        fragment.process(httpResponse);

        assertNotNull(activity);
        Context context = activity.getApplicationContext();
        assertNotNull(context);
        EmployeeDbHelper helper = new EmployeeDbHelper(context);
        MubalooDatabase db = MubalooDatabase.getDatabase(context);
        assertNotNull(helper);

        //clean all the tables
        dirty(db);
        ArrayList<TeamMember> teamLists = new ArrayList<TeamMember>();

        String sql = "Select e.userId, e.firstName, e.lastName, e.profileImageUrl, p.positionName,"
                + " p.teamLead, b.branchName "
                + " from tblEmployee e inner join tblPositions p "
                + " on e.positionId = p.positionId inner join tblBranch b on"
                + " p.branchId = b.branchId";

        System.out.println(sql);

        Cursor c = db.getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()) {
            TeamMember tm = new TeamMember(c);
            teamLists.add(tm);

        }

        c.close();

        assertEquals(24, teamLists.size());

        /*
         *<p>
         * I need to write more tests, which can interact with more UI
         *</p>
         */
    }

    private void dirty(MubalooDatabase db) {
        db.getWritableDatabase().execSQL("delete from tblEmployee where _id>0");

        db.getWritableDatabase().execSQL("delete from tblBranch where branchId>0");

        db.getWritableDatabase().execSQL("delete from tblPositions where positionId>0");

        db.getWritableDatabase().execSQL("delete from tblEmployeeCache where _id>0");
    }
}
