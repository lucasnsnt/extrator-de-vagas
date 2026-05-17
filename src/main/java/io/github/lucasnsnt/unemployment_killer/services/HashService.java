package io.github.lucasnsnt.unemployment_killer.services;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;

@Service
public class HashService {

    public String generateHash(String title, String description, String company) throws Exception {

        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(title.getBytes("utf8"),0,title.length());
        if (description != null) {
            m.update(description.getBytes("utf8"), 0, description.length());
        }
        if (company != null) {
            m.update(company.getBytes("utf8"),0,company.length());
        }
        return new BigInteger(1,m.digest()).toString(16);

    }
}
