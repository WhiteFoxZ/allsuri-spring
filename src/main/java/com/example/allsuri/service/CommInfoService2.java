package com.example.allsuri.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.allsuri.mapper.CommInfoMapper;


@Service
public class CommInfoService2   {

	@Autowired
	private CommInfoMapper commInfoMapper;

	@Autowired
	private PlatformTransactionManager transactionManager;

	private TransactionStatus txStatus=null;


	public TransactionStatus getTxStatus() {
		return txStatus;
	}


	public void setTxStatus(TransactionStatus txStatus) {
		this.txStatus = txStatus;
	}


	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}


	public void insertDmlCommInfoTransationAop() {

		String cdGroupId = "testG14";
		String cdGroupNm = "tesGnm";
		String cdId = "testId";
		String cdMeaning = "cdMeaning";
		String loginId = "aaa";
		String price = "0";
		String ext1 = "";
		String ext2 = "";
		String ext3 = "";
		String sortSeq = "10";

		HashMap<String,String> map = new HashMap<String,String>();

		map.put("CD_GROUP_ID", cdGroupId);
		map.put("CD_GROUP_NM", cdGroupNm);
		map.put("CD_ID", cdId);
		map.put("CD_MEANING", cdMeaning);
		map.put("LOGIN_ID", loginId);
		map.put("PRICE", price);
		map.put("EXT1", ext1);
		map.put("EXT2", ext2);
		map.put("EXT3", ext3);
		map.put("SORT_SEQ", sortSeq);

		int result = commInfoMapper.insertDmlCommInfo(map);

		System.out.println("result 1 : " + result);

	map.put("CD_GROUP_ID", "testG15");

		result = commInfoMapper.insertDmlCommInfo(map);

		System.out.println("result 2 : " + result);

	}

}
