package com.kalibyte.d089_6may_lms.util;

import java.util.Random;

public class UserIdGenerator
{
    public static String generateRandomIdForUserID()
    {
        String id = "LMSID";
        Random random = new Random();
        int i = random.nextInt(999999999);
        id = id + i;
        System.out.println(id);
        return id+i;
    }

    public static Long generateLoanApplicationRandomId()
    {
        Random random = new Random();
        return 100000L + random.nextInt(900000);
    }
}
