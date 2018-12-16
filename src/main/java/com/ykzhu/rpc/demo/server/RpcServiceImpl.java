package com.ykzhu.rpc.demo.server;

import com.ykzhu.rpc.demo.share.RpcService;

/**
 * 服务实现
 */
public class RpcServiceImpl implements RpcService.Iface{
	
    public String sayHi(String name) {
        return "Hello," + name;
    }
}