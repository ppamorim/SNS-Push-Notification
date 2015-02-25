package com.ppamorim.sample;

import com.amazonaws.services.cognitosync.model.Platform;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;

import java.util.HashMap;
import java.util.Map;

public class SNSMobilePush {

  private AmazonSNSClientWrapper snsClientWrapper;

  public SNSMobilePush(AmazonSNS snsClient) {
    this.snsClientWrapper = new AmazonSNSClientWrapper(snsClient);
  }

  public static final Map<Platform, Map<String, MessageAttributeValue>> attributesMap = new HashMap<>();

  static {
    attributesMap.put(Platform.ADM, null);
    attributesMap.put(Platform.GCM, null);
    attributesMap.put(Platform.APNS, null);
    attributesMap.put(Platform.APNS_SANDBOX, null);
  }

  public void demoAndroidAppNotification() {
    // TODO: Please fill in following values for your application. You can
    // also change the notification payload as per your preferences using
    // the method
    // com.amazonaws.sns.samples.tools.SampleMessageGenerator.getSampleAndroidMessage()
    String serverAPIKey = "AIzaSyBzguLyK211pufVy0PAm7sgxwTWrzct3Rs";
    String applicationName = "GCM/testiWalletPush";
    String registrationId = "APA91bHQKK2KYSydn32ecdapWC2LeAFTjLFawBKEmQA815UaVYpdTmciRdY-Uzm51WHeiRith0D5yfSBT9MHj3rM9n9Lop1-5r91Ynzzh3XWzzoxv7A2yQJMq-RFfAqL7RnoJIMb0SoRXwaOMsRoSmtbXQrgfoV_6ll2_Rv00XxRafL_0Gp6g_8";
    snsClientWrapper.demoNotification(Platform.GCM, "", serverAPIKey,
        registrationId, applicationName, attributesMap);
  }

  private static Map<String, MessageAttributeValue> addBaiduNotificationAttributes() {
    Map<String, MessageAttributeValue> notificationAttributes = new HashMap<String, MessageAttributeValue>();
    notificationAttributes.put("AWS.SNS.MOBILE.BAIDU.DeployStatus",
        new MessageAttributeValue().withDataType("String")
            .withStringValue("1"));
    notificationAttributes.put("AWS.SNS.MOBILE.BAIDU.MessageKey",
        new MessageAttributeValue().withDataType("String")
            .withStringValue("default-channel-msg-key"));
    notificationAttributes.put("AWS.SNS.MOBILE.BAIDU.MessageType",
        new MessageAttributeValue().withDataType("String")
            .withStringValue("0"));
    return notificationAttributes;
  }

  private static Map<String, MessageAttributeValue> addWNSNotificationAttributes() {
    Map<String, MessageAttributeValue> notificationAttributes = new HashMap<String, MessageAttributeValue>();
    notificationAttributes.put("AWS.SNS.MOBILE.WNS.CachePolicy",
        new MessageAttributeValue().withDataType("String")
            .withStringValue("cache"));
    notificationAttributes.put("AWS.SNS.MOBILE.WNS.Type",
        new MessageAttributeValue().withDataType("String")
            .withStringValue("wns/badge"));
    return notificationAttributes;
  }

  private static Map<String, MessageAttributeValue> addMPNSNotificationAttributes() {
    Map<String, MessageAttributeValue> notificationAttributes = new HashMap<String, MessageAttributeValue>();
    notificationAttributes.put("AWS.SNS.MOBILE.MPNS.Type",
        new MessageAttributeValue().withDataType("String")
            .withStringValue("token")); // This attribute is required.
    notificationAttributes.put("AWS.SNS.MOBILE.MPNS.NotificationClass",
        new MessageAttributeValue().withDataType("String")
            .withStringValue("realtime")); // This attribute is required.

    return notificationAttributes;
  }
}
