package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Or;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {
    @Mock
    Order orderMock;

    @InjectMocks
    EmailService emailServiceMock;

    @Test(expected = RuntimeException.class)
    public void sendEmail() {
        //Given
        EmailService emailService = new EmailService();
        Order order = new Order(3, "chips", 45.34);

        //When
        emailService.sendEmail(order);

        //Then
        verify(emailServiceMock).sendEmail(order);
    }

    @Test
    public void testSendEmail() {
        //Given
        EmailService emailService = new EmailService();
        Order order = new Order(3, "chips", 45.34);

        //When
        emailServiceMock.sendEmail(order, "ayush.tyagi2@tothenew.com");

        //Then
        assertEquals(true, emailService.sendEmail(order,"ayush.tyagi2@tothenew.com"));
    }
}