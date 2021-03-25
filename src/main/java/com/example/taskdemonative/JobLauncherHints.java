package com.example.taskdemonative;

import org.springframework.cloud.task.batch.configuration.JobLaunchCondition;
import org.springframework.nativex.hint.InitializationHint;
import org.springframework.nativex.hint.InitializationTime;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.stereotype.Component;

import static org.springframework.nativex.hint.AccessBits.*;

@Component
@NativeHint(
		initialization = @InitializationHint(types = {
				JobLaunchCondition.class,
		}, typeNames = {
				"org.springframework.cloud.task.batch.configuration.JobLaunchCondition",
				"org.springframework.cloud.task.batch.configuration.JobLaunchCondition$SpringBatchJobCondition",
				"org.springframework.cloud.task.batch.configuration.JobLaunchCondition$FailOnJobFailureCondition",
		}, packageNames = {
				"org.springframework.cloud.task.batch.configuration"
		}, initTime = InitializationTime.BUILD),
		types = {
				@TypeHint(types = JobLaunchCondition.class, access = PUBLIC_METHODS | DECLARED_FIELDS | DECLARED_METHODS | DECLARED_CONSTRUCTORS | ALL),
		}


)
@TypeHint(types = JobLaunchCondition.class, typeNames = {"org.springframework.cloud.task.batch.configuration.JobLaunchCondition$SpringBatchJobCondition","org.springframework.cloud.task.batch.configuration.JobLaunchCondition$FailOnJobFailureCondition"}, access = ALL)
public class JobLauncherHints {
}