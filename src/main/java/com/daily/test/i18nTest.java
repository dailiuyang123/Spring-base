package com.daily.test;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by 11851 on 2017/10/9.
 */
public class i18nTest {

    public static void main(String[] args) {
        int price=18;

        NumberFormat df=NumberFormat.getInstance(Locale.CHINA);   //中国

        String format = df.format(price);
        System.out.println(format);

    }
}
