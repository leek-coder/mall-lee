package com.huatech.mall.complexity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间统计执行器
 */
public class TimeTools {
	private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

	public interface Task {
		/**
		 * 执行器
		 */
		void execute();
	}
	
	public static void check(String title, Task task) {
		if (task == null){ return;}
		title = (title == null) ? "" : ("【" + title + "】");
		System.out.println(title);
		System.out.println("开始：" + fmt.format(new Date()));
		long begin = System.currentTimeMillis();
		task.execute();
		long end = System.currentTimeMillis();
		System.out.println("结束：" + fmt.format(new Date()));
		double delta = (end - begin) / 1000.0;
		System.out.println("耗时：" + delta + "秒");
		System.out.println("-------------------------------------");
	}
}
