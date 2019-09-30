package com.sgnbs.energy.core.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class EventCodeCreator {

    private static volatile int en = 1;

    private static volatile Date edate;

    /**
     * 事件编号生成器
     */
    public synchronized static String getEventCode(Integer eventEtype) {
        SimpleDateFormat ssdf = new SimpleDateFormat("yyMMddHHmmss");
        if (null == edate) {
            edate = new Date();
        } else {
            if (DateTools.daysBetween(edate, new Date()) != 0) {
                edate = new Date();
                en = 1;
            } else {
            	edate = new Date();
                ++en;
            }
        }
        String type="";
        switch (eventEtype) {
            case 1:
                type = "A";
                break;
            case 2:
                type = "B";
                break;
            case 3:
                type = "C";
                break;
            case 4:
                type = "D";
                break;
        }
        return type+ ssdf.format(edate) + String.format("%04d", en);
    }


}
