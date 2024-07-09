package com.duynb.spring.crud.constant;

import org.springframework.beans.factory.annotation.Value;


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
    public static final String DELETE_CAU_THU_PROCEDURE = "xoa_cau_thu";

    //Duy
//    @Value("${app.response.get-by-id-success}")
//    public static String messageGetByIdSuccess;
    public static final String GET_BY_ID_SUCCESS_MESSAGE= "Success";
    public static final String GET_BY_ID_NOT_FOUND_MESSAGE= "Khong tim thay cau thu";
    public static final String FIND_BY_CLUB_QUERY = "call find_by_club(:clb, :pages, :size)";
    public static final String GET_BY_ID_QUERY = "Select ct from CauThu ct where ct.id = :id";
//    @Value("${app.exception.message.cau_thu}")
//    public static String getMessageUpdateCauThuWithNullValue;
    public static final String UPDATE_CAU_THU_WITH_NULL_VALUE_MESSAGE="cauThu must not be Null";
    public static final String CREATE_CAU_THU_WITH_NULL_VALUE_MESSAGE="cauThu must not be Null";
    public static final String STATUS_CODE_API_MODEL_NOTES ="Giá trị của mã HttpStatus";
    public static final String STATUS_CODE_API_MODEL_EXAMPLE ="200";
    public static final String CAU_THU_CONTROLLER_API_VALUE = "Quản lý danh sách cầu thủ";
    public static final String CAU_THU_CONTROLLER_API_DESCRIPTION = "Các Api phục vụ crud liên quan tới cầu thủ và danh sách cầu thủ";
    public static final String GET_CAU_THU_BY_ID_API_OPERATION_VALUE= "Lấy thông tin chi tiết cầu thủ bằng id";
    public static final String GET_CAU_THU_BY_ID_API_PARAM_VALUE= "Id của cầu thủ muốn lấy thông tin";
    public static final String GET_CAU_THU_BY_ID_API_PARAM_EXAMPLE= "1";

//    Entity constant
    public static final String ENTITY_TABLE_NAME = "cau_thu";
    public static final String ENTITY_COLUMN_HOTEN = "ho_ten";
    public static final String ENTITY_COLUMN_NAMSINH = "nam_sinh";
    public static final String ENTITY_COLUMN_VITRI = "vi_tri";
    public static final String ENTITY_COLUMN_SOAO = "so_ao";
    public static final String ENTITY_COLUMN_CAULACBO = "cau_lac_bo";
    public static final String ENTITY_COLUMN_QUOCTICH = "quoc_tich";
    public static final String ENTITY_COLUMN_THOIHANHOPDONG = "thoi_han_hop_dong";
    public static final String ENTITY_COLUMN_LUONG = "luong";
    public static final String ENTITY_COLUMN_NULLPOINTER_HOTEN = "hoTen must not be Null";
    public static final String ENTITY_COLUMN_NULLPOINTER_NAMSINH = "namSinh must not be Null";
    public static final String ENTITY_COLUMN_NULLPOINTER_VITRI = "viTri must not be Null";
    public static final String ENTITY_COLUMN_NULLPOINTER_SOAO = "soAo must not be Null";
    public static final String ENTITY_COLUMN_NULLPOINTER_CAULACBO = "cauLacBo must not be Null";
    public static final String ENTITY_COLUMN_NULLPOINTER_QUOCTICH = "quocTich must not be Null";
    public static final String ENTITY_COLUMN_NULLPOINTER_THOIHANHOPDONG = "thoiHanHopDong must not be Null";
    public static final String ENTITY_COLUMN_NULLPOINTER_LUONG = "luong must not be Null";

}
