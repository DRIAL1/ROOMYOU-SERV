package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("FlatDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/FlatDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class FlatDao extends OntimizeJdbcDaoSupport {

 public static final String ATTR_FLAT = "flat_id";
 public static final String ATTR_ADDRESS = "address_id";
 
 
 

}