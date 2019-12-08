package com.funtl.hello.spring.cloud.commons.redisson.enums;

/**
 * 锁的模式
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-12-08 21:21:39
 * @see com.funtl.hello.spring.cloud.commons.redisson.enums
 */
public enum RedissonLockModel {

    /**
     * 可重入锁：某个线程已经获得某个锁，可以再次获取锁而不会出现死锁
     */
    REENTRANT,

    /**
     * 公平锁：加锁前先查看是否有排队等待的线程，有的话优先处理排在前面的线程
     */
    FAIR,

    /**
     * 联锁：可以把一组锁当作一个锁来加锁和释放
     * 基于 Redis 的分布式 RedissonMultiLock 对象将多个 RLock 对象分组，并将它们作为一个锁处理。
     * 每个 RLock 对象可能属于不同的 Redisson 实例
     */
    MULTIPLE,

    /**
     * 红锁：用于解决异步数据丢失和脑裂问题
     * 假设有多个 Redis 节点，这些节点之间既没有主从，也没有集群关系。
     * 客户端用相同的 key 和随机值在多个节点上请求锁，请求锁的超时时间应小于锁自动释放时间。
     * 当超过半数 Redis 上请求到锁的时候，才算是真正获取到了锁。
     * 如果没有获取到锁，则把部分已锁的 Redis 释放掉
     */
    REDLOCK,

    /**
     * 读锁（共享锁）：共享用于不更改或不更新数据的操作（只读操作），如 SELECT 语句
     * 如果事务 T 对数据 A 加上共享锁后，则其他事务只能对 A 再加共享锁，不能加排他锁。
     * 获准共享锁的事务只能读数据，不能修改数据
     */
    READ,

    /**
     * 写锁（排他锁）：用于数据修改操作，例如 INSERT、UPDATE 或 DELETE。确保不会同时同一资源进行多重更新
     * 如果事务 T 对数据 A 加上排他锁后，则其他事务不能再对 A 加任何类型的锁。
     * 获准排他锁的事务既能读数据，又能修改数据。
     * 我们在操作数据库的时候，可能会由于并发问题而引起的数据的不一致性（数据冲突）
     */
    WRITE,

    /**
     * 自动模式，当参数只有一个使用 REENTRANT 参数多个 REDLOCK
     */
    AUTO

}
