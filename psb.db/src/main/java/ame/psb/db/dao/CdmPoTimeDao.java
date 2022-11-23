package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.CdmPoTime;
import uia.utils.dao.DateUtils;

public class CdmPoTimeDao {

    private static final String SQL_INS = "INSERT INTO zm_cdm_po_item(cust_code,sap_cust_code,trad_cust_code,po_id,po_type,po_date,bonded,customer_device,fab_device,cust_fab_device_1,cust_fab_device_2,ht_pn,product_pn,sap_product_pn,lot_id,wafer_id,lot_wafer_id,passbin_count,failbin_count,mark_code,add_0,add_1,add_2,add_3,add_4,add_5,add_6,add_7,add_8,add_9,add_10,cdm_id,cdm_item,so_id,so_item,mo_id,mo_item,flag,flag2,flag3,create_date,create_by,update_date,update_by,wafer_times,upload_id,wafer_sn,id,wafer_pcs_price,wafer_die_price,wafer_hold,add_11,add_12,add_13,add_14,add_15,add_16,add_17,add_18,add_19,add_20,add_21,add_22,add_23,add_24,add_25,add_26,add_27,add_28,add_29,add_30,address_code,base_so,status,remark1,remark2,remark3,po_h,flag4,flag5,remakr4,remakr5) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zm_cdm_po_item SET cust_code=?,sap_cust_code=?,trad_cust_code=?,po_id=?,po_type=?,po_date=?,bonded=?,customer_device=?,fab_device=?,cust_fab_device_1=?,cust_fab_device_2=?,ht_pn=?,product_pn=?,sap_product_pn=?,lot_id=?,wafer_id=?,lot_wafer_id=?,passbin_count=?,failbin_count=?,mark_code=?,add_0=?,add_1=?,add_2=?,add_3=?,add_4=?,add_5=?,add_6=?,add_7=?,add_8=?,add_9=?,add_10=?,cdm_id=?,cdm_item=?,so_id=?,so_item=?,mo_id=?,mo_item=?,flag=?,flag2=?,flag3=?,create_date=?,create_by=?,update_date=?,update_by=?,wafer_times=?,upload_id=?,id=?,wafer_pcs_price=?,wafer_die_price=?,wafer_hold=?,add_11=?,add_12=?,add_13=?,add_14=?,add_15=?,add_16=?,add_17=?,add_18=?,add_19=?,add_20=?,add_21=?,add_22=?,add_23=?,add_24=?,add_25=?,add_26=?,add_27=?,add_28=?,add_29=?,add_30=?,address_code=?,base_so=?,status=?,remark1=?,remark2=?,remark3=?,po_h=?,flag4=?,flag5=?,remakr4=?,remakr5=? WHERE wafer_sn=?";

    private static final String SQL_SEL = "SELECT cust_code,sap_cust_code,trad_cust_code,po_id,po_type,po_date,bonded,customer_device,fab_device,cust_fab_device_1,cust_fab_device_2,ht_pn,product_pn,sap_product_pn,lot_id,wafer_id,lot_wafer_id,passbin_count,failbin_count,mark_code,add_0,add_1,add_2,add_3,add_4,add_5,add_6,add_7,add_8,add_9,add_10,cdm_id,cdm_item,so_id,so_item,mo_id,mo_item,flag,flag2,flag3,create_date,create_by,update_date,update_by,wafer_times,upload_id,wafer_sn,id,wafer_pcs_price,wafer_die_price,wafer_hold,add_11,add_12,add_13,add_14,add_15,add_16,add_17,add_18,add_19,add_20,add_21,add_22,add_23,add_24,add_25,add_26,add_27,add_28,add_29,add_30,address_code,base_so,status,remark1,remark2,remark3,po_h,flag4,flag5,remakr4,remakr5 FROM zm_cdm_po_item ";
    
    private final Connection conn;

