package com.yy.controller;

import com.alibaba.fastjson.JSONObject;
import com.yy.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @package: com.yy.controller
 * @className: AiController
 * @author: Created By Yy
 * @date: 2020-09-24 11:52
 */
@RestController
@RequestMapping("/ai")
public class AiController {
	
	@Autowired
	private AiService aiService;
	
	@PostMapping("/ocrIdCard")
	public JSONObject ocrIdCard(@RequestParam("file") MultipartFile file, @RequestParam("type") int type) throws IOException {
		
		return aiService.ocrIdCard(file, type);
	}
	
	@PostMapping("/ocrDriverLicense")
	public JSONObject ocrDriverLicense(@RequestParam("file") MultipartFile file, @RequestParam("type") int type) throws IOException {
		
		return aiService.ocrDriverLicense(file, type);
	}
	
	@PostMapping("/ocrGeneral")
	public JSONObject ocrGeneral(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.ocrGeneral(file);
	}
	
	@PostMapping("/ocrBizLicense")
	public JSONObject ocrBizLicense(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.ocrBizLicense(file);
	}
	
	@PostMapping("/ocrCreditCard")
	public JSONObject ocrCreditCard(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.ocrCreditCard(file);
	}
	
	@PostMapping("/ocrHandWriting")
	public JSONObject ocrHandWriting(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.ocrHandWriting(file);
	}
	
	@PostMapping("/ocrPlate")
	public JSONObject ocrPlate(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.ocrPlate(file);
	}
	
	@PostMapping("/ocrBc")
	public JSONObject ocrBc(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.ocrBc(file);
	}
	
	@PostMapping("/faceDetect")
	public JSONObject faceDetect(@RequestParam("file") MultipartFile file, @RequestParam("type") int mode) throws IOException {
		
		return aiService.faceDetect(file, mode);
	}
	
	@PostMapping("/faceDetectMulti")
	public JSONObject faceDetectMulti(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.faceDetectMulti(file);
	}
	
	@PostMapping("/faceDetectCrossAge")
	public JSONObject faceDetectCrossAge(@RequestParam("file") MultipartFile file1, @RequestParam("file") MultipartFile file2) throws IOException {
		
		return aiService.faceDetectCrossAge(file1, file2);
	}
	
	@PostMapping("/faceShape")
	public JSONObject faceShape(@RequestParam("file") MultipartFile file, @RequestParam("type") int mode) throws IOException {
		
		return aiService.faceShape(file, mode);
	}
	
	@PostMapping("/faceCompare")
	public JSONObject faceCompare(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2) throws IOException {
		
		return aiService.faceCompare(file1, file2);
	}
	
	@PostMapping("/faceVerify")
	public JSONObject faceVerify(@RequestParam("file") MultipartFile file, @RequestParam("person") String person) throws IOException {
		
		return aiService.faceVerify(file, person);
	}
	
	@PostMapping("/ptuImgFilter")
	public JSONObject ptuImgFilter(@RequestParam("file") MultipartFile file, @RequestParam("filter") int filter) throws IOException {
		
		return aiService.ptuImgFilter(file, filter);
	}
	
	@PostMapping("/visionImgFilter")
	public JSONObject visionImgFilter(@RequestParam("file") MultipartFile file, @RequestParam("filter") int filter) throws IOException {
		
		return aiService.visionImgFilter(file, filter);
	}
	
	@PostMapping("/ptuFaceCosmetic")
	public JSONObject ptuFaceCosmetic(@RequestParam("file") MultipartFile file, @RequestParam("cosmetic") int cosmetic) throws IOException {
		
		return aiService.ptuFaceCosmetic(file, cosmetic);
	}
	
	@PostMapping("/ptuFaceDecoration")
	public JSONObject ptuFaceDecoration(@RequestParam("file") MultipartFile file, @RequestParam("decoration") int decoration) throws IOException {
		
		return aiService.ptuFaceDecoration(file, decoration);
	}
	
	@PostMapping("/ptuFaceSticker")
	public JSONObject ptuFaceSticker(@RequestParam("file") MultipartFile file, @RequestParam("sticker") int sticker) throws IOException {
		
		return aiService.ptuFaceSticker(file, sticker);
	}
	
	@PostMapping("/ptuFaceAge")
	public JSONObject ptuFaceAge(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.ptuFaceAge(file);
	}
	
	@PostMapping("/visionImgToText")
	public JSONObject visionImgToText(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.visionImgToText(file);
	}
	
	@PostMapping("/imageTag")
	public JSONObject imageTag(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.imageTag(file);
	}
	
	@PostMapping("/imageFuzzy")
	public JSONObject imageFuzzy(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.imageFuzzy(file);
	}
	
	@PostMapping("/imageFood")
	public JSONObject imageFood(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.imageFood(file);
	}
	
	@PostMapping("/imageTerrorism")
	public JSONObject imageTerrorism(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.imageTerrorism(file);
	}
	
	@PostMapping("/visionPorn")
	public JSONObject visionPorn(@RequestParam("file") MultipartFile file) throws IOException {
		
		return aiService.visionPorn(file);
	}
	
	@PostMapping("/aaiEvilAudio")
	public JSONObject aaiEvilAudio(@RequestParam("url") String url) {
		
		return aiService.aaiEvilAudio(url);
	}
	
	@PostMapping("/nlpTextChat")
	public JSONObject nlpTextChat(@RequestParam("session") String session, @RequestParam("question") String question) {
		
		return aiService.nlpTextChat(session, question);
	}
	
	@PostMapping("/nlpTextTranslate ")
	public JSONObject nlpTextTranslate(@RequestParam("text") String text,
									   @RequestParam("target") String target,
									   @RequestParam("source") String source) {
		
		return aiService.nlpTextTranslate(text, source, target);
	}
	
	@PostMapping("/nlpImageTranslate")
	public JSONObject nlpImageTranslate(@RequestParam("file") MultipartFile file,
										@RequestParam("scene") String scene,
										@RequestParam("source") String source,
										@RequestParam("target") String target) throws IOException {
		
		return aiService.nlpImageTranslate(file, scene, source, target);
	}
	
	@PostMapping("/nlpTextDetect")
	public JSONObject nlpTextDetect(@RequestParam("text") String text,
									@RequestParam("candidateLang") String candidateLang,
									@RequestParam("force") int force){
		
		return aiService.nlpTextDetect(text,candidateLang,force);
	}
	
}
