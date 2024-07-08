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
public class CauThuController {
    private final CauThuService cauThuService;

    //Tung
    public CauThuController(CauThuService cauThuService) {
        this.cauThuService = cauThuService;
    }
    @GetMapping("/all")
    public ResponseStructure<Page<CauThu>> showAll(@RequestParam(defaultValue = MainConstants.FIRST_PAGE) Integer page,
                                                   @RequestParam(defaultValue = MainConstants.SIZE_PAGE) Integer size){
        return cauThuService.getAllCauThu(page,size);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseStructure<CauThu> deleteCauThu(@PathVariable Long id){
        return cauThuService.deleteCauThu(id);
    }
    @PostMapping("/add")
    public  ResponseStructure<CauThu> addCauThu(@RequestBody CauThu cauThu){
        return cauThuService.addCauThu(cauThu);
    }

    //Duy
    @GetMapping("/{id}")
    public ResponseStructure<CauThu> getCauThuById(@PathVariable Long id){
        return cauThuService.getCauThuById(id);
    }

    @GetMapping()
    public ResponseStructure<List<CauThu>> getCauThuByCauLacBo(
            @RequestParam(value = "club", defaultValue = "") String club,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        return cauThuService.getCauThuByCauLacBo(club, page, size);
    }

    @PutMapping
    public ResponseStructure<CauThu> updateCauThu(@RequestBody CauThu cauThu){
        return cauThuService.updateCauThu(cauThu);
    }
}
