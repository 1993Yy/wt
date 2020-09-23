package com.yy.service;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yy.common.consts.AiUrlConst;
import com.yy.common.util.ParamsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @package: com.yy.service
 * @className: AiService
 * @author: Created By Yy
 * @date: 2020-09-23 23:25
 */
@Service
@Slf4j
public class AiService {

    public JSONObject ocrIdCard(MultipartFile file, int type) throws IOException {
        Map<String, Object> param=new HashMap<>();
        param.put("image", Base64.encode(file.getInputStream()));
        param.put("card_type", type);
        String str = HttpUtil.post(AiUrlConst.ocr_idCard, ParamsUtil.getParams(param));
        return getResult(str);
    }

    public JSONObject ocrDriverLicense(MultipartFile file, int type) throws IOException {
        Map<String, Object> param=new HashMap<>();
        param.put("image", Base64.encode(file.getInputStream()));
        param.put("type", type);
        String str = HttpUtil.post(AiUrlConst.ocr_driverLicense, ParamsUtil.getParams(param));
        return getResult(str);
    }

    public JSONObject ocrGeneral(MultipartFile file) throws IOException {
        Map<String, Object> param=new HashMap<>();
        param.put("image", Base64.encode(file.getInputStream()));
        String str = HttpUtil.post(AiUrlConst.ocr_general, ParamsUtil.getParams(param));
        return getResult(str);
    }

    public JSONObject ocrBizLicense(MultipartFile file) throws IOException {
        Map<String, Object> param=new HashMap<>();
        param.put("image", Base64.encode(file.getInputStream()));
        String str = HttpUtil.post(AiUrlConst.ocr_bizLicense, ParamsUtil.getParams(param));
        return getResult(str);
    }

    public JSONObject ocrCreditCard(MultipartFile file) throws IOException {
        Map<String, Object> param=new HashMap<>();
        param.put("image", Base64.encode(file.getInputStream()));
        String str = HttpUtil.post(AiUrlConst.ocr_creditCard, ParamsUtil.getParams(param));
        return getResult(str);
    }

    public JSONObject ocrHandWriting(MultipartFile file) throws IOException {
        Map<String, Object> param=new HashMap<>();
        param.put("image", Base64.encode(file.getInputStream()));
        String str = HttpUtil.post(AiUrlConst.ocr_handWriting, ParamsUtil.getParams(param));
        return getResult(str);
    }

    public JSONObject ocrPlate(MultipartFile file) throws IOException {
        Map<String, Object> param=new HashMap<>();
        param.put("image", Base64.encode(file.getInputStream()));
        String str = HttpUtil.post(AiUrlConst.ocr_plate, ParamsUtil.getParams(param));
        return getResult(str);
    }

    public JSONObject ocrBc(MultipartFile file) throws IOException {
        Map<String, Object> param=new HashMap<>();
        param.put("image", Base64.encode(file.getInputStream()));
        String str = HttpUtil.post(AiUrlConst.ocr_bc, ParamsUtil.getParams(param));
        return getResult(str);
    }



    private JSONObject getResult(String str){
        JSONObject obj = JSON.parseObject(str);
        if (!"0".equals(obj.getString("ret"))){
            log.info("============{}",obj.get("msg"));
            return null;
        }
        return obj.getJSONObject("data");
    }
}
