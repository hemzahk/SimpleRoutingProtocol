/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simpleroutingprotocol;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Queue;




/**
 *
 * @author PC
 */
public class SimpleRoutingProtocol {

    public static void main(String[] args) throws UnsupportedEncodingException {
        
        // Testing the normal case : 
        
        // Creating packets : 
        
        Packet packet1 = new Packet("Hello".getBytes("UTF-8"));
        Packet packet2 = new Packet(", World!".getBytes("UTF-8"));
        Packet packet3 = new Packet("Routing Protocol".getBytes("UTF-8"));
        
        Queue<Packet> pq = new LinkedList<>();
        
        // Creating and initializing the packet queue : 
        
        PacketQueue packetQueue = new PacketQueue(pq,5);
        
        // Creating a Routing Protocol Object : 
        
        RoutingProtocol routingProtocol = new RoutingProtocol(ProtocolStateEnum.STATE_IDLE,packetQueue);
        
        System.out.println("---- Routing Protocol State : "+routingProtocol.protocolState+" ----");
        
        // Receiving packets using the receive() method : 
        
        routingProtocol.receive(packet1);
        routingProtocol.receive(packet2);
        routingProtocol.receive(packet3);
        
        
        // Forwarding packets using the forward() method : 
        
        routingProtocol.forward();
        routingProtocol.forward();
        routingProtocol.forward();
        
        
    }
}
