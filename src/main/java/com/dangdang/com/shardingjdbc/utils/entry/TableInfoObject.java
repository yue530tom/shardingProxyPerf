/**   
 * @Title: TableInfoObject.java 
 * @Package com.dangdang.com.shardingjdbc.utils.conf 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:23:41 
 * @version V1.0   
 */
package com.dangdang.com.shardingjdbc.utils.entry;

/**
 * @ClassName: TableInfoObject
 * @Description: TODO
 * @author yueling
 * @date 2018年5月9日 下午5:23:41
 * 
 */

public class TableInfoObject {
    private long min;
    private long max;
    private long minSeq;
    private long maxSeq;

    public long getMin() {
	return this.min;
    }

    public void setMin(long min) {
	this.min = min;
    }

    public long getMax() {
	return this.max;
    }

    public void setMax(long max) {
	this.max = max;
    }

    public long getMinSeq() {
	return this.minSeq;
    }

    public void setMinSeq(long minSeq) {
	this.minSeq = minSeq;
    }

    public long getMaxSeq() {
	return this.maxSeq;
    }

    public void setMaxSeq(long maxSeq) {
	this.maxSeq = maxSeq;
    }
}
