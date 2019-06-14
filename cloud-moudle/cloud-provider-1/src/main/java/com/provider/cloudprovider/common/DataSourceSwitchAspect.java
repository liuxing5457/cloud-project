package com.provider.cloudprovider.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p>
 *  数据源AOP注解实现
 * </p>
 *
 * @author lizhe
 * @since 2019-4-3
 */
@Component
@Aspect
@Order(-100)
public class DataSourceSwitchAspect {

    private Logger log= LoggerFactory.getLogger(DataSourceSwitchAspect.class);
    @Pointcut("execution(* com.ebuy.cloud.service.erp.crm.serviceerpcrm.service.common..*.*(..))")
    private void commonAspect() {
    }

    @Pointcut("execution(* com.ebuy.cloud.service.erp.crm.serviceerpcrm.service.order..*.*(..))")
    private void orderAspect() {
    }

    @Pointcut("execution(* com.ebuy.cloud.service.erp.crm.serviceerpcrm.service.system..*.*(..))")
    private void systemAspect() {
    }

    @Pointcut("execution(* com.ebuy.cloud.service.erp.crm.serviceerpcrm.service.logistics..*.*(..))")
    private void logisticsAspect() {
    }

    @Pointcut("execution(* com.ebuy.cloud.service.erp.crm.serviceerpcrm.service.warehouse..*.*(..))")
    private void warehouseAspect() {
    }

    @Pointcut("execution(* com.ebuy.cloud.service.erp.crm.serviceerpcrm.service.product..*.*(..))")
    private void productAspect() {
    }


    @Before( "commonAspect()" )
    public void basic(JoinPoint joinPoint) {
        log.info("切换到common 数据源...");
        setDataSource(joinPoint,DBTypeEnum.common);
    }

    @Before("orderAspect()" )
    public void order (JoinPoint joinPoint) {
        log.info("切换到order 数据源...");
        setDataSource(joinPoint,DBTypeEnum.order);
    }

    @Before("systemAspect()" )
    public void system (JoinPoint joinPoint) {
        log.info("切换到system 数据源...");
        setDataSource(joinPoint,DBTypeEnum.system);
    }

    @Before("logisticsAspect()" )
    public void logistics (JoinPoint joinPoint) {
        log.info("切换到logistics 数据源...");
        setDataSource(joinPoint,DBTypeEnum.logistics);
    }

    @Before("warehouseAspect()" )
    public void warehouse (JoinPoint joinPoint) {
        log.info("切换到warehouse 数据源...");
        setDataSource(joinPoint,DBTypeEnum.warehouse);
    }

    @Before("productAspect()" )
    public void product (JoinPoint joinPoint) {
        log.info("切换到product 数据源...");
        setDataSource(joinPoint,DBTypeEnum.product);
    }

    /**
     * 添加注解方式,如果有注解优先注解,没有则按传过来的数据源配置
     * @param joinPoint
     * @param dbTypeEnum
     */
    private void setDataSource(JoinPoint joinPoint, DBTypeEnum dbTypeEnum) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DataSourceSwitch dataSourceSwitch = methodSignature.getMethod().getAnnotation(DataSourceSwitch.class);
        if (Objects.isNull(dataSourceSwitch) || Objects.isNull(dataSourceSwitch.value())) {
            DbContextHolder.setDbType(dbTypeEnum);
        }else{
            log.info("根据注解来切换数据源,注解值为:"+dataSourceSwitch.value());
            switch (dataSourceSwitch.value().getValue()) {
                case "common":
                    DbContextHolder.setDbType(DBTypeEnum.common);
                    break;
                case "order":
                    DbContextHolder.setDbType(DBTypeEnum.order);
                    break;
                case "system":
                    DbContextHolder.setDbType(DBTypeEnum.system);
                    break;
                case "logistics":
                    DbContextHolder.setDbType(DBTypeEnum.logistics);
                    break;
                case "warehouse":
                    DbContextHolder.setDbType(DBTypeEnum.warehouse);
                    break;
                case "product":
                    DbContextHolder.setDbType(DBTypeEnum.product);
                    break;
                default:
                    DbContextHolder.setDbType(dbTypeEnum);
            }
        }
    }
}
