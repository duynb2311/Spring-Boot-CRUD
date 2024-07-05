package com.duynb.spring.crud.service;

import com.duynb.spring.crud.dto.ResponseStructure;
import com.duynb.spring.crud.entity.CauThu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CauThuService {
    ResponseStructure<String> deleteCauThu(Long id);
    ResponseStructure<Page<CauThu>> getAllCauThu(Integer page, Integer size);
    ResponseStructure<String> addCauThu(CauThu cauThuNew);
    ResponseStructure<CauThu> getCauThuById(Long id);

    ResponseStructure<List<CauThu>> getCauThuByCauLacBo(String club, Integer page, Integer size);

    ResponseStructure<CauThu> updateCauThu(CauThu cauThu);
}
