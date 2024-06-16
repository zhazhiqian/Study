package com.example.summerpublicapi.bigclassify.service;

import com.example.summerpublicapi.Enum.BigClassifyStatusEnum;
import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyAddParam;
import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyQueryRequest;
import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyUpdRequest;
import com.example.summerpublicapi.bigclassify.dao.result.BigClassifyQueryResponse;
import com.example.summerpublicapi.bigclassify.mapper.BigClassifyMapper;
import com.example.summerpublicapi.returndto.ReturnDto;
import com.example.summerpublicapi.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BigClassifyService {

    @Resource
    BigClassifyMapper mapper;

    public List<BigClassifyQueryResponse> queryBigClassify(BigClassifyQueryRequest request, List<String> status){

        return mapper.queryBigClassify(request, status);
    }

    /**
     * 新增大分类
     * @param param
     * @return
     */
    public String addBigClassify(BigClassifyAddParam param){
        // 大分类名称不允许为空
        String err = this.checkError(param);
        if(!StringUtils.isEmpty(err)){
            return err;
        }
        int i = mapper.addBigClassify(param);
        if(i<=0){
            return "新增失败，请联系管理员!";
        }else{
            return null;
        }
    }


    public String updateBigClassify(  BigClassifyUpdRequest request){
        int i = mapper.updateBigClassify(request);
        if(i<=0){
            return "修改失败，请联系管理员!";
        }else{
            return null;
        }
    }


    public String checkError(BigClassifyAddParam param){
        // 大分类名称不允许为空
        if(param == null || StringUtils.isEmpty(param.getBigClassifyName())){
            return "大分类名称不允许为空";
        }
        List<String> selectStatus = new ArrayList<>();
        selectStatus.add(BigClassifyStatusEnum.drafter.getCode());
        selectStatus.add(BigClassifyStatusEnum.normal.getCode());
        selectStatus.add(BigClassifyStatusEnum.abort.getCode());
        BigClassifyQueryRequest request = new BigClassifyQueryRequest();
        request.setEqualName(param.getBigClassifyName());
        // 首先需要判断当前大分类名称是否有正在使用的（草稿、中止、正常
        List<BigClassifyQueryResponse> bigClassifyQueryResponses = mapper.queryBigClassify(request, selectStatus);
        if(bigClassifyQueryResponses != null && bigClassifyQueryResponses.size() > 0){
            return "当前数据已存在，请更改大分类名";
        }
        return "";
    }

}
