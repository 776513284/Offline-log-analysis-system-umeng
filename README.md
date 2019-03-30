# Offline-log-analysis-system-umeng
软件架构：Hadoop、Zookeeper、Hive、Flume、Kafka、Springboot
项目描述：本项目是一个仿友盟数据服务的APP用户离线日志分析项目，通过离线日志分析出APP的日新增/活跃用户，周新增/活跃用户，月新增/活跃用户，沉默用户，月活率，回流用户，用户启动次数等信息。
实现技术：通过后台模拟生成启动/错误/事件/使用/页面日志到kafka集群，通过flume过滤收集kafka对应主题上的日志信息到hdfs，通过hive建立外部分区表，通过cron调度，周期性加载hdfs数据到hive的分区表，自定义udf函数通过HQL语句对hive表进行查询以实现相关功能，查询结果通过基于SSM框架和echart插件的页面展示。
