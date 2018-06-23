package dao.Impl;

import dao.Dao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository("dao1")
@Scope("prototype")
public class DaoImpl implements Dao {
    @Override
  public   void saveUser(){
        System.out.println("asdasdasd:"+(new DaoImpl() instanceof Dao));
        System.out.println("已经保存");
    }
}
