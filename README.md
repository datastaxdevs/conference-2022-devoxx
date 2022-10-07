## 🧑🏻‍💻 🧑🏾‍💻 A Java developer Journey into Apache Cassandra™ 👩🏿‍💻 👩‍💻

[![License Apache2](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/datastaxdevs/conference-2022-devoxx)
[![Discord](https://img.shields.io/discord/685554030159593522)](https://discord.com/widget?id=685554030159593522&theme=dark)
![Java](https://img.shields.io/badge/Java-17%20&%20GraalVM-00CC00?style=flat)


ℹ️ **About this Session**

> During this deep-dive session, we will give you everything you need to master this technology: from <b>architecture</b> to <b>data modeling</b>, from <b>drivers to</b> best practices.</b> Through practical labs requiring no installation, we will browse and run applications implemented with Spring Boot, Quarkus, and Micronaut in order to see how Apache Cassandra™ can be used in modern java applications.

⏲️ **Duration :** `3 hours`

🎓 **Level** `Intermediate`

## 📋 Table of content


#objectives
#materials

#setup
 #start-gitpod
 #starting-apache-cassandra-cluster
 #scaling-up-cluster
 #create-keyspace-devoxx

#connectivity
 #connect--with-drivers
 #drivers-configuration

#working-with-cql
  #getting-started
  #advanced-data-types

- [Objectives](#objectives)
- [Materials](#materials)
- [Prerequisites](#-prerequisites)
- [**Environment Setup**](#setup)
  - [Start `Gitpod`](#start-gitpod)
  - [Start Apache Cassandra™ cluster](#starting-apache-cassandra-cluster)
  - [Scale the cluster up](#scaling-up-cluster)
  - [Create keyspace](#create-keyspace-devoxx)

- [**Connectivity**](#working-with-cql)
  - [Connect with drivers](#connect--with-drivers)
  - [Drivers Configuration](#drivers-configuration)
  
- [**Working with CQL**](#working-with-cql)
  - [Simple Types](#getting-started)
  - [Advanced Data Types](#advanced-data-types)

  - [2.1 - Tables and simple data types](#21---tables-et-types-de-données-simples)
  - [2.2 - CRUD unitary operations](#22---opérations-create-read-update-delete)
  - [2.3 - Understanding CQL](#23---grammaire-des-requêtes-avec-cql)
  - [2.4 - Advanced Data Types](#24---types-de-données-avancés)
  - [2.5 - Batches](#25---batches)
  - [2.6 - Secondary Indices](#26---index-secondaires)
  - [2.7 - Consistency Levels](#27---niveau-de-consistance)
  - [2.8 - Lightweight Transactions](#28---lightweight-transactions-lwt)
- [#**LAB 3 - Data Modeling**](#lab-3---modélisation-de-données)
  - [3.1 - Methdology](#31---méthodologie)
  - [3.2 - Timseries data model](#32---modèle-de-données-pour-des-timeseries)
  - [3.3 - Migrating from SQL to NoSQL](#33---de-sql-à-nosql-avec-petclinic)
- [#**LAB 4 - Deep Dive with Drivers**](#lab-4---introduction-aux-drivers)
  - [4.1 - Connectivity](#41---connectivité)
  - [4.2 - Schema Definition](#42---création-du-schéma)
  - [4.3 - Working with Statements](#43---création-des-statements)
  - [4.4 - Create, Read, Update and Delete operations](#44---opération-create-read-update-delete-crud)
  - [4.5 - Batches](#45---batches)
  - [4.6 - Paging](#46---pagination)
  - [4.7 - Collections types: List, Map and UDT](#47---travailler-avec-list-set-et-map)
  - [4.8 - Working with  JSON](#48---requêter-avec-json)
  - [4.9 - Asynchroeous Programming](#49---programmation-asynchrone)
  - [4.10 - Reactive Programming](#410---programmation-réactive)
  - [4.11 - Counters](#411---les-counters)
  - [4.12 - Lightweight Transactions](#412---les-lightweight-transactions)
  - [4.13 - Object Mapping](#413---object-mapping)
- [#**LAB 5 - Spring Data Cassandra**](#lab-5---spring-data-cassandra)
  - [5.1 - Connection and Configuration](#51---configuration)
  - [5.2 - `CassandraRepository` and `CrudRepository`](#52---comprendre-les-crudrepositories)
  - [5.3 - Usage of `CassandraOperations`](#53---cassandraoperations)
  - [5.4 - Spring Boot Applications](#54---application-spring-boot)
- [#**LAB 6 - Cassandra Quarkus extension**](#lab-6---cassandra-quarkus-extension)
  - [6.1 - Introduction to Quarkus extensions](#61---introduction-aux-extensions-quarkus)
  - [6.2 - Connecton and configuration](#62---connexion-et-configuration)
  - [6.3 - Object Mapping](#63---object-mapping)
  - [6.4 - Application Quarkus](#64---application-quarkus)
- [#**LAB 7 - Micronaut Cassandra**](#lab-7---micronaut-cassandra)
  - [7.1 - Getting started with Micronaut Micronaut](#71---introduction-à-micronaut)
  - [7.2 - Connection and Configuration](#72---connexion-et-configuration)
  - [7.3 - Object Mapping](#73---object-mapping)
  - [7.4 - Micronaut Applications ](#74---application-micronaut)

---
## Objectives 

- 🎯 Discover what the NoSQL Database Apache Cassandra is and what are the relevant **use cases**
- 🎯 Understand how Apache Cassandra™ is different from relational database in the phylosophy and **data modeling**.
- 🎯 Practice on how **Java Applications** connect to the databases, what are the rules and things to know.
- 🎯 Learn how to work with Cassandra notions through the drivers, CRUD, Advanced Data Types, Batches, Lightweight transactions
- 🎯 Setup a Spring Boot application leverating Cassandra, Spring Data and Spring Boot
- 🎯 Setup Quarkus applications leverating Cassandra
- 🎯 Setup Micronaut Boot applications leverating Cassandra
- 🎯 Work with GraalVm and native compilation

## Materials

It doesn't matter if you join the presentation live or you prefer to work at your own pace later, we have you covered. In this repository, you'll find everything you need for this workshop:

- [Slide deck](content/slides.pdf)
- [Datastax Developers Discord chat](https://bit.ly/cassandra-workshop)
- [Questions and Answers](https://community.datastax.com/)


## Prerequisites

Instructions are provided to you to work within `gitpod` cloud IDE. Intention is to execute easily the steps with no installation required. You can of course use your own laptop and you will need a couple of tools

#### 📦 Docker
> - Use the [reference documentation](https://www.docker.com/products/docker-desktop) to install **Docker Desktop**
> - Validate your installation with
> ```bash
> 
> docker -v
> docker run hello-world
> ```

#### 📦 Java Development Kit (JDK) 17+
> - Use the [reference documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) to install a >**Java Development Kit**
> - Validate your installation with
> 
> ```bash
> java --version
> ```

#### 📦 Apache Maven (3.6+)
> - Use the [reference documentation](https://maven.apache.org/install.html) to install **Apache Maven**
> - Validate your installation with
> 
> ```bash
> mvn -version
> ```

#### 📦 GraalVM (22.1.r17+)
> - Use the [reference documentation](https://www.graalvm.org/22.0/docs/getting-started/#install-graalvm) to install **GraalVM**
> 
> - Validate your installation with
> 
> ```bash
> lli --version
> gu --version
> ```

## Setup

### Start `Gitpod`

[Gitpod](https://www.gitpod.io/) is a Free IDE provided as Saas. He leverages [VS Code](https://github.com/gitpod-io/vscode/blob/gp-code/LICENSE.txt?lang=en-US) and comes loaded with all tools needed to develop with multiple languages.

#### `✅.001`- _Right Click_ to open Gitpod in a new browser tab.

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/datastaxdevs/conference-2022-devoxx)

### Starting Apache Cassandra™ cluster

Once gitpod has launched you should find a couple of terminals available. Locate `setup`, you will get this message.

```
------------------------------------------------------------
---            Welcome to Devoxx  2022                   ---
------------------------------------------------------------
```

 ℹ️ **Copy-Paste in Gitpod**
> For the first `copy-paste` within `Gitpod` you are invited to authorize them. Please do so to keep moving in the session.
 

In `lab1-setup` locate  `docker-compose.yml`. We will run the Cassandra  [officia image™](https://hub.docker.com/_/cassandra/).

#### `✅.002`- Open the file and visualize the file, check how `seed` service is isolated from others. Recommendation is one `seed` per rack (2 / 3 `seeds` per ring/dc)

```bash
gp open /workspace/conference-2022-devoxx/setup/docker-compose.yml
```

#### `✅.003`- Start first 2 nodes with `docker-compose`

```bash
cd /workspace/conference-2022-devoxx/setup/
docker-compose up -d
```

> 🖥️ Result
>
> ```
> [+] Running 3/3
>  ⠿ Network labs_cassandra           Created      0.0s
>  ⠿ Container lab1-dc1_seed-1        Started      0.4s
>  ⠿ Container lab1-dc1_node-1        Started      1.2s
> ```

#### `✅.004`- Display containers status with `docker`

2 containers will start (services). The second one will wait 30s for the seed to bootstrap.

```bash
docker ps
```

#### `✅.005`- Display containers status with `docker-compose`

```bash
 docker-compose ps
```

> 🖥️ Results
>
> ```bash
>     Name                    Command               State                                        Ports
> --------------------------------------------------------------------------------------------------------------------------------------------
> lab1_dc1_node_1    docker-entrypoint.sh /bin/ ...   Up      7000/tcp, 7001/tcp, 7199/tcp, 9042/tcp, 9160/tcp
> lab1_dc1_seed_1    docker-entrypoint.sh cassa ...   Up      7000/tcp, 7001/tcp, 7199/tcp, 0.0.0.0:9042->9042/tcp,:::9042->9042/tcp, 9160/tcp
> ```

#### `✅.006`- Save `seed` container id

In order for us to use tools like `cqlsh` and `nodetool` we have to access container shell. here we save container id to ease future commands.

```bash
export dc1_seed_containerid=`docker ps | grep dc1_seed | cut -b 1-12`
echo "Seed container ID has been saved : $dc1_seed_containerid"
```

#### `✅.007`- Display cluster with `nodetool`

```
docker exec -it $dc1_seed_containerid nodetool status
```

> 🖥️ Result (after about 1min)
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

### Scaling up Cluster

#### `✅.008`- Add a third node in the cluster (scale up of the non-seed node).

```bash
docker-compose up --scale dc1_node=2 -d
```

The command will also restart `dc1_noeud` unfortunately `docker-compose scale` is deprecated. We did not provided any volume so no harm also as the seed is still present the nodes wi.l synchronize.

To deploy properly Cassandra in Docker for a multi node configuration you should consider Kubernetes and particuly [k8ssandra.io](k8ssandra.io).

#### `✅.009`- Check Status

Wait about a minute for nodes to have time to properly join the cluster.

```bash
docker exec -it $dc1_seed_containerid nodetool status
```

> 🖥️ Result (after about 1min)
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

### Create keyspace `devoxx`

#### `✅.010`- Open REPL CQLSH

This tool is available as part of Cassandra installation.  `C.Q.L` stands for _Cassandra Query Language_ and `sh` for shell.

```bash
docker exec -it $dc1_seed_containerid cqlsh
```

#### `✅.011`- Display local node informations

Table `system.local` contains information relative to current node (here `dc1_seed`).

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

#### `✅.012`- Display information for the 2 others nodes

Information for others nodes are stored in `system.peers`.

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

#### `✅.013`- Keyspace creation

A Keyspace is a logical grouping of objects. Best practice is to create a keyspace per application.

A single application can work with multiple `keyspaces` within the same session. It can be useful if some data need to be replicated in different manner (the replication factor is per keyspace).

Let's creat the keyspace `devoxx`.

```sql
CREATE KEYSPACE IF NOT EXISTS devoxx
WITH REPLICATION = {
  'class' : 'NetworkTopologyStrategy',
  'dc1' : 3
}  AND DURABLE_WRITES = true;
```

⁉️ `NetworkTopologyStrategy`

> `NetworkTopologyStrategy` will always be used except for tests with a single node. Under those conditions you will use `SimpleReplicationStrategy`.
> 
> ```sql
> CREATE KEYSPACE IF NOT EXISTS test_simple_strategy
> WITH REPLICATION = {
>   'class' : 'SimpleStrategy',
>   'replication_factor': '1'
> } AND DURABLE_WRITES = true;
> ```

⁉️ `DURABLE_WRITES`

> In Cassandra write path, Data will be written first into memory  (`memtable`). Then data is _flushed_  on disk into immutable files (SSTABLE). This will happen wether by vacation or when a threshold in memory is reached. 
>
> Using `DURABLE_WRITES = true` is a way to enable `commit log`: before writing into memory data will be persisted in an already open file on disk. It will prevent the loss of data if something goes wrong before data in memeory is flushed. `True` is the default value.

#### `✅.014`- List keyspaces

- In Cqlsh: 
```sql
describe keyspaces;
```

> 🖥️ Result
>
> ```
> devoxx  system_auth         system_schema  system_views
> system  system_distributed  system_traces  system_virtual_schema
> ```

## Connectivity

### Connect with drivers

- Check project `lab-cassandra-drivers` configuration file `pom.xml`

```
gp open /workspace/conference-2022-devoxx/lab-cassandra-drivers/pom.xml
```

- Run  `E00_TestConnectivityTest`

```
cd /workspace/conference-2022-devoxx/lab-cassandra-drivers
gp open /workspace/conference-2022-devoxx/lab-cassandra-drivers/src/test/java/com/datastax/devoxx/E00_ConnectivityTest.java
mvn test -Dtest=com.datastax.devoxx.E00_ConnectivityTest
```

### Drivers configuration

- Check project `lab-cassandra-drivers` configuration file `application.conf`

```
gp open /workspace/conference-2022-devoxx/lab-cassandra-drivers/src/main/resources/application.conf
```

## Working with CQL

### Getting Started

We keep using `cqlsh` to illustrate what have been seen so far

#### `✅.025`- list Keyspaces

Check that `devoxx` is one of the keyspace

```sql
describe KEYSPACES;
```

#### `✅.026`- Select keyspace `devoxx`

```sql
use devoxx;
```

#### `✅.027`-  List Tables in keyspaces `devoxx`

No suspense, the schema is empty

```sql
desc tables;
```

#### `✅.028`- Create your first table

```sql
CREATE TABLE IF NOT EXISTS city_by_country (
	country     text,
	city        text,
	population  int,
	PRIMARY KEY ((country), city)
);
```

ℹ️ **Note**:
> - `IF NOT EXISTS` permet d'avoir une commande idempotente
> - les colonnes sont de types simples `text` et `int`
> - La `clé primaire` en plusieurs parties que nous détaillerons par la suite.

#### `✅.029`- Insert a few rows

```sql
INSERT INTO city_by_country(country, city, population)
VALUES('FR','Paris', 2187526);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Marseille', 863310);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Lyon', 516092);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Toulouse', 479553);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Nice', 340017);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Nantes', 309346);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Montpellier', 285121);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Strasbourg', 280966);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Bordeaux', 254436);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Lille', 232787);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Rennes', 216815);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Reims', 182460);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Saint-Etienne', 172565);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Toulon', 171953);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Le Havre', 170147);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Grenoble', 158454);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Dijon', 156920);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Angers', 150610);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Saint-Denis', 147931);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Villeurbanne', 147712);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Clermont-Ferrand', 143886);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Le Mans', 142946);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Aix-en-Provence', 142482);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Brest',  140064);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Tours', 135787);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Amiens', 134057);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Limoges', 132175);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Annecy', 126924);

INSERT INTO city_by_country(country, city, population)
VALUES('FR','Perpignan', 120158);

INSERT INTO city_by_country(country, city, population)
VALUES('USA','New York', 8000000);

INSERT INTO city_by_country(country, city, population)
VALUES('USA','Los Angeles', 4000000);

INSERT INTO city_by_country(country, city, population)
VALUES('DE','Berlin', 3350000);

INSERT INTO city_by_country(country, city, population)
VALUES('UK','London', 9200000);

INSERT INTO city_by_country(country, city, population)
VALUES('AU','Sydney', 4900000);

INSERT INTO city_by_country(country, city, population)
VALUES('DE','Nuremberg', 500000);

INSERT INTO city_by_country(country, city, population)
VALUES('CA','Toronto', 6200000);

INSERT INTO city_by_country(country, city, population)
VALUES('CA','Montreal', 4200000);

INSERT INTO city_by_country(country, city, population)
VALUES('JP','Tokyo', 37430000);

INSERT INTO city_by_country(country, city, population)
VALUES('IN','Mumbai', 20200000);
```

ℹ️ **Note**:
> - The guy writing the readme really has a biase for french cities
> - Intructions are very close from `SQL` (not but exactly the same)

#### `✅.030`-  List records in table

```sql
select * from city_by_country;
```

#### `✅.031`- List french cities

<p/>
<details>
<summary>Click to display solution</summary>

```sql
select * from city_by_country 
WHERE country='FR';
```

</details>
<p/>

#### `✅.032`- Search for city `Brest`

<p/>
<details>
<summary>Click to show solution</summary>

```sql
select * from city_by_country 
WHERE country='FR' 
AND city='Brest';
```

</details>
<p/>

#### `✅.033`- Update Brest population to `142000` inhabitants

<p/>
<details>
<summary>Click to show solution</summary>
*Update*

```sql
update city_by_country 
SET population=142000 
WHERE country='FR' 
AND city='Brest';
```

*with Insert (as any insert is also an upset)*
```sql
INSERT INTO city_by_country(country, city, population) 
VALUES('FR','Brest',  142000);
```

</details>
<p/>

#### `✅.034`- Delete row with city of `Tokyo`

<p/>
<details>
<summary>Click to show solution</summary>

```sql
DELETE FROM city_by_country 
WHERE country='JP'
AND city='Tokyo';
```

*Check:*
```sql
select * from city_by_country 
WHERE country='JP';
```

</details>
<p/>

ℹ️ **Note**:
> When you delete a record in Cassandra it is not really deleted on disk, it creates a marker called a  `Tombstone` that need to be cleaned during an operation called compaction. If you miss some space on disk, delete here is not a good solution.

#### `✅.035`- Delete rows related to country Canada `(CA)`

<p/>
<details>
<summary>Click to show solution</summary>

```sql
DELETE FROM city_by_country 
WHERE country='CA';
```

*Vérification:*
```sql
select * from city_by_country 
WHERE country='CA';
```

</details>
<p/>

#### `✅.036`- Delete row for country `AU` and city `Sydney`

<p/>
<details>
<summary>Click to show solution</summary>

```sql
DELETE population 
FROM city_by_country 
WHERE country='AU' 
AND city='Sydney';
```

*Vérification:*
```sql
SELECT * from city_by_country 
WHERE country='AU';
```

</details>
<p/>

#### `✅.037`- Request over partition key with equalities `=`

- List cities for France `FR`.

```sql
SELECT * FROM city_by_country
WHERE country='FR';
```

#### `✅.038`- Request over partition key with `IN` claue

- Display list of cities for `CA` or `DE`.

```sql
select * FROM city_by_country
WHERE country IN('CA', 'DE');
```

⚠️ **Important**
> ```
> It is possible to do it, it is not recommended, it will move
> the load from the client application the coordinator, issue
> parallel request if you have to do it (N+1 select)
> ```

#### `✅.039`- Equality and clustering keys

- Show `Brest` city (country=`FR`)

```sql
SELECT * FROM city_by_country
WHERE country='FR'
AND city='Brest';
```

#### `✅.040`- Inequality and clustering keys

- Show french cities starting with a `P` and next using alphabetical ordering.

```sql
SELECT * FROM city_by_country
WHERE country='FR'
AND city>'P';
```

#### `✅.041`- Use `GROUP BY` and average function `AVG`

- Show average population grouped by country

```sql
SELECT country, AVG(CAST(population AS FLOAT)) AS avg_population
FROM city_by_country
GROUP BY country;
```

#### `✅.042`- Use `GROUP BY` and function `COUNT`

- Show number of cities per country

```sql
SELECT country, count(city) as nb_villes
FROM city_by_country
GROUP BY country;
```

#### `✅.044`- Clean the table

To avoid creating tombstones we will use `TRUNCATE` instead of `DELETE`.

```sql
TRUNCATE city_by_country;
```

## Advanced data types.

There a lot of different simple scalar types in CQL : `VARCHAR`, `ASCII`, `TINYINT`, `SMALLINT`, `INT`, `BIGINT`, `VARINT`, `FLOAT`, `DOUBLE`, `DECIMAL`, `TIME`, `TIMESTAMP`, `DATE`, `DURATION`, `BOOLEAN`, `BLOB`, et `INET`. Here is the [complete list](https://docs.datastax.com/en/cql-oss/3.x/cql/cql_reference/cql_data_types_c.html).

Some types considered as _advanced_ need to be mentionned

- Unitque identifier or `UUID` which types: `UUID` and `TIMEUUID`
- Collectiosn withs `SET`, `LIST` and `MAP`
- Tuples with `TUPLE`
- `UDT` (_User-Defined-Types_): `CREATE TYPE`, `ALTER TYPE`, `DROP TYPE` and `DESCRIBE TYPE`
- Counters `COUNTER`

### `UUIDS`

Un `UUID` est un nombre sur 128 bits qui peut être généré automatiquement. Ils sont utilisés pour identifier une entité ou une relation dans les bases Cassandra.

Ils fournissent une manière efficace de créer des identifiants sans introduire de synchronisation entre les nœuds. On s'affranchit ainsi d'`UPSERT` involontaires lors des accès concurrents (`MAX()`).

Le CQL supporte les 2 types suivants:

- `UUID` est un UUID dit de version 4 généré de manière aléatoire. Pour les générer on utilise la fonction `uuid()`.
- `TIMEUUID` est un UUID dit de version 1, il est construit sur la base de l'adresse MAC et d'un timestamp. Pour les générer on utilise la fonction `now()`. On peut extraire le `timestamp` d'un `TIMEUUID` avec les fonctions `unixTimestampOf()` ou `dateOf()`.

#### `✅.045`- Comprendre les `UUID`

- Créer une table `user` dont la clé primaire `id` est un `uuid`.

```sql
CREATE TABLE IF NOT EXISTS users (
  id UUID,
  name TEXT,
  age INT,
  PRIMARY KEY ((id))
);
```

#### `✅.046`- Insérer des enregistrements avec des `UUID`

- Insérer un enregistrement en utilisant une valeur fixe `7902a572-e7dc-4428-b056-0571af415df3` et un second avec la fonction `now()`.

```sql
INSERT INTO users (id, name, age)
VALUES (7902a572-e7dc-4428-b056-0571af415df3, 'Joe', 25);

INSERT INTO users (id, name, age)
VALUES (uuid(), 'Jen', 27);

SELECT * FROM users;
```

#### `✅.047`- Exercice `UUID`

- Créer une table `movies`, dont la partition est `id` de type `UUID` et insérer les lignes suivantes:

| id                                   | title                        | year     | duration |
| ------------------------------------ | ---------------------------- | -------- | -------- |
| 5069cc15-4300-4595-ae77-381c3af5dc5e | Alice au pays des Merveilles | 2010 108 |
| uuid()                               | Alice                        | 1951     | 75       |

<p/>
<details>
<summary>Cliquer pour afficher la solution</summary>

```sql
CREATE TABLE movies (
  id UUID,
  title TEXT,
  year INT,
  duration INT,
  PRIMARY KEY ((id))
);

INSERT INTO movies (id, title, year, duration)
VALUES (5069cc15-4300-4595-ae77-381c3af5dc5e,
'Alice au pays des Merveilles', 2010, 108);

INSERT INTO movies (id, title, year, duration)
VALUES (uuid(), 'Alice', 1951, 75);
```

*Vérification:*
```sql
SELECT * FROM movies;
```

</details>
<p/>

### 2.4.2 - Les `SET`

Comme en Java un `SET` est un attribut multi-valué, non ordonné, qui assure l'unicité de chaque enregistrement (dédoublonnage). Il a lui-même un `type` qui indique quels objets l'on peut y insérer.

#### `✅.048`- Ajouter une colonne `SET` dans la table `movies`

- Ajouter la colonne `production` de type `SET<TEXT>` dans la table `movies`.

```sql
ALTER TABLE movies
ADD production SET<TEXT>;
```

#### `✅.049`- Mise à jour des enregistrements contenant un `SET`

Pour mettre à jour la valeur d'un set ou utilise des accolades `{}`.

```sql
UPDATE movies
SET production = { 'Walt Disney Pictures',
                   'Roth Films' }
WHERE id = 5069cc15-4300-4595-ae77-381c3af5dc5e;

UPDATE movies
SET production = production + { 'Team Todd' }
WHERE id = 5069cc15-4300-4595-ae77-381c3af5dc5e;

SELECT title, year, production FROM movies;
```

#### `✅.050`- Exercice `SET`

- Ajouter une colonne `genres` de type `SET<TEXT>` dans la table `movies`
- Ajouter les valeurs `Aventure`, `Famille` et `Fantasie` dans le set `genres` pour l'identifiant `5069cc15-4300-4595-ae77-381c3af5dc5e`.

<p/>
<details>
<summary>Cliquer pour afficher la solution</summary>

```sql
ALTER TABLE movies ADD genres SET<TEXT>;

UPDATE movies
SET genres = { 'Adventure', 'Family', 'Fantasy' }
WHERE id = 5069cc15-4300-4595-ae77-381c3af5dc5e;
```

Vérification:

```sql
SELECT title, year, genres FROM movies;
```

</details>
<p/>

### 2.4.3 - Les `LIST`

Comme en Java une `LIST` est un attribut multi-valué, qui conserve l'ordre d'insertion. Il a lui-même un `type` qui indique quels sont les objets que l'on peut y insérer.

Les données y sont indexées, on peut donc accéder à un élément en fournissant l'offset.

#### `✅.051`- Ajouter une colonne `LIST` dans la table `users`

- Ajouter une colonne `searches` de type `LIST<TEXT>` dans la table `users`.

```sql
ALTER TABLE users
ADD searches LIST<TEXT>;
```

#### `✅.052`- Mise à jour des enregistrements contenant une `LIST`

Pour mettre à jour la valeur d'une `LIST` ou utilise des crochets `[]`.

- Ajouter la recherche `Alice au pays des merveilles` pour l'utilisateur `7902a572-e7dc-4428-b056-0571af415df3` dans la table `users`.

```sql
UPDATE users
SET searches = [ 'Alice au pays des merveilles' ]
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

- Ajouter la recherche `Comedies` pour l'utilisateur `7902a572-e7dc-4428-b056-0571af415df3` dans la table `users`.

```sql
UPDATE users
SET searches = searches + [ 'Comedies' ]
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

- Ajouter une seconde fois `Alice au pays des merveilles` pour l'utilisateur `7902a572-e7dc-4428-b056-0571af415df3` dans la table `users`.

```sql
UPDATE users
SET searches = searches + [ 'Alice au pays des merveilles' ]
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

- Vérification du résultat.

```sql
SELECT id, name, searches FROM users;
```

### 2.4.4 - Les `MAP`

Les maps sont une collection de clé/valeur. Dans un map, chaque clé est unique. La clé et la valeur sont toutes deux typées, on peut écrire une map sous la forme `MAP<TEXT, TEXT>`.

#### `✅.053`- Ajouter une colonne `MAP` dans la table `users`

- Ajouter une colonne nommée `session` de type `MAP<TIMEUUID, INT>` dans la table `users`

```sql
ALTER TABLE users ADD sessions MAP<TIMEUUID,INT>;
SELECT name, sessions FROM users;
```

#### `✅.054`- Ajouter/Supprimer des éléments d'une `MAP`

Pour mettre à jour la valeur d'une `MAP` ou utilise à nouveau les accolades `{ cle1:valeur1 , cle2:valeur2 }`.

- Définir une session pour l'utilisateur `7902a572-e7dc-4428-b056-0571af415df3` en utilisant `now()`.

```sql
UPDATE users
SET sessions = { now(): 32, e22deb70-b65f-11ea-9aac-99396fc4f757: 7 }
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

- Vérification

```sql
SELECT name, sessions FROM users;
```

#### `✅.055`- Remplacer un élément d'une `MAP`

```sql
UPDATE users
SET sessions[e22deb70-b65f-11ea-9aac-99396fc4f757] = 9
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

- Vérification

```sql
SELECT name, sessions FROM users;
```

#### `✅.056`- Exercice sur les `MAP`

- Ajouter une colonne `preferences` sur la table `users` de type `MAP<TEXT,TEXT>`. - Insérer les valeurs `color=noir, qualité=auto` dans cette map pour l'utilisateur `7902a572-e7dc-4428-b056-0571af415df3`.

<p/>
<details>
<summary>Cliquer pour afficher la solution</summary>

```sql
ALTER TABLE users ADD preferences MAP<TEXT,TEXT>;
UPDATE users
SET preferences['color'] = 'dark'
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;

UPDATE users
SET preferences['quality'] = 'auto'
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

Vérification:

```sql
SELECT id, name, preferences FROM users;
```

</details>
<p/>

### 2.4.5 - Collections Imbriquées 🪆🪆🪆

Il est possible d'imbriquer les collections les unes dans les autres. On peut ainsi avoir une liste de listes de maps. (`LIST<LIST<MAP<TEXT,TEXT>>>`).

Les collections imbriquées doivent contenir le terme `FROZEN`. Elles sont en effet stockées comme un blob. En d'autres termes, si l'un des items est mis à jour, c'est toute la liste qui est réécrite.

#### `✅.057`- Ajouter une colonne avec des collections imbriquées

- Ajouter une colonne nommée `crew` de type `MAP<TEXT,<LIST<TEXT>>>` dans la table `movies`

```sql
ALTER TABLE movies
ADD crew MAP<TEXT,FROZEN<LIST<TEXT>>>;
SELECT title, year, crew FROM movies;
```

#### `✅.058`- Ajouter et supprimer des éléments

- Dans la table `movies`, pour le film `5069cc15-4300-4595-ae77-381c3af5dc5e`, ajouter les valeurs pour `crew`: cast=[Johnny Depp,Mia Wasikowska] et directed by=[Tim Burton]

```sql
UPDATE movies
SET crew = {
  'cast': ['Johnny Depp', 'Mia Wasikowska'],
  'directed by': ['Tim Burton']
 }
WHERE id = 5069cc15-4300-4595-ae77-381c3af5dc5e;
SELECT title, year, crew FROM movies;
```

### 2.4.6 - Les `Tuples`

Un tuple est une liste de **taille fixe**. Chaque item de la liste peut avoir son propre type. Un tuple sera donc de la forme `TUPLE<type1, type2, ...typeN>`.

#### `✅.059`- Ajouter une colonne `TUPLE`

- Ajouter une colonne nommée `full_name` de type `TUPLE<TEXT,TEXT,TEXT>` dans la table `users`

```sql
ALTER TABLE users ADD full_name TUPLE<TEXT,TEXT,TEXT>;
```

#### `✅.060`- Mettre à jour un `TUPLE`

Pour mettre à jour un tuple on utilise des **parenthèses simples** `()`.

- Dans la table `users`, pour l'utilisateur `7902a572-e7dc-4428-b056-0571af415df3`, définir la valeur du `full_name` par `(Joe, The, Great)`.

```sql
UPDATE users
SET full_name = ('Joe', 'The', 'Great')
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;

SELECT name, full_name FROM users;
```

A l'inverse des User Defined types (UDT), il est nécessaire de mettre à jour tout le tuple à chaque fois et c'est pour cette raison **qu'ils sont peu utilisés.** on préfèrera les `UDT` qui sont, de fait, strictement supérieurs.

### 2.4.7 - Les `UDT` ou User Defined Type

Les `UDT` ou `User Defined Type` sont des structures _custom_ que vous pouvez définir comme vous voulez, des sous-types à votre convenance. Il est possible de les imbriquer également avec la contrainte FROZEN présentée en [2.2.5](#).

#### `✅.061`- Création d'un `UDT`

- Créer un `UDT` nommé `ADDRESS`

```sql
CREATE TYPE IF NOT EXISTS ADDRESS (
    street  TEXT,
    city    TEXT,
    state   TEXT,
    zipcode INT
);
```

#### `✅.062`- Ajouter une colonne de type `UDT`

- Ajouter une colonne `address` dans la table `users` de type `ADDRESS`.

```sql
ALTER TABLE users ADD address ADDRESS;
SELECT name, address FROM users;
```

#### `✅.063`- Renseigner une colonne de type `UDT`

La mise à jour d'un `UDT` est faite avec des accolades `{ attribut:'valeur'}`. Le nom de l'attribut ne prend pas de guillemets.

- Dans la table `users`, ajouter une adresse de votre choix pour l'utilisateur `7902a572-e7dc-4428-b056-0571af415df3`.

```sql
UPDATE users
SET address = { street: '1100 Congress Ave',
                city: 'Austin',
                state: 'Texas',
                zipcode: 78701 }
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;

SELECT name, address FROM users
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

#### `✅.064`- Mettre à jour une colonne de type `UDT`

- Dans la table `users`, pour l'utilisateur `7902a572-e7dc-4428-b056-0571af415df3` mettez à jour uniquement le `address.state` avec une nouvelle valeur `TX`.

```sql
UPDATE users
SET address.state = 'TX'
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
SELECT name,
       address.street      AS street,
       address.city        AS city,
       address.state       AS state,
       address.zipcode     AS zip
FROM users
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

#### `✅.065`- Exercice UDT

- Ajouter une colonne `previous_addresses` sur la table `user` comme une liste d'adresses (LIST<ADDRESS>), attention elle est considérée comme un type imbriqué.
- Renseigner 2 valeurs de votre choix pour `previous_addresses` pour notre utilisateur `7902a572-e7dc-4428-b056-0571af415df3`.

<p/>
<details>
<summary>Cliquer pour afficher la solution</summary>

```sql
ALTER TABLE users
ADD previous_addresses LIST<FROZEN<ADDRESS>>;

UPDATE users
SET previous_addresses = [
{ street: '10th and L St',
city: 'Sacramento',
state: 'CA',
zipcode: 95814 } ]
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;

UPDATE users
SET previous_addresses = previous_addresses + [
{ street: 'State St and Washington Ave',
city: 'Albany',
state: 'NY',
zipcode: 12224 } ]
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

Vérification:

```sql
SELECT name, address, previous_addresses
FROM users
WHERE id = 7902a572-e7dc-4428-b056-0571af415df3;
```

</details>
<p/>

### 2.4.8 - Les `Counter`

Un `counter` est un entier signé de 64 bits. Ce dernier est distribué mais sa mise à jour peut-être réalisée de manière rapide _(pas de lecture avant écriture)_ sans race condition _(accès concurrents)_

Cassandra définit le type `COUNTER` qui induit plusieurs restrictions:

- La valeur ne peut être ni forcée ou ni réinitialisée, on ne peut qu'incrémenter ou décrémenter. Si la valeur n'existait pas elle est insérée en considérant que la valeur par défaut était de `0`.
- Une table avec un `COUNTER` ne doit contenir que des colonnes de type `counter` en dehors de sa clé primaire.

#### `✅.066`- Création d'une table avec des counters

- Créer une table `movie_stats` contenant un identifiant `id` de type `uuid` et 2 counters.

```sql
CREATE TABLE movie_stats (
  id UUID,
  num_ratings COUNTER,
  sum_ratings COUNTER,
  PRIMARY KEY ((id))
);
```

#### `✅.067`- Mises à jour d'enregistrements avec counters

- Insérer un enregistrement pour le film `5069cc15-4300-4595-ae77-381c3af5dc5e` avec les valeurs `num_ratings=1` et `sum_ratings=7`.

```sql
UPDATE movie_stats
SET num_ratings = num_ratings + 1,
    sum_ratings = sum_ratings + 7
WHERE id = 5069cc15-4300-4595-ae77-381c3af5dc5e;
```

- Pour cet enregistrement, incrémenter `num_ratings` de `1` et `sum_ratings` de `9`.

```sql
UPDATE movie_stats
SET num_ratings = num_ratings + 1,
    sum_ratings = sum_ratings + 9
WHERE id = 5069cc15-4300-4595-ae77-381c3af5dc5e;

SELECT * FROM movie_stats;
```

#### `✅.068`- Exercice

- Dans la table `movie_stats`, ajouter une nouvelle colonne de type `counter` avec le nom `num_views` indiquant le nombre de vues pour chaque film
- Incrémenter le 3 fois de `1`.

<p/>
<details>
<summary>Cliquer pour afficher la solution</summary>

```sql
ALTER TABLE movie_stats ADD num_views COUNTER;

UPDATE movie_stats
SET num_views = num_views + 1
WHERE id = 5069cc15-4300-4595-ae77-381c3af5dc5e;

UPDATE movie_stats
SET num_views = num_views + 1
WHERE id = 5069cc15-4300-4595-ae77-381c3af5dc5e;

UPDATE movie_stats
SET num_views = num_views + 1
WHERE id = 5069cc15-4300-4595-ae77-381c3af5dc5e;
```

Vérification:

```sql
SELECT * FROM movie_stats;
```

</details>
<p/>

### 2.4.9 - Requêter avec `JSON`

Il est possible de requêter (lecture et écriture) directement les tables en JSON. Les documents JSON devront respecter le schéma des tables sous-jacentes.

#### `✅.069`- Créer une table `videos` avec un `UDT` `video_format`

```sql
CREATE TYPE IF NOT EXISTS video_format (
  width   int,
  height  int
);

CREATE TABLE IF NOT EXISTS videos (
 videoid   uuid,
 title     text,
 upload    timestamp,
 email     text,
 url       text,
 tags      set <text>,
 frames    list<int>,
 formats   map <text,frozen<video_format>>,
 PRIMARY KEY (videoid)
);
```

#### `✅.070`- Insertions dans la table `videos` avec `CQL`

```sql
INSERT INTO videos(videoid, email, title, upload, url, tags, frames, formats)
VALUES(uuid(), 'clu@sample.com', 'sample video',
     toTimeStamp(now()), 'http://google.fr',
     { 'cassandra','accelerate','2020'},
     [ 1, 2, 3, 4],
     { 'mp4':{width:1,height:1},'ogg':{width:1,height:1}});

INSERT INTO videos(videoid, email, title, upload, url)
VALUES(uuid(), 'clu@sample.com', 'video2', toTimeStamp(now()), 'http://google.fr');

select videoid, email, title from videos;
```

#### `✅.071`- Insertions dans la table `videos` avec `JSON`

```sql
INSERT INTO videos JSON '{
   "videoid":"e466f561-4ea4-4eb7-8dcc-126e0fbfd573",
     "email":"clunven@sample.com",
     "title":"A video inserted with JSON",
     "upload":"2020-02-26 15:09:22 +00:00",
     "url": "http://google.fr",
     "frames": [1,2,3,4],
     "tags":   [ "cassandra","accelerate", "2020"],
     "formats": {
        "mp4": {"width":1,"height":1},
        "ogg": {"width":1,"height":1}
     }
}';

select videoid, email, title from videos;
```

#### `✅.072`- Requêter un enregistrement avec `JSON`

_Traditionnellement:_

```sql
select * from videos
WHERE videoid=e466f561-4ea4-4eb7-8dcc-126e0fbfd573;
```

_Avec l'option JSON:_

```sql
select JSON * from videos
WHERE videoid=e466f561-4ea4-4eb7-8dcc-126e0fbfd573;
```

## 2.5 - Batches

### 2.5.1 - Introduction aux Batches `Atomic`

Avec Cassandra les opérations individuelles d'`insert`, `update`, `delete` sont atomiques (`atomic` = elles sont exécutées ou non, c'est blanc ou noir, pas de statut intermédaire) et isolées (`isolated` = les mises à jour ne sont pas visibles pour les autres). Afin de proposer de l'atomicité pour un groupe d'instructions, Cassandra fournit les batches.

On peut en recenser de 2 natures:

- On travaille avec une partition unique (`single-partition`) : Il n'y aura qu'un seul accès à la base et l'on peut garantir le tout-ou-rien. Le cas principal pour son utilisation est la mise à jour de plusieurs enregistrements qui seraient considérés comme corrompus si l'atomicité n'était pas assurée.

- On travaille avec plusieurs partitions (`multi-partition batch`) soit au sein de la même table soit à travers plusieurs tables. Cette fois, il s'agit de mettre à jour la même donnée dans plusieurs tables. Cette donnée aurait été dupliquée pour les besoins de la dénormalisation.

La syntaxe pour le `BATCH` est la suivante:

```sql
BEGIN BATCH
  INSERT ...; | UPDATE ...; | DELETE ...;
  [...]
APPLY BATCH;
```

Remarques importantes:

- Les batches `single-partition` peuvent utiliser les `Lightweight Transactions` mais pas les autres. (nous les aborderons au chapitre `2.8`)
- L'ordre des instructions n'est pas important, les instructions seront toutes exécutées en parallèle.

### 2.5.2 - `EXEMPLE BATCH 1` - Le caddie

#### `✅.073`- Création du schéma

- Voici une table permettant de stocker les différents articles du caddie dans un site de vente en ligne

\_Les colonnes `STATIC` sont des colonnes qui ne font pas partie de la clé primaire et qui ont la même valeur pour tous les enregistrements d'une même partition.

```sql
CREATE TABLE shopping_cart (
  cart_id   UUID,
  title     TEXT,
  year      INT,
  price     DECIMAL,
  user      TEXT STATIC,
  total     DECIMAL STATIC,
  PRIMARY KEY ((cart_id), title, year)
);
```

#### `✅.074`- Insertion Atomique avec un Batch

- Insérer 3 articles dans le même caddie `b7255608-4a42-4829-9b84-a355e0e5100d` avec un `BATCH`

```sql
BEGIN BATCH
  INSERT INTO shopping_cart
         (cart_id, title, year, price, user)
  VALUES (b7255608-4a42-4829-9b84-a355e0e5100d,
         'Alice au pays des merveilles', 2010, 1.99,
         'joe@datastax.com');

  INSERT INTO shopping_cart
         (cart_id, title, year, price, user)
  VALUES (b7255608-4a42-4829-9b84-a355e0e5100d,
         'Alice', 1951, 0.99,
         'joe@datastax.com');

  INSERT INTO shopping_cart (cart_id, total)
  VALUES (b7255608-4a42-4829-9b84-a355e0e5100d, 2.98)
  IF NOT EXISTS;
APPLY BATCH;
```

#### `✅.075`- Vérification

- Afficher les articles du caddie `b7255608-4a42-4829-9b84-a355e0e5100d`

```sql
SELECT total, price, title, year
FROM shopping_cart
WHERE cart_id = b7255608-4a42-4829-9b84-a355e0e5100d;
```

#### `✅.076`- Exercice

- Mettre à jour le caddie en ajoutant un autre item et en mettant à jour le total. On notera que total est une colonne `static`, mettre à jour la valeur d'un record, met à jour la valeur pour tous les enregistrements.

<p/>
<details>
<summary>Cliquer pour afficher la solution</summary>

```sql
BEGIN BATCH

INSERT INTO shopping_cart (cart_id, title, year, price, user)
VALUES (b7255608-4a42-4829-9b84-a355e0e5100d, 'Edward Scissorhands', 1990, 3.99, 'joe@datastax.com');

UPDATE shopping_cart
SET total = 6.97
WHERE cart_id = b7255608-4a42-4829-9b84-a355e0e5100d
IF total = 2.98;

APPLY BATCH;
```

Vérification:

```sql
SELECT total, price, title, year
FROM shopping_cart
WHERE cart_id = b7255608-4a42-4829-9b84-a355e0e5100d;
```

</details>
<p/>

### 2.5.3 - `EXEMPLE BATCH 2` - Mise à jour de plusieurs tables avec un BATCH

#### `✅.077`- Créations du schéma

Pour des raisons de dénormalisation par exemple, il est fréquent d'enregistrer la même donnée au sein de 2 tables avec des clés primaires différentes.

- Créer deux tables `ratings_by_user` et `ratings_by_movie` indiquant le rating d'un film avec la colonne `rating` de type `int`.

```sql
CREATE TABLE  IF NOT EXISTS ratings_by_user (
  email TEXT,
  title TEXT,
  year INT,
  rating INT,
  PRIMARY KEY ((email), title, year)
);

CREATE TABLE  IF NOT EXISTS ratings_by_movie (
  title TEXT,
  year INT,
  email TEXT,
  rating INT,
  PRIMARY KEY ((title, year), email)
);
```

#### `✅.078`- Insertion d'enregistrements avec un Batch (multi-partition)

- Pour l'utilisateur `'joe@datastax.com`, insérer le rating `9` pour le film `Alice aux pays des merveilles` (2010).

```sql
BEGIN BATCH
  INSERT INTO ratings_by_user (email, title, year, rating)
  VALUES ('joe@datastax.com', 'Alice aux pays des merveilles', 2010, 9);
  INSERT INTO ratings_by_movie (email, title, year, rating)
  VALUES ('joe@datastax.com', 'Alice aux pays des merveilles', 2010, 9);
APPLY BATCH;
```

#### `✅.079`- Mise à jour d'enregistrements avec un Batch (multi-partition)

- Mettre à jour le même rating avec la valeur `10`.

```sql
BEGIN BATCH
  UPDATE ratings_by_user SET rating = 10
  WHERE email = 'joe@datastax.com'
    AND title = 'Alice aux pays des merveilles'
    AND year  = 2010;
  UPDATE ratings_by_movie SET rating = 10
  WHERE email = 'joe@datastax.com'
    AND title = 'Alice aux pays des merveilles'
    AND year  = 2010;
APPLY BATCH;
```

#### `✅.080`- Affichage du rating

- Pour afficher les valeurs utiliser la clé primaire complète (email, title, year)

```sql
SELECT * FROM ratings_by_user
WHERE email = 'joe@datastax.com'
  AND title = 'Alice aux pays des merveilles'
  AND year  = 2010;

SELECT * FROM ratings_by_movie
WHERE title = 'Alice aux pays des merveilles'
  AND year  = 2010
  AND email = 'joe@datastax.com';
```

#### `✅.081`- Suppression d'enregistrements avec un Batch (multi-partition)

- Pour supprimer les valeurs, il convient d'utiliser la clé primaire complète (email, title, year)

```sql
BEGIN BATCH
  DELETE FROM ratings_by_user
  WHERE email = 'joe@datastax.com'
    AND title = 'Alice aux pays des merveilles'
    AND year  = 2010;
  DELETE FROM ratings_by_movie
  WHERE email = 'joe@datastax.com'
    AND title = 'Alice aux pays des merveilles'
    AND year  = 2010;
APPLY BATCH;
```

## 2.6 - Index Secondaires

Lorsqu'il est nécessaire de requêter la même donnée de plusieurs manières le choix par défaut est de **créer une nouvelle table avec une autre clé primaire**.

Maintenant, dans les cas aux limites, **lorsque la cardinalité est faible** (peu de partitions contiennent la valeur) alors on peut utiliser un index secondaire.

#### `✅.082`- Rappels sur la table `city_by_country`

- Afficher la structure de la table `city_by_country`

```sql
describe table city_by_country;
```

La partition key étant la colonne `country`, nous pouvons exécuter la requête suivante:

```sql
SELECT *
FROM city_by_country
WHERE country='FR';
```

En revanche, il n'est pas possible de rechercher sur les villes uniquement (sans ALLOW FILTERING). La partition n'étant pas fournie, cela entraînerait un full scan du cluster.

```sql
SELECT *
FROM city_by_country
WHERE city='Paris';
```

`--- oups: L'erreur était attendue. ---`

#### `✅.083`- Création d'un index secondaire

On considère qu'il existe peu de villes qui s'appellent `Paris` au travers des différents pays, la cardinalité est donc faible.

- Créer un index `country_city_idx`, dans la table `city_by_country` sur la colonne `city`

```sql
CREATE INDEX IF NOT EXISTS country_city_idx
ON city_by_country (city);
```

#### `✅.084`- Requêter avec un index

- Utiliser l'index nouvellement créé pour lister la ville de `Paris`.

```sql
SELECT * FROM city_by_country
WHERE city='Paris';
```

- Afficher les informations relatives à l'index `country_city_idx`

```sql
describe index country_city_idx;
```

> ℹ️ Sur Astra vous pouvez voir un index `CUSTOM` nommé `StorageAttachedIndex` (ou SAI). Un CEP est actuellement ouvert pour le verser dans `Cassandra 4.1`.
>
> ```
> CREATE CUSTOM INDEX country_city_idx
> ON devoxx.city_by_country (city) USING 'org.apache.cassandra.index.sai.> StorageAttachedIndex';
> ```

> ℹ️ Il existe d'autres types d'index custom comme `Sasi` que nous n'aborderons pas en détail ici (pas dans Astra + pas activé par défaut dans Cassandra). Il possède une configuration plus fine et est adapté à certaines requêtes _full text_ ou range queries. [Plus d'informations ici](https://docs.datastax.com/en/dse/5.1/cql/cql/cql_using/useSASIIndex.html)

Les indexes secondaires ne sont pas une garantie de performance. L'index est un dictionnaire qui associe la valeur de la colonne indexée à la liste partitions contenant la valeur. L'index est distribué entre les différents nœuds. Une requête avec index est donc par définitions assez lente:

- Pour une table donnée, demande à tous les nœuds N (stockant un partie de l'index) de lister les partitions contenant la valeur (P);
- Pour chaque partition (P), scan pour repérer les enregistrements.

La cardinalité est donc (P \* E) on ne multiplie pas par N car tous les nœuds travaillent mais le réseau peut également ralentir la requête. Plus d'informations sur les indexes secondaires sont disponibles [ici](https://www.doanduyhai.com/blog/?p=13191)


## Consistency Level

As of we do have a single datacenter `dc1`  with 3 nodes like the picture below

![my-pic](img/cluster-docker.png?raw=true)


#### `✅.085`- Show and define consistency level in `CQLSH`


If needed start the cqlsh command in your terminal

```
docker exec -it $dc1_seed_containerid cqlsh
```

- Execute the following

```sql
CONSISTENCY;
CONSISTENCY LOCAL_QUORUM;
```

#### `✅.086`- Activer les logs `trace` et exécuter une requête:

```sql
TRACING ON;

SELECT country,city, population
FROM city_by_country
WHERE country='DE';


TRACING OFF;
```

On notera que seuls 2 nœuds parmi les trois ont eu besoin de répondre avant de retourner le résultat au client.

#### `✅.087`- Règle d'or pour la consistance.

La règle d'or afin d'obtenir un système consistant à tout instant ( `immediate consistency`) c'est d'avoir, la somme des niveaux de consistance en lecture et écriture (CL_READ et CL_WRITE) supérieure au facteur de rèplication (RF)

```
CL_READ + CL_WRITE > RF
```

- Imaginons une écriture en quorum. Sur la figure ci-dessous, les deux noeuds marqués d'une coche ont confirmé la prise en compte de l'écriture. Le dernier replica sera mis à jour quasi-immédiatement mais à ce moment précis il est toujours inconsistant avec les 2 autres.

![my-pic](img/cl_write.png?raw=true)

- **Au même moment**, un autre client effectue une lecture en quorum sur la même donnée. Deux replicas répondent et parmi eux le nœud inconsistant. _(pas de chance ^\_^)_.

![my-pic](img/cl_read.png?raw=true)

- Cette fois le nœud qui coordonne la requête (appelé le coordinator node) prendra la valeur avec le timestamp le plus tard. La dernière écriture gagne et la réponse retournée sera correcte.

- Nous avons bien la somme du nombre de nœuds qui répondent à l'écriture `(2 = QUORUM)` et du nombre de noeuds qui répondent à la lecture `(2 = QUORUM)` strictement supérieure au facteur de réplication `(4>3)`.

Il y a plusieurs combinaisons possibles:

- `CL_READ=*QUORUM avec CL_WRITE=*QUORUM`
- `CL_READ=ONE avec CL_WRITE=ALL`
- `CL_READ=ALL avec CL_WRITE=ONE`



## 2.8 - LightWeight Transactions (LWT)

### 2.8.1 - Linearizable Consistency

L'_`eventual consistency`_, avec son niveau de consistance configurable, est suffisante pour bien des cas de la vie quotidienne - mais pas tous.

Certaines fois, il est nécessaire de se prémunir de _race condition_, c'est-à-dire la mise à jour de la même valeur par deux acteurs différents. C'est ce que l'on appelle la `Linearizable Consistency`.

### 2.8.2 - Introduction aux LWT

Avec Cassandra, pour assurer la `Linearizable Consistency` on utilise les _lightweight transactions_ ou _LWT_.

```sql
INSERT INTO ... VALUES ...
IF NOT EXISTS;

UPDATE ... SET ... WHERE ...
IF EXISTS | IF predicate [ AND ... ];

DELETE ... FROM ... WHERE ...
IF EXISTS | IF predicate [ AND ... ];
```

Avec Cassandra, afin de rendre les requêtes les plus rapides possibles, on veut éviter de faire des _lectures_ avant _écritures_.

Ici on ne peut s'y soustraire, la condition `IF` précède l'écriture. Cette transaction s'appuie sur l'algorithme de consensus distribué nommé `Paxos` et nécessite une pseudo-synchronisation des noeuds. Il faut s'attendre à un temps de réponse de l'ordre de 4 fois plus lents en raison des aller-retours en le coordinateur et les réplicas.

#### `✅.088`- Création d'une table pour illustrer les LWT

- Créer une table `sample_lwt` contenant des utilisateurs et leurs mots de passe.

```sql
CREATE TABLE sample_lwt (
  username TEXT,
  email TEXT,
  name TEXT,
  password TEXT,
  reset_token UUID,
  PRIMARY KEY ((username))
);
```

#### `✅.089`- Insertion de données sous conditions avec les LWT

- Insérer l'utilisateur `dragonslayer` seulement si ce dernier n'existe pas.

```sql
INSERT INTO sample_lwt (username, email, name)
VALUES ('dragonslayer', 'joe@datastax.com', 'Joe')
IF NOT EXISTS;

INSERT INTO sample_lwt (username, email, name)
VALUES ('dragonslayer', 'jen@datastax.com', 'Jen')
IF NOT EXISTS;

SELECT * FROM sample_lwt
WHERE username = 'dragonslayer';
```

On notera que dans la réponse nous obtenons une colonne `WAS_APPLIED`:

- Si la valeur est `true` l'instruction a été exécutée.
- Si la valeur est `false` l'instruction n'a pas été exécutée (captain obvious) et toutes les colonnes de l'enregistrement sont retournées.

### 2.8.3 - `EXEMPLE LWT 1` - Reset de mots de passe

Un utilisateur veut mettre à jour son password. À sa première demande un jeton expirant au bout d'une heure est généré. Si une nouvelle demande est formulée durant cette heure, le jeton ne doit pas être mis à jour.

#### `✅.090`- Créer une demande de mise à jour de mot de passe

- Mettre à jour l'enregistrement avec un jeton temporaire pour 1 heure. On remarquera que chaque écriture dispose d'une durée de vie (par défaut illimitée) appelée TTL _time-to-live_

```sql
UPDATE sample_lwt
USING TTL 3600
SET reset_token = 6ef95fd0-9ae0-11ea-a9d2-d777ab7dec9e
WHERE username = 'devoxx_developer';

SELECT * FROM sample_lwt
WHERE username = 'devoxx_developer';
```

#### `✅.091`- Mettre à jour le mot de passe

- Une fois le mot de passe mis à jour au moyen du reset token il n'est plus possible de recommencer l'opération.

```sql
UPDATE sample_lwt
SET reset_token = null, password = 'encrypted password'
WHERE username = 'devoxx_developer'
IF reset_token = 6ef95fd0-9ae0-11ea-a9d2-d777ab7dec9e;

UPDATE sample_lwt
SET reset_token = null, password = 'malicious password'
WHERE username = 'devoxx_developer'
IF reset_token = 6ef95fd0-9ae0-11ea-a9d2-d777ab7dec9e;
```

#### `✅.0092`- Afficher les informations de l'utilisateur

```sql
SELECT * FROM sample_lwt
WHERE username = 'devoxx_developer';
```

### 2.8.4 - `EXEMPLE LWT 2` - Annulation d'une commande

Dans cet exemple nous voulons changer le statut d'une commande. L'idée est de bloquer l'annulation de la commande lorsque l'envoi est déjà effectué.

Il peut donc passer à `cancelled` seulement si le précédent est `awaiting shipment` ou `awaiting payment`. Il peut également passer de `awaiting shipment` à `shipped`.

#### `✅.093`- Création du dataset

```sql
CREATE TABLE orders_by_user (
  username TEXT,
  order_id UUID,
  status TEXT,
  PRIMARY KEY ((username), order_id)
);

INSERT INTO orders_by_user (username, order_id, status)
VALUES ('devoxx_developer', f1fa2590-2d78-4b77-9710-95bdb45b7fa1, 'awaiting payment');

INSERT INTO orders_by_user (username, order_id, status)
VALUES ('devoxx_developer', c420d3a3-cecc-4c25-a7f8-ef28eb532969, 'awaiting shipment');

SELECT * FROM orders_by_user 
WHERE username = 'devoxx_developer';
```

#### `✅.094`- Déclencher les envois

- Mettre à jour le statut à `shipped` si les conditions sont réunies (KO)

```sql
UPDATE orders_by_user 
SET status = 'shipped'
WHERE username = 'devoxx_developer'
  AND order_id = f1fa2590-2d78-4b77-9710-95bdb45b7fa1
IF status = 'awaiting shipment';
```

- Mettre à jour le statut à `shipped` si les conditions sont réunies (OK)

```sql
UPDATE orders_by_user 
SET status = 'shipped'
WHERE username = 'devoxx_developer'
  AND order_id = c420d3a3-cecc-4c25-a7f8-ef28eb532969
IF status = 'awaiting shipment';

SELECT * FROM orders_by_user 
WHERE username = 'devoxx_developer';
```

#### `✅.095`- Tenter d'annuler les commandes

- Annuler une commande si les conditions sont réunies (OK)

```sql
UPDATE orders_by_user
SET status = 'cancelled'
WHERE username = 'devoxx_developer'
  AND order_id = f1fa2590-2d78-4b77-9710-95bdb45b7fa1
IF status IN ('awaiting payment','awaiting shipment');
```

- Annuler une commande si les conditions sont réunies (KO)

```sql
UPDATE orders_by_user
SET status = 'cancelled'
WHERE username = 'devoxx_developer'
  AND order_id = c420d3a3-cecc-4c25-a7f8-ef28eb532969
IF status IN ('awaiting payment','awaiting shipment');

SELECT * FROM orders_by_user WHERE username = 'devoxx_developer';
```

### 2.8.5 - `EXEMPLE LWT 3` - Système d'enchères

Dans cet exemple, nous allons simuler une vente aux enchères. L'enjeu est de ne pas permettre de surenchérir avec la même proposition et de gérer les accès concurrents.

#### `✅.096`- Création du schéma et import du jeu de données

- Création de la table. On notera l'enchère de départ `starting_bid`, l'enchère la plus haute `highest_bid` et le meilleur enchérisseur `highest_bidder`. Nous voulons retrouver toutes les enchères pour un objet en particulier, l'identifiant de l'objet sera notre partition key.

```sql
CREATE TABLE auction_items (
  item_id TEXT,
  starting_bid DECIMAL,
  highest_bid DECIMAL,
  highest_bidder TEXT,
  PRIMARY KEY ((item_id))
);
```

- Mise à prix de ma Wii à 50 euros.

```sql
INSERT INTO auction_items (item_id, starting_bid, highest_bid)
VALUES ('Wii_a_cedrick', 50.00, 0.00);

SELECT * FROM auction_items WHERE item_id = 'Wii_a_cedrick';
```

#### `✅.097`- Un client place une enchère

- Emmanuel place une enchère à `50` qui équivaut à la mise de départ. Le `highest_bid` est toujours à 0.

```sql
UPDATE auction_items
SET highest_bid = 50.00, highest_bidder = 'Emmanuel'
WHERE item_id = 'Wii_a_cedrick'
IF starting_bid <= 50.00 AND highest_bid < 10.00;

SELECT * FROM auction_items 
WHERE item_id = 'Wii_a_cedrick';
```

#### `✅.098`- Un client place une enchère

- Marine veut également placer une enchère à `50` mais cette fois la condition n'est plus remplie. (was_applied=false)

```sql
UPDATE auction_items
SET highest_bid = 50.00, highest_bidder = 'Marine'
WHERE item_id = 'Wii_a_cedrick'
IF starting_bid <= 50.00 AND highest_bid < 50.00;

SELECT * FROM auction_items 
WHERE item_id = 'Wii_a_cedrick';
```

#### `✅.099`- Le deuxième client place une second enchère plus important

```sql
UPDATE auction_items
SET highest_bid = 51.00, highest_bidder = 'Marine'
WHERE item_id = 'Wii_a_cedrick'
IF starting_bid <= 51.00 AND highest_bid < 51.00;

SELECT * FROM auction_items 
WHERE item_id = 'Wii_a_cedrick';
```

### 2.8.6 - `EXEMPLE LWT 4:` - Historique des enchères

#### `✅.100`- Création du schéma

- Créons une table pour les enchères mais cette ajoutons le `bid_id` comme un `timeuuid` pour conserver tous les records (plus d'upserts).

- L'ordre des enchères est `DESC`, les derniers seront en haut de la liste.

```sql
CREATE TABLE bids_by_item (
  item_id TEXT,
  bid_id TIMEUUID,
  bid DECIMAL,
  bidder TEXT,
  starting_bid DECIMAL STATIC,
  highest_bid DECIMAL STATIC,
  highest_bidder TEXT STATIC,
  PRIMARY KEY ((item_id), bid_id)
) WITH CLUSTERING ORDER BY (bid_id DESC);
```

- À nouveau la mise à prix est de 50.

```sql
INSERT INTO bids_by_item (item_id, bid_id, starting_bid, highest_bid)
VALUES ('Wii_a_cedrick', NOW(), 50.00, 0.00);

SELECT * FROM bids_by_item 
WHERE item_id = 'Wii_a_cedrick';
```

#### `✅.101`- Première enchère

- Emmanuel place son enchère à 50 à nouveau.

```sql
INSERT INTO bids_by_item (item_id, bid_id, bid, bidder)
VALUES ('Wii_a_cedrick', NOW(), 50.00, 'Emmanuel');
```

- Cette enchère place t'elle Emmanuel comme meilleur enchérisseur (ici oui)

```sql
UPDATE bids_by_item
SET highest_bid = 50.00, highest_bidder = 'Emmanuel'
WHERE item_id = 'Wii_a_cedrick'
IF starting_bid <= 50.00 AND highest_bid < 50.00;

SELECT * FROM bids_by_item 
WHERE item_id = 'Wii_a_cedrick';
```

#### `✅.102`- Deuxième enchère

- Marine place une enchère

```sql
INSERT INTO bids_by_item (item_id, bid_id, bid, bidder)
VALUES ('Wii_a_cedrick', NOW(), 50.00, 'Marine');
```

- Comme dans l'exemple précédent le montant est trop faible `highest_bid < 50.00;`, (was_applied=false)

```sql
UPDATE bids_by_item
SET highest_bid = 50.00, highest_bidder = 'Marine'
WHERE item_id = 'Wii_a_cedrick'
IF starting_bid <= 50.00 AND highest_bid < 50.00;

SELECT * FROM bids_by_item 
WHERE item_id = 'Wii_a_cedrick';
```

#### `✅.103`- Troisième enchère

- Avec un montant plus important Marine devient la meilleure enchérisseuse.

```sql
INSERT INTO bids_by_item (item_id, bid_id, bid, bidder)
VALUES ('Wii_a_cedrick', NOW(), 51.00, 'Marine');

UPDATE bids_by_item
SET highest_bid =  51.00, highest_bidder = 'Marine'
WHERE item_id = 'Wii_a_cedrick'
IF starting_bid <=  51.00 AND highest_bid <  51.00;

SELECT * FROM bids_by_item 
WHERE item_id = 'Wii_a_cedrick';
```

Ce type de modèle de données est appelé ledger. Il conserve à la fois le dernier état du système mais tous les états précédents.

<p/><br/>

> [🏠 Retour à la table des matières](#-table-des-matières)

# LAB 3 - Modélisation de données

## 3.1 - Méthodologie

Pour construire un modèle de données avec Apache Cassandra™ les entités ne sont pas suffisantes. Il faut également disposer de la liste des requêtes aussi appelée `Application Workflow`.

Par des règles de mapping on peut alors retrouver le design des différentes tables (`modèle logique de données`). La dernière étape est une optimisation où au travers des différents types de données et des opérations de batch on réduit le nombre de table.

Ce processus est décrit dans la figure ci-dessous:

![my-pic](img/modelisation-workflow.png?raw=true)

Nous allons appliquer la méthodologie pour quelques cas concrets, un apprentissage par l'exemple.

## 3.2 - Modèle de données pour des `timeseries`

_Une **série temporelle** ou **timeseries** correspond à l'enregistrement de l'évolution de valeurs au cours du temps._

### 3.2.1 - Modèle conceptuel de données

**Définition:** Un modèle conceptuel de données permet de représenter les objets et leurs intéractions pour un domaine fonctionnel en particulier. Le modèle permet la visualisation des différentes entités et les relations qui les caractérisent avec leur cardinalité et leur contraintes.

Dans premier exemple, nous nous intéressons à l'enregistrement de mesure pour des capteurs. Les entités sont `Network` (réseau), `Sensor` (capteur), `Temperature` (mesure).

Le diagramme entité relation peut être décrit comme suit:
re
![my-pic](img/sensor-01.png?raw=true)

### 3.2.2 - Workflow Applicatif

**Définition:** Un workflow applicatif _(application workflow)_ permet de comprendre les patterns d'accès à la données ainsi que leur enchaînement. Pour chaque requête il faut préciser quels sont les attributs recherchés, dans quel ordre et avec quelle agrégation doivent ils être retournés.

Dans notre exemple:

- `Q1`: Le point d'entrée de notre application liste les différents réseaux disponibles.

- `Q3`: Affiche les différents capteurs (`Sensor`) pour un réseau (`Network`) en particulier.

- `Q2`: Pour un réseau donné, pour une plage horaire spécifiée (date/heure), affiche une moyenne horaire de la température pour chaque capteur.

- `Q4`: Pour un réseau donné, pour un capteur donné, pour une plage horaire spécifiée (date/heure) afficher l'ensemble des mesures sans filtres mais avec un affichage par ordre décroissant par rapport au temps. (les dernières entrées seront les premiers éléments retournés.)

![my-pic](img/sensor-02.png?raw=true)

### 3.2.3 - Modèle logique de données

**Définition:** : Le modèle logique de données reprend les patterns d'accès à la donnée (`Q1..Q4`) que l'on enrichit avec les différents attributs provenant du diagramme entité relation. En utilisant les critères de recherche on définit les clés primaires des tables en utilisant la notation de `Chebotko`:

- `K` : partition KEY. C'est le plus important. Elle peut porter sur une **ou plusieurs** colonnes. C'est la clé de découpage, l'élément indispensable dans la clause where. On enregistre ensemble ce que l'on souhaite retrouver ensemble plus tard. C'est comme si on faisait **la jointure à l'écriture et non à la lecture.**

- `C` : Clustering Column with order `ASC` (`↑`) or `DESC` (`↓`). Elles sont utilisées comme critère de filtre secondaire (attention l'ordre est important) et pour assurer l'unicité d'un enregistrement.

- `S` : Static column. C'est une colonne qui prend la même valeur pour tous les enregistrements d'une même partition.

![my-pic](img/sensor-03.png?raw=true)

### 3.2.4 - Modèle physique de données

**Définition:** : Le modèle physique de données est obtenu par extension du modèle logique en ajoutant les types propres à Cassandra et en cherchant les optimisations possibles (TIMEUUID, Index secondaires..).

Il faut être vigilant à la taille des partitions les limites recommandées sont `100.000` enregistrements maximum et `100 Mo.` maximum. Les autres optimisations peuvent concerner des agrégations ou de l'indexation.

Voici le modèle physique dans notre cas et les modifications apportées (en vert)

- La table `networks` ne peut être partitionnée uniquement sur le nom car la requête reviendrait à faire un _full-scan._ En définissant un `bucket` on explore moins de partitions et la requête `Q1` est dramatiquement plus rapide.

- Sur la table `temperatures_by_network` 2 optimisations ont été apportées. Les colonnes `date` et `hour` peuvent être mergées en une seule de type `TIMESTAMP`. La seconde est une nouvelle fois d'éviter les partitions larges et d'introduire une colonne `week` pour diviser:
  - **Ancien design:** 100 capteurs, génèrent 100 lignes en une heure dans `temperatures_by_network` => 2400/jour, 16800/semaine, 876000/année....
  - **Nouveau design:** 16800 enregistrements par partition et toutes les partitions équivalentes.

![my-pic](img/sensor-04.png?raw=true)

#### `✅.104`- Créer un nouveau keyspace `sensor_data`

_Dans Docker:_

```sql
CREATE KEYSPACE IF NOT EXISTS devoxx_dm_sensor
WITH REPLICATION = {
  'class' : 'NetworkTopologyStrategy',
  'dc1' : 3
}  AND DURABLE_WRITES = true;
```

Avec Astra, la manipulation des keyspaces est désactivé, c'est lui qui fixe les facteurs de réplications pour vous (Saas). La procédure est décrite en détail dans [Awesome Astra](https://awesome-astra.github.io/docs/pages/astra/faq/#how-do-i-create-a-namespace-or-a-keyspace) mais voici quelques captures:

_Repérer le bouton `ADD KEYSPACE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace-button.png)

_Créer le keyspace `devoxx_dm_sensor` et valider avec `SAVE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace.png)

#### `✅.105`- Importer le modèle données

```sql
use devoxx_dm_sensor;

CREATE TABLE networks (
  bucket TEXT,
  name TEXT,
  description TEXT,
  region TEXT,
  num_sensors INT,
  PRIMARY KEY ((bucket),name)
);

CREATE TABLE sensors_by_network (
  network TEXT,
  sensor TEXT,
  latitude DECIMAL,
  longitude DECIMAL,
  characteristics MAP<TEXT,TEXT>,
  PRIMARY KEY ((network),sensor)
);

CREATE TABLE temperatures_by_sensor (
  sensor TEXT,
  date DATE,
  timestamp TIMESTAMP,
  value FLOAT,
  PRIMARY KEY ((sensor,date),timestamp)
) WITH CLUSTERING ORDER BY (timestamp DESC);

CREATE TABLE temperatures_by_network (
  network TEXT,
  week DATE,
  date_hour TIMESTAMP,
  sensor TEXT,
  avg_temperature FLOAT,
  latitude DECIMAL,
  longitude DECIMAL,
  PRIMARY KEY ((network,week),date_hour,sensor)
) WITH CLUSTERING ORDER BY (date_hour DESC, sensor ASC);

```

#### `✅.106`- Chargement des données avec la commande `SOURCE`

_Pour Docker:_ Le fichier `sensor_data.cql` a été monté comme un volume.

```sql
SOURCE '/tmp/data_modelling/sensor_data.cql'
```

_Pour Astra:_ fournissez le chemin complet du fichier

```sql
SOURCE '/workspace/conference-2022-devoxx/labs/lab3_data_modelling/sensor_data.cql'
```

#### `✅.107`- Utilisation du modèle, lister les données

```sql
SELECT * FROM networks;
SELECT network, week, date_hour, sensor, avg_temperature FROM temperatures_by_network;
SELECT * FROM sensors_by_network;
SELECT * FROM temperatures_by_sensor;
```

#### `✅.108`- Utilisation du modèle: `Q1` Lister les `networks`

- Afficher tous les `networks`

```sql
SELECT name, description, region, num_sensors
FROM networks
WHERE bucket = 'all';
```

#### `✅.109`- Utilisation du modèle: `Q2:` Moyenne horaire par capteur

- Avec notre jeu de données, nous utilisons le network `forest-net` et l'intervalle de dates [`2020-07-05`,`2020-07-06`] pour la semaine `2020-07-05`

```sql
SELECT date_hour, avg_temperature, latitude, longitude, sensor
FROM temperatures_by_network
WHERE network    = 'forest-net'
  AND week       = '2020-07-05'
  AND date_hour >= '2020-07-05'
  AND date_hour  < '2020-07-07';
```

- Avec notre jeu de données si nous voulons maintenant retrouver pour les 2 semaines `2020-06-28` and `2020-07-05`:

```sql
SELECT date_hour, avg_temperature, latitude, longitude, sensor
FROM temperatures_by_network
WHERE network    = 'forest-net'
  AND week      IN ('2020-07-05','2020-06-28')
  AND date_hour >= '2020-07-04'
  AND date_hour  < '2020-07-07';
```

## 3.3 - De SQL à NoSQL avec Petclinic

#### `✅.110`- Introduction à l'application `petclinic`

PetClinic est une application de démonstration utilisée par les équipes Spring pour présenter les différentes fonctionnalités du framework. Une description exhaustive est disponible [ici](https://projects.spring.io/spring-petclinic/).

Il existe même une communauté dédiée [Spring Clinic](https://spring-petclinic.github.io/) qui a étendu le principe en proposant de nouvelles implémentations. Il est possible de tester une démo live sur [Heroku](https://spring-petclinic-community.herokuapp.com/). _(Mais vous allez faire mieux et la lancer sur votre machine durant cette session)_.

![](img/petclinic_00.png?raw=true)

#### `✅.111`- Migration de SQL vers Apache Cassandra™

C'est une question qui revient fréquemment alors regardons comme faire avec un exemple.

Nous partons du modèle relationnel de l'application (elle existe déjà, il suffisait de faire un peu de retro engineering.)

![](img/petclinic_01.png?raw=true)

Dans ce modèle nous identifions différents types de relations `one-to-many` et `many-to-many` qui peuvent sembler difficiles à implémenter dans Cassandra qui ne propose ni transaction, ni intégrité référentielle ni relations ou jointures d'aucune sorte.

![](img/petclinic_02.png?raw=true)

C'est en réalité assez facile, il faut appliquer la méthodologie présentée plus haut. Nous avons besoin des entités mais aussi de l'application workflow des différentes requêtes nécessaires:

#### PetClinic - Liste des Owners

_`Q1`: Pas de critère de filtres nous voulons les lister tous_

![](img/petclinic_03.png?raw=true)

- Voici donc le modèle logique de données associé\*

![](img/petclinic_04.png?raw=true)

#### PetClinic - Détails d'un Owner et liste des Vets

- `Q2`: \_Pour un propriétaire, liste moi les différents animaux qu'il possède

_Sélection par l'identifiant_
![](img/petclinic_05.png?raw=true)

_Affichage du détail_
![](img/petclinic_06.png?raw=true)

- Voici donc le modèle logique de données associé à cette requête.

![](img/petclinic_07.png?raw=true)

La logique est identique pour lister les Vétérinaires ou afficher la liste des visites pour un animal (`one-to-many`). Cela nous donne le modèle logique de données suivant:

![](img/petclinic_08.png?raw=true)

#### PetClinic - Spécialité des vétérinaire `Many to Many`

Un vétérinaire peut avoir plusieurs spécialités.

![](img/petclinic_09.png?raw=true)

![](img/petclinic_10.png?raw=true)

#### `✅.112`- Création du keyspace `spring_petclinic`

_Dans Docker:_

```sql
CREATE KEYSPACE IF NOT EXISTS spring_petclinic
WITH REPLICATION = {
  'class' : 'NetworkTopologyStrategy',
  'dc1' : 3
}  AND DURABLE_WRITES = true;
```

Avec Astra, la manipulation des keyspaces est désactivée, c'est lui qui fixe les facteurs de réplications pour vous (Saas). La procédure est décrite en détail dans [Awesome Astra](https://awesome-astra.github.io/docs/pages/astra/faq/#how-do-i-create-a-namespace-or-a-keyspace) mais voici quelques captures:

_Repérer le bouton `ADD KEYSPACE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace-button.png)

_Créer le keyspace `spring_petclinic` et valider avec `SAVE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace.png)

#### `✅.113`- Création du schéma

```sql
use spring_petclinic;

DROP INDEX IF EXISTS petclinic_idx_vetname;
DROP INDEX IF EXISTS petclinic_idx_ownername;
DROP TABLE IF EXISTS petclinic_vet;
DROP TABLE IF EXISTS petclinic_vet_by_specialty;
DROP TABLE IF EXISTS petclinic_reference_lists;
DROP TABLE IF EXISTS petclinic_owner;
DROP TABLE IF EXISTS petclinic_pet_by_owner;
DROP TABLE IF EXISTS petclinic_visit_by_pet;

CREATE TABLE IF NOT EXISTS petclinic_vet (
  id          uuid,
  first_name  text,
  last_name   text,
  specialties set<text>,
  PRIMARY KEY ((id))
);

CREATE TABLE IF NOT EXISTS petclinic_vet_by_specialty (
 specialty   text,
 vet_id      uuid,
 first_name  text,
 last_name   text,
 PRIMARY KEY ((specialty), vet_id)
);

CREATE TABLE IF NOT EXISTS petclinic_owner (
  id         uuid,
  first_name text,
  last_name  text,
  address    text,
  city       text,
  telephone  text,
  PRIMARY KEY ((id))
);

CREATE TABLE IF NOT EXISTS petclinic_pet_by_owner (
  owner_id   uuid,
  pet_id     uuid,
  pet_type   text,
  name       text,
  birth_date date,
  PRIMARY KEY ((owner_id), pet_id)
);

CREATE TABLE IF NOT EXISTS petclinic_visit_by_pet (
   pet_id      uuid,
   visit_id    uuid,
   visit_date  date,
   description text,
   PRIMARY KEY ((pet_id), visit_id)
);

CREATE TABLE IF NOT EXISTS petclinic_reference_lists (
  list_name text,
  values set<text>,
  PRIMARY KEY ((list_name))
);

/** We could search veterinarians by their names. */
CREATE INDEX IF NOT EXISTS petclinic_idx_ownername ON petclinic_owner(last_name);
/** We could search vet by their names. */
CREATE INDEX IF NOT EXISTS petclinic_idx_vetname ON petclinic_vet(last_name);
```

Cette fois des index secondaires ont été placés sur les noms. Nous avons considéré que la cardinalité était faible.

#### `✅.114`- Insertion des données de références

```sql
INSERT INTO petclinic_reference_lists(list_name, values)
VALUES ('pet_type ', {'bird', 'cat', 'dog', 'lizard','hamster','snake'});

INSERT INTO petclinic_reference_lists(list_name, values)
VALUES ('vet_specialty', {'radiology', 'dentistry', 'surgery'});
```

Le code de l'application Petclinic est disponible à [workshop spring pet clinic](https://github.com/datastaxdevs/workshop-spring-reactive)> Vous pourriez également la lancer dans un second gitpod.

Vous avez désormais l'ensemble des bases pour bien démarrer avec Apache Cassandra™ et construire des modèles de données performants.

<p/><br/>

> [🏠 Retour à la table des matières](#-table-des-matières)

# LAB 4 - Introduction aux drivers


## 4.2 - Création du schéma

Afin d'illustrer une grand nombre de cas d'usages et non se limiter au _Hello World_ nous allons travailler avec les objets listés ci-dessous. La première étape sera de définir les objets en utilisant du code.

```sql
use devoxx_drivers;

CREATE TYPE devoxx_drivers.video_format (
    width int,
    height int
);

CREATE TABLE devoxx_drivers.comments_by_user (
    userid uuid,
    commentid timeuuid,
    comment text,
    videoid uuid,
    PRIMARY KEY (userid, commentid)
) WITH CLUSTERING ORDER BY (commentid DESC);

CREATE TABLE devoxx_drivers.comments_by_video (
    videoid uuid,
    commentid timeuuid,
    comment text,
    userid uuid,
    PRIMARY KEY (videoid, commentid)
) WITH CLUSTERING ORDER BY (commentid DESC);

CREATE TABLE devoxx_drivers.users (
    email text PRIMARY KEY,
    firstname text,
    lastname text
);

CREATE TABLE devoxx_drivers.videos (
    videoid uuid PRIMARY KEY,
    email text,
    title text,
    upload timestamp,
    url text,
    formats map<text, frozen<video_format>>,
    frames list<int>,
    tags set<text>
);

CREATE TABLE devoxx_drivers.videos_views (
    videoid uuid PRIMARY KEY,
    views counter
);
```

#### 📘 Ce qu'il faut retenir:

- Pour exécuter une requête on travaille avec l'objet `CqlSession` (`autocloseable` + doit être un singleton) et la méthode `execute()`.

- Les requêtes sont construites en utilisant un builder `SchemaBuilder`.

> ```java
> SchemaBuilder
> .createTable(USER_TABLENAME)
>  .ifNotExists()
>  .withPartitionKey(USER_EMAIL, DataTypes.TEXT)
>  .withColumn(USER_FIRSTNAME, DataTypes.TEXT)
>  .withColumn(USER_LASTNAME, DataTypes.TEXT)
>  .build()
> ```

- Les constantes sont regroupées dans un interface `SchemaConstants`. C'est une bonne pratique. En cas de renommage d'une colonne il ne faut changer qu'un seul fichier.

#### `✅.118`- Création du schéma

- Exécuter la classe `E01_CreateSchema` pour créer les tables et les types nécessaires.

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E01_CreateSchema
```

#### 🖥️ Logs

```bash
00:29:42.886 INFO  com.datastax.samples.E01_CreateSchema         : Starting 'CreateSchema' sample...
00:29:42.887 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
00:29:42.888 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
00:29:48.882 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
00:29:50.004 INFO  com.datastax.samples.schema.SchemaUtils       : + Type 'video_format' has been created (if needed).
00:29:51.120 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'users' has been created (if needed).
00:29:52.250 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'videos' has been created (if needed).
00:29:53.359 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'videos_views' has been created (if needed).
00:29:54.492 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'comments_by_video' has been created (if needed).
00:29:55.630 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'comments_by_user' has been created (if needed).
00:29:57.695 INFO  com.datastax.samples.E01_CreateSchema         : [OK] Success
```

## 4.3 - Création des `Statements`

#### 📘 Ce qu'il faut retenir:

- Pour exécuter une requête on travaille avec l'objet `CqlSession` et la méthode `execute()`.

- Les requêtes peuvent être exécutées en tant que chaînes de caractères

> ```java
> cqlSession.execute("" +
>  "INSERT INTO users (email, firstname, lastname) " +
>  "VALUES ('clun@sample.com', 'Cedrick', 'Lunven')");
> ```

- Toute requête est convertie en `Statement`

> ```java
> cqlSession.execute(SimpleStatement.newInstance(
>   "INSERT INTO users (email, firstname, lastname) " +
>   "VALUES ('clun2@sample.com', 'Cedrick', 'Lunven')"));
> ```

- Les paramètres doivent être externalisés (injection de CQL) soit en avec la position `?` soit avec leur nom `:label`

> ```java
> cqlSession.execute(SimpleStatement
>  .builder("INSERT INTO users (email, firstname, lastname) VALUES (?,?,?)")
>  .addPositionalValue("clun3@gmail.com")
>  .addPositionalValue("Cedrick")
>  .addPositionalValue("Lunven").build());
>
> cqlSession.execute(SimpleStatement
>   .builder("INSERT INTO users (email, firstname, lastname) VALUES (:e,:f,:l)")
>   .addNamedValue("e", "clun5@gmail.com")
>   .addNamedValue("f", "Cedrick")
>   .addNamedValue("l", "Lunven").build());
> ```

- Pour accélérer leur exécution il faut les `prepare()` au chargement de l'application. On les utilise alors avec un `bind()` des paramètres. Dans ce dernier exemple nous avons aussi démontré l'utilisation du `QueryBuilder` pour construire la requête.

_Prepare_
![](img/query-connect.png?raw=true)

_Requête_
![](img/query-sync.png?raw=true)

> ```java
> PreparedStatement ps2 = cqlSession.prepare(QueryBuilder
>  .insertInto(USER_TABLENAME)
>  .value(USER_EMAIL, QueryBuilder.bindMarker())
>  .value(USER_FIRSTNAME, QueryBuilder.bindMarker())
>  .value(USER_LASTNAME, QueryBuilder.bindMarker())
>  .build());
>
> cqlSession.execute(ps2.bind("clun7@gmail.com", "Cedrick", "Lunven"));
> ```

#### `✅.119`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E02_Statements
```

#### 🖥️ Logs

```bash
01:26:43.034 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:26:43.035 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:26:49.079 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:26:49.101 INFO  com.datastax.samples.E01_CreateSchema         : + Insert as a String
01:26:49.105 INFO  com.datastax.samples.E01_CreateSchema         : + Insert as a Statement
01:26:49.112 INFO  com.datastax.samples.E01_CreateSchema         : + Insert and externalize var with ?, option1
01:26:49.117 INFO  com.datastax.samples.E01_CreateSchema         : + Insert and externalize var with ?, option2
01:26:49.124 INFO  com.datastax.samples.E01_CreateSchema         : + Insert and externalize var with :labels, option1
01:26:49.131 INFO  com.datastax.samples.E01_CreateSchema         : + Insert and externalize var with :labels, option2
01:26:49.142 INFO  com.datastax.samples.E01_CreateSchema         : + Insert with QueryBuilder
01:26:49.193 INFO  com.datastax.samples.E01_CreateSchema         : + Insert with PrepareStatements
01:26:49.209 INFO  com.datastax.samples.E01_CreateSchema         : + Insert with PrepareStatements + QueryBuilder
```

## 4.4 - Opération `Create`, `Read`, `Update`, `Delete` (CRUD)

#### 📘 Ce qu'il faut retenir:

- On commence par définir les différents requêtes que l'on `prepare()` pour obtenir des `PreparedStatement`

> ```java
> private void prepareStatements(CqlSession cqlSession) {
>
>   // Create (upsert)
>   stmtCreateUser = cqlSession.prepare(QueryBuilder
>     .insertInto(USER_TABLENAME)
>     .value(USER_EMAIL, QueryBuilder.bindMarker())
>     .value(USER_FIRSTNAME, QueryBuilder.bindMarker())
>     .value(USER_LASTNAME, QueryBuilder.bindMarker())
>     .build());
>
>   // READ
>   stmtExistUser = cqlSession.prepare(QueryBuilder
>     .selectFrom(USER_TABLENAME).column(USER_EMAIL)
>     .whereColumn(USER_EMAIL)
>     .isEqualTo(QueryBuilder.bindMarker())
>     .build());
>
>   // DELETE
>   stmtDeleteUser = cqlSession.prepare(QueryBuilder
>      .deleteFrom(USER_TABLENAME)
>      .whereColumn(USER_EMAIL)
>      .isEqualTo(QueryBuilder.bindMarker())
>      .build());
> }
> ```

- On les utilise ensuite avec des `bind()`

> ```java
> boolean existUser(CqlSession cqlSession, String email) {
>   return cqlSession.execute(stmtExistUser.bind(email)).getAvailableWithoutFetching() > 0;
> }
>
> void deleteUser(CqlSession cqlSession, String email) {
> cqlSession.execute(stmtDeleteUser.bind(email));
> }
> ```

- Les requêtes retournent un `ResultSet` contenant un iterable de `Row`. Lorsque le résultat est unique nous pouvons utiliser `one()`. On accède aux différentes colonnes par le nom et le type exemple `.getString("colonne")`

> ```java
> ResultSet rs = cqlSession.execute(stmtFindUser.bind(email));
> Row record = rs.one();
>
> public UserDto(Row tableUsersRow) {
>   super();
>   this.email      = tableUsersRow.getString(USER_EMAIL);
>   this.firstName  = tableUsersRow.getString(USER_FIRSTNAME);
>   this.lastName   = tableUsersRow.getString(USER_LASTNAME);
> }
> ```

#### `✅.120`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E03_OperationsCrud
```

#### 🖥️ Logs

```bash
01:27:16.760 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:27:16.761 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:27:23.086 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:27:23.106 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'users' has been created (if needed).
01:27:23.293 INFO  com.datastax.samples.E03_OperationsCrud       : + clun@sample.com does not exists in table 'user'
01:27:23.341 INFO  com.datastax.samples.E03_OperationsCrud       : + User clun@sample.com has been created
01:27:23.347 INFO  com.datastax.samples.E03_OperationsCrud       : + clun@sample.com  now exists in table 'user'
01:27:23.352 INFO  com.datastax.samples.E03_OperationsCrud       : + eram@sample.com does not exists in table 'user'
01:27:23.358 INFO  com.datastax.samples.E03_OperationsCrud       : + User eram@sample.com has been updated
01:27:23.362 INFO  com.datastax.samples.E03_OperationsCrud       : + eram@sample.com  now exists in table 'user'
01:27:23.367 INFO  com.datastax.samples.E03_OperationsCrud       : + User eram@sample.com has been deleted
01:27:23.373 INFO  com.datastax.samples.E03_OperationsCrud       : + eram@sample.com does not exists in table 'user'
01:27:23.377 INFO  com.datastax.samples.E03_OperationsCrud       : + Retrieved eram@sample.com: Optional.empty
01:27:23.382 INFO  com.datastax.samples.E03_OperationsCrud       : + Retrieved clun@sample.com: clun@sample.com
01:27:23.388 INFO  com.datastax.samples.E03_OperationsCrud       : + User eram@sample.com has been updated
01:27:23.392 INFO  com.datastax.samples.E03_OperationsCrud       : + User clun@sample.com has been updated
01:27:23.400 INFO  com.datastax.samples.E03_OperationsCrud       : + Retrieved users count 2
```

## 4.5 - Batches

#### 📘 Ce qu'il faut retenir:

- Le batch est implémenter au traver d'un `BatchStatement` en y ajoutant les autres `Statements`

> ```java
> private static void updateComment(CqlSession cqlSession,
>   UUID commentid, UUID userid,
>   UUID videoid, String comment) {
>   cqlSession.execute(BatchStatement
>     .builder(BatchType.LOGGED)
>     .addStatement(stmt1.bind(videoid, userid, commentid, comment))
>     .addStatement(stmt2.bind(userid, videoid, commentid, comment))
>     .build()
>     );
> }
> ```

#### `✅.121`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E04_Batches
```

#### 🖥️ Logs

```bash
01:27:49.909 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:27:49.911 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:27:55.991 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:27:56.008 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'comments_by_user' has been created (if needed).
01:27:56.012 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'comments_by_video' has been created (if needed).
01:27:56.263 INFO  com.datastax.samples.E04_Batches              : Video2
01:27:56.263 INFO  com.datastax.samples.E04_Batches              : Video2 is cool
01:27:56.276 INFO  com.datastax.samples.E04_Batches              : I am user2 and video2 is bad
01:27:56.276 INFO  com.datastax.samples.E04_Batches              : This is my new comment
01:27:56.288 INFO  com.datastax.samples.E04_Batches              : This is my new comment
01:27:56.293 INFO  com.datastax.samples.E04_Batches              : Video2 is cool
01:27:56.293 INFO  com.datastax.samples.E04_Batches              : This is my new comment
01:27:56.297 INFO  com.datastax.samples.E04_Batches              : Video2
01:27:56.297 INFO  com.datastax.samples.E04_Batches              : Video2 is cool
```

## 4.6 - Pagination

#### 📘 Ce qu'il faut retenir:

- Avec Cassandra toutes les requêtes sont paginées, la taille la page (pageSize) par défaut `5000`.

- Le drivers ira chercher les données de la page suivante de manière transparente si vous travaillez avec l'iterable de `Row` du resultset. Pour ne pas le faire il faut travailler avec `getAvailableWithoutFetching()`.

> ```java
> ResultSet page1 = cqlSession.execute(statement);
>
> Iterator<Row> page1Iter = page1.iterator();
> while (0 <  page1.getAvailableWithoutFetching()) {
>   LOGGER.info("Page1: " + page1Iter.next().getString(USER_EMAIL));
> }
> ```

- Le resultset contient un `pagingState` qu'il est nécessaire de conserver et de re-spécifié si la requête pour la page suivante intervient plus tard. (comportement fréquent avec les interfaces utilisateurs).

> ```java
> ByteBuffer pagingStateAsBytes = page1.getExecutionInfo().getPagingState();
>
> // Preparation page 2
> statement.setPagingState(pagingStateAsBytes);
> ResultSet page2 = cqlSession.execute(statement);
> ```

#### `✅.122`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E05_Paging
```

#### 🖥️ Logs

```bash
01:30:21.231 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:30:21.233 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:30:27.489 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:30:27.508 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'users' has been created (if needed).
01:30:27.650 INFO  com.datastax.samples.E05_Paging               : + 50 users have been created
01:30:27.668 INFO  com.datastax.samples.E05_Paging               : + Page 1 has 10 items
01:30:27.670 INFO  com.datastax.samples.E05_Paging               : Page1: user_45@sample.com
01:30:27.670 INFO  com.datastax.samples.E05_Paging               : Page1: user_3@sample.com
01:30:27.670 INFO  com.datastax.samples.E05_Paging               : Page1: user_41@sample.com
01:30:27.670 INFO  com.datastax.samples.E05_Paging               : Page1: user_17@sample.com
01:30:27.671 INFO  com.datastax.samples.E05_Paging               : Page1: user_33@sample.com
01:30:27.671 INFO  com.datastax.samples.E05_Paging               : Page1: user_0@sample.com
01:30:27.671 INFO  com.datastax.samples.E05_Paging               : Page1: user_16@sample.com
01:30:27.671 INFO  com.datastax.samples.E05_Paging               : Page1: user_43@sample.com
01:30:27.671 INFO  com.datastax.samples.E05_Paging               : Page1: user_48@sample.com
01:30:27.671 INFO  com.datastax.samples.E05_Paging               : Page1: user_9@sample.com
01:30:27.680 INFO  com.datastax.samples.E05_Paging               : + Page 2 has 10 items
```

## 4.7 - Travailler avec `List`, `Set` et `Map`

#### 📘 Ce qu'il faut retenir:

- Il est possible de `binder` directement des `Set`, `List` et `Map`

> ```java
> cqlSession.execute(stmtCreateVideo.bind()
>   .setUuid(VIDEO_VIDEOID, dto.getVideoid())
>   .setString(VIDEO_TITLE, dto.getTitle())
>   .setString(VIDEO_USER_EMAIL, dto.getEmail())
>   .setInstant(VIDEO_UPLOAD, Instant.ofEpochMilli(dto.getUpload()))
>   .setString(VIDEO_URL, dto.getUrl())
>   .setSet(VIDEO_TAGS, dto.getTags(), String.class)
>   .setList(VIDEO_FRAMES, dto.getFrames(), Integer.class)
>   .setMap(VIDEO_FORMAT, dto.getFormats(), String.class, VideoFormatDto.class));
> ```

- Les opérations sur les collection `appendXXX` et `removeXXX`sur les listes sont disponibles.

> ```java
> cqlSession.execute(QueryBuilder
>   .update(VIDEO_TABLENAME)
>   .appendSetElement(VIDEO_TAGS, literal(newTag))
>   .whereColumn(VIDEO_VIDEOID).isEqualTo(literal(videoId))
>   .build());
> ```

- Pour travailler avec les `UDT` est les mapper il faut définir un custom codec

> ```java
> // Exemple de Bean
> public class VideoFormatDto {
>    private int width = 0;
>    private int height = 0;
> }
>
> // Définition du codec
> public class UdtVideoFormatCodec implements TypeCodec<VideoFormatDto> {
>  String format(VideoFormatDto value) {}
>  VideoFormatDto parse(String value)  {}
>  ByteBuffer encode(VideoFormatDto value, ProtocolVersion protocolVersion) {}
>  VideoFormatDto decode(ByteBuffer bytes, ProtocolVersion protocolVersion) {}
> ...
> }
>
> // Enregistrement
> // [...]
> cqlSession.getContext()
>  .getCodecRegistry()
>  .register(new UdtVideoFormatCodec(
>    registry.codecFor(videoFormatUdt),
>    VideoFormatDto.class)
>  );
> ```

#### `✅.123`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E06_ListSetMapAndUdt
```

#### 🖥️ Logs

```bash
01:31:02.667 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:31:02.669 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:31:10.578 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:31:10.595 INFO  com.datastax.samples.schema.SchemaUtils       : + Type 'video_format' has been created (if needed).
01:31:10.602 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'videos' has been created (if needed).
01:31:10.702 INFO  com.datastax.samples.E06_ListSetMapAndUdt     : + Tags before adding 'OK' [accelerate, cassandra]
01:31:10.717 INFO  com.datastax.samples.E06_ListSetMapAndUdt     : + Tags after adding 'OK' [OK, accelerate, cassandra]
01:31:10.728 INFO  com.datastax.samples.E06_ListSetMapAndUdt     : + Tags after removing 'accelerate' [OK, cassandra]
01:31:10.734 INFO  com.datastax.samples.E06_ListSetMapAndUdt     : + Formats before {mp4=VideoFormatDto [width=640, height=480, ogg=VideoFormatDto [width=640, height=480}
01:31:10.748 INFO  com.datastax.samples.E06_ListSetMapAndUdt     : + Formats after removing 'ogg' {mp4=VideoFormatDto [width=640, height=480}
01:31:10.753 INFO  com.datastax.samples.E06_ListSetMapAndUdt     : + Formats after removing 'ogg' {mp4=VideoFormatDto [width=640, height=480}
01:31:10.757 INFO  com.datastax.samples.E06_ListSetMapAndUdt     : + Formats frames before [2, 3, 5, 8, 13, 21]
01:31:10.769 INFO  com.datastax.samples.E06_ListSetMapAndUdt     : + Formats frames after update all [1, 2, 3]
01:31:10.781 INFO  com.datastax.samples.E06_ListSetMapAndUdt     : + Formats frames after append 4 [1, 2, 3, 4]
```

## 4.8 - Requêter avec JSON

#### 📘 Ce qu'il faut retenir:

- Pour les syntaxes `INSERT INTO ... JSON` le paramètre que l'on externalise c'est toute la requête json.

> ```java
> cqlSession
>   .execute(SimpleStatement.builder(
>     "INSERT INTO " + VIDEO_TABLENAME + " JSON ? ")
>   .addPositionalValue("{"
>     + "\"videoid\":\""+ videoid4.toString() + "\","
>     + "\"email\":\"clu@sample.com\","
>     + "\"title\":\"sample video\","
>     + "\"upload\":\"2020-02-26 15:09:22 +00:00\","
>     + "\"url\":\"http://google.fr\","
>     + "\"frames\": [1,2,3,4],"
>     + "\"tags\": [\"cassandra\",\"accelerate\", \"2020\"],"
>     + "\"formats\": {"
>     + "   \"mp4\":{\"width\":1,\"height\":1},"
>     + "   \"ogg\":{\"width\":1,\"height\":1}"
>     + "}}")
>   .build());
> ```

#### `✅.124`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E07_Json
```

#### 🖥️ Logs

```bash
01:32:48.700 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:32:48.701 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:32:54.760 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:32:54.778 INFO  com.datastax.samples.schema.SchemaUtils       : + Type 'video_format' has been created (if needed).
01:32:54.785 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'videos' has been created (if needed).
01:32:54.910 INFO  com.datastax.samples.E07_Json                 : + Video 'e7ae5cf3-d358-4d99-b900-85902fda9bb0' has been inserted
01:32:54.973 INFO  com.datastax.samples.E07_Json                 : + Video '8b8417b9-1772-4e6c-9060-6bb66a5ea8bd' has been inserted
01:32:54.985 INFO  com.datastax.samples.E07_Json                 : + Video '1c33bb64-a442-4923-b2a1-3b7412e8cc5f' has been inserted
01:32:54.996 INFO  com.datastax.samples.E07_Json                 : + Video '13bed42f-833e-49fd-9caa-fab86f8ec780' has been inserted
01:32:55.004 INFO  com.datastax.samples.E07_Json                 : + Video '08499c4c-3e55-49e0-aa0e-e975f529a746' has been inserted
01:32:55.004 INFO  com.datastax.samples.E07_Json                 : [OK] - All video Inserted
01:32:55.046 INFO  com.datastax.samples.E07_Json                 : + Video '08499c4c-3e55-49e0-aa0e-e975f529a746' has been inserted
01:32:55.087 INFO  com.datastax.samples.E07_Json                 : + Video '1c33bb64-a442-4923-b2a1-3b7412e8cc5f' has been read
01:32:55.088 INFO  com.datastax.samples.E07_Json                 : + Video '08499c4c-3e55-49e0-aa0e-e975f529a746' has been read
01:32:55.088 INFO  com.datastax.samples.E07_Json                 : + Video 'f169a4b0-6df9-4065-b5c5-ef468d0fbb25' has been read
01:32:55.088 INFO  com.datastax.samples.E07_Json                 : + Video '8b8417b9-1772-4e6c-9060-6bb66a5ea8bd' has been read
01:32:55.088 INFO  com.datastax.samples.E07_Json                 : + Video '1da246b5-8923-4479-9ebd-f757fbe4f644' has been read
01:32:55.088 INFO  com.datastax.samples.E07_Json                 : + Video '13bed42f-833e-49fd-9caa-fab86f8ec780' has been read
01:32:55.088 INFO  com.datastax.samples.E07_Json                 : [OK] - All video read
```

## 4.9 - Programmation Asynchrone

#### 📘 Ce qu'il faut retenir:

- Pour exécuter une requête asynchrone il faut utiliser la méthode `executeAsync()` de la classe `CqlSession`. Les drivers retournent un `CompletionStage` pour chaque page.

![](img/query-async.png?raw=true)

- On utilise les Api dites `fluent` pour travailler avec les réponses.

> ```java
> // Exécution
> CompletionStage<Boolean> existUserAsync(CqlSession cqlSession, String email) {
>   return cqlSession
>     .executeAsync(stmtExistUser.bind(email))
>     .thenApply(ars -> ars.one() != null);
> }
>
> // Utilisation
> existUserAsync(cqlSession, userEmail2)
>   .thenAccept(exist -> LOGGER.info("+ '{}' exists ? {}", userEmail2, exist))
>   .thenCompose(r->updateUserAsync(cqlSession, userEmail2,  "Eric", "Ramirez"))
>   .thenCompose(r->existUserAsync(cqlSession, userEmail2))
>   .thenAccept(exist -> LOGGER.info("+ '{}' exists ? {}", userEmail2, exist))
>   .toCompletableFuture()
>   .get();
> ```

#### `✅.125`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E08_Async
```

#### 🖥️ Logs

```bash
01:36:37.177 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:36:37.178 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:36:43.331 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:36:43.348 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'users' has been created (if needed).
01:36:43.498 INFO  com.datastax.samples.E08_Async                : + 'clun@sample.com' exists ? (expecting false): false
01:36:43.518 INFO  com.datastax.samples.E08_Async                : + User clun@sample.com has been created
01:36:43.524 INFO  com.datastax.samples.E08_Async                : + 'clun@sample.com' exists ? (expecting true): false
01:36:43.530 INFO  com.datastax.samples.E08_Async                : + 'eram@sample.com' exists ? (expecting false): false
01:36:43.534 INFO  com.datastax.samples.E08_Async                : + User eram@sample.com has been updated
01:36:43.541 INFO  com.datastax.samples.E08_Async                : + 'eram@sample.com' exists ? (expecting true): true
01:36:43.545 INFO  com.datastax.samples.E08_Async                : + User eram@sample.com has been deleted
01:36:43.552 INFO  com.datastax.samples.E08_Async                : + 'eram@sample.com' exists ? (expecting false) false
01:36:43.558 INFO  com.datastax.samples.E08_Async                : + Retrieved 'eram@sample.com': (expecting Optional.empty) Optional.empty
01:36:43.564 INFO  com.datastax.samples.E08_Async                : + Retrieved 'eram@sample.com': (expecting result) Optional[com.datastax.samples.dto.UserDto@57bd8fea]
01:36:43.569 INFO  com.datastax.samples.E08_Async                : + User eram@sample.com has been updated
01:36:43.571 INFO  com.datastax.samples.E08_Async                : + User clun@sample.com has been updated
01:36:43.572 INFO  com.datastax.samples.E08_Async                : + Retrieved users count 2
[INFO] ------------------------------------------------------------------------
```

## 4.10 - Programmation Réactive

#### 📘 Ce qu'il faut retenir:

- Pour exécuter une requête réactive il faut utiliser la méthode `executeAsync()` de la classe `CqlSession`.

![](img/query-reactive.png?raw=true)

- Les drivers travaillent avec un `Subscriber`. Une notification est renvoyée pour chaque enregistrement. Ce n'est pas du _Change Data Capture_, les éléments retournés seront les éléments présents à l'exécution de la requête mais pas ceux arrivés par la suite.

- Un système de back pressure est mis en place si le client est lent au traitement des notifications.

- Il est très facile retrouver les objets habituels `Mono<>` et `Flux<>` (pour travailler avec Spring par exemple)

> ```java
> // Exécution
> Mono<Boolean> existUserReactive(CqlSession cqlSession, String email) {
>  ReactiveResultSet rrs = cqlSession.executeReactive(stmtExistUser.bind(email));
>  return Mono.from(rrs).map(rs -> true).defaultIfEmpty(false);
> }
>
> // Utilisation
> existUserReactive(cqlSession, userEmail)
>  .doOnNext(exist -> LOGGER.info("+ '{}' exists ? {}", userEmail, exist))
>  .and(upsertUserReactive(cqlSession, userEmail, "Cedric", "Lunven"))
>  .block();
> ```

#### `✅.126`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E09_Reactive
```

#### 🖥️ Logs

```bash
01:37:12.174 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:37:12.175 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:37:18.216 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:37:18.236 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'users' has been created (if needed).
01:37:18.421 INFO  com.datastax.samples.E09_Reactive             : + 'clun@sample.com' exists ? (expecting false): false
01:37:18.426 INFO  com.datastax.samples.E09_Reactive             : + 'clun@sample.com' exists ? (expecting false): true
01:37:18.437 INFO  com.datastax.samples.E09_Reactive             : + Retrieved 'ram@sample.com': (expecting Optional.empty) Optional.empty
01:37:18.441 INFO  com.datastax.samples.E09_Reactive             : + Retrieved 'clun@sample.com': (expecting result) clun@sample.com
01:37:18.441 INFO  com.datastax.samples.E09_Reactive             : + Retrieved 'ram@sample.com': (expecting result) Optional[com.datastax.samples.dto.UserDto@709d926a]
01:37:18.493 INFO  com.datastax.samples.E09_Reactive             : + 'ram@sample.com' email found
01:37:18.493 INFO  com.datastax.samples.E09_Reactive             : + 'clun@sample.com' email found
```

## 4.11 - Les `counters`

#### 📘 Ce qu'il faut retenir:

- Les opérations d'incrémentation et décrémentation sont fournies par le `QueryBuilder`

> ````java
> cqlSession.prepare(QueryBuilder
>   .update(VIDEO_VIEWS_TABLENAME)
>   .increment(VIDEO_VIEWS_VIEWS, QueryBuilder.bindMarker())
>   .whereColumn(VIDEO_VIEWS_VIDEOID).isEqualTo(QueryBuilder.bindMarker())
>   .build()
> );
> > ```
> ````

#### `✅.127`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E10_Counters
```

#### 🖥️ Logs

```bash
01:37:47.296 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:37:47.298 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:37:53.434 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:37:53.453 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'videos_views' has been created (if needed).
01:37:53.560 INFO  com.datastax.samples.E10_Counters             : + Video views Optional.empty
01:37:53.607 INFO  com.datastax.samples.E10_Counters             : + Video views : 10
01:37:53.621 INFO  com.datastax.samples.E10_Counters             : + Video views : 2
01:37:53.633 INFO  com.datastax.samples.E10_Counters             : + Video views Optional.empty
```

## 4.12 - Les `Lightweight Transactions`

#### 📘 Ce qu'il faut retenir:

- Il est nécessaire d'ajouter la condition de la LWT dans le statement comme exemple le `ifNotExists` avec le `QueryBuilder` ou directement dans la requêtes `CQL`

> ```java
> cqlSession.prepare(QueryBuilder.insertInto(USER_TABLENAME)
>   .value(USER_EMAIL, QueryBuilder.bindMarker())
>   .value(USER_FIRSTNAME, QueryBuilder.bindMarker())
>   .value(USER_LASTNAME, QueryBuilder.bindMarker())
>   .ifNotExists()
>   .build());
> ```

- Le `APPLIED` est disponible dans le `ResultSet` retourné après une exécution.

> ```java
>  boolean createUserIfNotExist(CqlSession cqlSession, String email, String firstname, String lastname) {
>   return cqlSession
>     .execute(stmtCreateUser.bind(email, firstname, lastname))
>     .wasApplied();
> }
> ```

#### `✅.128`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E11_LightweightTransactions
```

#### 🖥️ Logs

```bash
01:38:30.073 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:38:30.074 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:38:36.161 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:38:36.215 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'users' has been created (if needed).
01:38:36.361 INFO  com.datastax.samples.E11_LightweightTransactions : + Created first time ? true and second time false
01:38:36.392 INFO  com.datastax.samples.E11_LightweightTransactions : + Applied when correct value ? true and invalid value false
```

## 4.13 - Object Mapping

#### 📘 Ce qu'il faut retenir:

Le mapping objet est une technique qui consiste à associer les tables de la base de données avec les objets d'une application. Le but est de ne pas avoir à écrire soit même les requêtes CQL. Cette approche est toutefois limitée car elle réduit les possibilités offertes.

Pour effectuer un mapping objet il n'est pas nécessaire de recourir à un framework externe type Spring, la fonctionnalité est proposée directement au niveau des drivers Cassandra. Pour une documentation exhaustive référez-vous à la [documentation officielle](https://docs.datastax.com/en/developer/java-driver/4.13/manual/mapper/)

- Il est nécessaire d'importer la librairie `java-driver-mapper-runtime`

> ```xml
> <dependency>
>   <groupId>com.datastax.oss</groupId>
>   <artifactId>java-driver-mapper-runtime</artifactId>
>   <version>${derniere-version}</version>
> </dependency>
> ```

- La librairie d'objet mapping va venir générer les classes nécessaires à la compilation sur la base d'annotations dans le code. (`Annotation Processor`). Pour l'activer avec le build `Maven` il est nécessaire de le déclarer dans le bloc XML `annotationProcessorPaths` au niveau du plugin `maven-compiler-plugin`.

> ```xml
> <plugins>
>  <plugin>
>   <groupId>org.apache.maven.plugins</groupId>
>   <artifactId>maven-compiler-plugin</artifactId>
>   <configuration>
>    <release>11</release>
>    <source>11</source>
>    <target>11</target>
>    <annotationProcessorPaths>
>     <path>
>      <groupId>com.datastax.oss</groupId>
>      <artifactId>java-driver-mapper-processor</artifactId>
>     </path>
>    </annotationProcessorPaths>
>   </configuration>
>  </plugin>
> </plugins>
> ```

- Dans le principe ,on construit un objet sur la base du schéma de la table (et non l'inverse - avec Cassandra c'est bien le modèle de données que l'on définit en premier)

> ```java
> @Entity
> @CqlName("myTable")
> public class CommentByUser {
>
>     @PartitionKey
>     UUID userid;
>
>     @ClusteringColumn
>     UUID commentid;
>
>     UUID videoid;
>
>     String comment;
> }
> ```

- Puis il est nécessaire de construire interface annotée avec `@Dao`. Il est à noter qu'en tant qu'interface elle ne contient pas d'implémentation. Les méthodes de `Create` (save), `Read` (findById), `Update` et `delete` (deleteById) sont disponibles et l'on peut déclarer d'autres méthodes plus spécifiques comme ci-dessous.

> ```java
> @Dao
> public interface CommentDao extends CassandraSchemaConstants {
>
>   @Query("SELECT * FROM ${keyspaceId}.${tableId} "
>          + "WHERE " + COMMENT_BY_USER_USERID + " = :userid ")
>   PagingIterable<CommentByUser> retrieveUserComments(UUID userid);
> ```

- Enfin le mapper, annoté avec `@Mapper` permet d'associer la `CqlSession` aux différents `@Dao`. Un seul est nécessaire dans votre application.

> ```java
> @Mapper
> public interface CommentDaoMapper {
>  @DaoFactory
>  CommentDao commentDao();
>
>  static MapperBuilder<CommentDaoMapper> builder(CqlSession session) {
>    return new CommentDaoMapperBuilder(session);
>  }
> }
> ```

#### `✅.129`- Exécuter la classe example

```bash
cd /workspace/conference-2022-devoxx/labs/lab4_cassandra_drivers
mvn clean compile exec:java -Dexec.mainClass=com.datastax.samples.E12_ObjectMapping
```

#### 🖥️ Logs

```bash
01:51:17.581 INFO  com.datastax.samples.CqlSessionProvider       : Creating your CqlSession to Cassandra...
01:51:17.582 INFO  com.datastax.samples.CqlSessionProvider       : + Connecting to [LOCAL CASSANDRA]
01:51:23.750 INFO  com.datastax.samples.CqlSessionProvider       : + [OK] Your are connected.
01:51:23.767 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'comments_by_user' has been created (if needed).
01:51:23.771 INFO  com.datastax.samples.schema.SchemaUtils       : + Table 'comments_by_video' has been created (if needed).
01:51:24.072 INFO  com.datastax.samples.E12_ObjectMapping        : Video2
01:51:24.072 INFO  com.datastax.samples.E12_ObjectMapping        : Video2 is cool
01:51:24.087 INFO  com.datastax.samples.E12_ObjectMapping        : I am user2 and video1 is bad
01:51:24.087 INFO  com.datastax.samples.E12_ObjectMapping        : This is my new comment
01:51:24.106 INFO  com.datastax.samples.E12_ObjectMapping        : I am user2 and video1 is bad
01:51:24.116 INFO  com.datastax.samples.E12_ObjectMapping        : Video2
01:51:24.116 INFO  com.datastax.samples.E12_ObjectMapping        : Video2 is cool
```

Les drivers sont très puissants et fournissent l'ensemble des opérations permises par la base Apache Cassandra™. Ils sont au coeur des simplifications et des abstractions proposées par d'autres frameworks tels que Spring, Micronaut ou Quarkus aussi est-il important de bien les maîtriser. SI vous êtes bloqués retournés à l'objet `CqlSession`.

<p/><br/>

> [🏠 Retour à la table des matières](#-table-des-matières)

# LAB 5 - Spring Data Cassandra

## 5.1 - Configuration

#### `✅.130`- Création du keyspace `devoxx_spring`

_Dans Docker:_

```sql
CREATE KEYSPACE IF NOT EXISTS devoxx_spring
WITH REPLICATION = {
  'class' : 'NetworkTopologyStrategy',
  'dc1' : 3
}  AND DURABLE_WRITES = true;
```

Avec Astra, la manipulation des keyspaces est désactivé, c'est lui qui fixe les facteurs de réplications pour vous (Saas). La procédure est décrite en détail dans [Awesome Astra](https://awesome-astra.github.io/docs/pages/astra/faq/#how-do-i-create-a-namespace-or-a-keyspace) mais voici quelques captures:

_Repérer le bouton `ADD KEYSPACE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace-button.png)

_Créer le keyspace `devoxx_spring` et valider avec `SAVE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace.png)

#### 📘 Ce qu'il faut retenir:

- [Spring Data](https://spring.io/projects/spring-data) est la couche d'accès aux données proposée dans le framework spring. Elle se décline pour plusieurs bases de données à la fois SQL (JPA) et NoSQL (Cassandra, Mongo, Redis...)

- [Spring Data Cassandra](https://spring.io/projects/spring-data-cassandra) comporte 1 librairie [`spring-data-cassandra`](https://mvnrepository.com/artifact/org.springframework.data/spring-data-cassandra) et la dernière version est [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.datastax.oss/java-driver-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.springframework.data/spring-data-cassandra)

```xml
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-cassandra</artifactId>
    <version>${latest}</version>
</dependency>
```

- Depuis les versions `3.x` Spring Data s'appuie sur la dernière génération de drivers Cassandra `4.x`. Dans nos exemples nous allons nous appuyer sur `Spring-boot`. Pour utiliser la dernière génération nous devons utiliser une version supérieure a `2.3+`. Les compatibilités sont décrites dans le tableau ci-dessous:

> | Drivers       | Spring-Data    | Spring Boot    |
> | ------------- | -------------- | -------------- |
> | Drivers `3.x` | `2.2` et avant | `2.2` et avant |
> | Drivers `4.x` | `3.x` et après | `2.3` et avant |

- Pour utiliser `Spring Data Cassandra` avec `Spring Boot` il existe 2 starters différents `spring-boot-starter-data-cassandra` (MVC) et `spring-boot-starter-data-cassandra-reactive` (Webflux). Dans notre exmple nous utilisons la première mais un exemple réactif est [disponible ici](https://github.com/datastaxdevs/workshop-spring-reactive)

#### `✅.131`- Vérifier le `pom.xml`

- Ouvrir le fichier

```bash
gp open /workspace/conference-2022-devoxx/labs/lab5_spring_data/pom.xml
```

- Vous devez retrouver:

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-cassandra</artifactId>
</dependency>
```

#### `✅.132`- Configuration de l'application Spring-Data

- Repérer le terminal `lab5_spring_data` et compiler le projet

```bash
cd /workspace/conference-2022-devoxx/labs/lab5_spring_data
mvn clean compile
```

- Localiser le fichier de configuration `application.yml`dans le répertoire `src/main/resources`. C'est le fichier de configuration principal de Spring-Boot.

```bash
gp open /workspace/conference-2022-devoxx/labs/lab5_spring_data/src/main/resources/application.yml
```

- Suivant la cible (Cassandra dans Docker ou Cassandra dans Astra) la configuration de `spring-data` changera légèrement c'est pourquoi nous avons proposé 2 exemple `application-astra.yml` et `application-astra.yml`

- Copier le fichier qui vous correspond vers `application.yml`

```bash
cp /workspace/conference-2022-devoxx/labs/lab5_spring_data/src/main/resources/application-astra.yml /workspace/conference-2022-devoxx/labs/lab5_spring_data/src/main/resources/application.yml
```

ou

```bash
cp cp/workspace/conference-2022-devoxx/labs/lab5_spring_data/src/main/resources/application-local.yml /workspace/conference-2022-devoxx/labs/lab5_spring_data/src/main/resources/application.yml
```

- Vérifier la configuration et éditer là le cas échéant:

_application-astra.yml_

```yaml
spring:
  data:
    cassandra:
      schema-action: CREATE_IF_NOT_EXISTS
      keyspace-name: devoxx_spring
      username: token
      password: AstraCS:<votre_jeton>
datastax:
  astra:
    secure-connect-bundle: /home/gitpod/.cassandra/bootstrap.zip
```

_application-local.yml_

```yaml
spring:
  data:
    cassandra:
      schema-action: CREATE_IF_NOT_EXISTS
      keyspace-name: devoxx_spring
      contact-points: localhost:9042
      local-datacenter: dc1
```

#### `✅.133`- Validation de la configuration

```bash
/workspace/conference-2022-devoxx/labs/lab5_spring_data
mvn test -Dtest=com.datastax.workshop.E01_SpringDataInit
```

#### 🖥️ Logs

```
[INFO] Running com.datastax.workshop.E01_SpringDataInit
 ________                                  _______________   ________ ________
 \______ \   _______  _________  ______  __\_____  \   _  \  \_____  \\_____  \
 |    |  \_/ __ \  \/ /  _ \  \/  /\  \/  //  ____/  /_\  \  /  ____/ /  ____/
 |    `   \  ___/\   (  <_> >    <  >    </       \  \_/   \/       \/       \
 /_______  /\___  >\_/ \____/__/\_ \/__/\_ \_______ \_____  /\_______ \_______ \
 \/     \/                \/      \/       \/     \/         \/       \/

 The application will start at http://localhost:8080

13:49:30.253 INFO  com.datastax.workshop.E01_SpringDataInit      : Starting E01_SpringDataInit using Java 17.0.1 on clunven-rmbp16 with PID 33320 (started by cedricklunven in /Users/cedricklunven/dev/workspaces/datastax/conference-2022-devoxx/labs/2-spring-data)
13:49:30.255 INFO  com.datastax.workshop.E01_SpringDataInit      : No active profile set, falling back to default profiles: default
13:49:34.035 INFO  com.datastax.workshop.E01_SpringDataInit      : Started E01_SpringDataInit in 3.965 seconds (JVM running for 4.659)
13:49:34.329 INFO  com.datastax.workshop.E01_SpringDataInit      : Creating your CqlSession to Cassandra...
13:49:34.329 INFO  com.datastax.workshop.E01_SpringDataInit      : + [OK] Your are connected to keyspace devoxx_spring
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.604 s - in com.datastax.workshop.E01_SpringDataInit
[INFO]
```

## 5.2 - Comprendre les `CrudRepositories`

#### 📘 Ce qu'il faut retenir:

- Spring Data propose une system d'objet mapping pour associer les objets aux tables du modèles de données. Il utilise une interface générique `CrudRepository`.

- Travaillons avec le modèle (non optimisé) d'une todolist.

```sql
CREATE TABLE todos (
    uid uuid PRIMARY KEY,
    completed boolean,
    offset int,
    title text
)
```

- On définit un objet `TodoEntity` et on l'annote avec les annotations Spring Data.

> ```java
> @Table(value = TodoEntity.TABLENAME)
> public class TodoEntity {
>
>  public static final String TABLENAME        = "todos";
>  public static final String COLUMN_UID       = "uid";
>  public static final String COLUMN_TITLE     = "title";
>  public static final String COLUMN_COMPLETED = "completed";
>  public static final String COLUMN_ORDER     = "offset";
>
>  @PrimaryKey
>  @Column(COLUMN_UID)
>  @CassandraType(type = Name.UUID)
>  private UUID uid;
>
>  @Column(COLUMN_TITLE)
>  @CassandraType(type = Name.TEXT)
>  private String title;
>
>  @Column(COLUMN_COMPLETED)
>  @CassandraType(type = Name.BOOLEAN)
>  private boolean completed = false;
>
>  @Column(COLUMN_ORDER)
>  @CassandraType(type = Name.INT)
>  private int order = 0;
>
>  public TodoEntity(String title, int offset) {
>    this(UUID.randomUUID(), title, false, offset);
>  }
> }
> ```

- On définit une interface qui hérite de `CassandraRepository` (elle-même hérite de `CRUDRepository`) en spécifiant le bean et la clé primaire.

```java
@Repository
public interface TodoRepositoryCassandra extends CassandraRepository<TodoEntity, UUID> {
}
```

#### `✅.134`- Utiliser les `Repository` Spring Data

```bash
cd /workspace/conference-2022-devoxx/labs/lab5_spring_data
mvn test -Dtest=com.datastax.workshop.E02_SpringDataRepository
```

#### 🖥️ Logs

```bash
[INFO] Running com.datastax.workshop.E02_SpringDataRepository
 ________                                  _______________   ________ ________
 \______ \   _______  _________  ______  __\_____  \   _  \  \_____  \\_____  \
 |    |  \_/ __ \  \/ /  _ \  \/  /\  \/  //  ____/  /_\  \  /  ____/ /  ____/
 |    `   \  ___/\   (  <_> >    <  >    </       \  \_/   \/       \/       \
 /_______  /\___  >\_/ \____/__/\_ \/__/\_ \_______ \_____  /\_______ \_______ \
 \/     \/                \/      \/       \/     \/         \/       \/

 The application will start at http://localhost:8080

14:06:54.529 INFO  com.datastax.workshop.E02_SpringDataRepository : Starting E02_SpringDataRepository using Java 17.0.1 on clunven-rmbp16 with PID 33643 (started by cedricklunven in /Users/cedricklunven/dev/workspaces/datastax/conference-2022-devoxx/labs/2-spring-data)
14:06:54.530 INFO  com.datastax.workshop.E02_SpringDataRepository : No active profile set, falling back to default profiles: default
14:06:58.212 INFO  com.datastax.workshop.E02_SpringDataRepository : Started E02_SpringDataRepository in 3.895 seconds (JVM running for 4.565)
14:06:58.635 INFO  com.datastax.workshop.E02_SpringDataRepository : Tache enregistree avec id 8a175b9e-1010-4f9a-aa5c-628c81c8dd34
14:06:58.636 INFO  com.datastax.workshop.E02_SpringDataRepository : Liste des Taches
14:06:58.746 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=8a175b9e-1010-4f9a-aa5c-628c81c8dd34, title=Apprendre Cassandra, completed=false, order=0)
14:06:58.746 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=87eb778d-a938-441e-8ff5-e69feafb8719, title=Apprendre Cassandra, completed=false, order=0)
14:06:58.746 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=47a5c298-b6ec-4e8a-abb5-fca041730af3, title=Apprendre Cassandra, completed=false, order=0)
14:06:58.746 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=3847d7f9-0fa3-4d7e-b7f7-b76897b4e999, title=Apprendre Cassandra, completed=false, order=0)
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.724 s - in com.datastax.workshop.E02_SpringDataRepository
```

#### `✅.135`- Vérifier le résultat avec `CQLSh`

```sql
use devoxx_spring;
SELECT * FROM todos;
```

#### 🖥️ Logs

```bash
token@cqlsh:devoxx_spring> SELECT * FROM todos;

 uid                                  | completed | offset | title
--------------------------------------+-----------+--------+---------------------
 8a175b9e-1010-4f9a-aa5c-628c81c8dd34 |     False |      0 | Apprendre Cassandra
 87eb778d-a938-441e-8ff5-e69feafb8719 |     False |      0 | Apprendre Cassandra
 47a5c298-b6ec-4e8a-abb5-fca041730af3 |     False |      0 | Apprendre Cassandra
 3847d7f9-0fa3-4d7e-b7f7-b76897b4e999 |     False |      0 | Apprendre Cassandra

(4 rows)
```

## 5.3 - CassandraOperations

#### 📘 Ce qu'il faut retenir:

- Les `Repository` sont très puissants mais ne permettent pas tout. Le risque est de chercher à réutiliser les mêmes beans et les mêmes repositories pour différentes requêtes sur la même données alors que vous devez définir plusieurs tables.

- Spring Data propose l'accès aux opérations `CqlSession` sous-jacente au travers de objets `CassandraOperations` et `CassandraTemple`. Vous pouvez les injecter lorsque vous en avez besoin. Ils sont également disponibles dans les repository si vous héritez de `SimpleCassandraRepository`.

```java
@Repository
public class TodoRepositorySimpleCassandra extends SimpleCassandraRepository<TodoEntity, UUID> {

 protected final CqlSession cqlSession;

 protected final CassandraOperations cassandraTemplate;

 @SuppressWarnings("unchecked")
 public TodoRepositorySimpleCassandra(CqlSession cqlSession, CassandraOperations ops) {
   super(new MappingCassandraEntityInformation<TodoEntity, UUID>(
     (CassandraPersistentEntity<TodoEntity>) ops.getConverter().getMappingContext()
     .getRequiredPersistentEntity(TodoEntity.class), ops.getConverter()), ops);
   this.cqlSession = cqlSession;
   this.cassandraTemplate = ops;
 }
}
```

- L'objet `CqlSession` fait partie du contexte Spring et vous pouvez également l'utiliser au besoin.

#### `✅.136`- Utiliser `CassandraOperations` et un `SimpleCassandraRepository`

```bash
cd /workspace/conference-2022-devoxx/labs/lab5_spring_data
mvn test -Dtest=com.datastax.workshop.E03_SpringDataCassandraOperations
```

#### 🖥️ Logs

```bash
[INFO] Running com.datastax.workshop.E03_SpringDataCassandraOperations
 ________                                  _______________   ________ ________
 \______ \   _______  _________  ______  __\_____  \   _  \  \_____  \\_____  \
 |    |  \_/ __ \  \/ /  _ \  \/  /\  \/  //  ____/  /_\  \  /  ____/ /  ____/
 |    `   \  ___/\   (  <_> >    <  >    </       \  \_/   \/       \/       \
 /_______  /\___  >\_/ \____/__/\_ \/__/\_ \_______ \_____  /\_______ \_______ \
 \/     \/                \/      \/       \/     \/         \/       \/

 The application will start at http://localhost:8080

14:22:16.841 INFO  com.datastax.workshop.E03_SpringDataCassandraOperations : Starting E03_SpringDataCassandraOperations using Java 17.0.1 on clunven-rmbp16 with PID 33920 (started by cedricklunven in /Users/cedricklunven/dev/workspaces/datastax/conference-2022-devoxx/labs/2-spring-data)
14:22:16.843 INFO  com.datastax.workshop.E03_SpringDataCassandraOperations : No active profile set, falling back to default profiles: default
14:22:20.384 INFO  com.datastax.workshop.E03_SpringDataCassandraOperations : Started E03_SpringDataCassandraOperations in 3.755 seconds (JVM running for 4.457)
14:22:20.768 INFO  com.datastax.workshop.E02_SpringDataRepository : Tache enregistree avec id e73dcd8f-4427-42ab-9e32-4db8fd1a1144
14:22:20.769 INFO  com.datastax.workshop.E02_SpringDataRepository : Liste des Taches
14:22:20.865 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=8a175b9e-1010-4f9a-aa5c-628c81c8dd34, title=Apprendre Cassandra, completed=false, order=0)
14:22:20.865 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=e73dcd8f-4427-42ab-9e32-4db8fd1a1144, title=Apprendre Cassandra, completed=false, order=0)
14:22:20.865 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=87eb778d-a938-441e-8ff5-e69feafb8719, title=Apprendre Cassandra, completed=false, order=0)
14:22:20.865 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=47a5c298-b6ec-4e8a-abb5-fca041730af3, title=Apprendre Cassandra, completed=false, order=0)
14:22:20.865 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=3847d7f9-0fa3-4d7e-b7f7-b76897b4e999, title=Apprendre Cassandra, completed=false, order=0)
14:22:20.875 INFO  com.datastax.workshop.E02_SpringDataRepository : Utilisation de CassandraOperations
14:22:20.984 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=8a175b9e-1010-4f9a-aa5c-628c81c8dd34, title=Apprendre Cassandra, completed=false, order=0)
14:22:20.984 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=e73dcd8f-4427-42ab-9e32-4db8fd1a1144, title=Apprendre Cassandra, completed=false, order=0)
14:22:20.984 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=87eb778d-a938-441e-8ff5-e69feafb8719, title=Apprendre Cassandra, completed=false, order=0)
14:22:20.984 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=47a5c298-b6ec-4e8a-abb5-fca041730af3, title=Apprendre Cassandra, completed=false, order=0)
14:22:20.984 INFO  com.datastax.workshop.E02_SpringDataRepository : TodoEntity(uid=3847d7f9-0fa3-4d7e-b7f7-b76897b4e999, title=Apprendre Cassandra, completed=false, order=0)
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.677 s - in com.datastax.workshop.E03_SpringDataCassandraOperations
```

## 5.4 - Application Spring Boot

#### 📘 Ce qu'il faut retenir:

- Les différents `Repository` peuvent être injectés dans les controllers et exposés au niveau des APIs.

![](img/spring_layers.png?raw=true)

Une bonne pratique est de séparer les objets utilisés dans la couche d'accès aux données (entités) des objets utilisés dans les Apis (DTO).

#### `✅.137`- Lancer l'application

- Démarrer l'application à l'aide du plugin `spring-boot`

```bash
cd /workspace/conference-2022-devoxx/labs/lab5_spring_data
mvn spring-boot:run
```

- L'application démarre sur le port `8080`. La liste des `todos` est disponible sur `http://localhost:8080/api/v1/todos/`. Sur gitpod les ports n'étant pas ouverts il y a aura une translation d'adresse. Afficher l'Url gitpod

![](img/spring_api_local.png?raw=true)

- Afficher l'url translatée par `Gitpod` _(`gp` est la ligne de commande de gitpod)_

```bash
gp url 8080
```

- Afficher la liste des `todos`

```
gp preview "$(gp url 8080)/api/v1/todos/"
```

![](img/spring_api_gitpod.png?raw=true)

#### `✅.138`- Tests d'intégration de l'application

- Stopper l'application avec un `CTRL+C`

- Editer la classe `E04_SpringControllerTest` pour remplacer `createURLWithPort` avec l'url de votre gitpod :

_de:_

```java
private String createURLWithPort(String uri) {
  return "http://localhost:" + port + uri;
}
```

_à (ici 8080-datastaxdevs-conference2-g3jf9fgchk4.ws-eu34.gitpod.io est le résultat de ma commande gp url 8080):_

```java
private String createURLWithPort(String uri) {
  return "https://8080-datastaxdevs-conference2-g3jf9fgchk4.ws-eu34.gitpod.io" + uri;
}
```

- Exécuter le test unitaire suivant:

```bash
cd /workspace/conference-2022-devoxx/labs/lab5_spring_data
mvn test -Dtest=com.datastax.workshop.E04_SpringControllerTest
```

#### 🖥️ Logs

```bash
[INFO] Running com.datastax.workshop.E04_SpringControllerTest
 ________                                  _______________   ________ ________
 \______ \   _______  _________  ______  __\_____  \   _  \  \_____  \\_____  \
 |    |  \_/ __ \  \/ /  _ \  \/  /\  \/  //  ____/  /_\  \  /  ____/ /  ____/
 |    `   \  ___/\   (  <_> >    <  >    </       \  \_/   \/       \/       \
 /_______  /\___  >\_/ \____/__/\_ \/__/\_ \_______ \_____  /\_______ \_______ \
 \/     \/                \/      \/       \/     \/         \/       \/

 The application will start at http://localhost:8080

15:41:30.731 INFO  com.datastax.workshop.E04_SpringControllerTest : Starting E04_SpringControllerTest using Java 17.0.1 on clunven-rmbp16 with PID 41891 (started by cedricklunven in /Users/cedricklunven/dev/workspaces/datastax/conference-2022-devoxx/labs/2-spring-data)
15:41:30.733 INFO  com.datastax.workshop.E04_SpringControllerTest : No active profile set, falling back to default profiles: default
15:41:34.436 INFO  com.datastax.workshop.E04_SpringControllerTest : Started E04_SpringControllerTest in 3.898 seconds (JVM running for 4.712)
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.918 s - in com.datastax.workshop.E04_SpringControllerTest
```

<p/><br/>

> [🏠 Retour à la table des matières](#-table-des-matières)

# LAB 6 - Cassandra Quarkus Extension

## 6.1 - Introduction aux extensions Quarkus

#### 📘 Ce qu'il faut retenir:

[Quarkus](https://quarkus.io/) est un framework pour construire des microservices sur la plateforme Java. Le parti pris est de réaliser le plus d'opérations possibles durant le build et de ne packager que ce qui est absolument nécessaire. Les objectifs sont:

- La production d'une image native de quelques mega-octets seulement
- La production d'une image qui démarre en quelques millièmes de seconde.

Une [extension Quarkus](https://quarkus.io/guides/writing-extensions) permet de simplifier la configuration d'une application et d'assurer une meilleure compatibilité. L'équipe `Datastax` a créé et open sourcé une extension pour Cassandra [ici](https://github.com/datastax/cassandra-quarkus). Voici ce qu'elle permet:

- Le support de réactif avec `Mutiny` (couche réactive de Quarkus)
- L'intégration avec `vertx` et le event loop de Quarkus
- Déclarer les `Mapper` (object mapping) dans `Arc`, le système d'injection de dépendances de Quarkus.
- Fournir des hints pour la création d'une native image _aux petits oignons._

La librairie à utiliser est `cassandra-quarkus-client` et la version est [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.datastax.oss.quarkus/cassandra-quarkus-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.datastax.oss.quarkus/cassandra-quarkus-client)

```xml
<dependency>
  <groupId>com.datastax.oss.quarkus</groupId>
  <artifactId>cassandra-quarkus-client</artifactId>
  <version>${latest}</version>
</dependency>
```

Quarkus propose également un guide très bien fait sur le support de Cassandra [ici](https://quarkus.io/guides/cassandra)

## 6.2 - Connexion et configuration

#### `✅.139`- Création du keyspace `devoxx_quarkus`

_Dans Docker:_

```sql
CREATE KEYSPACE IF NOT EXISTS devoxx_quarkus
WITH REPLICATION = {
  'class' : 'NetworkTopologyStrategy',
  'dc1' : 3
}  AND DURABLE_WRITES = true;
```

Avec Astra, la manipulation des keyspaces est désactivée, c'est lui qui fixe les facteurs de réplications pour vous (Saas). La procédure est décrite en détail dans [Awesome Astra](https://awesome-astra.github.io/docs/pages/astra/faq/#how-do-i-create-a-namespace-or-a-keyspace) mais voici quelques captures:

_Repérer le bouton `ADD KEYSPACE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace-button.png)

_Créer le keyspace `devoxx_quarkus` et valider avec `SAVE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace.png)

#### `✅.140`- Configuration de l'application `Quarkus`

- Placer vous dans le répertoire `lab6_quarkus` et compiler le projet

```bash
cd /workspace/conference-2022-devoxx/labs/lab6_quarkus
mvn clean compile
```

- Localiser le fichier de configuration `application.properties` dans le répertoire `src/main/resources`. C'est le fichier de configuration principal de Quarkus. Noter le nombre de clés de configuration `quarkus.cassandra`

```bash
gp open /workspace/conference-2022-devoxx/labs/lab6_quarkus/src/main/resources/application.properties
```

- Suivant la cible (Cassandra dans Docker ou Cassandra dans Astra) la configuration de `quarkus` changera légèrement c'est pourquoi nous avons proposé 2 exemples `application-astra.properties` et `application-local.properties`

- Copier le fichier qui vous correspond vers `application.properties`

```bash
cp /workspace/conference-2022-devoxx/labs/lab6_quarkus/src/main/resources/application-astra.properties /workspace/conference-2022-devoxx/labs/lab6_quarkus/src/main/resources/application.properties
```

ou

```bash
cp /workspace/conference-2022-devoxx/labs/lab6_quarkus/src/main/resources/application-local.properties /workspace/conference-2022-devoxx/labs/lab6_quarkus/src/main/resources/application.propertoes
```

- Dans le cas de Astra changer la clef `quarkus.cassandra.auth.password` pour correspondre à votre base.

```ini
quarkus.cassandra.keyspace=devoxx_quarkus
quarkus.cassandra.cloud.secure-connect-bundle=/home/gitpod/.cassandra/bootstrap.zip
quarkus.cassandra.auth.username=<client_id>
quarkus.cassandra.auth.password=<client_secret>
```

#### `✅.141` - Validation de la configuration

```
cd /workspace/conference-2022-devoxx/labs/lab6_quarkus
mvn test -Dtest=com.datastax.workshop.E01_QuarkusInit
```

#### 🖥️ Logs

```
[INFO] Running com.datastax.workshop.E01_QuarkusInit
2022-04-19 19:18:06,628 INFO  [io.qua.arc.pro.BeanProcessor] (build-15) Found unrecommended usage of private members (use package-private instead) in application beans:
	- @Inject field com.datastaxdev.todo.TodoRestController#cqlSession,
	- @Inject field com.datastaxdev.todo.TodoRestController#uriInfo
2022-04-19 19:18:06,651 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-29) Micrometer metrics were enabled by configuration, but MicrometerMetricsFactory was not found.
2022-04-19 19:18:06,651 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-29) Make sure to include a dependency to the java-driver-metrics-micrometer module.
2022-04-19 19:18:06,952 INFO  [com.dat.oss.dri.int.cor.DefaultMavenCoordinates] (main) DataStax Java driver for Apache Cassandra(R) (com.datastax.oss:java-driver-core) version 4.13.0
2022-04-19 19:18:08,100 INFO  [com.dat.oss.dri.int.cor.tim.Clock] (vert.x-eventloop-thread-0) Using native clock for microsecond precision
2022-04-19 19:18:08,856 INFO  [com.dat.oss.dri.int.cor.ses.DefaultSession] (vert.x-eventloop-thread-8) [s0] Negotiated protocol version V4 for the initial contact point, but cluster seems to support V5, keeping the negotiated version
2022-04-19 19:18:09,215 INFO  [com.dat.oss.qua.run.int.qua.CassandraClientStarter] (main) Eagerly initializing Quarkus Cassandra client.
2022-04-19 19:18:09,255 INFO  [io.quarkus] (main) Quarkus 2.3.1.Final on JVM started in 3.793s. Listening on: http://localhost:8081
2022-04-19 19:18:09,255 INFO  [io.quarkus] (main) Profile test activated.
2022-04-19 19:18:09,255 INFO  [io.quarkus] (main) Installed features: [cassandra-client, cdi, kubernetes, micrometer, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, smallrye-openapi, swagger-ui, vertx]
2022-04-19 19:18:09,619 INFO  [com.dat.wor.E01_QuarkusInit] (main) Creating your CqlSession to Cassandra...
2022-04-19 19:18:09,621 INFO  [com.dat.wor.E01_QuarkusInit] (main) + [OK] Your are connected to keyspace devoxx_quarkus
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.518 s - in com.datastax.workshop.E01_QuarkusInit
2022-04-19 19:18:09,641 INFO  [com.dat.oss.qua.run.int.qua.CassandraClientRecorder] (main) Closing Quarkus Cassandra session.
2022-04-19 19:18:09,657 INFO  [io.quarkus] (main) Quarkus stopped in 0.021s
```

#### `✅.142` - Utilisation de `CqlSession` avec `Quarkus`

```
cd /workspace/conference-2022-devoxx/labs/lab6_quarkus
mvn test -Dtest=com.datastax.workshop.E02_QuarkusCql
```

#### 🖥️ Logs

```bash
[INFO] Running com.datastax.workshop.E02_QuarkusCql
2022-04-19 19:21:07,918 INFO  [io.qua.arc.pro.BeanProcessor] (build-20) Found unrecommended usage of private members (use package-private instead) in application beans:
	- @Inject field com.datastaxdev.todo.TodoRestController#cqlSession,
	- @Inject field com.datastaxdev.todo.TodoRestController#uriInfo
2022-04-19 19:21:07,942 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-5) Micrometer metrics were enabled by configuration, but MicrometerMetricsFactory was not found.
2022-04-19 19:21:07,943 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-5) Make sure to include a dependency to the java-driver-metrics-micrometer module.
2022-04-19 19:21:08,289 INFO  [com.dat.oss.dri.int.cor.DefaultMavenCoordinates] (main) DataStax Java driver for Apache Cassandra(R) (com.datastax.oss:java-driver-core) version 4.13.0
2022-04-19 19:21:09,543 INFO  [com.dat.oss.dri.int.cor.tim.Clock] (vert.x-eventloop-thread-0) Using native clock for microsecond precision
2022-04-19 19:21:10,202 INFO  [com.dat.oss.dri.int.cor.ses.DefaultSession] (vert.x-eventloop-thread-8) [s0] Negotiated protocol version V4 for the initial contact point, but cluster seems to support V5, keeping the negotiated version
2022-04-19 19:21:10,559 INFO  [com.dat.oss.qua.run.int.qua.CassandraClientStarter] (main) Eagerly initializing Quarkus Cassandra client.
2022-04-19 19:21:10,603 INFO  [io.quarkus] (main) Quarkus 2.3.1.Final on JVM started in 4.033s. Listening on: http://localhost:8081
2022-04-19 19:21:10,603 INFO  [io.quarkus] (main) Profile test activated.
2022-04-19 19:21:10,604 INFO  [io.quarkus] (main) Installed features: [cassandra-client, cdi, kubernetes, micrometer, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, smallrye-openapi, swagger-ui, vertx]
2022-04-19 19:21:10,884 INFO  [com.dat.wor.E02_QuarkusCql] (main) Creating the schema...
2022-04-19 19:21:10,929 INFO  [com.dat.wor.E02_QuarkusCql] (main) + [OK]
2022-04-19 19:21:10,929 INFO  [com.dat.wor.E02_QuarkusCql] (main) Inserting Data
2022-04-19 19:21:11,206 INFO  [com.dat.oss.dri.api.cor.uui.Uuids] (main) PID obtained through native call to getpid(): 4465
2022-04-19 19:21:11,238 INFO  [com.dat.wor.E02_QuarkusCql] (main) + [OK]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.023 s - in com.datastax.workshop.E02_QuarkusCql
2022-04-19 19:21:11,258 INFO  [com.dat.oss.qua.run.int.qua.CassandraClientRecorder] (main) Closing Quarkus Cassandra session.
2022-04-19 19:21:11,276 INFO  [io.quarkus] (main) Quarkus stopped in 0.024s
```

## 6.3 - Object Mapping

#### 📘 Ce qu'il faut comprendre:

- Nous construisons un objet annoté avec `@RegisterForReflection` pour permettre la réflexion et les mappers.

```java
@RegisterForReflection
public class Todo {
   private String id;
   private String title;
   private boolean completed;
   // Getter and setters
}
```

- Nous définissions une classe de service `TodoServicesCassandraOM` avec l'annotation `@ApplicationScoped` pour l'introduire dans le contexte de l'application.

- Dans le constructeur nous utilisons le `Mapper` pour instancier un `DAO` créé directement avec le driver.

> ```java
> todoDao = TodoItemMapper
>   .builder(cqlSession)
>   .withDefaultKeyspace(cqlSession.getKeyspace().get())
>   .build()
>   .todoItemDao();
> ```

#### `✅.143` - Utilisation de l'`object mapping` avec `Quarkus`

```bash
cd /workspace/conference-2022-devoxx/labs/lab6_quarkus
mvn test -Dtest=com.datastax.workshop.E03_QuarkusObjectMapping
```

#### 🖥️ Logs

```bash
2022-04-19 19:27:49,029 INFO  [io.qua.arc.pro.BeanProcessor] (build-5) Found unrecommended usage of private members (use package-private instead) in application beans:
	- @Inject field com.datastaxdev.todo.TodoRestController#cqlSession,
	- @Inject field com.datastaxdev.todo.TodoRestController#uriInfo
2022-04-19 19:27:49,049 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-4) Micrometer metrics were enabled by configuration, but MicrometerMetricsFactory was not found.
2022-04-19 19:27:49,049 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-4) Make sure to include a dependency to the java-driver-metrics-micrometer module.
2022-04-19 19:27:49,343 INFO  [com.dat.oss.dri.int.cor.DefaultMavenCoordinates] (main) DataStax Java driver for Apache Cassandra(R) (com.datastax.oss:java-driver-core) version 4.13.0
2022-04-19 19:27:49,707 INFO  [com.dat.oss.qua.run.int.qua.CassandraClientStarter] (main) Eagerly initializing Quarkus Cassandra client.
2022-04-19 19:27:50,596 INFO  [com.dat.oss.dri.int.cor.tim.Clock] (vert.x-eventloop-thread-0) Using native clock for microsecond precision
2022-04-19 19:27:51,258 INFO  [com.dat.oss.dri.int.cor.ses.DefaultSession] (vert.x-eventloop-thread-8) [s0] Negotiated protocol version V4 for the initial contact point, but cluster seems to support V5, keeping the negotiated version
2022-04-19 19:27:51,657 INFO  [io.quarkus] (main) Quarkus 2.3.1.Final on JVM started in 3.676s. Listening on: http://localhost:8081
2022-04-19 19:27:51,658 INFO  [io.quarkus] (main) Profile test activated.
2022-04-19 19:27:51,658 INFO  [io.quarkus] (main) Installed features: [cassandra-client, cdi, kubernetes, micrometer, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, smallrye-openapi, swagger-ui, vertx]
2022-04-19 19:27:51,972 INFO  [com.dat.wor.E02_QuarkusCql] (main) Inserting Data
2022-04-19 19:27:52,098 INFO  [com.dat.oss.dri.api.cor.uui.Uuids] (main) PID obtained through native call to getpid(): 4585
2022-04-19 19:27:52,133 INFO  [com.dat.wor.E02_QuarkusCql] (main) + [OK]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.458 s - in com.datastax.workshop.E03_QuarkusObjectMapping
2022-04-19 19:27:52,154 INFO  [com.dat.oss.qua.run.int.qua.CassandraClientRecorder] (main) Closing Quarkus Cassandra session.
2022-04-19 19:27:52,169 INFO  [io.quarkus] (main) Quarkus stopped in 0.021s
```

## 6.4 - Application Quarkus

#### `✅.144` - Démarrer l'application `Quarkus`

- Utiliser le plugin pour démarrer l'application en mode `dev`.

```bash
cd /workspace/conference-2022-devoxx/labs/lab6_quarkus
mvn quarkus:dev -DskipTests
```

#### 🖥️ Logs

```bash
2021-12-02 17:53:52,114 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-16) Micrometer metrics were enabled by configuration, but MicrometerMetricsFactory was not found.
2021-12-02 17:53:52,116 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-16) Make sure to include a dependency to the java-driver-metrics-micrometer module.
__  ____  __  _____   ___  __ ____  ______
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/
2021-12-02 17:53:52,758 INFO  [com.dat.oss.dri.int.cor.DefaultMavenCoordinates] (Quarkus Main Thread) DataStax Java driver for Apache Cassandra(R) (com.datastax.oss:java-driver-core) version 4.13.0
2021-12-02 17:53:53,067 INFO  [com.dat.oss.qua.run.int.qua.CassandraClientStarter] (Quarkus Main Thread) Eagerly initializing Quarkus Cassandra client.
2021-12-02 17:53:53,919 INFO  [com.dat.oss.dri.int.cor.tim.Clock] (vert.x-eventloop-thread-0) Using native clock for microsecond precision
2021-12-02 17:53:55,381 INFO  [com.dat.oss.dri.int.cor.ses.DefaultSession] (vert.x-eventloop-thread-8) [s0] Negotiated protocol version V4 for the initial contact point, but cluster seems to support V5, keeping the negotiated version
**** Table created true****
2021-12-02 17:53:56,344 INFO  [io.quarkus] (Quarkus Main Thread) javazone-3-quarkus 0.0.1-SNAPSHOT on JVM (powered by Quarkus 2.3.1.Final) started in 5.326s. Listening on: http://localhost:8080
2021-12-02 17:53:56,346 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2021-12-02 17:53:56,346 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cassandra-client, cdi, kubernetes, micrometer, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, smallrye-openapi, swagger-ui, vertx]

Tests paused
Press [r] to resume testing, [o] Toggle test output, [h] for more options
```

- L'application démarre et devrait apparaître le tableau de bord de dev.

```bash
gp preview "$(gp url 8081)/q/dev"
```

_Dashboard_
![](img/quarkus-dashboard.png?raw=true)

- Plusieurs plugins sont disponibles directement et notamment `swagger-ui` pour tester l'Api dans un navigateur.

```bash
gp preview "$(gp url 8081)/q/swagger-ui"
```

![](img/quarkus-swagger.png?raw=true)

#### `✅.145` - Test d'intégration avec `Quarkus`

Arrêter l'application en utilisant la touche `q`. Nous pouvons terminer par un test d'intégration

```bash
cd /workspace/conference-2022-devoxx/labs/lab6_quarkus
mvn test -Dtest=com.datastax.workshop.E04_QuarkusController
```

#### 🖥️ Logs

```bash
[INFO] Running com.datastax.workshop.E04_QuarkusController
2022-04-19 21:06:43,421 INFO  [io.qua.arc.pro.BeanProcessor] (build-4) Found unrecommended usage of private members (use package-private instead) in application beans:
	- @Inject field com.datastaxdev.todo.TodoRestController#cqlSession,
	- @Inject field com.datastaxdev.todo.TodoRestController#uriInfo
2022-04-19 21:06:43,444 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-25) Micrometer metrics were enabled by configuration, but MicrometerMetricsFactory was not found.
2022-04-19 21:06:43,444 WARN  [com.dat.oss.qua.dep.int.CassandraClientProcessor] (build-25) Make sure to include a dependency to the java-driver-metrics-micrometer module.
2022-04-19 21:06:43,789 INFO  [com.dat.oss.dri.int.cor.DefaultMavenCoordinates] (main) DataStax Java driver for Apache Cassandra(R) (com.datastax.oss:java-driver-core) version 4.13.0
2022-04-19 21:06:45,588 INFO  [com.dat.oss.dri.int.cor.tim.Clock] (vert.x-eventloop-thread-0) Using native clock for microsecond precision
2022-04-19 21:06:46,307 INFO  [com.dat.oss.dri.int.cor.ses.DefaultSession] (vert.x-eventloop-thread-8) [s0] Negotiated protocol version V4 for the initial contact point, but cluster seems to support V5, keeping the negotiated version
2022-04-19 21:06:46,696 INFO  [com.dat.oss.qua.run.int.qua.CassandraClientStarter] (main) Eagerly initializing Quarkus Cassandra client.
2022-04-19 21:06:46,747 INFO  [io.quarkus] (main) Quarkus 2.3.1.Final on JVM started in 4.790s. Listening on: http://localhost:8081
2022-04-19 21:06:46,748 INFO  [io.quarkus] (main) Profile test activated.
2022-04-19 21:06:46,748 INFO  [io.quarkus] (main) Installed features: [cassandra-client, cdi, kubernetes, micrometer, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, smallrye-openapi, swagger-ui, vertx]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.577 s - in com.datastax.workshop.E04_QuarkusController
2022-04-19 21:06:48,222 INFO  [com.dat.oss.qua.run.int.qua.CassandraClientRecorder] (main) Closing Quarkus Cassandra session.
2022-04-19 21:06:48,236 INFO  [io.quarkus] (main) Quarkus stopped in 0.020s
```

<p/><br/>

> [🏠 Retour à la table des matières](#-table-des-matières)

# LAB 7 - Micronaut Cassandra

## 7.1 - Introduction à Micronaut

#### 📘 Ce qu'il faut retenir:

- [Micronaut](https://micronaut.io/) est un framework de la JVM pour construire des microservices. Comme Quarkus il vise à construire des applications avec une empreinte mémoire faible et des démarrages ultra rapides. L'idée est de permettre le _serverless_ ainsi que des déploiements dans Kubernetes et le cloud.

- L'approche est différente. Il privilégie l'Aspect Oriented Programming dès la compilation au travers d'`Annotation Processor` (oui comme les mappers). Ainsi de nombreux éléments sont construits à la compilation.

- Pour démarrer avec Micronaut il est utile d'installer [la ligne de commande](https://docs.micronaut.io/latest/guide/index.html#buildCLI) avec `sdkman`.

## 7.2 - Connexion et configuration

#### `✅.146`- Création du keyspace `devoxx_micronaut`

_Dans Docker:_

```sql
CREATE KEYSPACE IF NOT EXISTS devoxx_micronaut
WITH REPLICATION = {
  'class' : 'NetworkTopologyStrategy',
  'dc1' : 3
}  AND DURABLE_WRITES = true;
```

Avec Astra, la manipulation des keyspaces est désactivée, c'est lui qui fixe les facteurs de réplications pour vous (Saas). La procédure est décrite en détail dans [Awesome Astra](https://awesome-astra.github.io/docs/pages/astra/faq/#how-do-i-create-a-namespace-or-a-keyspace) mais voici quelques captures:

_Repérer le bouton `ADD KEYSPACE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace-button.png)

_Créer le keyspace `devoxx_micronaut` et valider avec `SAVE`_
![](https://awesome-astra.github.io/docs/img/faq/create-keyspace.png)

#### `✅.147`- Configuration de l'application `Micronaut`

- Placer vous dans le répertoire `lab7_micronaut` et compiler le projet

```bash
cd /workspace/conference-2022-devoxx/labs/lab7_micronaut
mvn clean compile
```

- Localiser le fichier de configuration `application.yml` dans le répertoire `src/main/resources`. C'est le fichier de configuration principal de Micronaut.

```bash
gp open /workspace/conference-2022-devoxx/labs/lab7_micronaut/src/main/resources/application.yml
```

- Suivant la cible (Cassandra dans Docker ou Cassandra dans Astra) la configuration de `micronaut` changera légèrement c'est pourquoi nous avons proposé 2 exemples `application-astra.yml` et `application-local.yml`

- Copier le fichier qui vous correspond vers `application.yml`

```bash
cp /workspace/conference-2022-devoxx/labs/lab7_micronaut/src/main/resources/application-astra.yml /workspace/conference-2022-devoxx/labs/lab7_micronaut/src/main/resources/application.yml
```

ou

```bash
cp /workspace/conference-2022-devoxx/labs/lab7_micronaut/src/main/resources/application-local.yml /workspace/conference-2022-devoxx/labs/lab7_micronaut/src/main/resources/application.yml
```

- Dans le cas de Astra changer la clef `cassandra.default.advanced.auth-provider.password` pour correspondre à votre base. On remarquera que Micronaut on fait le choix d'utiliser les mêmes clefs que le fichier de configuration du drivers et de ne pas réinventer la roue (merci à eux).

#### `✅.148` - Validation de la configuration

> 🚨 The maven test consider the bean NULL. The command below is failin

```
cd /workspace/conference-2022-devoxx/labs/lab7_micronaut
mvn test -Dtest=com.datastaxdev.E01_MicronautInit
```

#### 🖥️ Logs

![](img/micronaut_test_01.png?raw=true)

#### `✅.149` - Utilisation de `CqlSession` avec `Micronaut`

> 🚨 The maven test consider the bean NULL. The command below is failin

```
cd /workspace/conference-2022-devoxx/labs/lab7_micronaut
mvn test -Dtest=com.datastaxdev.E02_MicronautCql
```

#### 🖥️ Logs

![](img/micronaut_test_02.png?raw=true)

## 7.3 - Object Mapping

#### `✅.150` - Utilisation de l'`object mapping` avec `Micronaut`

> 🚨 The maven test consider the bean NULL. The command below is failin

```bash
cd /workspace/conference-2022-devoxx/labs/lab7_micronaut
mvn test -Dtest=com.datastaxdev.E03_MicronautObjectMapping
```

#### 🖥️ Logs

![](img/micronaut_test_02.png?raw=true)

## 7.4 - Application Micronaut

#### `✅.151`- Démarrer l'application `micronaut`

```bash
cd /workspace/conference-2022-devoxx/labs/lab7_micronaut
mvn clean compile exec:java
```

#### 🖥️ Logs

```
[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ lab7-micronaut ---
 __  __ _                                  _
|  \/  (_) ___ _ __ ___  _ __   __ _ _   _| |_
| |\/| | |/ __| '__/ _ \| '_ \ / _` | | | | __|
| |  | | | (__| | | (_) | | | | (_| | |_| | |_
|_|  |_|_|\___|_|  \___/|_| |_|\__,_|\__,_|\__|
  Micronaut (v3.2.6)

22:28:49.222 [com.datastaxdev.TodoApplication.main()] INFO  c.datastaxdev.TodoApplicationStartup - Startup Initialization
22:28:50.662 [com.datastaxdev.TodoApplication.main()] INFO  c.datastaxdev.TodoApplicationStartup - + Table TodoItems created if needed.
22:28:50.662 [com.datastaxdev.TodoApplication.main()] INFO  c.datastaxdev.TodoApplicationStartup - [OK]
```

- Open the application API on port `8082`

```bash
gp preview "$(gp url 8082)/api/v1/clun/todos/"
```

#### `✅.151` - Test d'intégration avec `Micronaut`

Arrêter l'application en utilisant la touche `CTRL+C`. Nous pouvons terminer par un test d'intégration

```bash
cd /workspace/conference-2022-devoxx/labs/lab7_micronaut
mvn test -Dtest=com.datastaxdev.E04_MicronautController
```

#### 🖥️ Logs

![](img/micronaut_test_04.png?raw=true)

---

Vous êtes à la fin de la session. Félicitations !!

![](img/end.gif?raw=true)

#### `✅.152` - Restons connectés

Si la session vous a plu.

- Rejoignez mon réseau sur [linkedin](https://www.linkedin.com/in/clunven/)
- Twittez à propos de la session avec `@clunven` et `#DevoxxFR`
- Notez la session sur l'application `Devoxx`
