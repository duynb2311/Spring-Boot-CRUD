package com.duynb.spring.crud.repository;

import com.duynb.spring.crud.entity.CauThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CauThuRepository extends JpaRepository<CauThu,Long> {
    @Query("select ct from CauThu ct where ct.id = ?1")
    CauThu findCauThuById(Long id);
    @Procedure("xoa_cau_thu")
    void xoaCauThuProc(@Param("id") Long id);
}
