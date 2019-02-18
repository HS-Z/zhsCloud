package com.zhs.basic.service;


import com.zhs.basic.model.RoleInfo;
import com.zhs.common.jqGrid.JqGridQueryVo;
import com.zhs.common.jqGrid.JqGridResponse;
import com.zhs.common.vo.Json;

import java.io.InputStream;
import java.util.List;

public interface RoleInfoService{


    public JqGridResponse findRoleInfoList(JqGridQueryVo jqGridQueryVo);


    public RoleInfo findById(Long id);


    public List<RoleInfo> getAllRoleInfo();


    public List<RoleInfo> getRoleInfoByIds(String ids);


    public List<RoleInfo> getAllRoleInfoNotDelete();


    public Json saveOrUpdate(RoleInfo roleInfo);


    public Json saveAll(List<RoleInfo> roleInfoList);


    public Json saveExcelData(List<RoleInfo> roleInfoList);


    public Json deleteRoleInfo(Long roleId);


    public String generateCode();


    public List<RoleInfo> uploadExcel(InputStream inputStream);


    public void txLcn();



}
