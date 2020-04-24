package mental.listener;



import mental.dal.DAOFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class AppContextListener implements ServletContextListener {
	
	private static final Logger LOGGER = Logger.getLogger( AppContextListener.class.getName() );
	
	@Override
	public void contextInitialized( ServletContextEvent sce ) {
		LOGGER.log( Level.INFO, "L'application démarre!" );
		try {
			DAOFactory.init(sce.getServletContext());
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed( ServletContextEvent sce ) {
		LOGGER.log( Level.INFO, "L'application s'arrête!" );
	}
}
