package com.duynb.spring.crud.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
// Lớp ánh xạ đối tượng CauThu sang bảng cau_thu trên mysql
public class CauThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "hoTen is not null")
    @Column(name = "ho_ten")
    private String hoTen;
    @NotNull(message = "namSinh is not null")
    @Temporal(TemporalType.DATE)
    @Column(name = "nam_sinh")
    private Date namSinh;
    @NotNull(message = "viTri is not null")
    @Column(name = "vi_tri")
    private String viTri;
    @NotNull(message = "soAo is not null")
    @Column(name = "so_ao")
    private Integer soAo;
    @NotNull(message = "cauLacBo is not null")
    @Column(name = "cau_lac_bo")
    private String cauLacBo;
    @NotNull(message = "quocTich is not null")
    @Column(name = "quoc_tich")
    private String quocTich;
    @NotNull(message = "thoiHanHopDong is not null")
    @Temporal(TemporalType.DATE)
    @Column(name = "thoi_han_hop_dong")
    private Date thoiHanHopDong;
    @NotNull(message = "luon is not null")
    @Column(name = "luong")
    private BigDecimal luong;

    public Long getId() {
        return id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public Integer getSoAo() {
        return soAo;
    }

    public void setSoAo(Integer soAo) {
        this.soAo = soAo;
    }

    public String getCauLacBo() {
        return cauLacBo;
    }

    public void setCauLacBo(String cauLacBo) {
        this.cauLacBo = cauLacBo;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public Date getThoiHanHopDong() {
        return thoiHanHopDong;
    }

    public void setThoiHanHopDong(Date thoiHanHopDong) {
        this.thoiHanHopDong = thoiHanHopDong;
    }

    public BigDecimal getLuong() {
        return luong;
    }

    public void setLuong(BigDecimal luong) {
        this.luong = luong;
    }

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
