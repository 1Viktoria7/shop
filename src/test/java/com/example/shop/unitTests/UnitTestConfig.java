package com.example.shop.unitTests;

import java.util.Properties;
import com.example.shop.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UnitTestConfig {
    @Test
    @DisplayName("Получени значений в правильной конфигурации")
    void ShouldGetPropsWithCorrectConfiguration() {
        Properties expectedProperties = new Properties();
        expectedProperties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        expectedProperties.setProperty("hibernate.connection.url", "jdbc:postgresql://stampy.db.elephantsql.com:5432/nykbjfyu");
        expectedProperties.setProperty("hibernate.connection.username", "nykbjfyu");
        expectedProperties.setProperty("hibernate.connection.password", "BJ0QQMsy2UK45xWFY1PP9GNxa3yNr2jh");
        expectedProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        expectedProperties.setProperty("hibernate.show_sql", "true");
        expectedProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        expectedProperties.setProperty("hibernate.connection.autocommit", "true");

        Properties actualProperties = Configuration.getProps();
        assertEquals(expectedProperties, actualProperties);
    }

    @Test
    @DisplayName("Получение исключения при создании экземпляра класса SessionFactory не равном нулю")
    void ShouldGetSessionFactoryWithoutException() {
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.buildFactory();
        assertNotNull(sessionFactory);
    }

    @Test
    @DisplayName("Получение исключения при получении экземпляра класса равном нулю")
    void ShouldCheckGetExceptionWhenFactoryNull() {
        assertThrows(NullPointerException.class, () -> {
            Configuration.createNewSession(null);
        });
    }

    @Test
    @DisplayName("Получение нового экземпляра класса session")
    void ShouldCreateNewSessionWithFactory() {
        SessionFactory mockFactory = mock(SessionFactory.class);
        Session mockSession = mock(Session.class);
        when(mockFactory.openSession()).thenReturn(mockSession);
        Session session = Configuration.createNewSession(mockFactory);
        assertNotNull(session);
        verify(mockFactory, times(1)).openSession();
    }
}