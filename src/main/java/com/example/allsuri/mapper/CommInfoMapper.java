package com.example.allsuri.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Mapper
public interface CommInfoMapper {

	public int insertCommInfo(Map<String,String> params);

	public int insertDmlCommInfo(Map<String,String> params);

	public int updateDmlCommInfo(Map<String,String> params);

	public int deleteDmlCommInfo(Map<String,String> params);

	public Map<String,String> selectCommInfoDetail(Map<String,String> params);

	public List<Map<String,String>> selectCommInfoList();

	public List<Map<String,String>> selectCommInfoListParam(String param);

	public List<Map<String,String>> selectCommInfoListHashMap(Map<String,String> params);

}
