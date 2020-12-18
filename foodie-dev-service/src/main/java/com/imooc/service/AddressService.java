package com.imooc.service;

import com.imooc.pojo.UserAddress;
import com.imooc.pojo.bo.AddressBO;

import java.util.List;

public interface AddressService {

    /**
     * 根据用户id查询用户所有收货地址
     */
    public List<UserAddress> queryAll(String userId);



    /**
     * 用户新增地址
     * @param addressBO
     */
    public void addNewUserAddress(AddressBO addressBO);

    /**
     * 用户修改地址
     * @param addressBO
     */
    public void updateUserAddress(AddressBO addressBO);

    /**
     * 用户删除地址
     * @param userId 用户id
     * @param addressId 地址id
     */
    public void deleteUserAddress(String userId, String addressId);

    /**
     * 修改默认地址
     * @param userId 用户id
     * @param addressId 地址id
     */
    public void updateUserAddressToBeDefault(String userId, String addressId);

    /**
     * 用于创建订单时根据用户id和地址id查询 具体信息
     * @param userId
     * @param addressId
     * @return
     */
    public UserAddress queryUserAddress(String userId, String addressId);
}
