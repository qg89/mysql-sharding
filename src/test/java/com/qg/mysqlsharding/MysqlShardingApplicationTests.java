package com.qg.mysqlsharding;

import com.qg.mysqlsharding.mapper.DBModelMappr;
import com.qg.mysqlsharding.mapper.DeviceHourReportMapper;
import com.qg.mysqlsharding.model.DBModel;
import com.qg.mysqlsharding.model.DeviceHourReport;
import com.qg.mysqlsharding.model.User;
import com.qg.mysqlsharding.util.LoginThreadCacheUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@SpringBootTest
@RunWith(SpringRunner.class)
class MysqlShardingApplicationTests {

    @Autowired
    private DBModelMappr dbModelMappr;

    @Autowired
    private DeviceHourReportMapper deviceHourReportMapper;

    private CountDownLatch countDownLatch = new CountDownLatch(50);

    @Test
    public void testLoginSearch() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 4; i++) {
            User user = new User();
            user.setSqlSessionBeanName("mall" + i);
            executorService.submit(new SelectRunnable(user, countDownLatch));
        }
        Thread.sleep(10000);
    }

    class SelectRunnable implements Runnable {
        private User user;
        private CountDownLatch countDownLatch;

        SelectRunnable(User user, CountDownLatch countDownLatch) {
            this.user = user;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            LoginThreadCacheUtil.setUser(user);
            countDownLatch.countDown();
            try {
//                countDownLatch.await();
                List<DeviceHourReport> deviceHourReports = deviceHourReportMapper.selectDeviceHourReportByLimit();
                DeviceHourReport report = new DeviceHourReport();
                report.setCount((int) countDownLatch.getCount());
                report.setCreateDate(new Date());
                report.setEndTime(new Date());
                report.setStartTime(new Date());
                report.setValue(countDownLatch.getCount() + 1.1D);
                report.setSubstationId(countDownLatch.getCount());
                report.setMonitorIdx(user.getSqlSessionBeanName() + "_monitorIdx");
                report.setMinValue(1D);
                report.setMaxValue(999D);
                report.setDataName(user.getSqlSessionBeanName());
                deviceHourReportMapper.insert(report);
                System.err.println(deviceHourReports);
            } catch (Exception e) {
                System.err.println(user.getSqlSessionBeanName());
                e.printStackTrace();
            }

        }
    }


    @Test
    public void insertDB() {

        for (int i = 1; i <= 3; i++) {
            DBModel dbModel = new DBModel();
            dbModel.setBeanName("mall" + i);
            dbModel.setDriver("com.mysql.cj.jdbc.Driver");
            dbModel.setUrl("jdbc:mysql://localhost:3306/mall" + i + "?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&useSSL=false&serverTimezone=UTC");
            dbModel.setUsername("root");
            dbModel.setPassword("");
            dbModelMappr.insert(dbModel);
        }

    }
}
