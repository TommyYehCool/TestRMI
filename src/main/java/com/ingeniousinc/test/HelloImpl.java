package com.ingeniousinc.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 遠程的接口的實現
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {
	private static final long serialVersionUID = 3509127927099606368L;

	/**
	 * 因為UnicastRemoteObject的構造方法拋出了RemoteException異常，因此這裡默認的構造方法必須寫，
	 * 必須聲明拋出RemoteException異常
	 *
	 * @throws RemoteException
	 */
	public HelloImpl() throws RemoteException {
	}

	public String helloWorld() throws RemoteException {
		return "Hello World!";
	}
}