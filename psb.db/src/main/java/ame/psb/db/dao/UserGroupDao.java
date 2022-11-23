package ame.psb.db.dao;

import ame.psb.db.UserGroup;
import uia.utils.dao.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao {

    private static final String SQL_INS = "INSERT INTO user_group(handle,change_stamp,site,user_group,description,workstation_bo,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE handle=?,change_stamp,site=?,user_group=?,description=?,workstation_bo=?,created_date_time=?,modified_date_time=? WHERE handle=?";

    private static final String SQL_SEL = "SELECT handle,change_stamp,site,user_group,description,workstation_bo,created_date_time,modified_date_time FROM user_group ";

    private final Connection conn;

    public UserGroupDao(Connection conn) {
        this.conn = conn;
    }

    public int insert(UserGroup data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getHandle());
            ps.setString(2, data.getChangeStamp());
            ps.setString(3, data.getSite());
            ps.setString(4, data.getUserGroup());
            ps.setString(5, data.getDescription());
            ps.setString(6, data.getWorkstationBo());
            DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());

            return ps.executeUpdate();
        }
    }

    public int insert(List<UserGroup> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for (UserGroup data : dataList) {
                ps.setString(1, data.getHandle());
                ps.setString(2, data.getChangeStamp());
                ps.setString(3, data.getSite());
                ps.setString(4, data.getUserGroup());
                ps.setString(5, data.getDescription());
                ps.setString(6, data.getWorkstationBo());
                DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
                DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }

    public int update(UserGroup data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getHandle());
            ps.setString(2, data.getChangeStamp());
            ps.setString(3, data.getSite());
            ps.setString(4, data.getUserGroup());
            ps.setString(5, data.getDescription());
            ps.setString(6, data.getWorkstationBo());
            DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());

            return ps.executeUpdate();
        }
    }

    public int update(List<UserGroup> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for (UserGroup data : dataList) {
                ps.setString(1, data.getHandle());
                ps.setString(2, data.getChangeStamp());
                ps.setString(3, data.getSite());
                ps.setString(4, data.getUserGroup());
                ps.setString(5, data.getDescription());
                ps.setString(6, data.getWorkstationBo());
                DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
                DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());
                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }

    public int delete(String handle) throws SQLException {
        try (PreparedStatement ps = this.conn
                .prepareStatement("DELETE FROM user_group WHERE handle=?")) {
            ps.setString(1, handle);

            return ps.executeUpdate();
        }
    }

    public List<UserGroup> selectAll() throws SQLException {
        ArrayList<UserGroup> result = new ArrayList<UserGroup>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


    public UserGroup selectByPK(String handle) throws SQLException {
        UserGroup result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
            ps.setString(1, handle);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }


    public List<UserGroup> selectByUserGroup(String userGroupBo) throws SQLException {
        ArrayList<UserGroup> result = new ArrayList<UserGroup>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE user_group_bo = ?")) {
            ps.setString(1, userGroupBo);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


    private UserGroup convert(ResultSet rs) throws SQLException {
        UserGroup data = new UserGroup();

        int index = 1;
        data.setHandle(rs.getString(index++));
        data.setChangeStamp(rs.getString(index++));
        data.setSite(rs.getString(index++));
        data.setUserGroup(rs.getString(index++));
        data.setDescription(rs.getString(index++));
        data.setWorkstationBo(rs.getString(index++));
        data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
        data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
