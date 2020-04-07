package com.example.cloudcommons.resp.http;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * @Description
 * @Author Carter
 * @Create 2019/7/18 0018
 */
public class HttpPostUtils {


    public static JSONObject doPost(String url, JSONObject json) throws Exception{
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent", "Mozilla/5.0");
        JSONObject response = null;
        try ( CloseableHttpClient httpclient = HttpClientBuilder.create().build()){
            StringEntity s = new StringEntity(json.toString(),"UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            setTimeOut(post);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.parseObject(result);
            }
        }
        return response;
    }


    public static JSONObject doPost(String url, JSONArray json) throws Exception{
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent", "Mozilla/5.0");
        JSONObject response = null;
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()){
            StringEntity s = new StringEntity(json.toString(),"UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            setTimeOut(post);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.parseObject(result);
            }
        }
        return response;
    }
    /**
     *  尽量使用json格式传参，保持java对外接收和输出格式的一致性
     * @param:  type 传参格式  json json字符串
     * @return:
     * @auther: Carter
     * @date: 2019/7/29 0029
     */
    public static JSONObject doPost(String url, JSONObject json, String type) throws Exception{
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent", "Mozilla/5.0");
        JSONObject response = null;
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()){
            StringEntity s = new StringEntity(json.toString(),"UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType(type);//发送json数据需要设置contentType
            post.setEntity(s);
            setTimeOut(post);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.parseObject(result);
            }
        }
        return response;
    }

    private static void setTimeOut(HttpPost post) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(180000)
                .setConnectionRequestTimeout(180000)
                .setSocketTimeout(180000)
                .setRedirectsEnabled(true)
                .setCircularRedirectsAllowed(false)
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .build();
        post.setConfig(requestConfig);
    }


}
