package com.example.taskdemonative;

import org.mariadb.jdbc.util.DefaultOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.batch.configuration.JobLaunchCondition;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.nativex.hint.InitializationHint;
import org.springframework.nativex.hint.InitializationTime;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;

import static org.springframework.nativex.hint.AccessBits.*;
import static org.springframework.nativex.hint.AccessBits.ALL;


@SpringBootApplication
@NativeHint(
		initialization = @InitializationHint(types = {
				JobLaunchCondition.class,
		}, typeNames = {
				"org.springframework.cloud.task.batch.configuration.JobLaunchCondition",
				"org.springframework.cloud.task.batch.configuration.JobLaunchCondition$SpringBatchJobCondition",
				"org.springframework.cloud.task.batch.configuration.JobLaunchCondition$FailOnJobFailureCondition",
				"org.mariadb.jdbc.util.DefaultOptions"
		}, packageNames = {
				"org.springframework.cloud.task.batch.configuration",
				"org.mariadb.jdbc.util"
		}, initTime = InitializationTime.BUILD),
		types = {
				@TypeHint(types = {JobLaunchCondition.class, DefaultOptions.class}, access = PUBLIC_METHODS | DECLARED_FIELDS | DECLARED_METHODS | DECLARED_CONSTRUCTORS | ALL),
		}


)
@TypeHint(types = {JobLaunchCondition.class, DefaultOptions.class}, typeNames = {"org.springframework.cloud.task.batch.configuration.JobLaunchCondition$SpringBatchJobCondition","org.springframework.cloud.task.batch.configuration.JobLaunchCondition$FailOnJobFailureCondition","org.mariadb.jdbc.util.DefaultOptions"}, access = ALL)
@EnableTask
public class TaskDemoNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskDemoNativeApplication.class, args);


	}

}
