package com.duynb.spring.crud.controller;

import com.duynb.spring.crud.constant.MainConstants;
import com.duynb.spring.crud.dto.response.ResponseWithCollectionDto;
import com.duynb.spring.crud.dto.response.ResponseWithObjectDto;
import com.duynb.spring.crud.dto.response.ResponseWithPageDto;
import com.duynb.spring.crud.entity.CauThu;
import com.duynb.spring.crud.service.CauThuService;
import io.swagger.annotations.*;
import org.jboss.jandex.Main;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = MainConstants.CAU_THU_CONTROLLER_API_VALUE, description = MainConstants.CAU_THU_CONTROLLER_API_DESCRIPTION)
@RestController
@RequestMapping("/api/v1/cau-thu")
// Lớp controller tạo các api crud cho bảng cầu thủ
public class CauThuController {
    private final CauThuService cauThuService;

    public CauThuController(CauThuService cauThuService) {
        this.cauThuService = cauThuService;
    }
    // Tùng -- phương thức lấy toàn bộ danh sách cầu thủ
    // input: thứ tự page và độ dài page
    // output: trang danh sách cầu thủ yêu cầu
    @ApiOperation(value = MainConstants.GET_ALL_CAU_THU_API_OPERATION_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = MainConstants.GET_ALL_CAU_THU_SUCCESS_MESSAGE),
            @ApiResponse(code = 404,message = MainConstants.GET_ALL_CAU_THU_NOT_FOUND_MESSAGE)
    })
    @GetMapping("/all")
    public ResponseEntity<ResponseWithPageDto<Page<CauThu>>> showAll(
            @RequestParam(defaultValue = MainConstants.FIRST_PAGE) Integer page,
            @RequestParam(defaultValue = MainConstants.SIZE_PAGE) Integer size
    ){
        ResponseWithPageDto<Page<CauThu>> response =  cauThuService.getAllCauThu(page,size);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatusCode()));
    }
    @ApiOperation(value = MainConstants.DELETE_CAU_THU_API_OPERATION_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = MainConstants.DELETE_CAU_THU_SUCCESS_MESSAGE),
            @ApiResponse(code = 404,message = MainConstants.DELETE_CAU_THU_NOT_FOUND_MESSAGE)
    })
    @DeleteMapping("/delete/{id}")
    // Tùng -- phương thức xóa cầu thủ với đầu vào id và đầu ra là kết quả xóa
    public ResponseEntity<ResponseWithObjectDto<CauThu>> deleteCauThu(@PathVariable Long id){
        ResponseWithObjectDto<CauThu> response = cauThuService.deleteCauThu(id);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatusCode()));
     }
    // Tùng -- phương thức thêm cầu thủ với đầu vào là đối tượng CauThu
    @ApiOperation(value = MainConstants.CREATE_CAU_THU_API_OPERATION_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = MainConstants.CREATE_SUCCESS_MESSAGE),
            @ApiResponse(code = 400,message = MainConstants.CREATE_BAD_REQUEST_MESSAGE)
    })
    @PostMapping("/add")
    public ResponseEntity<ResponseWithObjectDto<CauThu>> addCauThu(@RequestBody CauThu cauThu ){
        ResponseWithObjectDto<CauThu> response = cauThuService.addCauThu(cauThu);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    //Duy -- phương thức lấy thông tin chi tiết cầu thủ với đầu vào là id cầu thủ
    @ApiOperation(value = MainConstants.GET_CAU_THU_BY_ID_API_OPERATION_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = MainConstants.GET_BY_ID_SUCCESS_MESSAGE),
            @ApiResponse(code = 404, message = MainConstants.GET_BY_ID_NOT_FOUND_MESSAGE)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseWithObjectDto<CauThu>> getCauThuById(
            @ApiParam(value = MainConstants.GET_CAU_THU_BY_ID_API_PARAM_VALUE, example = MainConstants.GET_CAU_THU_BY_ID_API_PARAM_EXAMPLE) @PathVariable Long id
    ){
        ResponseWithObjectDto<CauThu> response= cauThuService.getCauThuById(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    // Duy -- phương thức tìm danh sách cầu thủ chung câu lạc bộ
    // input -- tên câu lạc bộ, thứ tự page và độ dài page
    // output -- page cầu thủ đc yêu cầu
    @GetMapping()
    public ResponseEntity<ResponseWithCollectionDto<List<CauThu>>> getCauThuByCauLacBo(
            @RequestParam(value = "club", defaultValue = "") String club,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = MainConstants.SIZE_PAGE) Integer size
    ){
        ResponseWithCollectionDto<List<CauThu>> response =cauThuService.getCauThuByCauLacBo(club, page, size);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    // Duy -- phương thức cập nhật thông tin cầu thủ với đầu vào là đối tượng CauThu với thông tin mới
    @PutMapping
    public ResponseEntity<ResponseWithObjectDto<CauThu>> updateCauThu(@RequestBody CauThu cauThu){
        ResponseWithObjectDto<CauThu> response= cauThuService.updateCauThu(cauThu);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatusCode()));
    }
}
