package com.duynb.spring.crud.repository;

import com.duynb.spring.crud.constant.MainConstants;
import com.duynb.spring.crud.entity.CauThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// Lớp ánh xạ các truy vấn tới cơ sở dữ liệu
public interface CauThuRepository extends JpaRepository<CauThu,Long> {
    //Tung
    @Query(MainConstants.FIND_CAU_THU_BY_ID)
    CauThu findCauThuById(Long id);
    @Procedure("xoa_cau_thu")
    void xoaCauThuProc(@Param("id") Long id);

    //Duy
    @Query(MainConstants.GET_BY_ID_QUERY)
    CauThu getById(Long id);

    @Query(value = MainConstants.FIND_BY_CLUB_QUERY, nativeQuery = true)
    List<CauThu> findByClub(@Param("clb") String clb, @Param("pages") Integer pages, @Param("size") Integer page);
}
