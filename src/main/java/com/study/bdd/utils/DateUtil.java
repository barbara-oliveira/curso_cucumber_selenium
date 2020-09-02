package com.study.bdd.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date obterDataDiferencaDias(int dias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
}
