package com.demo.test;

import com.demo.dao.TaskDao;
import com.demo.dataobject.TaskEntity;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JobTest {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private SolrClient solrClient;
    @Test
    public void test(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setJobId(UUID.randomUUID().toString());
        taskEntity.setJobName("12312321");
        taskEntity.setJobGroup("12311232321");
        TaskEntity save = taskDao.save(taskEntity);
        Assert.assertNotNull(save);
    }

    @Test
    public void test1(){
        taskDao.deleteById("9dfded74-03fb-4508-9c4d-b891872f7a5f");
    }

    @Test
    public void test2() throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.set("q","title:入门");
        QueryResponse query = solrClient.query(solrQuery);
        SolrDocumentList results = query.getResults();
        for (SolrDocument result : results) {
            System.out.println(result.get("id"));
            System.out.println(result.get("title"));
            System.out.println(result.get("createByName"));
            System.out.println(result.get("createDate"));
            
        }
    }
}
