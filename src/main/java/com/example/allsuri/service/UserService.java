package com.example.allsuri.service;

import java.util.List;
import java.util.Map;

public interface UserService {

	@SuppressWarnings("rawtypes")
	public List<Map<String, String>> retrieveAllUser(Map<String,String> params);

	@SuppressWarnings("rawtypes")
	public Map<String, String> retrieveUser(Map<String,String> params);

	public int createUser();

	public int updateUser();

	public int deleteUser();

}
