package com.duynb.spring.crud.constant;

import java.math.BigDecimal;

public class MainConstants {

    // Tung
    public static final String MESSANGER_SUCCESS = "ok";
    public static final String DATA_MESSAGER = "success";
    public static final String ERROR = "error";
    public static final String ADD_ERROR_DUPLICATE = "cầu thủ đã tồn tại";
    public static final String ADD_ERROR_NULLPOINTER = "thông tin cầu thủ không hợp lệ";
    public static final String DELETE_ERROR_NOT_FOUND ="cầu thủ không tồn tại";
    public static  final String FIND_CAU_THU_BY_ID = "select ct from CauThu ct where ct.id = ?1";
    public static final String FIRST_PAGE = "0";
    public static final String SIZE_PAGE = "5";

    //Duy
    public static final String GET_BY_ID_SUCCESS_MESSAGE= "Success";
    public static final String GET_BY_ID_NOT_FOUND_MESSAGE= "Khong tim thay cau thu";
    public static final String FIND_BY_CLUB_QUERY = "call find_by_club(:clb, :pages, :size)";
    public static final String GET_BY_ID_QUERY = "Select ct from CauThu ct where ct.id = :id";
}
