package com.ingeniousinc.test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 創建RMI註冊表，啟動RMI服務，並將遠程對象註冊到RMI註冊表中。
 */
public class HelloServer {
	public static void main(String args[]) {
		try {
			// 創建一個遠程對象
			IHello hello = new HelloImpl();

			// 本地主機上的遠程對象註冊表Registry的實例，並指定端口為8888，
			// 這一步必不可少（Java默認端口是1099），必不可缺的一步，缺少註冊表創建，則無法綁定對像到遠程註冊表上
			LocateRegistry.createRegistry(8888);

			// 把遠程對象註冊到RMI註冊服務器上，並命名為hello
			// 綁定的URL標準格式為：rmi://host:port/name(其中協議名可以省略，下面兩種寫法都是正確的）
			Naming.bind("rmi://localhost:8888/hello", hello);

			// Naming.bind("//localhost:8888/hello", hello);
			System.out.println(">>> 遠程IHello對象綁定成功！");
		} catch (RemoteException e) {
			System.out.println(">>> 創建遠程對象發生異常！");
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			System.out.println(">>> 發生重複綁定對象異常！");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println(">>> 發生URL異常！");
			e.printStackTrace();
		}
	}
}