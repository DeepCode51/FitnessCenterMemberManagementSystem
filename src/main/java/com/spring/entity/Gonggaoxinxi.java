package com.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gonggaoxinxi")
public class Gonggaoxinxi implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "gonggaobianhao")
    private String gonggaobianhao;

    @Column(name = "gonggaobiaoti")
    private String gonggaobiaoti;

    @Column(name = "gonggaomiaoshu")
    private String gonggaomiaoshu;

    @Column(name = "faburiqi")
    private String faburiqi;

    @Column(name = "faburen")
    private String faburen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGonggaobianhao() {
        return gonggaobianhao;
    }

    public void setGonggaobianhao(String gonggaobianhao) {
        this.gonggaobianhao = gonggaobianhao;
    }

    public String getGonggaobiaoti() {
        return gonggaobiaoti;
    }

    public void setGonggaobiaoti(String gonggaobiaoti) {
        this.gonggaobiaoti = gonggaobiaoti;
    }

    public String getGonggaomiaoshu() {
        return gonggaomiaoshu;
    }

    public void setGonggaomiaoshu(String gonggaomiaoshu) {
        this.gonggaomiaoshu = gonggaomiaoshu;
    }

    public String getFaburiqi() {
        return faburiqi;
    }

    public void setFaburiqi(String faburiqi) {
        this.faburiqi = faburiqi;
    }

    public String getFaburen() {
        return faburen;
    }

    public void setFaburen(String faburen) {
        this.faburen = faburen;
    }
}
