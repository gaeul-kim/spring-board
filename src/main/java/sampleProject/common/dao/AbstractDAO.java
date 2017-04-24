package sampleProject.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import sampleProject.article.domain.Article;

public abstract class AbstractDAO {
    protected Log LOG = LogFactory.getLog(AbstractDAO.class);

    @Autowired
    private SqlSessionTemplate sqlSession;

    protected void printQueryId(String queryId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("\t QueryId : " + queryId);
        }
    }

    public Object insert(String queryId, Object params) {
        printQueryId(queryId);
        return sqlSession.insert(queryId, params);
    }

    public Object update(String queryId, Object params) {
        printQueryId(queryId);
        return sqlSession.update(queryId, params);
    }

    public Object delete(String queryId, Object params) {
        printQueryId(queryId);
        return sqlSession.delete(queryId, params);
    }

    public Object deleteAll(String queryId) {
        printQueryId(queryId);
        return sqlSession.delete(queryId);
    }

    public Object selectOne(String queryId) {
        printQueryId(queryId);
        return sqlSession.selectOne(queryId);
    }

    public Object selectOne(String queryId, Object params) {
        printQueryId(queryId);
        return sqlSession.selectOne(queryId, params);
    }

    @SuppressWarnings("rawtypes")
    public List selectList(String queryId) {
        printQueryId(queryId);
        return sqlSession.selectList(queryId);
    }

    @SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params) {
        printQueryId(queryId);
        return sqlSession.selectList(queryId, params);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map selectPagingList(String queryId, Object params) {
        final Integer RECORD_COUNT_PER_PAGE = 15;
        final Integer PAGE_SIZE = 10;
        printQueryId(queryId);

        Map<String, Object> map = (Map<String, Object>) params;
        PaginationInfo paginationInfo = null;

        if (map.containsKey("currentPageNo") == false || StringUtils.isEmpty(map.get("currentPageNo")) == true) {
            map.put("currentPageNo", "1");
        }

        paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(Integer.parseInt(map.get("currentPageNo").toString()));
        if (map.containsKey("PAGE_ROW") == false || StringUtils.isEmpty(map.get("PAGE_ROW")) == true) {
            paginationInfo.setRecordCountPerPage(RECORD_COUNT_PER_PAGE);
        } else {
            paginationInfo.setRecordCountPerPage(Integer.parseInt(map.get("PAGE_ROW").toString()));
        }
        paginationInfo.setPageSize(PAGE_SIZE);

        int start = paginationInfo.getFirstRecordIndex();
        // int end = start + paginationInfo.getRecordCountPerPage();
        int end = RECORD_COUNT_PER_PAGE;
        map.put("START", start);
        map.put("END", end);

        params = map;

        Map<String, Object> returnMap = new HashMap<String, Object>();
        List<Article> list = sqlSession.selectList(queryId, params);

        if (list.size() == 0) {
            map = new HashMap<String, Object>();
            map.put("TOTAL_COUNT", 0);
            // list.add((Article) map);

            if (paginationInfo != null) {
                paginationInfo.setTotalRecordCount(0);
                returnMap.put("paginationInfo", paginationInfo);
            }
        } else {
            if (paginationInfo != null) {
                // paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getTOTAL_COUNT().toString()));
                paginationInfo.setTotalRecordCount(list.get(0).getTotalCount());
                returnMap.put("paginationInfo", paginationInfo);
            }
        }
        returnMap.put("articles", list);
        return returnMap;
    }

}
