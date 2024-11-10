package com.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "fankuihuifu")
public class Fankuihuifu implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "liuyanfankuiid")
    private Integer liuyanfankuiid;

    @Column(name = "liuyanren")
    private String liuyanren;

    @Column(name = "huifuneirong")
    private String huifuneirong;

    @Column(name = "huifuren")
    private String huifuren;

    @Column(name = "huifuriqi")
    private String huifuriqi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLiuyanfankuiid() {
        return liuyanfankuiid;
    }

    public void setLiuyanfankuiid(Integer liuyanfankuiid) {
        this.liuyanfankuiid = liuyanfankuiid;
    }

    public String getLiuyanren() {
        return liuyanren;
    }

    public void setLiuyanren(String liuyanren) {
        this.liuyanren = liuyanren;
    }

    public String getHuifuneirong() {
        return huifuneirong;
    }

    public void setHuifuneirong(String huifuneirong) {
        this.huifuneirong = huifuneirong;
    }

    public String getHuifuren() {
        return huifuren;
    }

    public void setHuifuren(String huifuren) {
        this.huifuren = huifuren;
    }

    public String getHuifuriqi() {
        return huifuriqi;
    }

    public void setHuifuriqi(String huifuriqi) {
        this.huifuriqi = huifuriqi;
    }
}
