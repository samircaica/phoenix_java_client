# phoenix_java_client

## Execution:
```
cp /etc/hbase/conf/hbase-site.xml .
cp /etc/hadoop/conf/hdfs-site.xml .
cp /etc/hadoop/conf/core-site.xml .

Thick client:
javac -cp "/usr/hdp/current/phoenix-client/phoenix-client.jar:." TestClientThick.java

Kerberos:
java -cp "/usr/hdp/current/phoenix-client/phoenix-client.jar:." TestClientThick <ZK_HOST> 2181 KERBEROS /hbase-secure <principal> <keytab>

Basic:
java -cp "/usr/hdp/current/phoenix-client/phoenix-client.jar:." TestClientThick <ZK_HOST> 2181 BASIC /hbase-unsecure

Thin client:
javac -cp "/usr/hdp/current/phoenix-client/phoenix-thin-client.jar:." TestClientThin.java

Kerberos:
java -cp "/usr/hdp/current/phoenix-client/phoenix-thin-client.jar:." TestClientThin http://<PQS_HOST> 8765 SPNEGO <principal> <keytab>

Basic
java -cp "/usr/hdp/current/phoenix-client/phoenix-thin-client.jar:." TestClientThin http://<PQS_HOST> 8765 BASIC
```

