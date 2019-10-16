package New.SignTable;

//符号表是一种典型的抽象数据类型，支持两种操作：插入(put),即将一组新的键值对存入表中；查找(get),即根据给定的键得到相应的值
public interface ST<Key extends Comparable<Key>,Value> {
    void put(Key key,Value value); //将键值对存入表中(若值为空则将键key从表中删除)
    Value get(Key key); //获得key对应的值(若key不存在返回null)
    void delete(Key key);//从表中删除键key(及对应的值)
    boolean contains(Key key); //键key在表中是否有对应的值
    boolean isEmpty();  //表是否为空
    int size(); //表中的键值对数量
    Iterable<Key> keys(); //表中所有键的集合


    //有序的泛型符号表的增加的API(Key从普通的key变为继承了Comparable类型)
    Key min(); //最小的键
    Key max(); //最大的键
    Key floor(Key key); //小于等于key的最大键
    Key ceiling(Key key);//大于等于key的最小键
    int rank(Key key);//小于key的键的数量
    Key select(int k); //排名为k的键
    void deleteMin(); //删除最小的键
    void deleteMax(); //删除最大的键
    int size(Key lo,Key hi); //[lo..hi]之间键的数量
    Iterable<Key> keys(Key lo,Key hi); //[lo.. hi]之间的所有键，已排序
}
