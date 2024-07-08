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
import java.util.List;

@Service
public class CauThuServiceImpl implements CauThuService {
    public final CauThuRepository cauThuRepository;

    public CauThuServiceImpl(CauThuRepository cauThuRepository) {
        this.cauThuRepository = cauThuRepository;
    }

    //Tung
    @Override
    public ResponseStructure<Page<CauThu>> getAllCauThu(Integer page,Integer size){
        Page<CauThu> cauThuPage = cauThuRepository.findAll(PageRequest.of(page,size));
        ResponseStructure<Page<CauThu>> response = new ResponseStructure<>(HttpStatus.OK.value(), MainConstants.MESSANGER_SUCCESS,cauThuPage);
        return response;
    }
    @Override
    public ResponseStructure<CauThu> addCauThu(CauThu cauThuNew){
        List<CauThu> cauThuList = cauThuRepository.findAll();

        // Kiểm tra nếu cầu thủ mới có thông tin trùng lặp với bất kỳ cầu thủ nào đã tồn tại
        for (CauThu cauThu : cauThuList) {
            if (cauThu.getId().equals(cauThuNew.getId())) {
                return  new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(),MainConstants.ADD_ERROR_DUPLICATE,null);
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
        if (cauThuNew.getViTri() == null||cauThuNew.getViTri().isEmpty()) {
            check = true;
        }
        if (cauThuNew.getSoAo() == null||cauThuNew.getSoAo()<0) {
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
            return new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(),MainConstants.ADD_ERROR_NULLPOINTER,null);
        }
            // Lưu cầu thủ mới vào cơ sở dữ liệu
            cauThuRepository.save(cauThuNew);
            return new ResponseStructure<>(HttpStatus.OK.value(), MainConstants.DATA_MESSAGER,cauThuNew);
    }
    @Override
    public ResponseStructure<CauThu> deleteCauThu(Long id){
        CauThu cauThu = cauThuRepository.findCauThuById(id);
        if(cauThu != null && cauThu.getId() != null) {
            cauThuRepository.xoaCauThuProc(id);
            ResponseStructure<CauThu> response = new ResponseStructure<>(HttpStatus.OK.value(),MainConstants.DATA_MESSAGER,cauThu);
            return response;
        }else {
            ResponseStructure<CauThu> response = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), MainConstants.DELETE_ERROR_NOT_FOUND,null);
            return response;
        }
    }

    //Duy -- Lay thong tin chi tiet cau thu bang id
    @Override
    public ResponseStructure<CauThu> getCauThuById(Long id){
        CauThu cauThu = cauThuRepository.getById(id);
        if(cauThu!= null){
            ResponseStructure<CauThu> response = new ResponseStructure<>(HttpStatus.OK.value(), MainConstants.GET_BY_ID_SUCCESS_MESSAGE,cauThu );
            return response;
        }else{
            ResponseStructure<CauThu> response = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), MainConstants.GET_BY_ID_NOT_FOUND_MESSAGE,cauThu );
            return response;
        }
    }

    //Duy -- Tim kiem cau thu theo cau lac bo
    @Override
    public ResponseStructure<List<CauThu>> getCauThuByCauLacBo(String club, Integer page, Integer size){
        List<CauThu> cauThus = cauThuRepository.findByClub(club, page, size);
        ResponseStructure<List<CauThu>> response = new ResponseStructure<>(HttpStatus.OK.value(), MainConstants.GET_BY_ID_SUCCESS_MESSAGE, cauThus);
        return response;
    }

    //Duy -- Cap nhat toan phan thong tin cau thu
    @Override
    public ResponseStructure<CauThu> updateCauThu(CauThu cauThu){
        CauThu currentCauThu = cauThuRepository.getById(cauThu.getId());
        if(currentCauThu!= null){
            CauThu updatedCauthu = cauThuRepository.save(cauThu);
            ResponseStructure<CauThu> response = new ResponseStructure<>(HttpStatus.OK.value(), MainConstants.GET_BY_ID_SUCCESS_MESSAGE,updatedCauthu );
            return response;
        }else{
            ResponseStructure<CauThu> response = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), MainConstants.GET_BY_ID_NOT_FOUND_MESSAGE,null );
            return response;
        }
    }

}
