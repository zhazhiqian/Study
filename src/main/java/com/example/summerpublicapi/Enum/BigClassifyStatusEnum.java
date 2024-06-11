package com.example.summerpublicapi.Enum;

public enum BigClassifyStatusEnum {
    /**
     * 1-草稿2-正常启用3-中止9-删除
     */
    drafter("1","草稿"),
    normal("2","正常"),
    abort("3","中止"),
    delete("9","删除")
    ;

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    BigClassifyStatusEnum(String code,String name){
        this.code = code;
        this.name = name;
    }
}
