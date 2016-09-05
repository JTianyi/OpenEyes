package com.example.dllo.openeyes.tools;

import com.example.dllo.openeyes.app.App;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.List;

/**
 * Created by mac on 16/8/30.
 * 数据库  工具类
 */
public class DatabaseManager {

    private LiteOrm liteOrm;
    private static DatabaseManager ourInstance = new DatabaseManager();

    private DatabaseManager() {
        if (liteOrm == null) {
            liteOrm = LiteOrm.newCascadeInstance(App.getContext(), "openeyes.db");
        }
    }

    public static DatabaseManager getOurInstance() {
        return ourInstance;
    }

    /**
     * 插入一条记录
     */
    public <T> void insert(T t) {
        liteOrm.save(t);
    }

    /**
     * 插入所有数据
     */
    public <T> void insertAll(List<T> list) {
        liteOrm.save(list);
    }

    /**
     * 查询所有记录
     */
    public <T> List<T> getQueryAll(Class<T> clas) {
        return liteOrm.query(clas);
    }

    /**
     * 查询  某字段 等于 Value的值
     */
    public <T> List<T> getQueryByWhereLength(Class<T> clas, String field, String[] values, int start, int length) {
        return liteOrm.<T>query(new QueryBuilder(clas).where(field + "=?", values).limit(start, length));
    }


    /**
     * 删除某条数据
     * @param cla
     * @param field
     * @param value
     * @param <T>
     */
    public <T> void delete(Class<T> cla,String field,String [] value){
        liteOrm.delete(cla, WhereBuilder.create(cla).where(field + "=?", value));
    }

    /**
     * 删除一个数据
     */
    public <T> void delete(T t) {
        liteOrm.delete(t);
    }

    /**
     * 删除一个表
     */
    public <T> void delete(Class<T> clas) {
        liteOrm.delete(clas);
    }

    /**
     * 删除集合中的数据
     */
    public <T> void deleteList(List<T> list) {
        liteOrm.delete(list);
    }
    /**
     * 删除数据库
     */
    public void deleteDatabase(){
        liteOrm.deleteDatabase();
    }

}