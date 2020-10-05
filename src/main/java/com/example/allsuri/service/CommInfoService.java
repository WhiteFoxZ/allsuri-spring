package com.example.allsuri.service;

import java.util.List;
import java.util.Map;

public interface CommInfoService {

	@SuppressWarnings("rawtypes")
	public List<Map<String, String>> retrieveAllCommInfo(Map<String,String> params);

	@SuppressWarnings("rawtypes")
	public Map<String, String> retrieveCommInfo(Map<String,String> params);

	public int createCommInfo();

	public int updateCommInfo();

	public int deleteCommInfo();

}
