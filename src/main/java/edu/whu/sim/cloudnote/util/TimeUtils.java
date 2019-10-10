package edu.whu.sim.cloudnote.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }
}
