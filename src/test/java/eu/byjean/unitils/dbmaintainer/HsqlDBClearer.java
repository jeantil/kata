package eu.byjean.unitils.dbmaintainer;

import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unitils.core.UnitilsException;
import org.unitils.core.dbsupport.DbSupport;
import org.unitils.core.dbsupport.HsqldbDbSupport;
import org.unitils.dbmaintainer.clean.impl.DefaultDBClearer;
import org.unitils.util.PropertyUtils;

public class HsqlDBClearer extends DefaultDBClearer {
	/**
	 * Property to indicate that we can drop and create the schemas to clean the
	 * database
	 */
	public static final String PROPERTY_DROP_SCHEMAS = "dbMaintainer.schemas.drop";

	private static final String DROP_SCHEMA = "DROP SCHEMA %1";
	private static final String CREATE_SCHEMA = "CREATE SCHEMA %1";
	
	  /* The logger instance for this class */
	private static Log logger = LogFactory.getLog(HsqlDBClearer.class);

	protected boolean dropSchemas;
	@Override
	public void clearSchemas() {
		if(dropSchemas){
			 for (DbSupport dbSupport : dbSupports) {
				 recreateSchemas(dbSupport);
			 }
		}else{
			super.clearSchemas();
		}
	}

	private void recreateSchemas(DbSupport dbSupport) {
		if(dbSupport instanceof HsqldbDbSupport){
			String dropQuery = MessageFormat.format(DROP_SCHEMA, dbSupport.getSchemaName());
			try{
				dbSupport.getSQLHandler().executeQuery(dropQuery);
			}catch (UnitilsException e) {	
				logger.warn("unable to drop schema attempting to create anyway");
			}
			String createQuery = MessageFormat.format(CREATE_SCHEMA, dbSupport.getSchemaName());
			dbSupport.getSQLHandler().executeQuery(dropQuery);
		}
	}

	@Override
	protected void doInit(Properties configuration) {
		// TODO Auto-generated method stub
		super.doInit(configuration);
		dropSchemas = PropertyUtils.getBoolean(PROPERTY_DROP_SCHEMAS,
				configuration);

	}

}
