package com.example.summerpublicapi.bigclassify.mapper;


import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyAddParam;
import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyQueryRequest;
import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyUpdRequest;
import com.example.summerpublicapi.bigclassify.dao.result.BigClassifyQueryResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BigClassifyMapper {

    List<BigClassifyQueryResponse> queryBigClassify(@Param("request") BigClassifyQueryRequest request, @Param("list") List<String> status);

    int addBigClassify(@Param("param") BigClassifyAddParam param);

    int updateBigClassify(@Param("param")  BigClassifyUpdRequest request);
}
