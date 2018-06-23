package dao.Impl;

import dao.Dao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("dao2")
@Scope("prototype")
public class DaoImpl1 implements Dao {
    @Override
    public void saveUser() {
        System.out.println("asdasdasd:"+(new DaoImpl() instanceof Dao));
        System.out.println("我是dao1");
    }
}
