package com.huatech.mall.service;


/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/

public interface ReIndexService {

	/**
	 * 对books索引进行全量重建
	 * @return
	 */
	public boolean reIndexBooks();

}
