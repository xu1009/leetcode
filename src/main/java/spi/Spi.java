package spi;

import java.util.ServiceLoader;

public class Spi {
	public static void main(String[] args){
		ServiceLoader<QuckAble> serviceLoader = ServiceLoader.load(QuckAble.class);
		for (QuckAble quckAble : serviceLoader){
			quckAble.sayHello();
		}
		System.out.println(QuckAble.class.getPackage());
	}
}
