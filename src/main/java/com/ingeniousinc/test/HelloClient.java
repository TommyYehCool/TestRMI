package com.ingeniousinc.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 客戶端測試，在客戶端調用遠程對像上的遠程方法，並返回結果。
 */
public class HelloClient {

	public static void main(String args[]) {
		try {
			// 在RMI服務註冊表中查找名稱為hello的對象，並調用其上的方法
			IHello rhello = (IHello) Naming.lookup("rmi://localhost:8888/hello");
			System.out.println(rhello.helloWorld());
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}