/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mubaloo.org.chart.sqlite.db.test;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.test.ActivityInstrumentationTestCase2;
import com.mubaloo.org.db.EmployeeDbHelper;
import com.mubaloo.org.db.MubalooDatabase;
import com.mubaloo.org.test.activity.MubalooTestActivity;
import org.junit.Test;

/**
 * <p>
 * Test to insert/delete record 
 * </p>
 * @author Zahid
 */
public class TestEmployeeDbHelper extends ActivityInstrumentationTestCase2<MubalooTestActivity> {
    /*
    * Android activity
    */
    
    private Activity activity;

    public TestEmployeeDbHelper() {
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

    /**
     * <p>
     * Functional test
     * Test of previously cached method.
     * </p>
     */
    @Test
    public void testPreviouslyCached() throws Exception {
        assertNotNull(activity);
        Context context = activity.getApplicationContext();
        assertNotNull(context);
        EmployeeDbHelper helper = new EmployeeDbHelper(context);
        MubalooDatabase db = MubalooDatabase.getDatabase(context);
        assertNotNull(helper);

        //clean all the tables
        dirty(db);

        final int numberOfRecords = 10;
        for (int i = 0; i < numberOfRecords; i++) {
            ContentValues values = new ContentValues();
            values.put("userId", i);
            values.put("firstName", "first name test" + i);
            values.put("lastName", "last name test" + i);
            values.put("profileImageUrl", "test url");
            values.put("positionId", i);
            assertEquals(true, db.getWritableDatabase().insert("tblEmployee", null, values) > 0);
        }
        db.getWritableDatabase().execSQL("DELETE FROM tblEmployeeCache WHERE _id > 0");
        db.getWritableDatabase().execSQL("INSERT OR REPLACE INTO tblEmployeeCache (numberOfEmployees) VALUES(" + numberOfRecords + ")");

        //will always get data from cache
        assertEquals(true, helper.previouslyCached());

        db.getWritableDatabase().execSQL("delete from tblEmployee where _id>0");
        db.getWritableDatabase().execSQL("delete from tblEmployeeCache where _id>0");

    }

    /**
     * <p>
     * Test to insert records.
     * </p>
     */
    @Test
    public void testInsert() throws Exception {
        assertNotNull(activity);
        Context context = activity.getApplicationContext();
        assertNotNull(context);
        EmployeeDbHelper helper = new EmployeeDbHelper(context);
        MubalooDatabase db = MubalooDatabase.getDatabase(context);
        assertNotNull(helper);

        //clean all the tables
        dirty(db);

        final int numberOfRecords = 10;
        int result = 0;
        //Employee
        for (int i = 0; i < numberOfRecords; i++) {
            ContentValues values = new ContentValues();
            values.put("userId", i);
            values.put("firstName", "first name test" + i);
            values.put("lastName", "last name test" + i);
            values.put("profileImageUrl", "test url");
            values.put("positionId", i);
            assertEquals(true, db.getWritableDatabase().insert("tblEmployee", null, values) > 0);
        }

        Cursor c = db.getReadableDatabase().rawQuery("select count(*) as total from tblEmployee", null);

        assertNotNull(c);
        if (c.moveToNext()) {
            result = c.getInt(c.getColumnIndex("total"));
        }
        c.close();
        assertEquals(true, result > 0);

        assertEquals(numberOfRecords, result);

        //Branch
        for (int i = 0; i < numberOfRecords; i++) {
            ContentValues values = new ContentValues();
            values.put("branchName", "test" + i);
            assertEquals(true, db.getWritableDatabase().insert("tblBranch", null, values) > 0);
        }

        Cursor c1 = db.getReadableDatabase().rawQuery("select count(*) as total from tblBranch", null);

        assertNotNull(c1);
        if (c1.moveToNext()) {
            result = c1.getInt(c.getColumnIndex("total"));
        }
        c1.close();
        assertEquals(true, result > 0);

        assertEquals(numberOfRecords, result);

        //Position
        for (int i = 0; i < numberOfRecords; i++) {
            ContentValues values = new ContentValues();
            values.put("positionName", "test position" + i);
            values.put("teamLead", 0);
            values.put("branchId", i);
            assertEquals(true, db.getWritableDatabase().insert("tblPositions", null, values) > 0);
        }

        Cursor c2 = db.getReadableDatabase().rawQuery("select count(*) as total from tblPositions", null);

        assertNotNull(c2);
        if (c2.moveToNext()) {
            result = c2.getInt(c.getColumnIndex("total"));
        }
        c2.close();
        assertEquals(true, result > 0);

        assertEquals(numberOfRecords, result);
        dirty(db);
    }

    private void dirty(MubalooDatabase db) {
        db.getWritableDatabase().execSQL("delete from tblEmployee where _id>0");

        db.getWritableDatabase().execSQL("delete from tblBranch where branchId>0");

        db.getWritableDatabase().execSQL("delete from tblPositions where positionId>0");

        db.getWritableDatabase().execSQL("delete from tblEmployeeCache where _id>0");
    }

}
