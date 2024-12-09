/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpleroutingprotocol;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author PC
 */
public class PacketQueue {
      Queue<Packet> packetQueue;
    int maxQueueLength;
    int queueLength;

    public PacketQueue(Queue<Packet> packetQueue, int maxQueueLength) {
        this.packetQueue = packetQueue;
        
        this.maxQueueLength = maxQueueLength;
        this.queueLength = 0;        
    }
    public void enqueue(Packet p) {
        
            packetQueue.add(p);
            queueLength++;
        
    }
    public void dequeue() {
        if(!packetQueue.isEmpty()) 
        {
            byte[] message = packetQueue.remove().getMessage();
      
            System.out.println("Packet forwarded => Content of the packet : "+new String(message,0,message.length));
        }else {
            System.out.println("The queue is empty there is no packet to forward ");
        }
        
        
    }
}
