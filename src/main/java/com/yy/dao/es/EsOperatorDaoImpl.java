package com.yy.dao.es;

import com.yy.enums.EsIndexAndTypeEnum;
import com.yy.util.EsUtils;
import com.yy.util.UUIDUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/5/9 16:03
 */
public class EsOperatorDaoImpl implements EsOperatorDao {

    private static final Logger log = LoggerFactory.getLogger(EsOperatorDaoImpl.class);

    @Override
    public void initIndexAndType() {
        EsIndexAndTypeEnum [] indexAndTypeEnums = EsIndexAndTypeEnum.values();
        for (EsIndexAndTypeEnum indexAndTypeEnum : indexAndTypeEnums) {
            TransportClient client = EsUtils.getClient();
            if (Objects.isNull(client)){
                return;
            }

            //索引创建
            IndicesAdminClient indicesAdminClient = client.admin().indices();
            CreateIndexResponse indexResponse = indicesAdminClient.prepareCreate(indexAndTypeEnum.getIndex()).
                    setSettings(Settings.builder().put("max_result_window",100000)).get();
            if (indexResponse.isAcknowledged()){
                log.debug("initIndexAndType::index----->[{}] 创建成功", indexAndTypeEnum.getIndex());
            }
            //putmapping
            XContentBuilder builder = null;
            try {
                builder = XContentFactory.jsonBuilder()
                        .startObject()
                        .startObject(indexAndTypeEnum.getType())
                        .startObject("_all")
                        .field("analyzer","index_ansj")
                        .field("enabled",true)
                        .endObject()
                        .endObject()
                        .endObject();
            } catch (IOException e) {
                log.error("创建 jvmSample mapping 失败," + e.getLocalizedMessage());
            }
            PutMappingRequest mappingRequest = Requests.putMappingRequest(indexAndTypeEnum.getIndex())
                    .type(indexAndTypeEnum.getType()).source(builder);
            PutMappingResponse mappingResponse = client.admin().indices().putMapping(mappingRequest).actionGet();
            if (mappingResponse.isAcknowledged()){
                log.debug("initIndexAndType::type-------->[{}] 创建成功", indexAndTypeEnum.getType());
            }
        }
    }

    @Override
    public void insertData(String index, String type, Map data) {
        if (data.isEmpty()){
            return;
        }
        TransportClient client = EsUtils.getClient();
        IndexResponse response = client.prepareIndex(index,type, UUIDUtils.getUUID())
                .setSource(data)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                .execute().actionGet();
    }
}
