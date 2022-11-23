package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Certification {

    private String handle;

    private BigDecimal changeStamp;

    private String site;

    private String certification;

    private String description;

    private BigDecimal renewalDays;

    private BigDecimal warningDays;

    private String warningAlarmBo;

    private String expirationAlarmBo;

    private String certificationTypeBo;

    private String durationType;

    private BigDecimal duration;

    private String durationUnits;

    private String statusBo;

    private BigDecimal numOfExtensions;

    private BigDecimal maxExtensionDuration;

    private String extensionUnits;

    private Date createdDateTime;

    private Date modifiedDateTime;


    public Certification() {
    }	

    public Certification(Certification data) {
        this.handle = data.handle;
        this.changeStamp = data.changeStamp;
        this.site = data.site;
        this.certification = data.certification;
        this.description = data.description;
        this.renewalDays = data.renewalDays;
        this.warningDays = data.warningDays;
        this.warningAlarmBo = data.warningAlarmBo;
        this.expirationAlarmBo = data.expirationAlarmBo;
        this.certificationTypeBo = data.certificationTypeBo;
        this.durationType = data.durationType;
        this.duration = data.duration;
        this.durationUnits = data.durationUnits;
        this.statusBo = data.statusBo;
        this.numOfExtensions = data.numOfExtensions;
        this.maxExtensionDuration = data.maxExtensionDuration;
        this.extensionUnits = data.extensionUnits;
        this.createdDateTime = data.createdDateTime;
        this.modifiedDateTime = data.modifiedDateTime;
    }	

    @Override
    public Certification clone() {
    	return new Certification(this);
    }

    @Override
    public String toString() {
        return this.handle;
    }
}
