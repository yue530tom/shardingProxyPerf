/**   
 * @Title: TOrderObject.java 
 * @Package com.dangdang.com.shardingjdbc.utils.conf 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:23:24 
 * @version V1.0   
 */
package com.dangdang.com.shardingjdbc.utils.entry;

/** 
 * @ClassName: TOrderObject 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:23:24 
 *  
 */
public class TOrderObject
{
  private long order_id;
  private String status;
  private int user_id;
  private int ip;
  
  public long getOrder_id()
  {
    return this.order_id;
  }
  
  public void setOrder_id(long order_id)
  {
    this.order_id = order_id;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public int getUser_id()
  {
    return this.user_id;
  }
  
  public void setUser_id(int user_id)
  {
    this.user_id = user_id;
  }
  
  public int getIp()
  {
    return this.ip;
  }
  
  public void setIp(int ip)
  {
    this.ip = ip;
  }
}
