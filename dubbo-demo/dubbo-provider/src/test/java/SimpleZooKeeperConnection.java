/**
 * @author zqz
 * @date 2024-04-26 23:03
 */
import org.apache.zookeeper.ZooKeeper;

public class SimpleZooKeeperConnection {
    public static void main(String[] args) throws Exception {
        // ZooKeeper服务器地址和端口
        String host = "127.0.0.1:2181";
        // 连接ZooKeeper
        ZooKeeper zooKeeper = new ZooKeeper(host, 3000, null);
        // 等待连接建立
        while (zooKeeper.getState() != ZooKeeper.States.CONNECTED) {
            Thread.sleep(1000);
        }
        // 连接成功
        System.out.println("Connected to ZooKeeper!");
        // 关闭连接
        zooKeeper.close();
    }
}