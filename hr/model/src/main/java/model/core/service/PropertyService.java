package model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import api.core.service.IPropertyService;
import model.core.dao.PropertyDao;
import model.core.dao.PropertyTypeDao;

import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("PropertyService")
@Lazy
public class PropertyService implements IPropertyService{

 @Autowired private PropertyDao propertyDao;
 @Autowired private PropertyTypeDao propertyTypeDao;
 @Autowired private DefaultOntimizeDaoHelper daoHelper;
 
 @Override
 public EntityResult propertyQuery(Map<String, Object> keyMap, List<String> attrList)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.query(this.propertyDao, keyMap, attrList);
 }
 
 @Override
 public EntityResult propertyRoomQuery(Map<String, Object> keyMap, List<String> attrList)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.query(this.propertyDao, keyMap, attrList, PropertyDao.QUERY_ROOM_PROPERTIES);
 }
 
 @Override
 public EntityResult propertyFlatQuery(Map<String, Object> keyMap, List<String> attrList)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.query(this.propertyDao, keyMap, attrList, PropertyDao.QUERY_FLAT_PROPERTIES);
 }

 @Override
 public EntityResult propertyInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
  return this.daoHelper.insert(this.propertyDao, attrMap);
 }

 @Override
 public EntityResult propertyUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.update(this.propertyDao, attrMap, keyMap);
 }

 @Override
 public EntityResult propertyDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
  return this.daoHelper.delete(this.propertyDao, keyMap);
 }

@Override
public EntityResult propertyTypeQuery(Map<String, Object> keyMap, List<String> attrList)
		throws OntimizeJEERuntimeException {
	  return this.daoHelper.query(this.propertyTypeDao, keyMap, attrList);
}

@Override
public EntityResult propertyTypeInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
	return this.daoHelper.insert(this.propertyTypeDao, attrMap);
}

@Override
public EntityResult propertyTypeUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
		throws OntimizeJEERuntimeException {
	return this.daoHelper.update(this.propertyTypeDao, attrMap, keyMap);
}

@Override
public EntityResult propertyTypeDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
	return this.daoHelper.delete(this.propertyTypeDao, keyMap);
}

}