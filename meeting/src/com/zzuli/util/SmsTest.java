package com.zzuli.util;

import com.montnets.mwgate.common.Message;
import com.montnets.mwgate.smsutil.ConfigManager;
import com.montnets.mwgate.smsutil.SmsSendConn;

public class SmsTest {

	/**
	 * @description 设置用户账号信息
	 */
	public int setAccountInfo() {
		// 设置用户账号信息

		// 用户账号
		String userid = "E100Y8";
		// 密码
		String password = "oO66lQ";
		// 发送优先级
		int priority = 1;
		// 主IP信息
		String ipAddress1 = "api01.monyun.cn:7901";

		// 备用IP1信息
		String ipAddress2 = "api02.monyun.cn:7901";
		// 备用IP2信息
		String ipAddress3 = null;
		// 备用IP3信息
		String ipAddress4 = null;
		// 返回值
		int result = -310007;
		try {
			// 设置用户账号信息
			result = ConfigManager.setAccountInfo(userid, password, priority,
					ipAddress1, ipAddress2, ipAddress3, ipAddress4);
			/*// 判断返回结果，0设置成功，否则失败
			if (result == 0) {
				System.out.println("设置用户账号信息成功！");
			} else {
				System.out.println("设置用户账号信息失败，错误码：" + result);
			}*/
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * 
	 * @description 单条发送
	 * @param smsSendConn
	 *            短信处理对象,在这个方法中调用发送短信功能
	 * @param userid
	 *            用户账号
	 */
	public int singleSend(SmsSendConn smsSendConn, String userid,String phonenum,String vcode) {
		// 返回值
		int result = -310099;
		try {
			// 参数类
			Message message = new Message();
			// 设置用户账号 指定用户账号发送，需要填写用户账号，不指定用户账号发送，无需填写用户账号
			message.setUserid(userid);
			// 设置手机号码 此处只能设置一个手机号码
			message.setMobile(phonenum);
			// 设置内容
			message.setContent("您的验证码是"+vcode+"，在3分钟内输入有效。如非本人操作请忽略此短信。");
			// 设置扩展号
			message.setExno("11");
			// 用户自定义流水编号
			message.setCustid("20160929194950100001");
			// 自定义扩展数据
			message.setExdata("abcdef");
			// 业务类型
			message.setSvrtype("SMS001");

			// 返回的流水号
			StringBuffer returnValue = new StringBuffer();
			
			// 发送短信
			result = smsSendConn.singleSend(message, returnValue);
			
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}
		return result;
	}
}
