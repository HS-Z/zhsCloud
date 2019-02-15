package com.zhs.provider.dao.MybatisMapper;


import com.zhs.common.jqGrid.JqGridQueryVo;
import com.zhs.provider.model.RoleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleInfoMapper {


    /**
     * 查询角色列表
     * @param jqGridQueryVo
     * @return
     */
    List<Object> getRoleInfoList(JqGridQueryVo jqGridQueryVo);


    /**
     * 根据角色编码查询角色信息
     */
    RoleInfo findRoleInfoByRoleCode(String roleCode);


    RoleInfo findById(Long id);


    @Select("SELECT MAX(role_code) as roleCode FROM t_zhs_role_info")
    String getMaxRoleCode();


    /**
     * 查询所有的角色信息，不包括已被删除的
     * @return
     */
    List<RoleInfo> getAllRoleInfoNotDelete();


    /**
     * 根据多个id同时查询角色信息
     * @param ids
     * @return
     */
    List<RoleInfo> getRoleInfoByIds(@Param("ids") String ids);


}
