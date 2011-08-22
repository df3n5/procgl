package com.df3n5.gwtproc.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/resources/com/df3n5/gwtproc/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Enter your name".
   * 
   * @return translated "Enter your name"
   */
  @DefaultMessage("Enter your name")
  @Key("nameField")
  String nameField();

  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();
}
