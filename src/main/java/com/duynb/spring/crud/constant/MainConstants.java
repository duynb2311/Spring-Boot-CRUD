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
    public static final String GET_ALL_CAU_THU_API_OPERATION_VALUE = "Hiển thị danh sách cầu thủ theo page";
    public static final String GET_ALL_CAU_THU_SUCCESS_MESSAGE = "ok";
    public static final String DELETE_CAU_THU_API_OPERATION_VALUE = "Xóa cầu thủ theo id cầu thủ";
    public static final String DELETE_CAU_THU_SUCCESS_MESSAGE = "ok";
    public static final String DELETE_CAU_THU_NOT_FOUND_MESSAGE = "cầu thủ không tồn tại";

    //Duy
//    @Value("${app.response.get-by-id-success}")
//    public static String messageGetByIdSuccess;
    public static final String SUCCESS_MESSAGE= "Success";
    public static final String GET_BY_ID_NOT_FOUND_MESSAGE= "Cầu thủ không tồn tại";
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
    public static final String CREATE_CAU_THU_API_OPERATION_VALUE = "thêm mới thông tin một cầu thủ";
    public static final String CREATE_SUCCESS_MESSAGE = "success";
    public static final String CREATE_NO_CONTENT_MESSAGE = "không có dữ liệu nào trả về";
    public static final String CREATE_BAD_REQUEST_MESSAGE = "dữ liệu không hợp lệ";
    public static final String GET_CAU_THU_BY_CLB_API_OPERATION_VALUE= "Lấy danh sách cầu thủ theo câu lạc bộ";
    public static final String GET_CAU_THU_BY_CLB_API_PARAM1_VALUE= "tên của câu lạc bộ muốn tìm";
    public static final String GET_CAU_THU_BY_CLB_API_PARAM1_EXAMPLE= "Ha Noi";
    public static final String GET_CAU_THU_BY_CLB_API_PARAM2_VALUE= "Số thứ tự trang muốn lấy";
    public static final String GET_CAU_THU_BY_CLB_API_PARAM2_EXAMPLE= "1";
    public static final String GET_CAU_THU_BY_CLB_API_PARAM3_VALUE= "Độ dài danh sách của 1 trang";
    public static final String GET_CAU_THU_BY_CLB_API_PARAM3_EXAMPLE= "10";
    public static final String UPDATE_CAU_THU_API_OPERATION_VALUE= "Chỉnh sửa thông tin cầu thủ";
    public static final String UPDATE_CAU_THU_API_PARAM_VALUE= "Request body chứa thông tin mới của cầu thủ";
    public static final String CAU_THU_ID_EXAMPLE = "1";
    public static final String HO_TEN_CAU_THU_EXAMPLE = "Nguyen Ba Duy";
    public static final String NAM_SINH_CAU_THU_EXAMPLE = "1989-12-31";
    public static final String VI_TRI_CAU_THU_EXAMPLE = "Tien dao";
    public static final String SO_AO_CAU_THU_EXAMPLE = "10";
    public static final String CAU_LAC_BO_CAU_THU_EXAMPLE = "Ha Noi FC";
    public static final String QUOC_TICH_CAU_THU_EXAMPLE = "Vietnam";
    public static final String THOI_HAN_HOP_DONG_CAU_THU_EXAMPLE = "2025-12-30";
    public static final String LUONG_CAU_THU_EXAMPLE = "50000.00";
    public static final String MESSAGE_EXAMPLE = "Success";
    public static final String CLUB_PARAM_DEFAULT = "";
    public static final String API_GET_CAU_THU_BY_CLB_NOT_FOUND_MESSAGE = "Không tìm thấy cầu thủ nào phù hợp";

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
