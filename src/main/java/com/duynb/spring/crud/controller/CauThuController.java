package com.duynb.spring.crud.controller;

import com.duynb.spring.crud.constant.MainConstants;
import com.duynb.spring.crud.dto.ResponseStructure;
import com.duynb.spring.crud.entity.CauThu;
import com.duynb.spring.crud.service.CauThuService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cau-thu")
public class CauThuController {
    private CauThuService cauThuService;

    public CauThuController(CauThuService cauThuService) {
        this.cauThuService = cauThuService;
    }
    @GetMapping("/all")
    public ResponseStructure<Page<CauThu>> showAll(@RequestParam(defaultValue = MainConstants.FIRST_PAGE) Integer page,
                                                   @RequestParam(defaultValue = MainConstants.SIZE_PAGE) Integer size){
        return cauThuService.getAllCauThu(page,size);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseStructure<String> deleteCauThu(@PathVariable Long id){
        return cauThuService.deleteCauThu(id);
    }
    @PostMapping("/add")
    public  ResponseStructure<String> addCauThu(@RequestBody CauThu cauThu){
        return cauThuService.addCauThu(cauThu);
    }
}
