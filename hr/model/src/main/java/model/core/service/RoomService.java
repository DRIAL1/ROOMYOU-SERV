package model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import api.core.service.IRoomService;
import model.core.dao.RoomDao;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("RoomService")
@Lazy
public class RoomService implements IRoomService{

 @Autowired private RoomDao roomDao;
 @Autowired private RoomDao roomDetailDao;
 @Autowired private DefaultOntimizeDaoHelper daoHelper;
 
 @Override
 public EntityResult roomQuery(Map<String, Object> keyMap, List<String> attrList)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.query(this.roomDao, keyMap, attrList);
 }

 @Override
 public EntityResult roomDetailsQuery(Map<String, Object> keyMap, List<String> attrList)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.query(this.roomDao, keyMap, attrList, "details");
 }
 
 @Override
 public EntityResult roomInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
  return this.daoHelper.insert(this.roomDao, attrMap);
 }

 @Override
 public EntityResult roomUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.update(this.roomDao, attrMap, keyMap);
 }

 @Override
 public EntityResult roomDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
  return this.daoHelper.delete(this.roomDao, keyMap);
 }

@Override
public EntityResult roomTypeQuery(Map<String, Object> keyMap, List<String> attrList)
		throws OntimizeJEERuntimeException {
	return this.daoHelper.query(this.roomDetailDao, keyMap, attrList);
}

@Override
public EntityResult roomTypeInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
	return this.daoHelper.insert(this.roomDetailDao, attrMap);
}

@Override
public EntityResult roomTypeUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
		throws OntimizeJEERuntimeException {
	return this.daoHelper.update(this.roomDetailDao, attrMap, keyMap);
}

@Override
public EntityResult roomTypeDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
	return this.daoHelper.delete(this.roomDetailDao, keyMap);
}

}