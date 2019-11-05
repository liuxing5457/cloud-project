package com.provider.cloudprovider.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.provider.cloudprovider.common.DBTypeEnum;
import com.provider.cloudprovider.common.DynamicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  持久化配置
 * </p>
 *
 * @author lizhe
 * @since 2019-4-3
 */
@Configuration
@MapperScan({"com.ebuy.cloud.service.erp.crm.serviceerpcrm.mapper.*"})
public class MybatisPlusConfig {

    /**
     * mapper-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //paginationInterceptor.setLocalPage(true);// 开启 PageHelper 的支持
        return paginationInterceptor;
    }

    /**
     * mapper-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    @Bean(name = "common")
    @ConfigurationProperties(prefix = "spring.datasource.druid.common" )
    public DataSource basic () {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "order")
    @ConfigurationProperties(prefix = "spring.datasource.druid.order" )
    public DataSource order () {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "system")
    @ConfigurationProperties(prefix = "spring.datasource.druid.system" )
    public DataSource system () {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "logistics")
    @ConfigurationProperties(prefix = "spring.datasource.druid.logistics" )
    public DataSource logistics () {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "warehouse")
    @ConfigurationProperties(prefix = "spring.datasource.druid.warehouse" )
    public DataSource warehouse () {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "product")
    @ConfigurationProperties(prefix = "spring.datasource.druid.product" )
    public DataSource product () {
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * 动态数据源配置
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource (@Qualifier("common") DataSource common,
                                          @Qualifier("order") DataSource order,
                                          @Qualifier("system") DataSource system,
                                          @Qualifier("logistics") DataSource logistics,
                                          @Qualifier("warehouse") DataSource warehouse,
                                          @Qualifier("product") DataSource product) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map< Object, Object > targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.common.getValue(), common );
        targetDataSources.put(DBTypeEnum.order.getValue(), order);
        targetDataSources.put(DBTypeEnum.system.getValue(), system);
        targetDataSources.put(DBTypeEnum.logistics.getValue(), logistics);
        targetDataSources.put(DBTypeEnum.warehouse.getValue(), warehouse);
        targetDataSources.put(DBTypeEnum.product.getValue(), product);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(order);
        return dynamicDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(multipleDataSource(basic(),order(),system(),logistics(),warehouse(),product()));

        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*Mapper.xml"));

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setPlugins(new Interceptor[]{
                paginationInterceptor()
        });
        return sqlSessionFactory.getObject();
    }


}
