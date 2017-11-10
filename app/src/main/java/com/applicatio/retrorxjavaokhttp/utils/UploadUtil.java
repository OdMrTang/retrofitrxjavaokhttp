package com.applicatio.retrorxjavaokhttp.utils;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Tang on 2017/8/21.
 */

public class UploadUtil {

    /**
     * 返回上传文件
     * */
    public MultipartBody.Part uploadAvatar(String path){
        File file = new File(path);
        RequestBody body = RequestBody.create(MediaType.parse("image/jpg"),file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("picture",file.getName(),body);
        return part;
    }

}
