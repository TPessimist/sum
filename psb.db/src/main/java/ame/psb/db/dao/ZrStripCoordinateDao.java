package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZrStripCoordinate;

public class ZrStripCoordinateDao {

    private static final String SQL_INS = "INSERT INTO zr_strip_coordinate(strip_id,fx,fy,tx,ty) VALUES (?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_strip_coordinate SET fx=?,fy=? WHERE strip_id=? AND tx=? AND ty=?";

    private static final String SQL_SEL = "SELECT strip_id,fx,fy,tx,ty FROM zr_strip_coordinate ";
    
    private final Connection conn;

    public ZrStripCoordinateDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ZrStripCoordinate data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getStripId());
            ps.setInt(2, data.getFx());
            ps.setInt(3, data.getFy());
            ps.setInt(4, data.getTx());
            ps.setInt(5, data.getTy());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ZrStripCoordinate> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ZrStripCoordinate data : dataList) {
            ps.setString(1, data.getStripId());
            ps.setInt(2, data.getFx());
            ps.setInt(3, data.getFy());
            ps.setInt(4, data.getTx());
            ps.setInt(5, data.getTy());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ZrStripCoordinate data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setInt(1, data.getFx());
            ps.setInt(2, data.getFy());
            ps.setString(3, data.getStripId());
            ps.setInt(4, data.getTx());
            ps.setInt(5, data.getTy());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ZrStripCoordinate> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ZrStripCoordinate data : dataList) {
            ps.setInt(1, data.getFx());
            ps.setInt(2, data.getFy());
            ps.setString(3, data.getStripId());
            ps.setInt(4, data.getTx());
            ps.setInt(5, data.getTy());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String stripId, int tx, int ty) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_strip_coordinate WHERE strip_id=? AND tx=? AND ty=?")) {
            ps.setString(1, stripId);
            ps.setInt(2, tx);
            ps.setInt(3, ty);

            return ps.executeUpdate();
        }
    }
    
    public int deleteByStripId(String stripId) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_strip_coordinate WHERE strip_id=?")) {
            ps.setString(1, stripId);

            return ps.executeUpdate();
        }
    }  

    public List<ZrStripCoordinate> selectAll() throws SQLException {
        ArrayList<ZrStripCoordinate> result = new ArrayList<ZrStripCoordinate>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ZrStripCoordinate selectByPK(String stripId, int tx, int ty) throws SQLException {
        ZrStripCoordinate result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE strip_id=? AND tx=? AND ty=?")) {
            ps.setString(1, stripId);
            ps.setInt(2, tx);
            ps.setInt(3, ty);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private ZrStripCoordinate convert(ResultSet rs) throws SQLException {
        ZrStripCoordinate data = new ZrStripCoordinate();
        
        int index = 1;
        data.setStripId(rs.getString(index++));
        data.setFx(rs.getInt(index++));
        data.setFy(rs.getInt(index++));
        data.setTx(rs.getInt(index++));
        data.setTy(rs.getInt(index++));

        return data;
    }
}
