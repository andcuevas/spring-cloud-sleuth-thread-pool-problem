# Spring Cloud Sleuth with Thread Pool Problem Example

This is a small example of a problem I found when using Spring ThreadPoolTaskExecutor.

When using the thread pool the original trace id is not used for the asynchronous process. When the pool is not used the trace id is assigned to the asynchronous process without problems.

## How to run
Run the Spring boot application using the class com.example.Application.

Trigger the following URL's:

http://localhost:1076/without_pool
http://localhost:1076/with_pool

You will see the following entries in the log:

    2016-09-16 15:19:26.695  INFO [-,4adbf9119ae81330,4caff443a69ad12,false] 20030 --- [nio-1076-exec-1] com.example.Application                  : Executing without pool.
    2016-09-16 15:19:26.706  INFO [-,4adbf9119ae81330,f4531218cbc7c6f0,false] 20030 --- [cTaskExecutor-1] com.example.Application                  : This task is running without a pool.
    2016-09-16 15:19:35.445  INFO [-,a9d54e83d23946c3,13a8847f788f91d9,false] 20030 --- [nio-1076-exec-2] com.example.Application                  : Executing with pool.
    2016-09-16 15:19:35.448  INFO [-,c31fbe9183c4031,c31fbe9183c4031,false] 20030 --- [lTaskExecutor-1] com.example.Application                  : This task is running with a pool.
