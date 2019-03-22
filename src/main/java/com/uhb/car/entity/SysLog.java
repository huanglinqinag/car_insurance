package com.uhb.car.entity;

<<<<<<< HEAD
import javax.persistence.*;

=======
>>>>>>> origin/master
/**
 * @ClassName:日志实体类
 * @Author: hlq
 * @Date: 2019/3/21 19:21
 * @Version 1.0
 */
<<<<<<< HEAD
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


=======
public class SysLog {
    private Integer id;
    //日志描述
    private String description;
    //执行的方法
    private String method;
    //日志类型 0:操作日志 1:异常日志
    private Integer logType;
    //客户端请求的ip地址
    private String requestIp;
    //异常代码
    private String exceptionCode;
    //异常详细信息
    private String exceptionDetail;
    //请求参数
    private String params;
    //操作人
    private String createBy;
    //操作时间
    private String createDate;

>>>>>>> origin/master
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
