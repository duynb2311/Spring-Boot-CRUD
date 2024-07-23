package com.duynb.spring.crud.repository;

import com.duynb.spring.crud.constant.MainConstants;
import com.duynb.spring.crud.entity.CauThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
// Lớp ánh xạ các truy vấn tới cơ sở dữ liệu
public interface CauThuRepository extends JpaRepository<CauThu,Long> {
    //Tung -- tìm cầu thủ bằng id
    @Query(MainConstants.FIND_CAU_THU_BY_ID)
    CauThu findCauThuById(Long id);
    //Tung -- gọi procedure xóa cầu thủ
    @Procedure(MainConstants.DELETE_CAU_THU_PROCEDURE)
    void xoaCauThuProc(@Param("id") Long id);
    @Query("select ct from CauThu ct where ct.cauLacBo = ?1 and ct.soAo = ?2")
    List<CauThu> findCauThuByCauLacBoAndSoAo(String cauLacBo,Integer soAo);

    //Duy -- Gọi procedure tìm cầu thủ theo câu lạc bộ
    @Query(value = MainConstants.FIND_BY_CLUB_QUERY, nativeQuery = true)
    List<CauThu> findByClub(@Param("clb") String clb, @Param("pages") Integer pages, @Param("size") Integer page);
}
