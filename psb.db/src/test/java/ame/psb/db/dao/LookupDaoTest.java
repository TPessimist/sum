package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.commons.HtksSfcName;
import ame.psb.commons.HtksTrayName;
import ame.psb.db.CustomerItem;
import ame.psb.db.Lookup;
import ame.psb.db.RunOa;
import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import java.awt.image.LookupOp;
import java.util.List;
import java.util.Objects;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class LookupDaoTest {

    @Test
    public void testInsert() throws SQLException {
        try (Connection conn = DB.create()) {
            LookupDao dao = new LookupDao(conn);
            dao.insert("1", "2", "3", "4");
            System.out.println(dao.selectByPK("1", "2"));
        }
    }


    @Test
    public void testInsert1() {

        try {
            Env.initialTest();
            Connection conn = DB.create();
            LookupExDao  dao = new LookupExDao(conn);
            CustomerItemDao customerItemDao = new CustomerItemDao(conn);

            String shopOrderName = "ShopOrderBO:1020,TEST-0124105624";
            List<CustomerItem> customerItems = customerItemDao.selectByShopOrderBo(shopOrderName);
            List<String> subids = new ArrayList<>();
            subids.add("WO_S");
            subids.add("WAFER_CUST_PART_NUM1");

            Objects.requireNonNull(subids, "cc");

            for (CustomerItem customerItem : customerItems) {
                for (String subid : subids) {
                    Lookup lookup = new Lookup();
                    lookup.setId(customerItem.getShopOrderBo() + "," + customerItem.getId());
                    lookup.setSubid(subid);
                    lookup.setValue("test");
                    lookup.setGroupName(customerItem.getId());
                    try {
                        dao.insert(lookup);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSelectAndUpdate() throws SQLException {
        try (Connection conn = DB.create()) {
            System.out.println(LookupDao.nextValue(conn, "a", "b", HtksSfcName::nextValue));
            System.out.println(LookupDao.nextValue(conn, "a", "c", HtksTrayName::nextValue));
        }
    }

    @Test
    public void testInsertBatch() throws SQLException {
        ArrayList<Lookup> data = new ArrayList<Lookup>();
        for (int i = 0; i < 1000000; i++) {
            Lookup lk = new Lookup();
            lk.setId("ABCdefg111");
            lk.setSubid("ABCdefg111-" + i);
            lk.setValue("" + i);
            data.add(lk);
        }
        try (Connection conn = DB.create()) {
            conn.setAutoCommit(false);
            LookupExDao dao = new LookupExDao(conn);
            System.out.println(dao.insert(data));
            conn.rollback();
        }
    }

    @Test
    public void testInsertSpecial() throws SQLException {
        ArrayList<Lookup> data = new ArrayList<Lookup>();
        try (Connection conn = Hana.createProd()) {
            Lookup lk = new Lookup();
            lk.setId("00000000000000000000001");
            lk.setSubid("00000000000000000000001");
            lk.setValue("RCLAMP®");
            data.add(lk);

            LookupExDao dao = new LookupExDao(conn);
            dao.insert(data);

            System.out
                    .println(dao.selectByPK("00000000000000000000001", "00000000000000000000001").getValue());
        }
    }

    @Test
    public void testSpecial() throws SQLException {
        ArrayList<Lookup> data = new ArrayList<Lookup>();
        try (Connection conn = Hana.createProd()) {
            LookupExDao dao = new LookupExDao(conn);
            System.out
                    .println(dao.selectByPK("ShopOrderBO:1020,ATZ-18050063", "37_CUST_DEVICE1").getValue());
        }
    }

    @Test
    public void testjay() throws Exception {
        Env.initialTest();
        try (Connection conn = DB.create()) {
            RunOaDao runOaDao = new RunOaDao(conn);
            RunOa runOa = runOaDao.selectByPK("1938078");
            runOa.setStateName("DOWN"); //RUNNING
            runOaDao.updateState(runOa);

            System.out.println(runOa);

            System.out.println("状态结果：" + runOa.getStateName());
        } catch (Exception e) {

        }
    }

}
