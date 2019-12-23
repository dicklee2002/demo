package com.example.demo;

import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		//System.out.println("现在时间延后1小时："+getForwardTimeFreeSet(1));
	}
	
	public static void main(String[] args) {
		System.out.println("现在时间延后1小时："+getForwardTimeFreeSet(1));
	}
	
   /**
    * 取当前系统时间(yyyy-MM-dd HH:mm:ss)
    */
	public static String getNow_Time()
	{
		Date date = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = simpledateformat.format(date);
		return s;
	}

	public static int getUHour()
	{
		Calendar calendar = Calendar.getInstance();
		return calendar.get(11);
	}

	public static int getUMinutes()
	{
		Calendar calendar = Calendar.getInstance();
		return calendar.get(12);
	}
	
	/**
	 * getForwardTimeFreeSet 自定义取当前时间各个大天1单位的延后1个单位标准数字时间(包有小时/日期/月份/年份)
	 * @param setType  1取延后1小时 2取延后1天 3取延后1个月 4取延后1年
	 * @return  完整的日期+时间(yyyy-MM-dd HH:mm:ss)
	 */
	public static String getForwardTimeFreeSet(int setType){
		int iTemp = 0;
		String bakStr = getNow_Time();
		if (setType>0){
			if (setType==1){//当前的小时大于1的取提前1小时
				if (bakStr.length()>=10){
					iTemp = getUHour();
					if (iTemp>1){  
						if (iTemp<10){
						   bakStr = bakStr.substring(0,11)+"0"+(iTemp+1)+bakStr.substring(13);
						}else{
							 bakStr = bakStr.substring(0,11)+(iTemp+1)+bakStr.substring(13);
						}
					}
				}
			}else if (setType==2){//当前的日期大于1号的取提前1天
				if (bakStr.length()>=10){
					iTemp = Integer.parseInt(bakStr.substring(8,10));
					if (iTemp>1){  
						if (iTemp<10){
						   bakStr = bakStr.substring(0,8)+"0"+(iTemp+1)+bakStr.substring(10);
						}else{
							 bakStr = bakStr.substring(0,8)+(iTemp+1)+bakStr.substring(10);
						}
					}
				}
			}else if (setType==3){//当前的月份大于1月份的取提前1月
				if (bakStr.length()>=7){
					iTemp = Integer.parseInt(bakStr.substring(5,7));
					if (iTemp>1){  
						if (iTemp<10){
						   bakStr = bakStr.substring(0,5)+"0"+(iTemp+1)+bakStr.substring(7);
						}else{
							 bakStr = bakStr.substring(0,5)+(iTemp+1)+bakStr.substring(7);
						}
					}
				}
			}else if (setType==4){//当前的年份大于1年的取提前1年
				if (bakStr.length()>=4){
					iTemp = Integer.parseInt(bakStr.substring(0,4));
					if (iTemp>1){
						if (iTemp<1000){
						   bakStr = "000"+(iTemp+1)+bakStr.substring(4);
						}else{
							 bakStr =(iTemp+1)+bakStr.substring(4);
						}
					}
				}
			}	
		}		
		return bakStr;
	}

}
