package com.yy.common.util;

import cn.hutool.core.net.Ipv4Util;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.xsshome.taip.nlp.TAipNlp;
import jodd.io.NetUtil;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.*;

/**
 * @package: com.yy.common.util
 * @className: ParamsUtil
 * @author: Created By Yy
 * @date: 2020-09-21 20:47
 */
public class ParamsUtil {

    public static Map<String, Object> getParams(Map<String, Object> params){
        Map<String, Object> param=new TreeMap<>(params);
        param.put("app_id","2118147806");
        param.put("time_stamp", Instant.now().getEpochSecond());
        param.put("nonce_str", IdUtil.fastSimpleUUID());

        StringBuilder builder=new StringBuilder();
        param.forEach((k,v)->{
            builder.append(k).append("=");
            builder.append(URLEncoder.encode(Objects.toString(v), CharsetUtil.CHARSET_UTF_8)).append("&");
        });
        builder.append("app_key=").append("AssxqFKVramn45g5");
        String sign = SecureUtil.md5(builder.toString()).toUpperCase();
        param.put("sign",sign);
        return param;
    }

    public static void main(String[] args) throws Exception {
        String url="https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordcom";
        Map<String, Object> params = new HashMap<>();
        params.put("text","今天深圳的天气怎么样？明天呢");
        String s = HttpUtil.get(url, getParams(params));
        System.out.println(s);


    }
}
