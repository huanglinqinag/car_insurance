package com.uhb.car.util.qiniuyun;

import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

import okhttp3.*;

import java.io.IOException;

/**
 * @ClassName:七牛云文件上传工具类
 * @Author: hlq
 * @Date: 2019/3/18 11:25
 * @Version 1.0
 */
public class QiniuCloudUtil {
        /**
         设置需要操作的账号的AK和SK
         */
        private static final  String ACCESS_KEY = "mDNTqAC4WC_VQ9AIA5BhvYB_Ic8I0dbWxkvQXd3J";
        private static final String SECRET_KEY = "98qUybBYmlKFByuCr-HPMixL63XlpL59_ZeWrZlA";
         // 要上传的空间
        private static final String bucketname = "car_insurance";

         // 密钥
        private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        private static final String DOMAIN = "http://pocg6c04c.bkt.clouddn.com";

        //private static final String style = "自定义的图片样式";

        public static String getUpToken() {
            return auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));
        }


    /**
     * @ClassName:base64方式上传
     * @Author: hlq
     * @Date: 2019/3/18 14:28
     * @Version 1.0
     */
    public static String put64image(byte[] base64, String key) throws Exception{
        String file64=Base64.encodeToString(base64,0);
        Integer len =base64.length;
        String url= "http://upload-z0.qiniu.com/putb64/" + len + "/key/"+ UrlSafeBase64.encodeToString(key);
        RequestBody rd=RequestBody.create(null,file64);
        Request request=new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rd).build();
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response=client.newCall(request).execute();
        System.out.println(response);
        System.out.println("++++++++++++++++"+DOMAIN+key);
        return DOMAIN+key;
    }
    /**
     * 解码
     *
     * @param str
     * @return string
     */
    public static byte[] decode(String str) {
        byte[] bt = null;
        try {
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            bt = decoder.decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bt;
    }

}








