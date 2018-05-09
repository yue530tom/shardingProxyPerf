/**   
 * @Title: RandomUtils.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:26:11 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

/** 
 * @ClassName: RandomUtils 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:26:11 
 *  
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtils {

	public static int createRandom() {
		return ((int) (Math.random() * 10)) % 2;
	}
	/**
	 * 作用取区间的一个随机数
	 * @param maxNum 最大数值
	 * @param minNum 最小数值
	 * @return
	 */
	public static Long getRangeRandom(long maxNum,long minNum){
		return (long) (Math.random() * (maxNum-minNum+1))+minNum;
	}
	public static Long getRandomDateRandom() {  
		  
    SimpleDateFormat simpleDateFormat;  

    simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  

    Date date = new Date();  

    String str = simpleDateFormat.format(date);  

    Random random = new Random();  

    int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数  

    return Long.valueOf(str+rannum);// 当前时间  
}  
	public static Long getRandomDefine() {  
		  
    SimpleDateFormat simpleDateFormat;  

    simpleDateFormat = new SimpleDateFormat("yyyy");  

    Date date = new Date();  

    String str = simpleDateFormat.format(date);  

    Random random = new Random();  

    long rannum = (long) (random.nextDouble() * 100000000L);// 获取9位随机数  

    return Long.valueOf(str+String.format("%015d", rannum));//  
}  
	/**
	 * 生成以0x结尾的字符串
	 * @return
	 */
	public static Long getRandomDefineFix0x(String xString) {  
		  
    SimpleDateFormat simpleDateFormat;  

    simpleDateFormat = new SimpleDateFormat("yyyy");  

    Date date = new Date();  

    String str = simpleDateFormat.format(date);  

    Random random = new Random();  

    long rannum = (long) (random.nextDouble() * 100000000L);// 获取9位随机数  
    if(xString.length()==1){
    	xString="0"+xString;
    }
    return Long.valueOf(str+String.format("%013d", rannum)+xString);//后两位收尾为xString  
}  
	/**
	 * 生成以04结尾的字符串
	 * @return
	 */
	public static Long getRandomDefineFix04() {  
		  
    SimpleDateFormat simpleDateFormat;  

    simpleDateFormat = new SimpleDateFormat("yyyy");  

    Date date = new Date();  

    String str = simpleDateFormat.format(date);  

    Random random = new Random();  

    long rannum = (long) (random.nextDouble() * 100000000L);// 获取9位随机数  

    return Long.valueOf(str+String.format("%013d", rannum)+"04");//收尾为04  
}  
	/**
	 * @author yueling
	 * 生成以04或者05结尾的字符串
	 * @return
	 */
	public static Long getRandomDefineFix04_1() {  
		  
    SimpleDateFormat simpleDateFormat;  

    simpleDateFormat = new SimpleDateFormat("yyyy");  

    Date date = new Date();  

    String str = simpleDateFormat.format(date);  

    Random random = new Random();  

    long rannum = (long) (random.nextDouble() * 100000000L);// 获取9位随机数  

    return Long.valueOf(str+String.format("%013d", rannum)+"0"+String.valueOf(RandomUtils.createRandom()+4));//  以04或者05结尾
}  
}
