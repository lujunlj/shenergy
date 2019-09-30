//package com.sgnbs.energy.core.common.utils;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.logging.Logger;
//
//import static java.util.logging.Level.WARNING;
//
///**
// * Created with IDEA
// * author: lujun
// * Date:2019/9/24
// * Time:9:38
// */
//public class ThreadCountSqlUtils {
//    static Logger logger = Logger.getLogger("ThreadCountSqlUtils");// 一般为当前的类名
//    public static <T extends Model> List<T> countSqlsByList(List<Object> sqls, Class<T> c) throws IllegalAccessException, InstantiationException {
//        // sql集合长度
//        int length = sqls.size();
//        // 初始化合并集合，并指定大小，防止数组越界
//        final List<T> list = new ArrayList<T>(length);
//        // 初始化线程池
//        ExecutorService pool = Executors.newFixedThreadPool(length);
//        // 初始化计数器
//        final CountDownLatch latch = new CountDownLatch(length);
//        // 查询每天的时间并合并
//        for (final Object sql : sqls) {
//            Map<String, Object> param = new HashMap<>();
//            final T t = c.newInstance();
//            final String sqlStr = sql.toString();
//            // param 组装查询条件
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        // 查询sql
//                      T tt =  (T)t.findFirst(sqlStr.toString());
//                        // 将结果汇总
//                      list.add(tt);
//                    } catch (Exception e) {
//                        logger.log(WARNING, "获取异常");
//                    } finally {
//                        //线程结束-1
//                        latch.countDown();
//                    }
//                }
//            });
//        }
//        try {
//            // 等待所有查询结束
//            //暂停当前线程,死循环 判断线程数是否结束
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // list为汇总集合
//        // 如果有必要，可以组装下你想要的业务数据，计算什么的，如果没有就没了
//        return list;
//    }
//
//    public static <T extends Model> Map<String,T> countSqlsByMap(Map<String, Object> map, Class<T> c) throws IllegalAccessException, InstantiationException {
//        // sql集合长度
//        int length = map.size();
//        // 初始化合并集合，并指定大小，防止数组越界
//        final Map<String,T> resMap = new HashMap<>();
//        // 初始化线程池
//        ExecutorService pool = Executors.newFixedThreadPool(length);
//        // 初始化计数器
//        final CountDownLatch latch = new CountDownLatch(length);
//        // 查询每天的时间并合并
//        for (String key : map.keySet()) {
//            Map<String, Object> param = new HashMap<>();
//            final T t = c.newInstance();
//            final String keyStr = key;
//            final Object sql = map.get(key);
//            // param 组装查询条件
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        // 查询sql
//                        T tt =  (T)t.findFirst(sql.toString());
//                        // 将结果汇总
//                        resMap.put(keyStr,tt);
//                    } catch (Exception e) {
//                        logger.log(WARNING, "获取异常");
//                    } finally {
//                        //线程结束-1
//                        latch.countDown();
//                    }
//                }
//            });
//        }
//        try {
//            // 等待所有查询结束
//            //暂停当前线程,死循环 判断线程数是否结束
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // list为汇总集合
//        // 如果有必要，可以组装下你想要的业务数据，计算什么的，如果没有就没了
//        return resMap;
//    }
//
//}
