package ame.me.db.dao;

import ame.me.db.SfcBomComponent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SfcBomComponentDao {

  private static final String SQL_SEL = "SELECT sfc_bo,bom_bo,operation_bo,item_bo,item_name FROM view_sfc_bom_component ";

  private final Connection conn;

  public SfcBomComponentDao(Connection conn) {
    this.conn = conn;
  }

  public List<SfcBomComponent> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<SfcBomComponent> result = new ArrayList<SfcBomComponent>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY operation_bo,item_bo")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private SfcBomComponent convert(ResultSet rs) throws SQLException {
    SfcBomComponent data = new SfcBomComponent();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setBomBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));

    return data;
  }
}
