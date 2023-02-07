package nt.bek.uzumnt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseDTO<T> {
    private Boolean succes;
    private Integer code;
    private String message;
    private T data;
}


