package com.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "huiyuanka")
public class Huiyuanka implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "kehuid")
    private Integer kehuid;

    @Column(name = "zhanghao")
    private String zhanghao;

    @Column(name = "xingming")
    private String xingming;

    @Column(name = "huiyuankahao")
    private String huiyuankahao;

    @Column(name = "kayue")
    private Double kayue;

    @Column(name = "youxiaoriqi")
    private String youxiaoriqi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKehuid() {
        return kehuid;
    }

    public void setKehuid(Integer kehuid) {
        this.kehuid = kehuid;
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

    public Double getKayue() {
        return kayue;
    }

    public void setKayue(Double kayue) {
        this.kayue = kayue;
    }

    public String getYouxiaoriqi() {
        return youxiaoriqi;
    }

    public void setYouxiaoriqi(String youxiaoriqi) {
        this.youxiaoriqi = youxiaoriqi;
    }
}
