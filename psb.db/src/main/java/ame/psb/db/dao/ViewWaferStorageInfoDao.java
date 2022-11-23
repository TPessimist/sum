package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ViewWaferStorageInfo;
import uia.utils.dao.DateUtils;

public class ViewWaferStorageInfoDao {

    private static final String SQL_INS = "INSERT INTO view_wafer_storage_info(handle,sfc,device_name,customer,wafer_id,balance_qty,film_time,expire_time,membrance_type,storage_location_1,storage_location_2,storage_location_3,created_user,created_time,claimed_user,claimed_time,id,remain_wafer_carrier_bo,normal_wafer_carrier_bo,remain_wafer_done_flag,normal_wafer_done_flag,reverse_field1,reverse_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE view_wafer_storage_info SET sfc=?,device_name=?,customer=?,wafer_id=?,balance_qty=?,film_time=?,expire_time=?,membrance_type=?,storage_location_1=?,storage_location_2=?,storage_location_3=?,created_user=?,created_time=?,claimed_user=?,claimed_time=?,id=?,remain_wafer_carrier_bo=?,normal_wafer_carrier_bo=?,remain_wafer_done_flag=?,normal_wafer_done_flag=?,reverse_field1=?,reverse_field2=?,updated_user=?,updated_time=? WHERE handle=?";

    private static final String SQL_SEL = "SELECT handle,sfc,device_name,customer,wafer_id,balance_qty,film_time,expire_time,membrance_type,storage_location_1,storage_location_2,storage_location_3,created_user,created_time,claimed_user,claimed_time,id,remain_wafer_carrier_bo,normal_wafer_carrier_bo,remain_wafer_done_flag,normal_wafer_done_flag,reverse_field1,reverse_field2,updated_user,updated_time FROM view_wafer_storage_info ";
    
    private final Connection conn;

    public ViewWaferStorageInfoDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ViewWaferStorageInfo data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getHandle());
            ps.setString(2, data.getSfc());
            ps.setString(3, data.getDeviceName());
            ps.setString(4, data.getCustomer());
            ps.setString(5, data.getWaferId());
            ps.setBigDecimal(6, data.getBalanceQty());
            DateUtils.setDateTz(ps, 7, data.getFilmTime());
            DateUtils.setDateTz(ps, 8, data.getExpireTime());
            ps.setString(9, data.getMembranceType());
            ps.setString(10, data.getStorageLocation1());
            ps.setString(11, data.getStorageLocation2());
            ps.setString(12, data.getStorageLocation3());
            ps.setString(13, data.getCreatedUser());
            DateUtils.setDateTz(ps, 14, data.getCreatedTime());
            ps.setString(15, data.getClaimedUser());
            DateUtils.setDateTz(ps, 16, data.getClaimedTime());
            ps.setString(17, data.getId());
            ps.setString(18, data.getRemainWaferCarrierBo());
            ps.setString(19, data.getNormalWaferCarrierBo());
            ps.setString(20, data.getRemainWaferDoneFlag());
            ps.setString(21, data.getNormalWaferDoneFlag());
            ps.setString(22, data.getReverseField1());
            ps.setString(23, data.getReverseField2());
            ps.setString(24, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 25, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ViewWaferStorageInfo> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ViewWaferStorageInfo data : dataList) {
            ps.setString(1, data.getHandle());
            ps.setString(2, data.getSfc());
            ps.setString(3, data.getDeviceName());
            ps.setString(4, data.getCustomer());
            ps.setString(5, data.getWaferId());
            ps.setBigDecimal(6, data.getBalanceQty());
            DateUtils.setDateTz(ps, 7, data.getFilmTime());
            DateUtils.setDateTz(ps, 8, data.getExpireTime());
            ps.setString(9, data.getMembranceType());
            ps.setString(10, data.getStorageLocation1());
            ps.setString(11, data.getStorageLocation2());
            ps.setString(12, data.getStorageLocation3());
            ps.setString(13, data.getCreatedUser());
            DateUtils.setDateTz(ps, 14, data.getCreatedTime());
            ps.setString(15, data.getClaimedUser());
            DateUtils.setDateTz(ps, 16, data.getClaimedTime());
            ps.setString(17, data.getId());
            ps.setString(18, data.getRemainWaferCarrierBo());
            ps.setString(19, data.getNormalWaferCarrierBo());
            ps.setString(20, data.getRemainWaferDoneFlag());
            ps.setString(21, data.getNormalWaferDoneFlag());
            ps.setString(22, data.getReverseField1());
            ps.setString(23, data.getReverseField2());
            ps.setString(24, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 25, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ViewWaferStorageInfo data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getSfc());
            ps.setString(2, data.getDeviceName());
            ps.setString(3, data.getCustomer());
            ps.setString(4, data.getWaferId());
            ps.setBigDecimal(5, data.getBalanceQty());
            DateUtils.setDateTz(ps, 6, data.getFilmTime());
            DateUtils.setDateTz(ps, 7, data.getExpireTime());
            ps.setString(8, data.getMembranceType());
            ps.setString(9, data.getStorageLocation1());
            ps.setString(10, data.getStorageLocation2());
            ps.setString(11, data.getStorageLocation3());
            ps.setString(12, data.getCreatedUser());
            DateUtils.setDateTz(ps, 13, data.getCreatedTime());
            ps.setString(14, data.getClaimedUser());
            DateUtils.setDateTz(ps, 15, data.getClaimedTime());
            ps.setString(16, data.getId());
            ps.setString(17, data.getRemainWaferCarrierBo());
            ps.setString(18, data.getNormalWaferCarrierBo());
            ps.setString(19, data.getRemainWaferDoneFlag());
            ps.setString(20, data.getNormalWaferDoneFlag());
            ps.setString(21, data.getReverseField1());
            ps.setString(22, data.getReverseField2());
            ps.setString(23, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 24, data.getUpdatedTime());
            ps.setString(25, data.getHandle());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ViewWaferStorageInfo> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ViewWaferStorageInfo data : dataList) {
            ps.setString(1, data.getSfc());
            ps.setString(2, data.getDeviceName());
            ps.setString(3, data.getCustomer());
            ps.setString(4, data.getWaferId());
            ps.setBigDecimal(5, data.getBalanceQty());
            DateUtils.setDateTz(ps, 6, data.getFilmTime());
            DateUtils.setDateTz(ps, 7, data.getExpireTime());
            ps.setString(8, data.getMembranceType());
            ps.setString(9, data.getStorageLocation1());
            ps.setString(10, data.getStorageLocation2());
            ps.setString(11, data.getStorageLocation3());
            ps.setString(12, data.getCreatedUser());
            DateUtils.setDateTz(ps, 13, data.getCreatedTime());
            ps.setString(14, data.getClaimedUser());
            DateUtils.setDateTz(ps, 15, data.getClaimedTime());
            ps.setString(16, data.getId());
            ps.setString(17, data.getRemainWaferCarrierBo());
            ps.setString(18, data.getNormalWaferCarrierBo());
            ps.setString(19, data.getRemainWaferDoneFlag());
            ps.setString(20, data.getNormalWaferDoneFlag());
            ps.setString(21, data.getReverseField1());
            ps.setString(22, data.getReverseField2());
            ps.setString(23, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 24, data.getUpdatedTime());
            ps.setString(25, data.getHandle());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String handle) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM view_wafer_storage_info WHERE handle=?")) {
            ps.setString(1, handle);

            return ps.executeUpdate();
        }
    }    

    public List<ViewWaferStorageInfo> selectAll() throws SQLException {
        ArrayList<ViewWaferStorageInfo> result = new ArrayList<ViewWaferStorageInfo>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public List<ViewWaferStorageInfo> selectByDeviceName(String deviceName) throws SQLException {
        ArrayList<ViewWaferStorageInfo> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where DEVICE_NAME = ? and CLAIMED_USER IS NULL ")) {
            ps.setString(1, deviceName);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }



    public List<ViewWaferStorageInfo> selectByNormalCarrierBo(String normalCarrierBo) throws SQLException {
        ArrayList<ViewWaferStorageInfo> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where NORMAL_WAFER_CARRIER_BO = ? ")) {
            ps.setString(1, normalCarrierBo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<ViewWaferStorageInfo> selectByRemainCarrierBo(String remainCarrierBo) throws SQLException {
        ArrayList<ViewWaferStorageInfo> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where REMAIN_WAFER_CARRIER_BO = ? ")) {
            ps.setString(1, remainCarrierBo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }



    public ViewWaferStorageInfo selectByPK(String handle) throws SQLException {
        ViewWaferStorageInfo result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE handle=?")) {
            ps.setString(1, handle);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private ViewWaferStorageInfo convert(ResultSet rs) throws SQLException {
        ViewWaferStorageInfo data = new ViewWaferStorageInfo();
        
        int index = 1;
        data.setHandle(rs.getString(index++));
        data.setSfc(rs.getString(index++));
        data.setDeviceName(rs.getString(index++));
        data.setCustomer(rs.getString(index++));
        data.setWaferId(rs.getString(index++));
        data.setBalanceQty(rs.getBigDecimal(index++));
        data.setFilmTime(DateUtils.getDateTz(rs, index++));
        data.setExpireTime(DateUtils.getDateTz(rs, index++));
        data.setMembranceType(rs.getString(index++));
        data.setStorageLocation1(rs.getString(index++));
        data.setStorageLocation2(rs.getString(index++));
        data.setStorageLocation3(rs.getString(index++));
        data.setCreatedUser(rs.getString(index++));
        data.setCreatedTime(DateUtils.getDateTz(rs, index++));
        data.setClaimedUser(rs.getString(index++));
        data.setClaimedTime(DateUtils.getDateTz(rs, index++));
        data.setId(rs.getString(index++));
        data.setRemainWaferCarrierBo(rs.getString(index++));
        data.setNormalWaferCarrierBo(rs.getString(index++));
        data.setRemainWaferDoneFlag(rs.getString(index++));
        data.setNormalWaferDoneFlag(rs.getString(index++));
        data.setReverseField1(rs.getString(index++));
        data.setReverseField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
