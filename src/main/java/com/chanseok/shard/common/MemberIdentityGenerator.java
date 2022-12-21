package com.chanseok.shard.common;

import java.math.BigInteger;
import java.util.UUID;

public class MemberIdentityGenerator {
    public static String generateUserIdentity() {
        return String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(1, 21);
    }
}
