package com.example.allsuri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.allsuri.mapper.CommInfoMapper;
import com.example.allsuri.service.CommInfoServiceImpl;

@SpringBootTest
public class CommInfoMapperTest {

	@Autowired
	private CommInfoMapper commInfoMapper;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private CommInfoServiceImpl commInfoService;



//	@Test
//	public void insertDmlCommInfo() {
//
//		String cdGroupId = "testG10";
//		String cdGroupNm = "tesGnm";
//		String cdId = "testId";
//		String cdMeaning = "cdMeaning";
//		String loginId = "aaa";
//		String price = "0";
//		String ext1 = "";
//		String ext2 = "";
//		String ext3 = "";
//		String sortSeq = "10";
//
//		HashMap map = new HashMap();
//
//		map.put("CD_GROUP_ID", cdGroupId);
//		map.put("CD_GROUP_NM", cdGroupNm);
//		map.put("CD_ID", cdId);
//		map.put("CD_MEANING", cdMeaning);
//		map.put("LOGIN_ID", loginId);
//		map.put("PRICE", price);
//		map.put("EXT1", ext1);
//		map.put("EXT2", ext2);
//		map.put("EXT3", ext3);
//		map.put("SORT_SEQ", sortSeq);
//
//		int result = commInfoMapper.insertDmlCommInfo(map);
//
//		System.out.println("result 1 : " + result);
//
//	}
//
//	/**
//	 * Mybatis Transation 처리방법 기본
//	 */
//	@Test
//	public void insertCommInfoTransation() {
//
//		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
//
//		String cdGroupId = "testG13";
//		String cdGroupNm = "tesGnm";
//		String cdId = "testId";
//		String cdMeaning = "cdMeaning";
//		String loginId = "aaa";
//		String price = "0";
//		String ext1 = "";
//		String ext2 = "";
//		String ext3 = "";
//		String sortSeq = "10";
//
//		HashMap map = new HashMap();
//
//		map.put("CD_GROUP_ID", cdGroupId);
//		map.put("CD_GROUP_NM", cdGroupNm);
//		map.put("CD_ID", cdId);
//		map.put("CD_MEANING", cdMeaning);
//		map.put("LOGIN_ID", loginId);
//		map.put("PRICE", price);
//		map.put("EXT1", ext1);
//		map.put("EXT2", ext2);
//		map.put("EXT3", ext3);
//		map.put("SORT_SEQ", sortSeq);
//
//		try {
//
//			int result = commInfoMapper.insertCommInfo(map);
//
//			System.out.println("result 1 : " + result);
//
////	map.put("CD_GROUP_ID", "testG2");
//
//			result = commInfoMapper.insertCommInfo(map);
//
//			System.out.println("result 2 : " + result);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			transactionManager.rollback(txStatus);
//
//			System.out.println("transactionManager.rollback ");
//
//			throw e;
//		}
//
//		transactionManager.commit(txStatus);
//
//		System.out.println("transactionManager.commit ");
//
//	}

	@Test
	public void insertDmlCommInfoTransationAop() {

		commInfoService.insertDmlCommInfoTransationAop();

	}



//	@Test
//	public void testSelectCommInfoList() {
//
//		List<Map<String, String>> al = commInfoMapper.selectCommInfoList();
//
////		List<Map<String, String>> al = commInfoMapper.selectCommInfoList("testG4");
//
//		System.out.println("size : " + al.size());
//
//		if (al != null && al.size() > 0) {
//
//			System.out.println("size : " + al.size());
//
//			for (Map<String, String> hashMap : al) {
//
//				System.out.println(hashMap.get("CD_GROUP_ID"));
//
//			}
//
//		}
//
//	}
//
//	@Test
//	public void testSelectCommInfoList2() {
//
//		List<Map<String, String>> al = commInfoMapper.selectCommInfoListParam("testG4");
//
//		System.out.println("size : " + al.size());
//
//		if (al != null && al.size() > 0) {
//
//			System.out.println("size : " + al.size());
//
//			for (Map<String, String> hashMap : al) {
//
//				System.out.println(hashMap.get("CD_GROUP_ID"));
//
//			}
//
//		}
//
//	}
//
//	@Test
//	public void testSelectCommInfoList3() {
//
//		HashMap<String, String> params = new HashMap<String, String>();
//
//		params.put("CD_GROUP_ID", "testG4");
//		params.put("CD_ID", "testId");
//
//		List<Map<String, String>> al = commInfoMapper.selectCommInfoListHashMap(params);
//
//		System.out.println("size : " + al.size());
//
//		if (al != null && al.size() > 0) {
//
//			System.out.println("size : " + al.size());
//
//			for (Map<String, String> hashMap : al) {
//
//				System.out.println(hashMap.get("CD_GROUP_ID"));
//
//			}
//
//		}
//
//	}




}
