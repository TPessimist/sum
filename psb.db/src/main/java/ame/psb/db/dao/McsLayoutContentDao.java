package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.McsLayoutContent;
import uia.utils.dao.DateUtils;

public class McsLayoutContentDao {

    private static final String SQL_SEL = "SELECT resource_bo,next_resource_bo,bay_bo,id,slot_no,slot_type,content,capacity,root_resource,updated_user,updated_time,ref,reserve_for,state_name,type FROM view_mcs_layout_content ";
    
    private final Connection conn;

    public McsLayoutContentDao(Connection conn) {
        this.conn = conn;
    }


    public List<McsLayoutContent> selectAll() throws SQLException {
        ArrayList<McsLayoutContent> result = new ArrayList<McsLayoutContent>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<McsLayoutContent> selectByBayBoAndResType(String bayBo, String resType) throws SQLException {
        ArrayList<McsLayoutContent> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE BAY_BO = ? and TYPE = ?")) {

            ps.setString(1, bayBo);
            ps.setString(2, resType);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<McsLayoutContent> selectByResType(String resType) throws SQLException {
        ArrayList<McsLayoutContent> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE TYPE = ?")) {

            ps.setString(1, resType);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


    private McsLayoutContent convert(ResultSet rs) throws SQLException {
        McsLayoutContent data = new McsLayoutContent();
        
        int index = 1;
        data.setResourceBo(rs.getString(index++));
        data.setNextResourceBo(rs.getString(index++));
        data.setBayBo(rs.getString(index++));
        data.setId(rs.getString(index++));
        data.setSlotNo(rs.getString(index++));
        data.setSlotType(rs.getString(index++));
        data.setContent(rs.getString(index++));
        data.setCapacity(rs.getBigDecimal(index++));
        data.setRootResource(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
        data.setRef(rs.getString(index++));
        data.setReserveFor(rs.getString(index++));
        data.setStateName(rs.getString(index++));
        data.setType(rs.getString(index++));

        return data;
    }
}
