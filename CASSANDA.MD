## Cassandra Day Singapore

### 1. Setup Cassandra Cluster 

#### `✅.001`- Start first 2 nodes with `docker-compose`
 
```bash
cd /workspace/conference-2022-devoxx/setup/
docker-compose up -d
```

> 🖥️ Result
>
> ```
> Creating network "setup_cassandra" with the default driver
> Creating setup_dc1_seed_1 ... done
> Creating setup_dc1_node_1 ... done
> ```


#### `✅.002`- Display containers status with `docker`
 
2 containers will start (services). The second one will wait 30s for the seed to bootstrap.
 
```bash
docker ps
```
 
#### `✅.003`- Display containers status with `docker-compose`
 
```bash
docker-compose ps
```
 
> 🖥️ Results
>
> ```bash
>     Name                    Command               State                                        Ports
> --------------------------------------------------------------------------------------------------------------------------------------------
> setup_dc1_node_1    docker-entrypoint.sh /bin/ ...   Up      7000/tcp, 7001/tcp, 7199/tcp, 9042/tcp, 9160/tcp
> setup_dc1_seed_1    docker-entrypoint.sh cassa ...   Up      7000/tcp, 7001/tcp, 7199/tcp, 0.0.0.0:9042->9042/tcp,:::9042->9042/tcp, 9160/tcp
> ```
 
#### `✅.004`- Save `seed` container id
 
In order for us to use tools like `cqlsh` and `nodetool` we have to access the container shell. here we save container id to ease future commands.
 
```bash
export dc1_seed_containerid=`docker ps | grep dc1_seed | cut -b 1-12`
echo "Seed container ID has been saved : $dc1_seed_containerid"
```
 
#### `✅.005`- Display cluster with `nodetool`
 
```
docker exec -it $dc1_seed_containerid nodetool status
```
 
> 🖥️ Result
>
> ```
> Datacenter: dc1
> ===============
> Status=Up/Down
> |/ State=Normal/Leaving/Joining/Moving
> --  Address     Load       Tokens  Owns (effective)  Host > ID                               Rack
> UN  172.28.0.2  69.05 KiB  16      100.0%8707bea1-ac47-4da0-9e96-5541d3e1431d  rack1
> UN  172.28.0.3  69.05 KiB  16      100.0%            25f43936-be10-471d-b8ac-7efe93834712  rack1
> ```
 
We expect nodes `states` to be `UN`(Up/Normal).
  
#### `✅.006`- Add a third node in the cluster (scale up of the non-seed node).
 
```bash
docker-compose up --scale dc1_node=2 -d
```
 
The command will also restart `dc1_node` unfortunately `docker-compose scale` is deprecated. We did not provide any volume so no harm also as the seed is still present the nodes wi.l synchronize.
 
To properly deploy Cassandra in Docker for a multi node configuration you should consider Kubernetes and particularly [k8ssandra.io](k8ssandra.io).
 
> 🖥️ `Result `
> ```
> gitpod /workspace/conference-2022-devoxx/setup (main) $ docker-compose up --scale dc1_node=2 -d
> [+] Running 3/3
> ⠿ Container setup-dc1_seed-1  Running                                                                                                                     0.0s
> ⠿ Container setup-dc1_node-2  Running                                                                                                                     5.3s
> ⠿ Container setup-dc1_node-1  Started                                                                                                                     5.3s
> ```
>.
 
#### `✅.007`- Check Status
 
Wait about a minute for nodes to have time to properly join the cluster.
 
```bash
docker exec -it $dc1_seed_containerid nodetool status
```
 
> 🖥️ Result
>
> ```
> Datacenter: dc1
> ===============
> Status=Up/Down
> |/ State=Normal/Leaving/Joining/Moving
> --  Address     Load       Tokens  Owns (effective)  Host > ID                               Rack
> UN  172.28.0.2  69.05 KiB  16      100.0%8707bea1-ac47-4da0-9e96-5541d3e1431d  rack1
> UN  172.28.0.3  69.05 KiB  16      100.0%            25f43936-be10-471d-b8ac-7efe93834712  rack1
> UN  172.28.0.4  69.06 KiB  16      76.0%             fe43b0d0-952b-48ec-86e1-d73ace617dc8  rack1
> ```

#### `✅.008`- Open REPL CQLSH
 
This tool is available as part of Cassandra installation.  `C.Q.L` stands for _Cassandra Query Language_ and `sh` for shell.
 
```bash
docker exec -it $dc1_seed_containerid cqlsh
```
 
#### `✅.009`- Display local node informations
 
Table `system.local` contains information relative to the current node (here `dc1_seed`).
 
```sql
select cluster_name,data_center,rack,broadcast_address
from system.local;
```
 
> 🖥️ Result
>
> ```
>  cluster_name | data_center | rack  | broadcast_address
> --------------+-------------+-------+-------------------
>       handson |         dc1 | rack1 |        172.28.0.2
>
> (1 rows)
> ```
 
#### `✅.010`- Display information for the 2 others nodes
 
Information for other nodes are stored in `system.peers`.
 
```sql
select data_center,rack,peer
from system.peers;
```
 
> 🖥️ Result
>
> ```
> cqlsh> select data_center,rack,peer from system.peers;
>
> data_center | rack  | peer
> -------------+-------+------------
>         dc1 | rack1 | 172.28.0.4
>         dc1 | rack1 | 172.28.0.3
>
> (2 rows)
> ```
 

### 2. Working with Data

#### `✅.001`- Keyspace creation
 
A Keyspace is a logical grouping of objects. Best practice is to create a keyspace per application.
 
A single application can work with multiple `keyspaces` within the same session. It can be useful if some data needs to be replicated in different manners (the replication factor is per keyspace).
 
Let's create the keyspace `devoxx`.
 
```sql
CREATE KEYSPACE IF NOT EXISTS cassandra_day
WITH REPLICATION = {
 'class' : 'NetworkTopologyStrategy',
 'dc1' : 3
}  AND DURABLE_WRITES = true;
```

#### `✅.002`- List keyspaces
 
```sql
describe keyspaces;
```

#### `✅.003`- Create table
 
```sql
CREATE TABLE IF NOT EXISTS sensors_by_network (
    network         TEXT,
    sensor          TEXT,
    temperator      DECIMAL,
    PRIMARY KEY ((network), sensor)
);
```

#### `✅.004`- Import Data

```sql
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('forest', 'f001', 92);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('forest', 'f002', 88);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('volcano', 'v001', 210);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('sea', 's001', 45);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('sea', 's002', 50);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('home', 'h001', 72);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('car', 'c001', 69);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('car', 'c002', 70);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('dog', 'd001', 40);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('road', 'r001', 105);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('road', 'r002', 110);
INSERT INTO sensors_by_network(network, sensor, temperature) VALUES('ice', 'i001', 35);
```

#### `✅.005`- Select Data

- Select All

```sql
select * from sensors_by_network;
```

- Select by partition

```sql
select * from sensors_by_network 
where network='car';
```

- Select by partition

```sql
select token(network),network,sensor,temperature from sensors_by_network where network='car';
```

### 3. Working with API

#### Rest API

[REST API](https://dad4f3d7-c76b-4883-8b81-432f233b1685-northeurope.apps.astra.datastax.com/api/rest/swagger-ui/#/)

#### Graph QL

[GRAPHQL API](https://dad4f3d7-c76b-4883-8b81-432f233b1685-northeurope.apps.astra.datastax.com/api/playground)

```yaml
query getAllSensor {
    sensors_by_network (value: {network:"car"}) {
      values {
      	network
        temperature
        sensor
      }
    }
}
```




