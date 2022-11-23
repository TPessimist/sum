package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FTTractionTest;
import uia.utils.dao.DateUtils;

/**
 * FT拉力测试DAO层
 */
public class FTTractionTestDao {

    private static final String SQL_INS = "INSERT INTO zd_ft_traction_test(uuid,sfc,max,min,average,cpk,result,opportunity,mode,customer,zd_supplier,zd_sfc,gd_supplier,gd_sfc,user,time,resource,package,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_ft_traction_test SET sfc=?,max=?,min=?,average=?,cpk=?,result=?,opportunity=?,mode=?,customer=?,zd_supplier=?,zd_sfc=?,gd_supplier=?,gd_sfc=?,user=?,time=?,resource=?,package=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,sfc,max,min,average,cpk,result,opportunity,mode,customer,zd_supplier,zd_sfc,gd_supplier,gd_sfc,user,time,resource,package,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_ft_traction_test ";
    
    private final Connection conn;

    public FTTractionTestDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(FTTractionTest data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getSfc());
            ps.setBigDecimal(3, data.getMax());
            ps.setBigDecimal(4, data.getMin());
            ps.setBigDecimal(5, data.getAverage());
            ps.setBigDecimal(6, data.getCpk());
            ps.setString(7, data.getResult());
            ps.setString(8, data.getOpportunity());
            ps.setString(9, data.getMode());
            ps.setString(10, data.getCustomer());
            ps.setString(11, data.getZdSupplier());
            ps.setString(12, data.getZdSfc());
            ps.setString(13, data.getGdSupplier());
            ps.setString(14, data.getGdSfc());
            ps.setString(15, data.getUser());
            DateUtils.setDateTz(ps, 16, data.getTime());
            ps.setString(17, data.getResource());
            ps.setString(18, data.getPackageName());
            ps.setString(19, data.getReversedField1());
            ps.setString(20, data.getReversedField2());
            ps.setString(21, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 22, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<FTTractionTest> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(FTTractionTest data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getSfc());
            ps.setBigDecimal(3, data.getMax());
            ps.setBigDecimal(4, data.getMin());
            ps.setBigDecimal(5, data.getAverage());
            ps.setBigDecimal(6, data.getCpk());
            ps.setString(7, data.getResult());
            ps.setString(8, data.getOpportunity());
            ps.setString(9, data.getMode());
            ps.setString(10, data.getCustomer());
            ps.setString(11, data.getZdSupplier());
            ps.setString(12, data.getZdSfc());
            ps.setString(13, data.getGdSupplier());
            ps.setString(14, data.getGdSfc());
            ps.setString(15, data.getUser());
            DateUtils.setDateTz(ps, 16, data.getTime());
            ps.setString(17, data.getResource());
            ps.setString(18, data.getPackageName());
            ps.setString(19, data.getReversedField1());
            ps.setString(20, data.getReversedField2());
            ps.setString(21, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 22, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(FTTractionTest data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getSfc());
            ps.setBigDecimal(2, data.getMax());
            ps.setBigDecimal(3, data.getMin());
            ps.setBigDecimal(4, data.getAverage());
            ps.setBigDecimal(5, data.getCpk());
            ps.setString(6, data.getResult());
            ps.setString(7, data.getOpportunity());
            ps.setString(8, data.getMode());
            ps.setString(9, data.getCustomer());
            ps.setString(10, data.getZdSupplier());
            ps.setString(11, data.getZdSfc());
            ps.setString(12, data.getGdSupplier());
            ps.setString(13, data.getGdSfc());
            ps.setString(14, data.getUser());
            DateUtils.setDateTz(ps, 15, data.getTime());
            ps.setString(16, data.getResource());
            ps.setString(17, data.getPackageName());
            ps.setString(18, data.getReversedField1());
            ps.setString(19, data.getReversedField2());
            ps.setString(20, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 21, data.getUpdatedTime());
            ps.setString(22, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<FTTractionTest> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(FTTractionTest data : dataList) {
            ps.setString(1, data.getSfc());
            ps.setBigDecimal(2, data.getMax());
            ps.setBigDecimal(3, data.getMin());
            ps.setBigDecimal(4, data.getAverage());
            ps.setBigDecimal(5, data.getCpk());
            ps.setString(6, data.getResult());
            ps.setString(7, data.getOpportunity());
            ps.setString(8, data.getMode());
            ps.setString(9, data.getCustomer());
            ps.setString(10, data.getZdSupplier());
            ps.setString(11, data.getZdSfc());
            ps.setString(12, data.getGdSupplier());
            ps.setString(13, data.getGdSfc());
            ps.setString(14, data.getUser());
            DateUtils.setDateTz(ps, 15, data.getTime());
            ps.setString(16, data.getResource());
            ps.setString(17, data.getPackageName());
            ps.setString(18, data.getReversedField1());
            ps.setString(19, data.getReversedField2());
            ps.setString(20, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 21, data.getUpdatedTime());
            ps.setString(22, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_ft_traction_test WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<FTTractionTest> selectAll() throws SQLException {
        ArrayList<FTTractionTest> result = new ArrayList<FTTractionTest>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public FTTractionTest selectByPK(String uuid) throws SQLException {
        FTTractionTest result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    /**
     * 生产批次查询对应解析数据
     * @param sfc 生产批次
     * @return List<FTTractionTest> 数据集合
     * @throws SQLException
     */
    public List<FTTractionTest> selectBySfc(String sfc) throws SQLException {
        List<FTTractionTest> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE sfc=?")) {
            ps.setString(1, sfc);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    private FTTractionTest convert(ResultSet rs) throws SQLException {
        FTTractionTest data = new FTTractionTest();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setSfc(rs.getString(index++));
        data.setMax(rs.getBigDecimal(index++));
        data.setMin(rs.getBigDecimal(index++));
        data.setAverage(rs.getBigDecimal(index++));
        data.setCpk(rs.getBigDecimal(index++));
        data.setResult(rs.getString(index++));
        data.setOpportunity(rs.getString(index++));
        data.setMode(rs.getString(index++));
        data.setCustomer(rs.getString(index++));
        data.setZdSupplier(rs.getString(index++));
        data.setZdSfc(rs.getString(index++));
        data.setGdSupplier(rs.getString(index++));
        data.setGdSfc(rs.getString(index++));
        data.setUser(rs.getString(index++));
        data.setTime(DateUtils.getDateTz(rs, index++));
        data.setResource(rs.getString(index++));
        data.setPackageName(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
