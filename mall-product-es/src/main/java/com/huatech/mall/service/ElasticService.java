package com.huatech.mall.service;

import java.util.List;
import java.util.Map;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/
public interface ElasticService {

	/**
	 * 增加es索引
	 * @param doc
	 * @param index
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public Boolean add(Map<String, Object> doc, String index, String type) throws Exception;

	/**
	 * 增加索引类型
	 * @param docs
	 * @return
	 */
	public Boolean adds(List<Map<String, Object>> docs);

	/**
	 * 往索引库里批量增加数据
	 * @param datas
	 * @param index
	 * @param type
	 * @return
	 */
	public Boolean addBulkIn(List<Map<String, Object>> datas, String index, String type);

	/**
	 * 删除索引
	 * @param index
	 * @return
	 */
	public Boolean delete(String index);


}
