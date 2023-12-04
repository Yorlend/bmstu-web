This is ApacheBench, Version 2.3 <$Revision: 1903618 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)


Server Software:        nginx/1.25.0
Server Hostname:        localhost
Server Port:            8080

Document Path:          /api/v1/users
Document Length:        92 bytes

Concurrency Level:      100
Time taken for tests:   9.419 seconds
Complete requests:      3000
Failed requests:        0
Total transferred:      1185000 bytes
HTML transferred:       276000 bytes
Requests per second:    318.50 [#/sec] (mean)
Time per request:       313.974 [ms] (mean)
Time per request:       3.140 [ms] (mean, across all concurrent requests)
Transfer rate:          122.86 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.6      0       9
Processing:     6  309 350.5    138    1617
Waiting:        6  309 350.5    138    1617
Total:          6  310 350.5    139    1617

Percentage of the requests served within a certain time (ms)
  50%    139
  66%    351
  75%    459
  80%    549
  90%    852
  95%   1108
  98%   1329
  99%   1397
 100%   1617 (longest request)
