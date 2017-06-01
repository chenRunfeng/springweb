package service;

import java.util.List;
import java.io.Serializable;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import dao.BaseDaoImpl;
import service.IBaseServices;  
@Service
@Transactional
public class BaseServiceImpl<T, PK extends Serializable> implements IBaseServices<T, PK>{  
    @Autowired
    private BaseDaoImpl<T, PK> BaseDaoImpl;     
    public T get(PK id) {  
        return BaseDaoImpl.get(id);  
    }  
      
    public PK save(T entity) {  
        return BaseDaoImpl.save(entity);  
    }  
    public List<T> getObject(){
    	return BaseDaoImpl.getentitys();
    }
    public List querybysql(String sql){
    	List<Object[]> list=BaseDaoImpl.queryBySql(sql);
    	return list;
    }
  public int excuteBysql(String sql){
	return BaseDaoImpl.excuteBySql(sql);
}
}  