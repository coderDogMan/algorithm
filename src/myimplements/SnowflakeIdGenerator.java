package myimplements;

public class SnowflakeIdGenerator {
    // 定义初始时间戳 (2020-01-01 00:00:00 GMT)
    private static final long START_TIMESTAMP = 1577836800000L;

    // 定义各部分占位长度
    private static final long SEQUENCE_BITS = 12; // 序列号占用的位数
    private static final long WORKER_ID_BITS = 5; // 机器标识占用的位数
    private static final long DATACENTER_ID_BITS = 5; // 数据中心标识占用的位数

    // 计算各部分最大值
    private static final long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BITS);
    private static final long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);
    private static final long MAX_DATACENTER_ID = -1L ^ (-1L << DATACENTER_ID_BITS);

    // 定义各部分向左的位移
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

    // 定义初始值
    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    // 构造函数
    public SnowflakeIdGenerator(long workerId, long datacenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("WorkerId必须在0-%d之间", MAX_WORKER_ID));
        }
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("DatacenterId必须在0-%d之间", MAX_DATACENTER_ID));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    // 生成ID的方法
    public synchronized long nextId() {
        long timestamp = timeGen();

        // 如果当前时间小于上一次生成ID的时间，说明系统时钟回退过，应抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("系统时钟发生回退，请检查系统时间配置");
        }

        // 如果当前时间与上一次生成ID的时间相同，则需要使用序列号进行递增
        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            // 如果序列号已经达到最大值，则等待下一毫秒
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 如果当前时间大于上一次生成ID的时间，则将序列号重置为0
            sequence = 0;
        }

        // 更新上一次生成ID的时间戳
        lastTimestamp = timestamp;

        // 生成ID
        return ((timestamp - START_TIMESTAMP) << TIMESTAMP_LEFT_SHIFT) |
                (datacenterId << DATACENTER_ID_SHIFT) |
                (workerId << WORKER_ID_SHIFT) |
                sequence;
    }

    // 获取下一个毫秒的方法
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    // 获取当前时间戳的方法
    private long timeGen() {
        return System.currentTimeMillis();
    }

    // 测试
    public static void main(String[] args) {
        // 创建一个 SnowflakeIdGenerator 对象，传入机器标识和数据中心标识
        SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1, 1);

        // 生成并打印10个ID
        for (int i = 0; i < 10; i++) {
            long id = idGenerator.nextId();
            System.out.println("生成的ID：" + id);
        }
    }
}