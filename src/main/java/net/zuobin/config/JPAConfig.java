package net.zuobin.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Sahinn
 * @date 16/6/13
 * 使用Spring Data,作为持久层框架,配置需要扫描的包
 */
@Configuration
@PropertySource("classpath:demo.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "net.zuobin.dao")
public class JPAConfig {

    @Autowired
    private Environment env;

    /*
    相当于以下配置
    <property name="jpaProperties">
        <props>
        <!--设置外连接抓取树的最大深度 -->
        <prop key="hibernate.max_fetch_depth">3</prop>
        <prop key="hibernate.jdbc.fetch_size">18</prop>
        <prop key="hibernate.jdbc.batch_size">10</prop>
        <!-- 自动建表类型 validate|create|create-drop|update -->
        <!-- <prop key="hibernate.hbm2ddl.auto">validate</prop> -->
        <!-- 是否显示SQL -->
        <prop key="hibernate.show_sql">true</prop>
        <!-- 显示SQL是否格式化 -->
        <prop key="hibernate.format_sql">false</prop>
        <!-- 关闭二级缓存 -->
        <prop key="hibernate.cache.provider_class">org.hibernate.cache.NoCacheProvider</prop>
        <!-- 关闭实体字段映射校验 -->
        <prop key="javax.persistence.validation.mode">none</prop>
        <prop key="hibernate.ejb.naming_strategy">org.hibernate.cfg.ImprovedNamingStrategy</prop>
        </props>
    </property>
    */
    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.query.substitutions", env.getProperty("hibernate.query.substitutions"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.connection.autocommit", env.getProperty("hibernate.connection.autocommit"));
        properties.setProperty("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
        return properties;
    }

    /*
    类似于作以下的xml配置
    <bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
        <property name="dataSource" ref="mysqlDataSource"></property>
        <property name="packagesToScan" value="net.zuobin.entity"></property>
        <property name="persistenceUnitName" value="mysqldb"></property>
        <property name="jpaVendorAdapter">
        <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
        <property name="showSql" value="true"></property>
        <property name="databasePlatform" value="org.hibernate.dialect.MySQLDialect" />
        </bean>
        </property>
        <property name="jpaProperties">
        <props>
        <!--设置外连接抓取树的最大深度 -->
        <prop key="hibernate.max_fetch_depth">3</prop>
        <prop key="hibernate.jdbc.fetch_size">18</prop>
        <prop key="hibernate.jdbc.batch_size">10</prop>
        <!-- 自动建表类型 validate|create|create-drop|update -->
        <!-- <prop key="hibernate.hbm2ddl.auto">validate</prop> -->
        <!-- 是否显示SQL -->
        <prop key="hibernate.show_sql">true</prop>
        <!-- 显示SQL是否格式化 -->
        <prop key="hibernate.format_sql">false</prop>
        <!-- 关闭二级缓存 -->
        <prop key="hibernate.cache.provider_class">org.hibernate.cache.NoCacheProvider</prop>
        <!-- 关闭实体字段映射校验 -->
        <prop key="javax.persistence.validation.mode">none</prop>
        <prop key="hibernate.ejb.naming_strategy">org.hibernate.cfg.ImprovedNamingStrategy</prop>
        </props>
        </property>
    </bean>
    */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());

        //配置需要扫描的包
        em.setPackagesToScan(new String[] {"net.zuobin.entity"});

        //可选配置
        //em.setPersistenceUnitName("");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setMaxActive(Integer.valueOf(env.getProperty("jdbc.maxActive")));
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }

    /*
    相当于xml的以下配置
    <bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
        <property name="entityManagerFactory" ref="entityManagerFactory"/>
    </bean>
    */
    @Bean
    public PlatformTransactionManager transactionManager(){
        EntityManagerFactory factory = entityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
