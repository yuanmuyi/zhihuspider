package com.yy.enums;

import lombok.Getter;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/5/9 16:07
 */
@Getter
public enum EsIndexAndTypeEnum {

    ZHIHU("es_index_zhihu","es_type_zhihu");

    private String index;

    private String type;

    EsIndexAndTypeEnum(String index, String type) {
        this.index = index;
        this.type = type;
    }
}
