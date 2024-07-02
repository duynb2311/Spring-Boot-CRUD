package com.duynb.spring.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class CauThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "nam_sinh")
    private Date namSinh;
    @Column(name = "vi_tri")
    private String viTri;
    @Column(name = "so_ao")
    private Integer soAo;
    @Column(name = "cau_lac_bo")
    private String cauLacBo;
    @Column(name = "quoc_tich")
    private String quocTich;
    @Column(name = "thoi_han_hop_dong")
    private Date thoiHanHopDong;
    @Column(name = "luong")
    private BigDecimal luong;

    public CauThu() {
    }

    public CauThu(Long id, String hoTen, Date namSinh, String viTri, Integer soAo, String cauLacBo, String quocTich, Date thoiHanHopDong, BigDecimal luong) {
        this.id = id;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.viTri = viTri;
        this.soAo = soAo;
        this.cauLacBo = cauLacBo;
        this.quocTich = quocTich;
        this.thoiHanHopDong = thoiHanHopDong;
        this.luong = luong;
    }

    public CauThu(String hoTen, Date namSinh, String viTri, Integer soAo, String cauLacBo, String quocTich, Date thoiHanHopDong, BigDecimal luong) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.viTri = viTri;
        this.soAo = soAo;
        this.cauLacBo = cauLacBo;
        this.quocTich = quocTich;
        this.thoiHanHopDong = thoiHanHopDong;
        this.luong = luong;
    }
}
