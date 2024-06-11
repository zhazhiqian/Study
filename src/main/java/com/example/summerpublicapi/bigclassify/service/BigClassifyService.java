package com.example.summerpublicapi.bigclassify.service;

import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyQueryRequest;
import com.example.summerpublicapi.bigclassify.dao.result.BigClassifyQueryResponse;
import com.example.summerpublicapi.bigclassify.mapper.BigClassifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BigClassifyService {

    @Resource
    BigClassifyMapper mapper;

    public List<BigClassifyQueryResponse> queryBigClassify(BigClassifyQueryRequest request, List<String> status){

        return mapper.queryBigClassify(request, status);
    }

}
