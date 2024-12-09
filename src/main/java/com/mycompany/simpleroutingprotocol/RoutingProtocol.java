/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpleroutingprotocol;

/**
 *
 * @author PC
 */
public class RoutingProtocol {
     ProtocolStateEnum protocolState;
   PacketQueue packetQueue;

    public RoutingProtocol(ProtocolStateEnum protocolState, PacketQueue packetQueue) {
        this.protocolState = protocolState;
        this.packetQueue = packetQueue;
    }
   public void receive(Packet p) {
       
       if(packetQueue.queueLength < packetQueue.maxQueueLength) {
           protocolState = ProtocolStateEnum.STATE_ON_RECEIVE;
           System.out.println("---- Routing Protocol State : "+protocolState+" ----");
            packetQueue.enqueue(p);
            System.out.println("Packet received");
       } else {
           System.out.println("The queue is full");
       }
       protocolState = ProtocolStateEnum.STATE_IDLE;
       System.out.println("---- Routing Protocol State : "+protocolState+" ----");
   }
   public void forward() {
           protocolState = ProtocolStateEnum.STATE_ON_FORWARD;
           System.out.println("---- Routing Protocol State : "+protocolState+" ----");
           packetQueue.dequeue();
           protocolState = ProtocolStateEnum.STATE_IDLE;
           System.out.println("---- Routing Protocol State : "+protocolState+" ----");
   }
}
