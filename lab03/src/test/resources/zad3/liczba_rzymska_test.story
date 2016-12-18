Given liczba

When set argument to 1
Then after conversion it should be I

When set argument to 1999
Then after conversion it should be MCMXCIX

When set argument to 2400
Then after conversion it should be MMCD

When set parameter to 0
Then illegal argument exception should be thrown

When set parameter to 6000
Then illegal argument exception should be thrown