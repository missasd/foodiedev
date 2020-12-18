package com.imooc.controller.center;

import com.imooc.controller.BaseController;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.center.CenterUserBO;
import com.imooc.resource.FileUpload;
import com.imooc.service.center.CenterUserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.DateUtil;
import com.imooc.utils.JSONResult;
import com.imooc.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户中心-用户信息接口", tags = {"用户信息相关接口"})
@RestController
@RequestMapping("userInfo")
public class CenterUserController extends BaseController {

    @Autowired
    private CenterUserService centerUserService;

    @Autowired
    private FileUpload fileUpload;

    @ApiOperation(value = "用户头像修改", notes = "用户头像修改", httpMethod = "POST")
    @PostMapping("uploadFace")
    public JSONResult uploadFace(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "file", value = "用户头像", required = true)
            MultipartFile file,
            HttpServletRequest request,HttpServletResponse response){

        // 定义头像保存的地址
        // String fileSpace = IMAGE_USER_FACE_LOCATION;
        String fileSpace = fileUpload.getImageUserFaceLocation(); //http://localhost:8082/
        // 在路径上为每个用户增加一个userId, 用于区分不同用户上传
        String uploadPathPrefix = File.separator + userId;

        // 开始文件上传
        if (file != null){

            // 获得文件上传的文件名称
            String fileName = file.getOriginalFilename();

            if (StringUtils.isNotBlank(fileName)){
                FileOutputStream fileOutputStream = null;
                try {
                    // 文件重命名 imooc-face.png -> ["imooc-face", "png"]
                    String[] fileNameArr = fileName.split("\\.");

                    // 获取文件的后缀名
                    String suffix = fileNameArr[fileNameArr.length - 1];

                    // 后缀名进行校验
                    if (!suffix.equalsIgnoreCase("png")&&
                            !suffix.equalsIgnoreCase("jpg")&&
                            !suffix.equalsIgnoreCase("jpeg")&&
                            !suffix.equalsIgnoreCase("gif")
                    ){
                        return JSONResult.errorMsg("图片格式不正确");
                    }

                    // 保存形式: face-{userid}.png
                    // 文件名称重组, 覆盖式上传, 增量式:  额外拼接当前时间
                    String newFileName = "face-" + userId + "." + suffix;

                    // 上传的头像最终保存的位置
                    String finalFacePath = fileSpace + uploadPathPrefix + File.separator + newFileName;

                    // 用于提供给web服务访问的地址
//                    uploadPathPrefix += ("/" + newFileName);
                    uploadPathPrefix = userId + "/" + newFileName;

                    File outFile = new File(finalFacePath);

                    if (outFile.getParentFile() != null){
                        // 创建文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    // 文件输出保存到目录
                    fileOutputStream = new FileOutputStream(outFile);
                    InputStream inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    try {
                        if (fileOutputStream != null){
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        }else {
            return JSONResult.errorMsg("文件不能为空! ");
        }


        // 获得图片服务地址
        String imageServerUrl = fileUpload.getImageServerUrl();

        // 由于浏览器可能存在缓存, 所以在这里, 我们需要加上时间戳来保证更新后的图片可以及时刷新
        // imageServerUrl: http://localhost:8082/
        // uploadPathPrefix: File.separator + userId
        // uploadPathPrefix += ("/" + newFileName);

        String finalUserFaceUrl = imageServerUrl + uploadPathPrefix
                + "?t=" + DateUtil.getCurrentDateString(DateUtil.DATE_PATTERN);
//        String finalUserFaceUrl = imageServerUrl + "/" + userId
//                + "?t=" + DateUtil.getCurrentDateString(DateUtil.DATE_PATTERN);
        // 更新用户头像到数据库
        Users userResult = centerUserService.updateUserFace(userId, finalUserFaceUrl);


        // 用户信息脱敏
        userResult = setNullProperty(userResult);

        // 得到修改后的用户信息后, 将本地的cookie里存的用户信息给更新
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        // TODO 后续要改, 增加令牌Token, 会整合进redis, 分布式会话
        return JSONResult.ok();

    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息", httpMethod = "POST")
    @PostMapping("update")
    public JSONResult userInfo(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @RequestBody @Valid CenterUserBO centerUserBO,
            BindingResult bindingResult,
            HttpServletRequest request,
            HttpServletResponse response){

        // 判断字段的校验结果是否包含错误的验证信息, 如果有, 则直接return

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = getErrors(bindingResult);
            return JSONResult.errorMap(errorMap);

        }

        Users userResult = centerUserService.updateUserInfo(userId, centerUserBO);



        // 用户信息脱敏
        userResult = setNullProperty(userResult);

        // 得到修改后的用户信息后, 将本地的cookie里存的用户信息给更新
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        // TODO 后续要改, 增加令牌Token, 会整合进redis, 分布式会话
        return JSONResult.ok();

    }

    // 获取字段验证的错误信息
    private Map<String, String> getErrors(BindingResult bindingResult){
        Map<String, String> map = new HashMap<>();

        List<FieldError> errorList = bindingResult.getFieldErrors();
        for (FieldError error : errorList){
            // 发生验证错误所对应的某一个属性
            String errorField = error.getField();
            // 验证错误的信息
            String errorMsg = error.getDefaultMessage();
            map.put(errorField, errorMsg);
        }
        return map;
    }

    private Users setNullProperty(Users userResult){
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }

}