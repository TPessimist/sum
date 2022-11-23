package ame.psb.db.dao;

import ame.me.db.DcParameter;
import ame.me.db.dao.DcParameterDao;
import ame.psb.commons.Env;
import ame.psb.db.Dcop;
import ame.psb.db.DcopParameter;
import ame.psb.db.ItemGroup;
import ame.psb.db.TestXufeng;
import ame.psb.db.ViewDcop;
import ame.psb.db.ViewDcopParameter;
import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import ame.psb.db.conf.Oracle;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import uia.utils.dao.AssertUtil;

public class DcopDaoTest {

  @Test
  public void test1() throws SQLException {
    try (Connection conn = Oracle.create()) {
      DcopDao dao = new DcopDao(conn);
      dao.selectAll().forEach(System.out::println);
    }
  }

  @Test
  public void test2() throws SQLException {
    try (Connection conn = Hana.createDev()) {
      DcopDao dao = new DcopDao(conn);
      dao.select("OperationBO:1020,EETC1-NCG2,#", "ItemGroupBO:1020,A101M",
          "DcGroupBO:1020,TTHICKNESS,A", "EDIT")
          .forEach(System.out::println);
    }
  }

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      DcopDao dao = new DcopDao(conn);
      Dcop data = dao.selectByPK("BFB-INSP1-BCDOPENING-X57013B");
      data.setId("0000000000000000");
      dao.insert(data);
      data.setDcCount(123434);
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }


  @Test
  public void testBuildDCOPByDeviceNameAndOperationNameAndDcGroupName() {

    try {
      Env.initialProd();
      Connection conn = DB.create();
      try {
        conn.setAutoCommit(false);
        TestXufengDao testXufengDao = new TestXufengDao(conn);
        Set<String> testXufengs = testXufengDao.selectAll().stream().map(TestXufeng::getId).collect(Collectors.toSet());
        for (String testXufeng : testXufengs) {
          testBuildDCOPByDeviceNameAndOperationNameAndDcGroupName(conn, testXufeng);
        }
        conn.commit();
      } catch (Exception e) {
        conn.rollback();
        e.printStackTrace();
      }


    } catch (Exception e) {
      e.printStackTrace();
    }


  }


  public void testBuildDCOPByDeviceNameAndOperationNameAndDcGroupName(Connection conn,
      String deviceName
  ) throws Exception {
    try {
      String operationName = "WSAW-LWH";
      String dcGroupName = "WLPSAWLWHOFFSET-NEW";
      String originDcGroupName = "WLPSAWLWHOFFSET";
      int dieCount = 9;

      DcopDao dcopDao = new DcopDao(conn);
      DcParameterDao dcParameterDao = new DcParameterDao(conn);
      DcopParameterDao dcopParameterDao = new DcopParameterDao(conn);
      ItemGroupDao itemGroupDao = new ItemGroupDao(conn);

      ItemGroup itemGroup = itemGroupDao.selectByPK(Env.genItemGroupBO(deviceName));
      if(null == itemGroup)
        return;

      Dcop dcop = new Dcop();
      dcop.setItemGroupBo(Env.genItemGroupBO(deviceName));
      dcop.setId(operationName + "-" + deviceName + "-" + dcGroupName);
      dcop.setOperationBo(Env.genOperationBo(operationName));
      dcop.setDcGroupBo("DcGroupBO:1020," + dcGroupName + ",A");
      dcop.setWaferSelector("A");
      dcop.setDcCount(dieCount);
      dcop.setDcCount(1);
      dcop.setUpdatedUser("ADMINISTRATOR_1213");
      dcop.setUpdatedTime(new Date());
      dcop.setStateName("ENABLE");

      Optional<ViewDcop> any = dcopDao
          .select(Env.genOperationBo(operationName), Env.genItemGroupBO(deviceName)).stream()
          .filter(a -> "ENABLE".equals(a.getStateName())).findAny();

      if(!any.isPresent())
        throw new Exception(String.format("origin: device : %s dcop not found", deviceName));

      ViewDcop viewDcop = any.get();
      dcop.setDieCount(viewDcop.getDieCount());

      List<DcParameter> dcParameters = dcParameterDao
          .selectByGroup("DcGroupBO:1020," + dcGroupName + ",A");

      for (DcParameter dcParameter : dcParameters) {
        ViewDcopParameter viewDcopParameter = dcopParameterDao.selectByDcopAnddcparameterBo(
            viewDcop.getId().replace(dcGroupName, originDcGroupName),
            dcParameter.getHandle().substring(0, dcParameter.getHandle().length() - 1)
                .replace(dcGroupName, originDcGroupName)
        );
        AssertUtil.notNull(viewDcopParameter, String
            .format("origin: device : %s, param : %s not found", deviceName,
                dcParameter.getParameterName()));
        BigDecimal usl = viewDcopParameter.getAlarmUcl();
        BigDecimal lsl = viewDcopParameter.getAlarmLcl();
        BigDecimal target = viewDcopParameter.getTargetValue();

        DcopParameter dcopParameter = new DcopParameter();
        dcopParameter.setDcopBo(dcop.getId());
        dcopParameter.setDcParameterBo(dcParameter.getHandle());
        dcopParameter.setAlarmUcl(usl);
        dcopParameter.setAlarmLcl(lsl);
        dcopParameter.setVerify("Y");
        dcopParameter.setTargetValue(target);
        dcopParameterDao.insert(dcopParameter);
      }
      dcopDao.insert(dcop);


      viewDcop.setStateName("DISABLE");
      dcopDao.update(viewDcop);

    } catch (Exception e) {
      System.out.println(deviceName);
      e.printStackTrace();
      throw e;
    }
  }


}