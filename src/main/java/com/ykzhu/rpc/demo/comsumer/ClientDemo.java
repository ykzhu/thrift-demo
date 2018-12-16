package com.ykzhu.rpc.demo.comsumer;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.ykzhu.rpc.demo.share.RpcService;

/**
 * 客户端发起一次服务调用
 *
 */
public class ClientDemo {

    public static void main(String[] args) throws TException {
        System.out.println("----------start invoke----------------");
        
        TSocket socket = new TSocket("127.0.0.1", 9999);
		socket.setTimeout(3000);
		TTransport transport = new TFramedTransport(socket);
		TProtocol protocol = new TCompactProtocol(transport);
		transport.open();
		System.out.println("Connected to Thrfit Server");
		
		RpcService.Client client = new RpcService.Client.Factory()
				.getClient(protocol);
		String result = client.sayHi("Hi,RPC");
		System.out.println(result);
		
        System.out.println("----------end invoke----------------");
    }
}
