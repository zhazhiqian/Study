package com.example.summerpublicapi.bigclassify.dao.param;

import com.example.summerpublicapi.common.dto.UserInfo;
import lombok.Data;

@Data
public class BigClassifyUpdRequest extends UserInfo {


    private String bigClassifyId;
    // 修改后的状态：点击中止：3，点击启用：2：点击删除传9，如果为空，代表不改变状态仅仅修改名称及其备注
    private String updateStatus;

    private String remark;

    private String bigClassifyName;
}
