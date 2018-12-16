package com.ykzhu.rpc.demo.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

import com.ykzhu.rpc.demo.share.RpcService;
import com.ykzhu.rpc.demo.share.RpcService.Iface;

public class ServerDemo {
	public static void main(String[] args){
	     TNonblockingServerSocket socket;
	     try {
	         socket = new TNonblockingServerSocket(9999);
	         TNonblockingServer.Args options = new TNonblockingServer.Args(socket);
	         TProcessor processor = new RpcService.Processor<Iface>(new RpcServiceImpl());
	         options.processor(processor);
	         options.protocolFactory(new TCompactProtocol.Factory());
	         TServer server = new TNonblockingServer(options);
	         System.out.println("Thrift Server is running at 9999 port");
	         server.serve();        
	     } catch (Exception e) {
	         throw new RuntimeException(e);
	     }
	 }
}
