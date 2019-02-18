package com.zhs.basic.service;


import com.zhs.basic.model.Dictionary;
import com.zhs.common.jqGrid.JqGridQueryVo;
import com.zhs.common.jqGrid.JqGridResponse;
import com.zhs.common.vo.Json;

import java.util.List;

public interface DictionaryService{


    public JqGridResponse getDictionaryList(JqGridQueryVo jqGridQueryVo);


    public Dictionary findById(Long id);


    public Json deleteById(Long id);


    public Json changeState(Long id,Boolean state);


    public Json saveOrUpdate(Dictionary dictionary);


    public String generateCode(String type);


    public List<Dictionary> getListByType(String type);


}
