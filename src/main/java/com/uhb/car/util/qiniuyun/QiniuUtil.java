package com.uhb.car.util.qiniuyun;


import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;

/**
 * @ClassName:七牛云图片配置
 * @Author: hlq
 * @Date: 2019/3/15 9:38
 * @Version 1.0
 */
public class QiniuUtil {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    final String ACCESS_KEY = "mDNTqAC4WC_VQ9AIA5BhvYB_Ic8I0dbWxkvQXd3J";
    final String SECRET_KEY = "98qUybBYmlKFByuCr-HPMixL63XlpL59_ZeWrZlA";
    //要上传的空间
    final String BUCKET_NAME = "car_insurance";

    /**
     * 七牛云上传图片
     * @param localFilePath
     * @return
     */
    Configuration cfg = new Configuration(Zone.zone0());



}
