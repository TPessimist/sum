package ame.me.db.dao;

import ame.me.db.RouterOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouterOperationDao {

  private static final String SQL_SEL = "SELECT router_operation_bo,router_bo,router,router_step_bo,operation_parent,operation_bo,operation,step_id,rework,queue_decision_type,sequence,router_type,revision,operation_type,cycle_time_type,recipe_type FROM view_router_operation ";

  private static final String SQL_SEL_DEVIEC = "";

  private Connection conn;

  public RouterOperationDao(Connection conn) {
    this.conn = conn;
  }

  public List<RouterOperation> selectByRouter(String routerBo) throws SQLException {
    ArrayList<RouterOperation> result = new ArrayList<RouterOperation>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE router_bo=? ORDER BY sequence")) {
      ps.setString(1, routerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  private RouterOperation convert(ResultSet rs) throws SQLException {
    RouterOperation data = new RouterOperation();
    data.setRouterOperationBo(rs.getString(1));
    data.setRouterBo(rs.getString(2));
    data.setRouter(rs.getString(3));
    data.setRouterStepBo(rs.getString(4));
    data.setOperationParent(rs.getString(5));
    data.setOperationBo(rs.getString(6));
    data.setOperation(rs.getString(7));
    data.setStepId(rs.getString(8));
    data.setRework(rs.getString(9));
    data.setQueueDecisionType(rs.getString(10));
    data.setSequence(rs.getInt(11));
    data.setRouterType(rs.getString(12));
    data.setRevision(rs.getString(13));
    data.setOperationType(rs.getString(14));
    data.setCycleTimeType(rs.getString(15));
    data.setRecipeType(rs.getString(16));
    return data;
  }
}
