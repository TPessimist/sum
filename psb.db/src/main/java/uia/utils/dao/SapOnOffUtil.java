package uia.utils.dao;

import ame.me.db.dao.NcCodeDao;
import ame.psb.commons.Env;
import ame.psb.db.Lookup;
import ame.psb.db.conf.DB;
import ame.psb.db.dao.LookupDao;
import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: lihao
 * @DATE: 2020/12/21
 * @description:
 */
public class SapOnOffUtil {

  public static boolean SAP_ON_FLAG = false;
  public static boolean SAP_IN_STOCK_FLAG = false;
  public static Date SAP_SHOP_ORDER_CREATE_TIME;
  public static Map<String, String> ncGrades;

  static {
    try (Connection conn = DB.create()) {

      LookupDao lookupDao = new LookupDao(conn);

      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Lookup lookup = lookupDao.selectByPK("SAP", "SAP");
      Lookup lookup1 = lookupDao.selectByPK("SAP_IN_STOCK", "SAP_IN_STOCK");
      Lookup lookup2 = lookupDao
          .selectByPK("SAP_SHOP_ORDER_CREATE_TIME", "SAP_SHOP_ORDER_CREATE_TIME");

      if (null != lookup && "SAP".equals(lookup.getValue())) {
        SAP_ON_FLAG = true;
      }
      if (null != lookup1 && "SAP_IN_STOCK".equals(lookup1.getValue())) {
        SAP_IN_STOCK_FLAG = true;
      }
      if (null != lookup2) {
        SAP_SHOP_ORDER_CREATE_TIME = simpleDateFormat.parse(lookup2.getValue());
      }

      ncGrades = new NcCodeDao(conn).selectLevelAll(Env.SITE)
          .stream()
          .collect(Collectors.toMap(l -> l.getHandle(), l -> l.getNcLevel()));


    } catch (Exception e) {
      e.printStackTrace();
    } finally {

    }
  }

  public static boolean isSapInstockTime() throws SQLException {
    try (Connection conn = DB.create()) {
      boolean permitFlag = true;
      LookupDao lookupDao = new LookupDao(conn);

      Calendar calendar = Calendar.getInstance();
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      int minute = calendar.get(Calendar.MINUTE);
      String currDate = String.format("%02d:%02d", hour, minute);

      List<Lookup> beginLookups = lookupDao.select("INSTOCK_SHUTDOWN_BEGIN");
      for (Lookup lookup : beginLookups) {
        String beginTime = lookup.getValue();
        String subid = lookup.getSubid();
        Lookup endLookup = lookupDao.selectByPK("INSTOCK_SHUTDOWN_END", subid);
        if (endLookup == null || StringUtils.isNullOrEmpty(endLookup.getValue())) {
          continue;
        }
        String endTime = endLookup.getValue();
        if (currDate.compareTo(beginTime) >= 0 && currDate.compareTo(endTime) <= 0) {
          permitFlag = false;
          break;
        }
      }
      return permitFlag;

    } catch (Exception e) {
      e.printStackTrace();
      throw new SQLException("入库卡控时间获取失败：" + e);
    }


  }

  public static boolean isPermitTime() throws SQLException {
    try (Connection conn = DB.create()) {
      boolean permitFlag = true;
      LookupDao lookupDao = new LookupDao(conn);

      Calendar calendar = Calendar.getInstance();
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      int minute = calendar.get(Calendar.MINUTE);
      String currDate = String.format("%02d:%02d", hour, minute);

      List<Lookup> beginLookups = lookupDao.select("NO_PERMIT_BEGIN");
      for (Lookup lookup : beginLookups) {
        String beginTime = lookup.getValue();
        String subid = lookup.getSubid();
        Lookup endLookup = lookupDao.selectByPK("NO_PERMIT_END", subid);
        if (endLookup == null || StringUtils.isNullOrEmpty(endLookup.getValue())) {
          continue;
        }
        String endTime = endLookup.getValue();
        if (currDate.compareTo(beginTime) >= 0 && currDate.compareTo(endTime) <= 0) {
          permitFlag = false;
          break;
        }
      }
      return permitFlag;

    } catch (Exception e) {
      e.printStackTrace();
      throw new SQLException("入库卡控时间获取失败：" + e);
    }


  }

}
