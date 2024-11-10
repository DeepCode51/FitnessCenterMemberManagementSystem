package com.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "liuyanfankui")
public class Liuyanfankui implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "liuyanneirong")
    private String liuyanneirong;

    @Column(name = "liuyanren")
    private String liuyanren;

    @Column(name = "liuyanriqi")
    private String liuyanriqi;

    @Column(name = "zhuangtai")
    private String zhuangtai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLiuyanneirong() {
        return liuyanneirong;
    }

    public void setLiuyanneirong(String liuyanneirong) {
        this.liuyanneirong = liuyanneirong;
    }

    public String getLiuyanren() {
        return liuyanren;
    }

    public void setLiuyanren(String liuyanren) {
        this.liuyanren = liuyanren;
    }

    public String getLiuyanriqi() {
        return liuyanriqi;
    }

    public void setLiuyanriqi(String liuyanriqi) {
        this.liuyanriqi = liuyanriqi;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
}
