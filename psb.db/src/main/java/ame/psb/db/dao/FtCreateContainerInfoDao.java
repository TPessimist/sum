package ame.psb.db.dao;

import ame.psb.db.FtCreateContainerInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FtCreateContainerInfoDao {

  private static final String SQL_INS = "INSERT INTO zd_ft_create_container_info(sfc,reel_number,unique_id,root_sfc,container_bo,content,update_user,update_time,reserve1,reserve2) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ft_create_container_info SET unique_id=?,root_sfc=?,container_bo=?,content=?,update_user=?,update_time=?,reserve1=?,reserve2=? WHERE sfc=? AND reel_number=?";

  private static final String SQL_SEL = "SELECT sfc,reel_number,unique_id,root_sfc,container_bo,content,update_user,update_time,reserve1,reserve2 FROM zd_ft_create_container_info ";

  private final Connection conn;

  public FtCreateContainerInfoDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtCreateContainerInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getReelNumber());
      ps.setString(3, data.getUniqueId());
      ps.setString(4, data.getRootSfc());
      ps.setString(5, data.getContainerBo());
      ps.setString(6, data.getContent());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getReserve1());
      ps.setString(10, data.getReserve2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FtCreateContainerInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtCreateContainerInfo data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getReelNumber());
        ps.setString(3, data.getUniqueId());
        ps.setString(4, data.getRootSfc());
        ps.setString(5, data.getContainerBo());
        ps.setString(6, data.getContent());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getReserve1());
        ps.setString(10, data.getReserve2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtCreateContainerInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getUniqueId());
      ps.setString(2, data.getRootSfc());
      ps.setString(3, data.getContainerBo());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getUpdateUser());
      DateUtils.setDateTz(ps, 6, data.getUpdateTime());
      ps.setString(7, data.getReserve1());
      ps.setString(8, data.getReserve2());
      ps.setString(9, data.getSfc());
      ps.setString(10, data.getReelNumber());

      return ps.executeUpdate();
    }
  }

  public int update(List<FtCreateContainerInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtCreateContainerInfo data : dataList) {
        ps.setString(1, data.getUniqueId());
        ps.setString(2, data.getRootSfc());
        ps.setString(3, data.getContainerBo());
        ps.setString(4, data.getContent());
        ps.setString(5, data.getUpdateUser());
        DateUtils.setDateTz(ps, 6, data.getUpdateTime());
        ps.setString(7, data.getReserve1());
        ps.setString(8, data.getReserve2());
        ps.setString(9, data.getSfc());
        ps.setString(10, data.getReelNumber());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfc, String reelNumber) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_ft_create_container_info WHERE sfc=? AND reel_number=?")) {
      ps.setString(1, sfc);
      ps.setString(2, reelNumber);

      return ps.executeUpdate();
    }
  }

  public List<FtCreateContainerInfo> selectAll() throws SQLException {
    ArrayList<FtCreateContainerInfo> result = new ArrayList<FtCreateContainerInfo>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FtCreateContainerInfo selectByPK(String sfc, String reelNumber) throws SQLException {
    FtCreateContainerInfo result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc=? AND reel_number=?")) {
      ps.setString(1, sfc);
      ps.setString(2, reelNumber);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FtCreateContainerInfo selectBySfc(String sfc) throws SQLException {
    FtCreateContainerInfo result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc=? ")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FtCreateContainerInfo convert(ResultSet rs) throws SQLException {
    FtCreateContainerInfo data = new FtCreateContainerInfo();

    int index = 1;
    data.setSfc(rs.getString(index++));
    data.setReelNumber(rs.getString(index++));
    data.setUniqueId(rs.getString(index++));
    data.setRootSfc(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReserve1(rs.getString(index++));
    data.setReserve2(rs.getString(index++));

    return data;
  }
}
