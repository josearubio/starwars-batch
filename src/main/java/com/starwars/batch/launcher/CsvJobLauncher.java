package com.starwars.batch.launcher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jaro on 21/07/17.
 */
@Component
public class CsvJobLauncher {

    //baellgund the exchange api get api json
    //alernativa obtener el string a pelo y con un objectmapper convertimos el objeto
    private JobLauncher jobLauncher;
    private Job csvJob;

    public CsvJobLauncher(JobLauncher jobLauncher, Job csvJob){
        this.jobLauncher = jobLauncher;
        this.csvJob = csvJob;
    }

    @Scheduled(fixedDelay = 15000)
    public void run() throws Exception{
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(csvJob, jobParameters);
    }
}
