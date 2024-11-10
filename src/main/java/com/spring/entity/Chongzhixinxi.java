package com.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "chongzhixinxi")
public class Chongzhixinxi implements Serializable {

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

    @Column(name = "chongzhijine")
    private Double chongzhijine;

    @Column(name = "chongzhiriqi")
    private String chongzhiriqi;

    @Column(name = "chongzhiren")
    private String chongzhiren;

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

    public Double getChongzhijine() {
        return chongzhijine;
    }

    public void setChongzhijine(Double chongzhijine) {
        this.chongzhijine = chongzhijine;
    }

    public String getChongzhiriqi() {
        return chongzhiriqi;
    }

    public void setChongzhiriqi(String chongzhiriqi) {
        this.chongzhiriqi = chongzhiriqi;
    }

    public String getChongzhiren() {
        return chongzhiren;
    }

    public void setChongzhiren(String chongzhiren) {
        this.chongzhiren = chongzhiren;
    }
}
