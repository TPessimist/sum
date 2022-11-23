package ame.me.db.dao;

import ame.me.db.DcParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DcParameterDao {

  private static String SQL_SEL = "select HANDLE,DC_GROUP_BO,PARAMETER_NAME,DATA_TYPE,PROMPT,SEQUENCE,DESCRIPTION from DC_PARAMETER ";

  private Connection conn;

  public DcParameterDao(Connection conn) {
    this.conn = conn;
  }

  public List<DcParameter> selectByGroup(String dcGroupBo) throws SQLException {
    ArrayList<DcParameter> dps = new ArrayList<DcParameter>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where DC_GROUP_BO=? order by SEQUENCE");
    ps.setString(1, dcGroupBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      dps.add(convert(rs));
    }
    rs.close();
    ps.close();

    return dps;

  }

  public DcParameter selectByGroupAndparameterName(String dcGroupBo, String parameterName)
      throws SQLException {
    DcParameter resule = null;

    PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " where DC_GROUP_BO=? and PARAMETER_NAME = ? order by SEQUENCE");
    ps.setString(1, dcGroupBo);
    ps.setString(2, parameterName);

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      resule = convert(rs);
    }
    rs.close();
    ps.close();
    return resule;

  }

  private DcParameter convert(ResultSet rs) throws SQLException {
    DcParameter dp = new DcParameter();
    dp.setHandle(rs.getString(1));
    dp.setDcGroupBo(rs.getString(2));
    dp.setParameterName(rs.getString(3));
    dp.setDataType(rs.getString(4));
    dp.setPrompt(rs.getString(5));
    dp.setSequence(rs.getInt(6));
    dp.setParameterDescription(rs.getString(7));
    return dp;
  }
}
