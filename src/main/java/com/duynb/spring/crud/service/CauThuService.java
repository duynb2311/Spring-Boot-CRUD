package com.duynb.spring.crud.service;

import com.duynb.spring.crud.constant.MainConstants;
import com.duynb.spring.crud.dto.ResponseStructure;
import com.duynb.spring.crud.entity.CauThu;
import com.duynb.spring.crud.repository.CauThuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class CauThuService {
    public final CauThuRepository cauThuRepository;

    public CauThuService(CauThuRepository cauThuRepository) {
        this.cauThuRepository = cauThuRepository;
    }
    public ResponseStructure<Page<CauThu>> getAllCauThu(Integer page,Integer size){
        Page<CauThu> cauThuPage = cauThuRepository.findAll(PageRequest.of(page,size));
        ResponseStructure<Page<CauThu>> response = new ResponseStructure<>(HttpStatus.OK.value(), MainConstants.MESSANGER_SUCCESS,cauThuPage);
        return response;
    }
    public ResponseStructure<String> addCauThu(CauThu cauThuNew){
        List<CauThu> cauThuList = cauThuRepository.findAll();

        // Kiểm tra nếu cầu thủ mới có thông tin trùng lặp với bất kỳ cầu thủ nào đã tồn tại
        for (CauThu cauThu : cauThuList) {
            if (cauThu.getId().equals(cauThuNew.getId())) {
                return new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), MainConstants.ERROR, MainConstants.ADD_ERROR_DUPLICATE);
            }
        }

        // Kiểm tra các trường thông tin của cầu thủ mới
        boolean check = false;
        if (cauThuNew.getHoTen() == null || cauThuNew.getHoTen().isEmpty()) {
            check = true;
        }
        if (cauThuNew.getNamSinh() == null) {
            check = true;
        }
        if (cauThuNew.getViTri() == null) {
            check = true;
        }
        if (cauThuNew.getSoAo() == null) {
            check = true;
        }
        if (cauThuNew.getCauLacBo() == null || cauThuNew.getCauLacBo().isEmpty()) {
            check = true;
        }
        if (cauThuNew.getQuocTich() == null || cauThuNew.getQuocTich().isEmpty()) {
            check = true;
        }
        if (cauThuNew.getThoiHanHopDong() == null) {
            check = true;
        }
        if (cauThuNew.getLuong() == null || cauThuNew.getLuong().compareTo(BigDecimal.ZERO) < 0) {
            check = true;
        }
        if (check) {
            return new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), MainConstants.ERROR, MainConstants.ADD_ERROR_NULLPOINTER);
        }
            // Lưu cầu thủ mới vào cơ sở dữ liệu
            cauThuRepository.save(cauThuNew);
            return new ResponseStructure<>(HttpStatus.OK.value(), MainConstants.MESSANGER_SUCCESS, MainConstants.DATA_MESSAGER);


    }
    public ResponseStructure<String> deleteCauThu(Long id){
        CauThu cauThu = cauThuRepository.findCauThuById(id);
        if(cauThu != null && cauThu.getId() != null) {
            cauThuRepository.xoaCauThuProc(id);
            ResponseStructure<String> response = new ResponseStructure<>(HttpStatus.OK.value(), MainConstants.MESSANGER_SUCCESS,MainConstants.DATA_MESSAGER);
            return response;
        }else {
            ResponseStructure<String> response = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), MainConstants.ERROR,MainConstants.DELETE_ERROR_NOT_FOUND);
            return response;
        }
    }

}
