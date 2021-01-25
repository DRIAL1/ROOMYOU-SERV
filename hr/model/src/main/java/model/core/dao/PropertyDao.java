package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("PropertyDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/PropertyDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class PropertyDao extends OntimizeJdbcDaoSupport {

 public static final String ATTR_IDPROPERTY = "property_id";
 public static final String ATTR_ROOM = "room_id";
 public static final String ATTR_FLAT = "flat_id";
 public static final String ATTR_PROPERTY = "propertytype_id";
 public static final String ATTR_PROPERTY_SPEC = "property_txt";
 public static final String ATTR_PROPERTY_SPEC2 = "property_binary";
 public static final String ATTR_PROPERTY_SPEC3 = "property_number";
 public static final String QUERY_ROOM_PROPERTIES = "roomproperties";
 public static final String QUERY_FLAT_PROPERTIES = "flatproperties";
 
 

}