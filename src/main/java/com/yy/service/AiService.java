package com.yy.service;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
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
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("card_type", type);
		String str = HttpUtil.post(AiUrlConst.ocr_idCard, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ocrDriverLicense(MultipartFile file, int type) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("type", type);
		String str = HttpUtil.post(AiUrlConst.ocr_driverLicense, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ocrGeneral(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.ocr_general, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ocrBizLicense(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.ocr_bizLicense, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ocrCreditCard(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.ocr_creditCard, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ocrHandWriting(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.ocr_handWriting, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ocrPlate(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.ocr_plate, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ocrBc(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.ocr_bc, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject faceDetect(MultipartFile file, int mode) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("mode", mode);
		String str = HttpUtil.post(AiUrlConst.face_detect, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject faceDetectMulti(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.face_detectMulti, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject faceDetectCrossAge(MultipartFile source, MultipartFile target) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("source_image", Base64.encode(source.getInputStream()));
		param.put("target_image", Base64.encode(target.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.face_detectcrossage, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject faceShape(MultipartFile file, int mode) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("mode", mode);
		String str = HttpUtil.post(AiUrlConst.face_faceshape, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject faceCompare(MultipartFile file1, MultipartFile file2) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image_a", Base64.encode(file1.getInputStream()));
		param.put("image_b", Base64.encode(file2.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.face_facecompare, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject faceVerify(MultipartFile file, String person) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("person_id", person);
		String str = HttpUtil.post(AiUrlConst.face_faceverify, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ptuImgFilter(MultipartFile file, int filter) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("filter", filter);
		String str = HttpUtil.post(AiUrlConst.ptu_imgfilter, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject visionImgFilter(MultipartFile file, int filter) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("filter", filter);
		String str = HttpUtil.post(AiUrlConst.vision_imgfilter, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ptuFaceCosmetic(MultipartFile file, int cosmetic) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("cosmetic", cosmetic);
		String str = HttpUtil.post(AiUrlConst.ptu_facecosmetic, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ptuFaceDecoration(MultipartFile file, int decoration) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("decoration", decoration);
		String str = HttpUtil.post(AiUrlConst.ptu_facedecoration, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ptuFaceSticker(MultipartFile file, int sticker) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("decoration", sticker);
		String str = HttpUtil.post(AiUrlConst.ptu_facesticker, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject ptuFaceAge(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.ptu_faceage, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject visionImgToText(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("session_id", IdUtil.fastSimpleUUID());
		String str = HttpUtil.post(AiUrlConst.vision_imgtotext, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject imageTag(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.image_tag, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject imageFuzzy(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.image_fuzzy, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject imageFood(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.image_food, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject imageTerrorism(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.image_terrorism, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject visionPorn(MultipartFile file) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		String str = HttpUtil.post(AiUrlConst.vision_porn, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject aaiEvilAudio(String url)  {
		Map<String, Object> param = new HashMap<>();
		param.put("speech_id", IdUtil.fastSimpleUUID());
		param.put("speech_url", url);
		String str = HttpUtil.post(AiUrlConst.aai_evilaudio, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject nlpTextChat(String question,String session)  {
		Map<String, Object> param = new HashMap<>();
		param.put("session", session);
		param.put("question", question);
		String str = HttpUtil.post(AiUrlConst.nlp_textchat, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject nlpTextTranslate (String text,String source,String target)  {
		Map<String, Object> param = new HashMap<>();
		param.put("text", text);
		param.put("source", source);
		param.put("target", target);
		String str = HttpUtil.post(AiUrlConst.nlp_texttranslate, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject nlpImageTranslate (MultipartFile file,String scene,String source,String target) throws IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("image", Base64.encode(file.getInputStream()));
		param.put("session_id", IdUtil.fastSimpleUUID());
		param.put("scene", scene);
		param.put("source", source);
		param.put("target", target);
		String str = HttpUtil.post(AiUrlConst.nlp_imagetranslate, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	public JSONObject nlpTextDetect (String text,String candidateLang,int force){
		Map<String, Object> param = new HashMap<>();
		param.put("text", text);
		param.put("candidate_langs", candidateLang);
		param.put("force", force);
		String str = HttpUtil.post(AiUrlConst.nlp_textdetect, ParamsUtil.getParams(param));
		return getResult(str);
	}
	
	
	private JSONObject getResult(String str) {
		JSONObject obj = JSON.parseObject(str);
		if (!"0".equals(obj.getString("ret"))) {
			log.info("============{}", obj.get("msg"));
			return null;
		}
		return obj.getJSONObject("data");
	}
}
