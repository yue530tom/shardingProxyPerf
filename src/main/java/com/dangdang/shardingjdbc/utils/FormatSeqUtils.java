/**   
 * @Title: FormatSeqUtils.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:25:30 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

/** 
 * @ClassName: FormatSeqUtils 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:25:30 
 *  
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class FormatSeqUtils {
    static Logger logger = Logger.getLogger("com.dangdang.com.shardingjdbc.utils.CreateSeqId");
    static AtomicLong atomicLong = new AtomicLong();

    public static int getip() {
	logger.info("getip");
	try {
	    String address = InetAddress.getLocalHost().getHostAddress();
	    return Integer.parseInt(address.substring(address.lastIndexOf('.') + 1));
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	}
	return 0;
    }

    public static int decimalAddr = getip();

    public static long MyAtomicLong() {
	return atomicLong.incrementAndGet();
    }

    public static long getSeqId(int xTimes, int formatLength) {
	return formatLong(decimalAddr, Long.valueOf(xTimes * MyAtomicLong()), formatLength).longValue();
    }

    public static long getSeqId(int xTimes) {
	return getSeqId(xTimes, 11);
    }

    public static long getSeqId() {
	return getSeqId(1);
    }

    public static long getSeqId(Long seq, int formatLength) {
	return formatLong(decimalAddr, seq, formatLength).longValue();
    }

    public static long getSeqId(Long seq) {
	return getSeqId(seq, 11);
    }

    public static Long formatLong(int hostAddress, Long seq, int formatLength) {
	return Long.valueOf(Long.parseLong(String.valueOf(hostAddress) + String.format(new StringBuilder().append("%0")
		.append(formatLength - String.valueOf(hostAddress).length()).append("d").toString(),
		new Object[] { seq })));
    }
}
