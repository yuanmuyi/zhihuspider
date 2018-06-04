package com.yy.util;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/5/8 15:08
 */
@Component
public class EsUtils {

    private Logger logger = LoggerFactory.getLogger(EsUtils.class);

    @Value("${es.cluster.name}")
    private String clusterName;

    @Value("${es.host.ip}")
    private String ipAddress;

    @Value("${es.host.port}")
    private int port;

    private static TransportClient client;

    @PostConstruct
    public void initEsClient(){
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        TransportAddress transportAddress;
        try {
            transportAddress = new TransportAddress(InetAddress.getByName(ipAddress),port);
            client = new PreBuiltTransportClient(settings).addTransportAddress(transportAddress);
            logger.info("-------success connect to es, clusterName:[{}], ip:[{}], port:[{}]------",clusterName,ipAddress,port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static TransportClient getClient(){
        return client;
    }
}
