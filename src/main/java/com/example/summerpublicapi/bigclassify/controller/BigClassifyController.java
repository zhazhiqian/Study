package com.example.summerpublicapi.bigclassify.controller;

import com.example.summerpublicapi.Enum.BigClassifyStatusEnum;
import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyAddParam;
import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyQueryRequest;
import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyUpdRequest;
import com.example.summerpublicapi.bigclassify.dao.result.BigClassifyQueryResponse;
import com.example.summerpublicapi.bigclassify.service.BigClassifyService;
import com.example.summerpublicapi.returndto.ReturnDto;
import com.example.summerpublicapi.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bigClassifyController")
public class BigClassifyController {

    @Resource
    BigClassifyService bigClassifyService;
    /**
     * 大分类功能查询
     * @return
     */
    @PostMapping("/queryBigClassify")
    public ReturnDto queryBigClassify(@RequestBody BigClassifyQueryRequest param){
        List<BigClassifyQueryResponse> result = new ArrayList<>();
        // arrayList、linkedList/HashSet、HashMap
        List<String> selectStatus = new ArrayList<>();
        // 当前端页面不选择状态，默认查询所有状态
        if(StringUtils.isEmpty(param.getBigClassifyStatus())){
            selectStatus.add(BigClassifyStatusEnum.drafter.getCode());
            selectStatus.add(BigClassifyStatusEnum.normal.getCode());
            selectStatus.add(BigClassifyStatusEnum.abort.getCode());
        }else{
            selectStatus.add(param.getBigClassifyStatus());
        }
        result = bigClassifyService.queryBigClassify(param,selectStatus);
        return ReturnDto.success("请求成功",result);
    }

    /**
     * @符号后面跟英文叫注解
     * @param param
     * @return
     */
    @PostMapping(value = "/addBigClassify")
    public ReturnDto addBigClassify(@RequestBody BigClassifyAddParam param){
        String error = bigClassifyService.addBigClassify(param);
        if(!StringUtils.isEmpty(error)){
            return ReturnDto.error("501",error,null);
        }
        return ReturnDto.success("请求成功",null);
    }

    @PostMapping(value = "/updateBigClassify")
    public ReturnDto updateBigClassify(@RequestBody BigClassifyUpdRequest request){
        // 先判断当前是修改名称还是修改状态
        // 修改名称
        if(StringUtils.isEmpty(request.getUpdateStatus())){
            // 大分类名称不允许为空
            BigClassifyAddParam param = new BigClassifyAddParam();
            param.setBigClassifyName(request.getBigClassifyName());
            param.setRemark(request.getRemark());
            // java封装
            String error = bigClassifyService.checkError(param);
            if(!StringUtils.isEmpty(error)){
                return ReturnDto.error("501","修改失败!",null);
            }else{
                String updateError = bigClassifyService.updateBigClassify(request);
                if(!StringUtils.isEmpty(updateError)){
                    return ReturnDto.error("501",updateError,null);
                }
                return ReturnDto.success("请求成功",null);
            }
        }
        // 修改状态
        else{
            String updateError = bigClassifyService.updateBigClassify(request);
            if(!StringUtils.isEmpty(updateError)){
                return ReturnDto.error("501",updateError,null);
            }
            return ReturnDto.success("请求成功",null);
        }
    }


}
