package com.ednipro.dniprotesttask.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RowModelResponseDto {
    private List<CellModelResponseDto> listResponseDto;
}
