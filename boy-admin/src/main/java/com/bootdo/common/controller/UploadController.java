package com.bootdo.common.controller;

import com.bootdo.common.utils.MD5Utils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xgh
 * 文件上传
 */
@Controller
@RequestMapping("/file")
public class UploadController {
    private static final Log logger = LogFactory.getLog(UploadController.class);
    @Value("${com.xu.path}")
    private String user_upload_path;
    /**
     * 上传方法
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile files, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取用户信息

        //获取上传文件
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");

        //可传入存储位置
        String time = new Date().getTime() + "";
        String path = "";
/*        if (user == null) {
            path = PropertyReader.getProperty("user_upload_path") + "text" + "_" + "1024" + "/" + time;
        } else {
            path = PropertyReader.getProperty("user_upload_path") + user.getName() + "_" + user.getId() + "/" + time;
        }*/
        path =  user_upload_path + "text" + "_" + "1024" + "/" + time;
        //file:上传上来的文件 //uploadFile：文件存储位置 //targetFile：重命名后的文件
        File uploadFile = new File(path);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
        //原文件名
        String originalFilename = file.getOriginalFilename();
        String encryptName = encrypt(originalFilename);
        File targetFile = new File(path, encryptName);
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            logger.error("Transfer File Error");
        }
        Map<String, String> result = new HashMap<String, String>();
        result.put("fileName", targetFile.getName());
        result.put("fileDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        result.put("filePath", targetFile.getPath());
        result.put("fileId", time);
        return result;
    }
    private String encrypt(String filename){
        filename = (filename == null)?"defalt.jpg":filename;
        int index = StringUtils.lastIndexOf(filename,".");
        String pre =  StringUtils.substring(filename,0,index);
        String suffix = StringUtils.substring(filename,index);
        pre = MD5Utils.encrypt(String.valueOf(System.currentTimeMillis()), "file");
        return pre + suffix;
    }
}

