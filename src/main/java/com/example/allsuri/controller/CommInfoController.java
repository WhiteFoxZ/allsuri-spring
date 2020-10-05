package com.example.allsuri.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.allsuri.service.CommInfoService;
import com.example.allsuri.service.CommInfoServiceImpl;


public class CommInfoController implements CommInfoService {

	@Autowired
	CommInfoServiceImpl commInfoServiceImpl;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	@PostMapping("/comminfoes")
	public List<Map<String, String>> retrieveAllCommInfo(@RequestBody Map<String,String> params) {
		// TODO Auto-generated method stub


		logger.debug(params.toString());

		return commInfoServiceImpl.retrieveAllCommInfo(params);
	}

	@Override
	public int createCommInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@PostMapping("/comminfo")
	public HashMap retrieveCommInfo(@RequestBody Map<String,String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCommInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCommInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
