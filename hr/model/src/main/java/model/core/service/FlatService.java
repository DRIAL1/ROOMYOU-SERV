package model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import api.core.service.IFlatService;
import model.core.dao.AddressDao;
import model.core.dao.FlatDao;
import model.core.dao.RoomDao;

import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("FlatService")
@Lazy
public class FlatService implements IFlatService{

 @Autowired private FlatDao flatDao;
 @Autowired private DefaultOntimizeDaoHelper daoHelper;
 @Autowired private RoomDao roomDao;
 @Autowired private AddressDao addressDao;
 
 
 @Override
 public EntityResult flatQuery(Map<String, Object> keyMap, List<String> attrList)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.query(this.flatDao, keyMap, attrList);
 }

 @Override
 public EntityResult flatInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
  return this.daoHelper.insert(this.flatDao, attrMap);
 }

 @Override
 public EntityResult flatUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.update(this.flatDao, attrMap, keyMap);
 }

 @Override
 public EntityResult flatDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
  return this.daoHelper.delete(this.flatDao, keyMap);
 }

@Override
public EntityResult roomQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException {
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
public EntityResult addressQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException {
	return this.daoHelper.query(this.addressDao, keyMap, attrList);
}

@Override
public EntityResult addressInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
	return this.daoHelper.insert(this.addressDao, attrMap);
}

@Override
public EntityResult addressUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
		throws OntimizeJEERuntimeException {
	return this.daoHelper.update(this.addressDao, attrMap, keyMap);
}

@Override
public EntityResult addressDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
	return this.daoHelper.delete(this.addressDao, keyMap);
}

}