

package ecommerce.webdemo;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("ecommerce.webdemo")
public class HibernateConfig 
{
	
	@Bean("dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecommerce");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		factoryBuilder.addProperties(getProperties());
		factoryBuilder.scanPackages("ecommerce.webdemo.model");
		return factoryBuilder.buildSessionFactory();
		
	}
	

	public Properties getProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		properties.setProperty("hibernate.show_sql","true");
		return properties;
		
	}
	
@Bean
	public HibernateTransactionManager geHibernateTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}
}
