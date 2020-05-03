package com.example.lib_http;

import androidx.core.util.TimeUtils;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testStringToDate() {

        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse("2020-05-04T20:40:10.000+0000");
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            Date date1 = df1.parse(date.toString());
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df2.format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}