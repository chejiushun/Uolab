/**
 * 太原科技大学(c)版权所有 2020-2023
 */
package com.yckj.uol.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * C3P0连接池数据源工厂
 * @author liuxinda
 * @version 1.0
 */
public class C3P0DataSourceFactory  extends UnpooledDataSourceFactory{
	
	public C3P0DataSourceFactory() {
		this.dataSource  = new ComboPooledDataSource();
	}
}
