/**
 * 太原科技大学(c)版权所有 2020-2023
 */
package com.yckj.uol.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 *
 * @author liuxinda
 * @version 1.0
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory{
	public DruidDataSourceFactory() {
		this.dataSource =new DruidDataSource();
	}
}
