package com.zzuli.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.montnets.mwgate.common.GlobalParams;
import com.montnets.mwgate.smsutil.ConfigManager;
import com.montnets.mwgate.smsutil.SmsSendConn;
import com.zzuli.util.SmsTest;

/**
 * Servlet implementation class SmsServlet
 */
public class SmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		String phone = request.getParameter("phone");
		System.out.println(phone);
		
		SmsTest st = new SmsTest();
		// 用户账号
		String userid = "E100Y8";

		// 创建全局参数
		GlobalParams globalParams = new GlobalParams();
		// 设置请求路径
		globalParams.setRequestPath("/sms/v2/std/");
		// 设置是否需要日志 1:需要日志;0:不需要日志
		globalParams.setNeedLog(1);
		// 设置全局参数
		ConfigManager.setGlobalParams(globalParams);

		// 设置用户账号信息
		st.setAccountInfo();

		// 是否保持长连接
		boolean isKeepAlive = true;
		// 实例化短信处理对象
		SmsSendConn smsSendConn = new SmsSendConn(isKeepAlive);
		//随机生成验证码
		int code1 = (int)(Math.random()*10);
		int code2 = (int)(Math.random()*10);
		int code3 = (int)(Math.random()*10);
		int code4 = (int)(Math.random()*10);
		String vcode = ""+code1+""+code2+""+code3+""+code4;
		// 单条发送
		int result = st.singleSend(smsSendConn, userid,phone,vcode);
		
		PrintWriter out = response.getWriter();
		String json = null;
		// result为0:成功
		if (result == 0) {
			System.out.println("单条发送提交成功！");
			json = JSON.toJSONString(vcode);
			//System.out.println(returnValue.toString());
		}
		// result为非0：失败
		else {
			System.out.println("单条发送提交失败,错误码：" + result);
			json = JSON.toJSONString(false);
		}
		out.print(json);
		out.flush();
		out.close();
	}


}
