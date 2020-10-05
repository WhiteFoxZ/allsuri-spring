package com.example.allsuri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import com.example.allsuri.mapper.CommInfoMapper;

/**
 * DML transaction 처리 위한 Interface
 * @author fox97
 *
 */
public class  DefaultService {

	@Autowired
	protected PlatformTransactionManager transactionManager;

	protected TransactionStatus txStatus=null;

	public TransactionStatus getTxStatus() {
		return txStatus;
	}


	public void setTxStatus(TransactionStatus txStatus) {
		this.txStatus = txStatus;
	}


	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
}