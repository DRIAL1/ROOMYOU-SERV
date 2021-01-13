package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("PropertyTypeDao")
@Lazy
@ConfigurationFile ( configurationFile = "dao/PropertyTypeDao.xml", configurationFilePlaceholder = "dao/placeholders.properties") 
public class PropertyTypeDao extends OntimizeJdbcDaoSupport{
	
	public static final String ATTR_PROPERTYTYPE_ID = "propertytype_id";
	public static final String ATTR_PROPERTYDESC    = "propertydesc";

}