    public CdmPoTimeDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(CdmPoTime data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getCustCode());
            ps.setString(2, data.getSapCustCode());
            ps.setString(3, data.getTradCustCode());
            ps.setString(4, data.getPoId());
            ps.setString(5, data.getPoType());
            ps.setString(6, data.getPoDate());
            ps.setString(7, data.getBonded());
            ps.setString(8, data.getCustomerDevice());
            ps.setString(9, data.getFabDevice());
            ps.setString(10, data.getCustFabDevice1());
            ps.setString(11, data.getCustFabDevice2());
            ps.setString(12, data.getHtPn());
            ps.setString(13, data.getProductPn());
            ps.setString(14, data.getSapProductPn());
            ps.setString(15, data.getLotId());
            ps.setString(16, data.getWaferId());
            ps.setString(17, data.getLotWaferId());
            ps.setString(18, data.getPassbinCount());
            ps.setString(19, data.getFailbinCount());
            ps.setString(20, data.getMarkCode());
            ps.setString(21, data.getAdd0());
            ps.setString(22, data.getAdd1());
            ps.setString(23, data.getAdd2());
            ps.setString(24, data.getAdd3());
            ps.setString(25, data.getAdd4());
            ps.setString(26, data.getAdd5());
            ps.setString(27, data.getAdd6());
            ps.setString(28, data.getAdd7());
            ps.setString(29, data.getAdd8());
            ps.setString(30, data.getAdd9());
            ps.setString(31, data.getAdd10());
            ps.setString(32, data.getCdmId());
            ps.setString(33, data.getCdmItem());
            ps.setString(34, data.getSoId());
            ps.setString(35, data.getSoItem());
            ps.setString(36, data.getMoId());
            ps.setString(37, data.getMoItem());
            ps.setString(38, data.getFlag());
            ps.setString(39, data.getFlag2());
            ps.setString(40, data.getFlag3());
            DateUtils.setDateTz(ps, 41, data.getCreateDate());
            ps.setString(42, data.getCreateBy());
            DateUtils.setDateTz(ps, 43, data.getUpdateDate());
            ps.setString(44, data.getUpdateBy());
            ps.setString(45, data.getWaferTimes());
            ps.setString(46, data.getUploadId());
            ps.setString(47, data.getWaferSn());
            ps.setString(48, data.getId());
            ps.setString(49, data.getWaferPcsPrice());
            ps.setString(50, data.getWaferDiePrice());
            ps.setString(51, data.getWaferHold());
            ps.setString(52, data.getAdd11());
            ps.setString(53, data.getAdd12());
            ps.setString(54, data.getAdd13());
            ps.setString(55, data.getAdd14());
            ps.setString(56, data.getAdd15());
            ps.setString(57, data.getAdd16());
            ps.setString(58, data.getAdd17());
            ps.setString(59, data.getAdd18());
            ps.setString(60, data.getAdd19());
            ps.setString(61, data.getAdd20());
            ps.setString(62, data.getAdd21());
            ps.setString(63, data.getAdd22());
            ps.setString(64, data.getAdd23());
            ps.setString(65, data.getAdd24());
            ps.setString(66, data.getAdd25());
            ps.setString(67, data.getAdd26());
            ps.setString(68, data.getAdd27());
            ps.setString(69, data.getAdd28());
            ps.setString(70, data.getAdd29());
            ps.setString(71, data.getAdd30());
            ps.setString(72, data.getAddressCode());
            ps.setString(73, data.getBaseSo());
            ps.setString(74, data.getStatus());
            ps.setString(75, data.getRemark1());
            ps.setString(76, data.getRemark2());
            ps.setString(77, data.getRemark3());
            ps.setString(78, data.getPoH());
            ps.setString(79, data.getFlag4());
            ps.setString(80, data.getFlag5());
            ps.setString(81, data.getRemakr4());
            ps.setString(82, data.getRemakr5());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<CdmPoTime> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(CdmPoTime data : dataList) {
            ps.setString(1, data.getCustCode());
            ps.setString(2, data.getSapCustCode());
            ps.setString(3, data.getTradCustCode());
            ps.setString(4, data.getPoId());
            ps.setString(5, data.getPoType());
            ps.setString(6, data.getPoDate());
            ps.setString(7, data.getBonded());
            ps.setString(8, data.getCustomerDevice());
            ps.setString(9, data.getFabDevice());
            ps.setString(10, data.getCustFabDevice1());
            ps.setString(11, data.getCustFabDevice2());
            ps.setString(12, data.getHtPn());
            ps.setString(13, data.getProductPn());
            ps.setString(14, data.getSapProductPn());
            ps.setString(15, data.getLotId());
            ps.setString(16, data.getWaferId());
            ps.setString(17, data.getLotWaferId());
            ps.setString(18, data.getPassbinCount());
            ps.setString(19, data.getFailbinCount());
            ps.setString(20, data.getMarkCode());
            ps.setString(21, data.getAdd0());
            ps.setString(22, data.getAdd1());
            ps.setString(23, data.getAdd2());
            ps.setString(24, data.getAdd3());
            ps.setString(25, data.getAdd4());
            ps.setString(26, data.getAdd5());
            ps.setString(27, data.getAdd6());
            ps.setString(28, data.getAdd7());
            ps.setString(29, data.getAdd8());
            ps.setString(30, data.getAdd9());
            ps.setString(31, data.getAdd10());
            ps.setString(32, data.getCdmId());
            ps.setString(33, data.getCdmItem());
            ps.setString(34, data.getSoId());
            ps.setString(35, data.getSoItem());
            ps.setString(36, data.getMoId());
            ps.setString(37, data.getMoItem());
            ps.setString(38, data.getFlag());
            ps.setString(39, data.getFlag2());
            ps.setString(40, data.getFlag3());
            DateUtils.setDateTz(ps, 41, data.getCreateDate());
            ps.setString(42, data.getCreateBy());
            DateUtils.setDateTz(ps, 43, data.getUpdateDate());
            ps.setString(44, data.getUpdateBy());
            ps.setString(45, data.getWaferTimes());
            ps.setString(46, data.getUploadId());
            ps.setString(47, data.getWaferSn());
            ps.setString(48, data.getId());
            ps.setString(49, data.getWaferPcsPrice());
            ps.setString(50, data.getWaferDiePrice());
            ps.setString(51, data.getWaferHold());
            ps.setString(52, data.getAdd11());
            ps.setString(53, data.getAdd12());
            ps.setString(54, data.getAdd13());
            ps.setString(55, data.getAdd14());
            ps.setString(56, data.getAdd15());
            ps.setString(57, data.getAdd16());
            ps.setString(58, data.getAdd17());
            ps.setString(59, data.getAdd18());
            ps.setString(60, data.getAdd19());
            ps.setString(61, data.getAdd20());
            ps.setString(62, data.getAdd21());
            ps.setString(63, data.getAdd22());
            ps.setString(64, data.getAdd23());
            ps.setString(65, data.getAdd24());
            ps.setString(66, data.getAdd25());
            ps.setString(67, data.getAdd26());
            ps.setString(68, data.getAdd27());
            ps.setString(69, data.getAdd28());
            ps.setString(70, data.getAdd29());
            ps.setString(71, data.getAdd30());
            ps.setString(72, data.getAddressCode());
            ps.setString(73, data.getBaseSo());
            ps.setString(74, data.getStatus());
            ps.setString(75, data.getRemark1());
            ps.setString(76, data.getRemark2());
            ps.setString(77, data.getRemark3());
            ps.setString(78, data.getPoH());
            ps.setString(79, data.getFlag4());
            ps.setString(80, data.getFlag5());
            ps.setString(81, data.getRemakr4());
            ps.setString(82, data.getRemakr5());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(CdmPoTime data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getCustCode());
            ps.setString(2, data.getSapCustCode());
            ps.setString(3, data.getTradCustCode());
            ps.setString(4, data.getPoId());
            ps.setString(5, data.getPoType());
            ps.setString(6, data.getPoDate());
            ps.setString(7, data.getBonded());
            ps.setString(8, data.getCustomerDevice());
            ps.setString(9, data.getFabDevice());
            ps.setString(10, data.getCustFabDevice1());
            ps.setString(11, data.getCustFabDevice2());
            ps.setString(12, data.getHtPn());
            ps.setString(13, data.getProductPn());
            ps.setString(14, data.getSapProductPn());
            ps.setString(15, data.getLotId());
            ps.setString(16, data.getWaferId());
            ps.setString(17, data.getLotWaferId());
            ps.setString(18, data.getPassbinCount());
            ps.setString(19, data.getFailbinCount());
            ps.setString(20, data.getMarkCode());
            ps.setString(21, data.getAdd0());
            ps.setString(22, data.getAdd1());
            ps.setString(23, data.getAdd2());
            ps.setString(24, data.getAdd3());
            ps.setString(25, data.getAdd4());
            ps.setString(26, data.getAdd5());
            ps.setString(27, data.getAdd6());
            ps.setString(28, data.getAdd7());
            ps.setString(29, data.getAdd8());
            ps.setString(30, data.getAdd9());
            ps.setString(31, data.getAdd10());
            ps.setString(32, data.getCdmId());
            ps.setString(33, data.getCdmItem());
            ps.setString(34, data.getSoId());
            ps.setString(35, data.getSoItem());
            ps.setString(36, data.getMoId());
            ps.setString(37, data.getMoItem());
            ps.setString(38, data.getFlag());
            ps.setString(39, data.getFlag2());
            ps.setString(40, data.getFlag3());
            DateUtils.setDateTz(ps, 41, data.getCreateDate());
            ps.setString(42, data.getCreateBy());
            DateUtils.setDateTz(ps, 43, data.getUpdateDate());
            ps.setString(44, data.getUpdateBy());
            ps.setString(45, data.getWaferTimes());
            ps.setString(46, data.getUploadId());
            ps.setString(47, data.getId());
            ps.setString(48, data.getWaferPcsPrice());
            ps.setString(49, data.getWaferDiePrice());
            ps.setString(50, data.getWaferHold());
            ps.setString(51, data.getAdd11());
            ps.setString(52, data.getAdd12());
            ps.setString(53, data.getAdd13());
            ps.setString(54, data.getAdd14());
            ps.setString(55, data.getAdd15());
            ps.setString(56, data.getAdd16());
            ps.setString(57, data.getAdd17());
            ps.setString(58, data.getAdd18());
            ps.setString(59, data.getAdd19());
            ps.setString(60, data.getAdd20());
            ps.setString(61, data.getAdd21());
            ps.setString(62, data.getAdd22());
            ps.setString(63, data.getAdd23());
            ps.setString(64, data.getAdd24());
            ps.setString(65, data.getAdd25());
            ps.setString(66, data.getAdd26());
            ps.setString(67, data.getAdd27());
            ps.setString(68, data.getAdd28());
            ps.setString(69, data.getAdd29());
            ps.setString(70, data.getAdd30());
            ps.setString(71, data.getAddressCode());
            ps.setString(72, data.getBaseSo());
            ps.setString(73, data.getStatus());
            ps.setString(74, data.getRemark1());
            ps.setString(75, data.getRemark2());
            ps.setString(76, data.getRemark3());
            ps.setString(77, data.getPoH());
            ps.setString(78, data.getFlag4());
            ps.setString(79, data.getFlag5());
            ps.setString(80, data.getRemakr4());
            ps.setString(81, data.getRemakr5());
            ps.setString(82, data.getWaferSn());

            return ps.executeUpdate();
        }
    }    

    public int update(List<CdmPoTime> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(CdmPoTime data : dataList) {
            ps.setString(1, data.getCustCode());
            ps.setString(2, data.getSapCustCode());
            ps.setString(3, data.getTradCustCode());
            ps.setString(4, data.getPoId());
            ps.setString(5, data.getPoType());
            ps.setString(6, data.getPoDate());
            ps.setString(7, data.getBonded());
            ps.setString(8, data.getCustomerDevice());
            ps.setString(9, data.getFabDevice());
            ps.setString(10, data.getCustFabDevice1());
            ps.setString(11, data.getCustFabDevice2());
            ps.setString(12, data.getHtPn());
            ps.setString(13, data.getProductPn());
            ps.setString(14, data.getSapProductPn());
            ps.setString(15, data.getLotId());
            ps.setString(16, data.getWaferId());
            ps.setString(17, data.getLotWaferId());
            ps.setString(18, data.getPassbinCount());
            ps.setString(19, data.getFailbinCount());
            ps.setString(20, data.getMarkCode());
            ps.setString(21, data.getAdd0());
            ps.setString(22, data.getAdd1());
            ps.setString(23, data.getAdd2());
            ps.setString(24, data.getAdd3());
            ps.setString(25, data.getAdd4());
            ps.setString(26, data.getAdd5());
            ps.setString(27, data.getAdd6());
            ps.setString(28, data.getAdd7());
            ps.setString(29, data.getAdd8());
            ps.setString(30, data.getAdd9());
            ps.setString(31, data.getAdd10());
            ps.setString(32, data.getCdmId());
            ps.setString(33, data.getCdmItem());
            ps.setString(34, data.getSoId());
            ps.setString(35, data.getSoItem());
            ps.setString(36, data.getMoId());
            ps.setString(37, data.getMoItem());
            ps.setString(38, data.getFlag());
            ps.setString(39, data.getFlag2());
            ps.setString(40, data.getFlag3());
            DateUtils.setDateTz(ps, 41, data.getCreateDate());
            ps.setString(42, data.getCreateBy());
            DateUtils.setDateTz(ps, 43, data.getUpdateDate());
            ps.setString(44, data.getUpdateBy());
            ps.setString(45, data.getWaferTimes());
            ps.setString(46, data.getUploadId());
            ps.setString(47, data.getId());
            ps.setString(48, data.getWaferPcsPrice());
            ps.setString(49, data.getWaferDiePrice());
            ps.setString(50, data.getWaferHold());
            ps.setString(51, data.getAdd11());
            ps.setString(52, data.getAdd12());
            ps.setString(53, data.getAdd13());
            ps.setString(54, data.getAdd14());
            ps.setString(55, data.getAdd15());
            ps.setString(56, data.getAdd16());
            ps.setString(57, data.getAdd17());
            ps.setString(58, data.getAdd18());
            ps.setString(59, data.getAdd19());
            ps.setString(60, data.getAdd20());
            ps.setString(61, data.getAdd21());
            ps.setString(62, data.getAdd22());
            ps.setString(63, data.getAdd23());
            ps.setString(64, data.getAdd24());
            ps.setString(65, data.getAdd25());
            ps.setString(66, data.getAdd26());
            ps.setString(67, data.getAdd27());
            ps.setString(68, data.getAdd28());
            ps.setString(69, data.getAdd29());
            ps.setString(70, data.getAdd30());
            ps.setString(71, data.getAddressCode());
            ps.setString(72, data.getBaseSo());
            ps.setString(73, data.getStatus());
            ps.setString(74, data.getRemark1());
            ps.setString(75, data.getRemark2());
            ps.setString(76, data.getRemark3());
            ps.setString(77, data.getPoH());
            ps.setString(78, data.getFlag4());
            ps.setString(79, data.getFlag5());
            ps.setString(80, data.getRemakr4());
            ps.setString(81, data.getRemakr5());
            ps.setString(82, data.getWaferSn());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String waferSn) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zm_cdm_po_item WHERE wafer_sn=?")) {
            ps.setString(1, waferSn);

            return ps.executeUpdate();
        }
    }    

    public List<CdmPoTime> selectAll() throws SQLException {
        ArrayList<CdmPoTime> result = new ArrayList<CdmPoTime>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public CdmPoTime selectByPK(String waferSn) throws SQLException {
        CdmPoTime result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE wafer_sn=?")) {
            ps.setString(1, waferSn);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private CdmPoTime convert(ResultSet rs) throws SQLException {
        CdmPoTime data = new CdmPoTime();
        
        int index = 1;
        data.setCustCode(rs.getString(index++));
        data.setSapCustCode(rs.getString(index++));
        data.setTradCustCode(rs.getString(index++));
        data.setPoId(rs.getString(index++));
        data.setPoType(rs.getString(index++));
        data.setPoDate(rs.getString(index++));
        data.setBonded(rs.getString(index++));
        data.setCustomerDevice(rs.getString(index++));
        data.setFabDevice(rs.getString(index++));
        data.setCustFabDevice1(rs.getString(index++));
        data.setCustFabDevice2(rs.getString(index++));
        data.setHtPn(rs.getString(index++));
        data.setProductPn(rs.getString(index++));
        data.setSapProductPn(rs.getString(index++));
        data.setLotId(rs.getString(index++));
        data.setWaferId(rs.getString(index++));
        data.setLotWaferId(rs.getString(index++));
        data.setPassbinCount(rs.getString(index++));
        data.setFailbinCount(rs.getString(index++));
        data.setMarkCode(rs.getString(index++));
        data.setAdd0(rs.getString(index++));
        data.setAdd1(rs.getString(index++));
        data.setAdd2(rs.getString(index++));
        data.setAdd3(rs.getString(index++));
        data.setAdd4(rs.getString(index++));
        data.setAdd5(rs.getString(index++));
        data.setAdd6(rs.getString(index++));
        data.setAdd7(rs.getString(index++));
        data.setAdd8(rs.getString(index++));
        data.setAdd9(rs.getString(index++));
        data.setAdd10(rs.getString(index++));
        data.setCdmId(rs.getString(index++));
        data.setCdmItem(rs.getString(index++));
        data.setSoId(rs.getString(index++));
        data.setSoItem(rs.getString(index++));
        data.setMoId(rs.getString(index++));
        data.setMoItem(rs.getString(index++));
        data.setFlag(rs.getString(index++));
        data.setFlag2(rs.getString(index++));
        data.setFlag3(rs.getString(index++));
        data.setCreateDate(DateUtils.getDateTz(rs, index++));
        data.setCreateBy(rs.getString(index++));
        data.setUpdateDate(DateUtils.getDateTz(rs, index++));
        data.setUpdateBy(rs.getString(index++));
        data.setWaferTimes(rs.getString(index++));
        data.setUploadId(rs.getString(index++));
        data.setWaferSn(rs.getString(index++));
        data.setId(rs.getString(index++));
        data.setWaferPcsPrice(rs.getString(index++));
        data.setWaferDiePrice(rs.getString(index++));
        data.setWaferHold(rs.getString(index++));
        data.setAdd11(rs.getString(index++));
        data.setAdd12(rs.getString(index++));
        data.setAdd13(rs.getString(index++));
        data.setAdd14(rs.getString(index++));
        data.setAdd15(rs.getString(index++));
        data.setAdd16(rs.getString(index++));
        data.setAdd17(rs.getString(index++));
        data.setAdd18(rs.getString(index++));
        data.setAdd19(rs.getString(index++));
        data.setAdd20(rs.getString(index++));
        data.setAdd21(rs.getString(index++));
        data.setAdd22(rs.getString(index++));
        data.setAdd23(rs.getString(index++));
        data.setAdd24(rs.getString(index++));
        data.setAdd25(rs.getString(index++));
        data.setAdd26(rs.getString(index++));
        data.setAdd27(rs.getString(index++));
        data.setAdd28(rs.getString(index++));
        data.setAdd29(rs.getString(index++));
        data.setAdd30(rs.getString(index++));
        data.setAddressCode(rs.getString(index++));
        data.setBaseSo(rs.getString(index++));
        data.setStatus(rs.getString(index++));
        data.setRemark1(rs.getString(index++));
        data.setRemark2(rs.getString(index++));
        data.setRemark3(rs.getString(index++));
        data.setPoH(rs.getString(index++));
        data.setFlag4(rs.getString(index++));
        data.setFlag5(rs.getString(index++));
        data.setRemakr4(rs.getString(index++));
        data.setRemakr5(rs.getString(index++));

        return data;
    }
}
