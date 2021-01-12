package com.huatech.mall.configurer;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/
@Component
public class ElasticSearchRestClient {
	/**
	 * http的形式接入es
	 * @return
	 */
	@Bean("highLevelClient")
	public RestHighLevelClient highLevelClient() {
		//配置你的es地址和端口 我这里是演示所以就只配置一台了
		HttpHost httpHost1 = new HttpHost("39.99.193.2", 19200);
		return new RestHighLevelClient(RestClient.builder(new HttpHost[] { httpHost1 }));
	}
}
