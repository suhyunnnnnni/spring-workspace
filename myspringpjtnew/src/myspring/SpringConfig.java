package myspring;

import java.io.IOException;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// <context:component-scan base-package="myspring"></context:component-scan>
@Configuration
@ComponentScan(basePackages = "myspring")
public class SpringConfig {

	/*
	 * <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
			<property name="driverClassName" value="com.mysql.cj.jdbc.Driver"></property>
			<property name="url" value="jdbc:mysql://localhost:3306/newhr"></property>
			<property name="username" value="root"></property>
			<property name="password" value="rotrotroot"></property>
		</bean>
	*/
	
	@Bean 
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/newhr");
		dataSource.setUsername("root");
		dataSource.setPassword("rotrotroot");
		return dataSource;
	}
	
	/*<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
			<property name="dataSource" ref="dataSource"></property>
			<property name="mapperLocations" value="classpath:mapper-emp.xml"></property>
			<property name="configuration">
				<bean class="org.apache.ibatis.session.Configuration">
					<property name="mapUnderscoreToCamelCase" value="true"></property>
				</bean>
			</property>
		</bean>
	*/
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext context) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setMapperLocations(context.getResources("classpath:mapper-emp.xml"));
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		factory.setConfiguration(configuration);
		return factory;
	}
	/*<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
			<constructor-arg index="0" ref="sqlSessionFactory"></constructor-arg>
		</bean>*/
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
		return template;
	}
	
	
}
