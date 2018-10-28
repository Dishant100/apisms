package com.example.dishant.apicall;

import java.util.ArrayList;

public class ApicallsmsResponse {

    String ErrorCode;
    String ErrorMessage;
    String JobId;
    ArrayList<Data> MessageData;

    public String getErrorCode() {
        return ErrorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public String getJobId() {
        return JobId;
    }

    public ArrayList<Data> getMessageData() {
        return MessageData;
    }

    public class Data
    {
        String Number;
        String MessageId;
    }
}
