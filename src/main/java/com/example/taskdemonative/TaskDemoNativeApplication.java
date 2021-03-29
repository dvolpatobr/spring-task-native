package com.example.taskdemonative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner;
import org.springframework.boot.jdbc.AbstractDataSourceInitializer;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.cloud.task.batch.configuration.JobLaunchCondition;
import org.springframework.cloud.task.batch.configuration.TaskBatchAutoConfiguration;
import org.springframework.cloud.task.batch.configuration.TaskBatchExecutionListenerBeanPostProcessor;
import org.springframework.cloud.task.batch.handler.TaskJobLauncherApplicationRunner;
import org.springframework.cloud.task.batch.listener.BatchEventAutoConfiguration;
import org.springframework.cloud.task.batch.listener.TaskBatchExecutionListener;
import org.springframework.cloud.task.batch.listener.support.TaskBatchEventListenerBeanPostProcessor;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.configuration.SimpleTaskAutoConfiguration;
import org.springframework.cloud.task.repository.support.TaskRepositoryInitializer;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.nativex.hint.*;

import java.sql.DatabaseMetaData;


@NativeHint(trigger= SimpleTaskAutoConfiguration.class,
        resources = @ResourceHint(patterns = {"org/springframework/cloud/task/schema-h2.sql",
                "org/springframework/cloud/task/schema-mysql.sql",
                "org/springframework/cloud/task/schema-oracle10g.sql",
                "org/springframework/cloud/task/schema-postgresql.sql",
                "org/springframework/cloud/task/schema-hsqldb.sql",
                "org/springframework/cloud/task/schema-sqlserver.sql"}),
        types = {
                @TypeHint(types = {
                        AbstractDataSourceInitializer.class,
                }, access = AccessBits.LOAD_AND_CONSTRUCT|AccessBits.DECLARED_METHODS),
                @TypeHint(types = {
                        DefaultTaskConfigurer.class,
                        JobLauncherApplicationRunner.class,
                        TaskJobLauncherApplicationRunner.class,
                        DataSourcePoolMetadataProvider.class,
                        TaskRepositoryInitializer.class,
                        LockRegistry.class,
                        TaskBatchExecutionListener.class,
                        TaskBatchAutoConfiguration.class,
                        TaskBatchExecutionListenerBeanPostProcessor.class,
                        TaskBatchEventListenerBeanPostProcessor.class,
                        JobLaunchCondition.class,
                        BatchEventAutoConfiguration.class
                }, access = AccessBits.ALL),
                @TypeHint(typeNames = { "org.springframework.cloud.task.batch.configuration.JobLaunchCondition$FailOnJobFailureCondition"
                }, access = AccessBits.ALL),
                @TypeHint(typeNames = { "org.springframework.cloud.task.batch.configuration.JobLaunchCondition$SpringBatchJobCondition"
                }, access = AccessBits.ALL),
                @TypeHint(types= {DatabaseMetaData.class})},
        proxies = {
                @ProxyHint(typeNames = {
                        "org.springframework.cloud.task.batch.configuration.TaskBatchExecutionListenerBeanPostProcessor",
                        "org.springframework.aop.SpringProxy",
                        "org.springframework.aop.framework.Advised",
                        "org.springframework.core.DecoratingProxy"}),
                @ProxyHint(typeNames = {
                        "org.springframework.cloud.task.batch.configuration.TaskBatchEventListenerBeanPostProcessor",
                        "org.springframework.aop.SpringProxy",
                        "org.springframework.aop.framework.Advised",
                        "org.springframework.core.DecoratingProxy"}),
                @ProxyHint(typeNames = {
                        "org.springframework.cloud.task.repository.TaskRepository",
                        "org.springframework.aop.SpringProxy",
                        "org.springframework.aop.framework.Advised",
                        "org.springframework.core.DecoratingProxy"}),
                @ProxyHint(typeNames = {
                        "org.springframework.cloud.task.repository.TaskExplorer",
                        "org.springframework.aop.SpringProxy",
                        "org.springframework.aop.framework.Advised",
                        "org.springframework.core.DecoratingProxy"}),
                @ProxyHint(typeNames = {
                        "org.springframework.transaction.PlatformTransactionManager",
                        "org.springframework.aop.SpringProxy",
                        "org.springframework.aop.framework.Advised",
                        "org.springframework.core.DecoratingProxy"}),
                @ProxyHint(typeNames = {
                        "java.util.concurrent.ConcurrentMap",
                        "java.io.Serializable",
                        "java.util.Map",
                        "org.springframework.aop.SpringProxy",
                        "org.springframework.aop.framework.Advised",
                        "org.springframework.core.DecoratingProxy"})
        })
@SpringBootApplication
@EnableTask
public class TaskDemoNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskDemoNativeApplication.class, args);


    }

}
