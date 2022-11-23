package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class SorterJob {

    private String id;

    private String resrce;

    private String actionName;

    private String sfcs;

    private String sorterPlanId;

    private String mqMessage;

    private String result;

    private String cdmMessage;

    private Date createdTime;

    private Date completeTime;

    private String eapMessage;

    private String sendMessageToCdm;


    public SorterJob() {
        this.id = UUID.randomUUID().toString();
    }


    public SorterJob(SorterJob data) {
        this.id = data.id;
        this.resrce = data.resrce;
        this.actionName = data.actionName;
        this.sfcs = data.sfcs;
        this.sorterPlanId = data.sorterPlanId;
        this.mqMessage = data.mqMessage;
        this.result = data.result;
        this.createdTime = data.createdTime;
        this.completeTime = data.completeTime;
        this.eapMessage = data.getEapMessage();
        this.sendMessageToCdm = data.getSendMessageToCdm();
    }


    @Override
    public SorterJob clone() {
        return new SorterJob(this);
    }

    public String getEapMessage() {
        return eapMessage;
    }

    public void setEapMessage(String eapMessage) {
        this.eapMessage = eapMessage;
    }

    public String getSendMessageToCdm() {
        return sendMessageToCdm;
    }

    public void setSendMessageToCdm(String sendMessageToCdm) {
        this.sendMessageToCdm = sendMessageToCdm;
    }

    @Override
    public String toString() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResrce() {
        return resrce;
    }

    public void setResrce(String resrce) {
        this.resrce = resrce;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getSfcs() {
        return sfcs;
    }

    public void setSfcs(String sfcs) {
        this.sfcs = sfcs;
    }

    public String getSorterPlanId() {
        return sorterPlanId;
    }

    public void setSorterPlanId(String sorterPlanId) {
        this.sorterPlanId = sorterPlanId;
    }

    public String getMqMessage() {
        return mqMessage;
    }

    public void setMqMessage(String mqMessage) {
        this.mqMessage = mqMessage;
    }

    public String getCdmMessage() {
        return cdmMessage;
    }

    public void setCdmMessage(String cdmMessage) {
        this.cdmMessage = cdmMessage;
    }

    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

}
