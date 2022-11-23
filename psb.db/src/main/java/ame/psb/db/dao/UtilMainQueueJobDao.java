package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.UtilMainQueueJob;
import uia.utils.dao.DateUtils;

public class UtilMainQueueJobDao {

    private static final String SQL_INS = "INSERT INTO zd_util_main_queue_job(id,main_queue_bo,queue_job_seq,queue_job_content,queue_job_status,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_util_main_queue_job SET main_queue_bo=?,queue_job_seq=?,queue_job_content=?,queue_job_status=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,main_queue_bo,queue_job_seq,queue_job_content,queue_job_status,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_util_main_queue_job ";

    private final Connection conn;

    public UtilMainQueueJobDao(Connection conn) {
        this.conn = conn;
    }

    public int insert(UtilMainQueueJob data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getMainQueueBo());
            ps.setBigDecimal(3, data.getQueueJobSeq());
            ps.setString(4, data.getQueueJobContent());
            ps.setString(5, data.getQueueJobStatus());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }

    public int insert(List<UtilMainQueueJob> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(UtilMainQueueJob data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getMainQueueBo());
            ps.setBigDecimal(3, data.getQueueJobSeq());
            ps.setString(4, data.getQueueJobContent());
            ps.setString(5, data.getQueueJobStatus());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }

    public int update(UtilMainQueueJob data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getMainQueueBo());
            ps.setBigDecimal(2, data.getQueueJobSeq());
            ps.setString(3, data.getQueueJobContent());
            ps.setString(4, data.getQueueJobStatus());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getId());

            return ps.executeUpdate();
        }
    }

    public int update(List<UtilMainQueueJob> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(UtilMainQueueJob data : dataList) {
            ps.setString(1, data.getMainQueueBo());
            ps.setBigDecimal(2, data.getQueueJobSeq());
            ps.setString(3, data.getQueueJobContent());
            ps.setString(4, data.getQueueJobStatus());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_util_main_queue_job WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }

    public List<UtilMainQueueJob> selectAll() throws SQLException {
        ArrayList<UtilMainQueueJob> result = new ArrayList<UtilMainQueueJob>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<UtilMainQueueJob> selectByMainQueueBo(String mainQueueBo) throws SQLException {
        ArrayList<UtilMainQueueJob> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where MAIN_QUEUE_BO = ? ")) {
            ps.setString(1, mainQueueBo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public UtilMainQueueJob selectByPK(String id) throws SQLException {
        UtilMainQueueJob result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    public UtilMainQueueJob selectByContent(String id) throws SQLException {
        UtilMainQueueJob result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE QUEUE_JOB_CONTENT = ?")) {
            ps.setString(1, id);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    private UtilMainQueueJob convert(ResultSet rs) throws SQLException {
        UtilMainQueueJob data = new UtilMainQueueJob();

        int index = 1;
        data.setId(rs.getString(index++));
        data.setMainQueueBo(rs.getString(index++));
        data.setQueueJobSeq(rs.getBigDecimal(index++));
        data.setQueueJobContent(rs.getString(index++));
        data.setQueueJobStatus(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
