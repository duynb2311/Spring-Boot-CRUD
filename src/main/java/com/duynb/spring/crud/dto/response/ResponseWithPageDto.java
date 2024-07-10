package com.duynb.spring.crud.dto.response;

import com.duynb.spring.crud.constant.MainConstants;
import com.duynb.spring.crud.dto.ICauThuManagerDto;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

public class ResponseWithPageDto<T extends Page<? extends ICauThuManagerDto>> {
    @ApiModelProperty(notes = MainConstants.STATUS_CODE_API_MODEL_NOTES, example =MainConstants.STATUS_CODE_API_MODEL_EXAMPLE )
    private int statusCode;
    @ApiModelProperty(example = MainConstants.MESSAGE_EXAMPLE)
    private String message;
    private T data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseWithPageDto() {
    }

    public ResponseWithPageDto(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}
