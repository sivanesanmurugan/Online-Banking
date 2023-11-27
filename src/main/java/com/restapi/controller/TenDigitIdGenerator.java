package com.restapi.controller;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class TenDigitIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Random random = new Random();
        long randomValue = (long) (Math.pow(10, 9) + random.nextInt((int) Math.pow(10, 9)));
        return randomValue;
    }
}
