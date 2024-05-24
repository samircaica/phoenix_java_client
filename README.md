# phoenix_java_client

## Execution:
```

cd phoenix_java_client

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
HDP:
javac -cp "/usr/hdp/current/phoenix-client/phoenix-thin-client.jar:." TestClientThin.java

CDP:
javac -cp "/opt/cloudera/parcels/CDH/lib/phoenix_queryserver/phoenix-queryserver-client-X.0.0.X.Y.Z.0-ABC.jar:." TestClientThin.java

- Kerberos:

HDP
java -cp "/usr/hdp/current/phoenix-client/phoenix-thin-client.jar:." TestClientThin http://<PQS_HOST> 8765 SPNEGO PROTOBUF <principal> <keytab>

CDP:
java -cp "/opt/cloudera/parcels/CDH/lib/phoenix_queryserver/phoenix-queryserver-client-X.0.0.X.Y.Z.0-ABC.jar:." TestClientThin http://<PQS_HOST> 8765 SPNEGO PROTOBUF <principal> <keytab>

- Basic

HDP:
java -cp "/usr/hdp/current/phoenix-client/phoenix-thin-client.jar:." TestClientThin http://<PQS_HOST> 8765 BASIC PROTOBUF

CDP:
java -cp "/opt/cloudera/parcels/CDH/lib/phoenix_queryserver/phoenix-queryserver-client-X.0.0.X.Y.Z.0-ABC.jar:." TestClientThin http://<PQS_HOST> 8765 BASIC PROTOBUF
```

