package com.duynb.spring.crud.service;

import com.duynb.spring.crud.constant.MainConstants;
import com.duynb.spring.crud.dto.response.ResponseWithCollectionDto;
import com.duynb.spring.crud.dto.response.ResponseWithObjectDto;
import com.duynb.spring.crud.dto.response.ResponseWithPageDto;
import com.duynb.spring.crud.entity.CauThu;
import com.duynb.spring.crud.exception.NullValueInputException;
import com.duynb.spring.crud.repository.CauThuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
// Lớp làm rõ các phương thức xử lý request
public class CauThuServiceImpl implements CauThuService {
    public final CauThuRepository cauThuRepository;

    public CauThuServiceImpl(CauThuRepository cauThuRepository) {
        this.cauThuRepository = cauThuRepository;
    }

    //Tùng
    //hiển thị danh sách cầu thủ
    //đầu vào số trang (page) và kích thước trang (size)
    //đầu ra danh sách cầu thủ theo số trang và kích thước trang
    @Override
    public ResponseWithPageDto<Page<CauThu>> getAllCauThu(Integer page, Integer size){
        Page<CauThu> cauThuPage = cauThuRepository.findAll(PageRequest.of(page,size));
        ResponseWithPageDto<Page<CauThu>> response = new ResponseWithPageDto<>(HttpStatus.OK.value(), MainConstants.MESSANGER_SUCCESS,cauThuPage);
        return response;
    }
    //Tùng
    // Thêm cầu thủ mới vào danh sách
    // đầu vào là thông tín đối tượng cauThu mới
    // đầu ra trả về danh sách cauThu mới
    @Override
    public ResponseWithObjectDto<CauThu> addCauThu(CauThu cauThuNew){
        List<CauThu> cauThuList = cauThuRepository.findAll();
        // kiểm tra dữ liệu input nhập vào
        if(Objects.isNull(cauThuNew)){
            throw new NullValueInputException(MainConstants.CREATE_CAU_THU_WITH_NULL_VALUE_MESSAGE);
        }

        // Kiểm tra nếu cầu thủ mới có thông tin trùng lặp với bất kỳ cầu thủ nào đã tồn tại
        for (CauThu cauThu : cauThuList) {
            if (cauThu.getId().equals(cauThuNew.getId())) {
                return  new ResponseWithObjectDto<>(HttpStatus.BAD_REQUEST.value(),MainConstants.ADD_ERROR_DUPLICATE,null);
            }
        }
            cauThuRepository.save(cauThuNew);
            return new ResponseWithObjectDto<>(HttpStatus.OK.value(), MainConstants.DATA_MESSAGER, cauThuNew);

    }
    @Override
    public ResponseWithObjectDto<CauThu> deleteCauThu(Long id){
        CauThu cauThu = cauThuRepository.findCauThuById(id);
        if(!Objects.isNull(cauThu) && !Objects.isNull(cauThu.getId())) {
            cauThuRepository.xoaCauThuProc(id);
            ResponseWithObjectDto<CauThu> response = new ResponseWithObjectDto<>(HttpStatus.OK.value(),MainConstants.DATA_MESSAGER,cauThu);
            return response;
        }else {
            ResponseWithObjectDto<CauThu> response = new ResponseWithObjectDto<>(HttpStatus.NOT_FOUND.value(), MainConstants.DELETE_ERROR_NOT_FOUND,null);
            return response;
        }
    }

    //Duy -- Lay thong tin chi tiet cau thu bang id
    @Override
    public ResponseWithObjectDto<CauThu> getCauThuById(Long id){
        CauThu cauThu = cauThuRepository.findCauThuById(id);
        if(!Objects.isNull(cauThu)){
            ResponseWithObjectDto<CauThu> response = new ResponseWithObjectDto<>(HttpStatus.OK.value(), MainConstants.GET_BY_ID_SUCCESS_MESSAGE,cauThu );
            return response;
        }else{
            ResponseWithObjectDto<CauThu> response = new ResponseWithObjectDto<>(HttpStatus.NOT_FOUND.value(), MainConstants.GET_BY_ID_NOT_FOUND_MESSAGE,cauThu );
            return response;
        }
    }

    //Duy -- Tim kiem cau thu theo cau lac bo
    // input -- tên câu lạc bộ, thứ tự page và độ dài page
    // output -- page cầu thủ đc yêu cầu
    @Override
    public ResponseWithCollectionDto<List<CauThu>> getCauThuByCauLacBo(String club, Integer page, Integer size){
        List<CauThu> cauThus = cauThuRepository.findByClub(club, page, size);
        ResponseWithCollectionDto<List<CauThu>> response = new ResponseWithCollectionDto<>(HttpStatus.OK.value(), MainConstants.GET_BY_ID_SUCCESS_MESSAGE, cauThus);
        return response;
    }

    // Duy -- phương thức cập nhật thông tin cầu thủ với đầu vào là đối tượng CauThu với thông tin mới
    @Override
    public ResponseWithObjectDto<CauThu> updateCauThu(CauThu cauThu){
        if(Objects.isNull(cauThu)){
            throw new NullValueInputException(MainConstants.UPDATE_CAU_THU_WITH_NULL_VALUE_MESSAGE);
        }
        CauThu currentCauThu = cauThuRepository.findCauThuById(cauThu.getId());
        if(!Objects.isNull(currentCauThu)){
            CauThu updatedCauthu = cauThuRepository.save(cauThu);
            ResponseWithObjectDto<CauThu> response = new ResponseWithObjectDto<>(HttpStatus.OK.value(), MainConstants.GET_BY_ID_SUCCESS_MESSAGE,updatedCauthu );
            return response;
        }else{
            ResponseWithObjectDto<CauThu> response = new ResponseWithObjectDto<>(HttpStatus.NOT_FOUND.value(), MainConstants.GET_BY_ID_NOT_FOUND_MESSAGE,null );
            return response;
        }
    }

}
