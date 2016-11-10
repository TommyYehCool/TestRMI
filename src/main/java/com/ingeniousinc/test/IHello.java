package com.ingeniousinc.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定義一個遠程接口，必須繼承Remote接口，其中需要遠程調用的方法必須拋出RemoteException異常
 */
public interface IHello extends Remote {
	/**
	 * 簡單的返回"Hello World!"字串
	 *
	 * @return 返回"Hello World!"字串
	 * @throws java.rmi.RemoteException
	 */
	public String helloWorld() throws RemoteException;
}