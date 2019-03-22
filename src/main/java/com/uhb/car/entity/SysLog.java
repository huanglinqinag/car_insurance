package com.uhb.car.entity;


import javax.persistence.*;


@Entity
@Table(name = "sysLog", schema = "vehicle", catalog = "")
public class SysLog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "method")
    private String method;
    @Basic
    @Column(name = "logType")
    private Integer logType;
    @Basic
    @Column(name = "requestIp")
    private String requestIp;
    @Basic
    @Column(name = "exceptionCode")
    private String exceptionCode;
    @Basic
    @Column(name = "exceptionDetail")
    private String exceptionDetail;
    @Basic
    @Column(name = "params")
    private String params;
    @Basic
    @Column(name = "createBy")
    private String createBy;
    @Basic
    @Column(name = "createDate")
    private String createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
