package com.example.summerpublicapi.bigclassify.dao.param;

import com.example.summerpublicapi.common.dto.UserInfo;
import lombok.Data;


@Data
public class BigClassifyAddParam extends UserInfo {


    private String  bigClassifyName;

    private String remark;




}
