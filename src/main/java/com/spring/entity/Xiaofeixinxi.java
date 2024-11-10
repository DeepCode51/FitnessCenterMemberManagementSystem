package com.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "xiaofeixinxi")
public class Xiaofeixinxi implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "huiyuankaid")
    private Integer huiyuankaid;

    @Column(name = "zhanghao")
    private String zhanghao;

    @Column(name = "xingming")
    private String xingming;

    @Column(name = "huiyuankahao")
    private String huiyuankahao;

    @Column(name = "xiaofeijine")
    private Double xiaofeijine;

    @Column(name = "xiaofeixiangmu")
    private String xiaofeixiangmu;

    @Column(name = "xiaofeiriqi")
    private String xiaofeiriqi;

    @Column(name = "beizhu")
    private String beizhu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHuiyuankaid() {
        return huiyuankaid;
    }

    public void setHuiyuankaid(Integer huiyuankaid) {
        this.huiyuankaid = huiyuankaid;
    }

    public String getZhanghao() {
        return zhanghao;
    }

    public void setZhanghao(String zhanghao) {
        this.zhanghao = zhanghao;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getHuiyuankahao() {
        return huiyuankahao;
    }

    public void setHuiyuankahao(String huiyuankahao) {
        this.huiyuankahao = huiyuankahao;
    }

    public Double getXiaofeijine() {
        return xiaofeijine;
    }

    public void setXiaofeijine(Double xiaofeijine) {
        this.xiaofeijine = xiaofeijine;
    }

    public String getXiaofeixiangmu() {
        return xiaofeixiangmu;
    }

    public void setXiaofeixiangmu(String xiaofeixiangmu) {
        this.xiaofeixiangmu = xiaofeixiangmu;
    }

    public String getXiaofeiriqi() {
        return xiaofeiriqi;
    }

    public void setXiaofeiriqi(String xiaofeiriqi) {
        this.xiaofeiriqi = xiaofeiriqi;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
}
