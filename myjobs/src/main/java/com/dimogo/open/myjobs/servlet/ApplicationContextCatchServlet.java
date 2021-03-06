package com.dimogo.open.myjobs.servlet;

import com.dimogo.open.myjobs.quartz.MyJobExecutor;
import com.dimogo.open.myjobs.quartz.MyJobMaster;
import com.dimogo.open.myjobs.quartz.MyJobSlave;
import com.dimogo.open.myjobs.sys.ExecutorResourceMonitor;
import com.dimogo.open.myjobs.utils.ZKUtils;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by Ethan Xiao on 2017/4/2.
 */
public class ApplicationContextCatchServlet extends HttpServlet {
	public ApplicationContextCatchServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ApplicationContextCatcher.getInstance().set(context);

		Thread masterThread = new Thread(MyJobMaster.getInstance());
		Thread slaveThread = new Thread(MyJobSlave.getInstance());
		Thread monitorThread = new Thread(ExecutorResourceMonitor.getInstance());
		Thread executorThread = new Thread(MyJobExecutor.getInstance());
		masterThread.start();
		executorThread.start();
		slaveThread.start();
		monitorThread.start();

		ZkClient zkClient = ZKUtils.newClient();
		ZKUtils.initSupperUser(zkClient);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

}
