package com.ppamorim.sample.controller;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.ppamorim.sample.SNSMobilePush;

public class SNSClientController {

  public String sendPushNotification(){
    try {

      AWSCredentials cred=new BasicAWSCredentials("AKIAJWI2M4VALBVWT75Q","soS8pOijtnutIoSNOnWCMYR6uSlLahzbG6IB1Dpq");
      AmazonSNSClient sns=new AmazonSNSClient(cred);
      sns.setEndpoint("https://sns.us-east-1.amazonaws.com");
      System.out.println("===========================================\n");
      System.out.println("Getting Started with Amazon SNS");
      System.out.println("===========================================\n");

      SNSMobilePush sample = new SNSMobilePush(sns);
			/* TODO: Uncomment the services you wish to use. */
      sample.demoAndroidAppNotification();
      // sample.demoKindleAppNotification();
      // sample.demoAppleAppNotification();
      // sample.demoAppleSandboxAppNotification();
      // sample.demoBaiduAppNotification();
      // sample.demoWNSAppNotification();
      // sample.demoMPNSAppNotification();
    } catch (AmazonServiceException ase) {
      System.out
          .println("Caught an AmazonServiceException, which means your request made it "
              + "to Amazon SNS, but was rejected with an error response for some reason.");
      System.out.println("Error Message:    " + ase.getMessage());
      System.out.println("HTTP Status Code: " + ase.getStatusCode());
      System.out.println("AWS Error Code:   " + ase.getErrorCode());
      System.out.println("Error Type:       " + ase.getErrorType());
      System.out.println("Request ID:       " + ase.getRequestId());
    } catch (AmazonClientException ace) {
      System.out
          .println("Caught an AmazonClientException, which means the client encountered "
              + "a serious internal problem while trying to communicate with SNS, such as not "
              + "being able to access the network.");
      System.out.println("Error Message: " + ace.getMessage());
    }



    return "it works :) ";
  }
}