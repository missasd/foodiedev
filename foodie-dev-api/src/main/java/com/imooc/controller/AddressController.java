package com.imooc.controller;

import com.imooc.pojo.UserAddress;
import com.imooc.pojo.bo.AddressBO;
import com.imooc.pojo.vo.ShopcartVO;
import com.imooc.service.AddressService;
import com.imooc.utils.JSONResult;
import com.imooc.utils.MobileEmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("address")
@Api(value = "地址相关", tags = {"地址相关的api接口"})
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 用户在确认订单页面, 可以针对收获地址做如下操作:
     * 1. 查询用户所有收获地址
     * 2. 新增收货地址
     * 3. 删除收货地址
     * 4. 修改收货地址
     * 5. 设置默认收货地址
     */
    @ApiOperation(value = "根据用户id查询收获地址列表", notes = "根据用户id查询收获地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public JSONResult list(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId) {


        if (StringUtils.isBlank(userId)){
            return JSONResult.errorMsg("用户id不能为空");
        }
        List<UserAddress> list = addressService.queryAll(userId);

        return JSONResult.ok(list);
    }

    @ApiOperation(value = "用户新增地址", notes = "用户新增地址", httpMethod = "POST")
    @PostMapping("/add")
    public JSONResult add(@RequestBody AddressBO addressBO) {

        JSONResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200){
            return checkRes;
        }
        addressService.addNewUserAddress(addressBO);
        return JSONResult.ok();
    }

    private JSONResult checkAddress(AddressBO addressBO){
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)){
            return JSONResult.errorMsg("收货人不能为空");
        }
        if (receiver.length() > 12){
            return JSONResult.errorMsg("收货人姓名不能太长");
        }

        String mobile = addressBO.getMobile();
        if (StringUtils.isBlank(mobile)){
            return JSONResult.errorMsg("收货人手机号不能为空");
        }
        if (mobile.length() != 11){
            return JSONResult.errorMsg("收件人手机号长度不正确");
        }
        boolean isMobileOK = MobileEmailUtils.checkMobileIsOk(mobile);
        if (!isMobileOK) {
            return JSONResult.errorMsg("收货人手机号格式不正确");
        }

        String province = addressBO.getProvince();
        String city = addressBO.getCity();
        String district = addressBO.getDistrict();
        String detail = addressBO.getDetail();
        if (StringUtils.isBlank(province) ||
                StringUtils.isBlank(city) ||
                StringUtils.isBlank(district) ||
                StringUtils.isBlank(detail)) {
            return JSONResult.errorMsg("收货地址信息不能为空");
        }

        return JSONResult.ok();
    }

    @ApiOperation(value = "用户修改地址", notes = "用户修改地址", httpMethod = "POST")
    @PostMapping("/update")
    public JSONResult update(@RequestBody AddressBO addressBO) {

        if (StringUtils.isBlank(addressBO.getAddressId())){
            return JSONResult.errorMsg("修改地址错误: addressId不能为空");
        }

        JSONResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200){
            return checkRes;
        }
        addressService.updateUserAddress(addressBO);
        return JSONResult.ok();
    }

    @ApiOperation(value = "用户删除地址", notes = "用户删除地址", httpMethod = "POST")
    @PostMapping("/delete")
    public JSONResult delete(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "addressId", value = "地址id", required = true)
            @RequestParam String addressId) {

        if (StringUtils.isBlank(addressId) || StringUtils.isBlank(userId)){
            return JSONResult.errorMsg("");
        }


        addressService.deleteUserAddress(userId, addressId);
        return JSONResult.ok();
    }

    @ApiOperation(value = "用户设置默认地址", notes = "用户设置默认地址", httpMethod = "POST")
    @PostMapping("/setDefalut")
    public JSONResult setDefault(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "addressId", value = "地址id", required = true)
            @RequestParam String addressId) {

        if (StringUtils.isBlank(addressId) || StringUtils.isBlank(userId)){
            return JSONResult.errorMsg("");
        }


        addressService.updateUserAddressToBeDefault(userId, addressId);
        return JSONResult.ok();
    }


}
