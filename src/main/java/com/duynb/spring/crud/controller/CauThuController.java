package com.duynb.spring.crud.controller;

import com.duynb.spring.crud.constant.MainConstants;
import com.duynb.spring.crud.dto.ResponseStructure;
import com.duynb.spring.crud.entity.CauThu;
import com.duynb.spring.crud.service.CauThuService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cau-thu")
// Lớp controller tạo các api crud cho bảng cầu thủ
public class CauThuController {
    private final CauThuService cauThuService;

    public CauThuController(CauThuService cauThuService) {
        this.cauThuService = cauThuService;
    }
    @GetMapping("/all")
    // Tùng -- phương thức lấy toàn bộ danh sách cầu thủ
    // input: thứ tự page và độ dài page
    // output: trang danh sách cầu thủ yêu cầu
    public ResponseStructure<Page<CauThu>> showAll(@RequestParam(defaultValue = MainConstants.FIRST_PAGE) Integer page,
                                                   @RequestParam(defaultValue = MainConstants.SIZE_PAGE) Integer size){
        return cauThuService.getAllCauThu(page,size);
    }
    @DeleteMapping("/delete/{id}")
    // Tùng -- phương thức xóa cầu thủ với đầu vào id và đầu ra là kết quả xóa
    public ResponseStructure<CauThu> deleteCauThu(@PathVariable Long id){
        return cauThuService.deleteCauThu(id);
    }
    @PostMapping("/add")
    // Tùng -- phương thức thêm cầu thủ với đầu vào là đối tượng CauThu
    public  ResponseStructure<CauThu> addCauThu(@RequestBody CauThu cauThu){
        return cauThuService.addCauThu(cauThu);
    }

    //Duy -- phương thức lấy thông tin chi tiết cầu thủ với đầu vào là id cầu thủ
    @GetMapping("/{id}")
    public ResponseStructure<CauThu> getCauThuById(@PathVariable Long id){
        return cauThuService.getCauThuById(id);
    }

    // Duy -- phương thức tìm danh sách cầu thủ chung câu lạc bộ
    // input -- tên câu lạc bộ, thứ tự page và độ dài page
    // output -- page cầu thủ đc yêu cầu
    @GetMapping()
    public ResponseStructure<List<CauThu>> getCauThuByCauLacBo(
            @RequestParam(value = "club", defaultValue = "") String club,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        return cauThuService.getCauThuByCauLacBo(club, page, size);
    }

    // Duy -- phương thức cập nhật thông tin cầu thủ với đầu vào là đối tượng CauThu với thông tin mới
    @PutMapping
    public ResponseStructure<CauThu> updateCauThu(@RequestBody CauThu cauThu){
        return cauThuService.updateCauThu(cauThu);
    }
}
