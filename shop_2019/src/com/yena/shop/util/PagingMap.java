package com.yena.shop.util;

import java.util.HashMap;
import java.util.Map;

public class PagingMap{
	Map pagingMap = new HashMap();
	
	
	/**
	 * 페이징 제한 페이지개수를 설정
	 * @param limit
	 */
	public void setLimit(int limit){
		pagingMap.put("LIMIT", limit);
	}
	
	/**
	 * 페이지 개수를 설정한다.
	 * @param limit
	 */
	public void setPageCount(int pageCount){
		pagingMap.put("PAGE_COUNT", pageCount);
	}
	
	/**
	 * 페이징 시작 페이지를 설정
	 * @param offset
	 */
	public void setPage(int page){
		pagingMap.put("PAGE", page);
	}
	
	/**
	 * 페이지 OFFSET를 설정 후 반환한다.
	 * @return offset
	 */
	public void setPaging(){
		int limit = getLimit();
		int offset = 0;
		int pageCount = getPageCount();
		int dataCount = getDataCount();
		int maxPage = 0;
		int page = getPage();
		int start = 0;
		
		if(page - 1 > 0){
			offset = (page - 1) * limit;
		}

		/*
		start = page / pageCount;
		if(page % pageCount > 0){
			start++;
		}
		*/
		start = (page - 1) / pageCount * pageCount + 1;
		
		int end = start + pageCount - 1;
		
		if(dataCount > 0){
			maxPage = dataCount / limit;
			if(dataCount % limit > 0){
				maxPage++;
			}
		}else{
			maxPage = 1;
			end = 1;
		}
		
		
		if(end > maxPage){
			end = maxPage;
		}
		
		pagingMap.put("MAX_PAGE", maxPage);
		pagingMap.put("START", start);
		pagingMap.put("END", end);
		pagingMap.put("OFFSET", offset);
	}
	
	/**
	 * 페이징 제한 페이지개수를 반환
	 * @return
	 */
	public int getLimit(){
		return pagingMap.get("LIMIT") == null ? 100 : Integer.parseInt(pagingMap.get("LIMIT").toString());
	}
	
	/**
	 * 페이지 개수를 반환
	 * @return
	 */
	public int getPageCount(){
		return pagingMap.get("PAGE_COUNT") == null ? 100 : Integer.parseInt(pagingMap.get("PAGE_COUNT").toString());
	}
	
	/**
	 * 페이징 시작 페이지를 반환
	 * @return
	 */
	public int getPage(){
		return pagingMap.get("PAGE") == null ? 0 : Integer.parseInt(pagingMap.get("PAGE").toString());
	}
	
	/**
	 * 검색에 사용될 객체를 넣는다.
	 * @param key
	 * @param object
	 */
	public void setObject(String key, Object object){
		pagingMap.put(key, object);
	}
	
	/**
	 * 검색에 사용될 객체를 반환한다.
	 * @param key
	 * @return
	 */
	public Object getObject(String key){
		return pagingMap.get(key) == null ? 0 : pagingMap.get(key).toString();
	}
	
	/**
	 * 페이징 정보를 담은 Map을 반환한다.
	 * @return
	 */
	public Map getMap(){
		return pagingMap;
	}

	/**
	 * 데이터 전체 개수를 설정
	 * @param cnt
	 */
	public void setDataCount(int cnt) {
		pagingMap.put("DATA_CNT", cnt);
	}
	
	/**
	 * 데이터 전체 개수를 반환
	 * @return
	 */
	public int getDataCount(){
		return pagingMap.get("DATA_CNT") == null ? 0 : Integer.parseInt(pagingMap.get("DATA_CNT").toString());
	}
	
	public void put(String key, Object value){
		pagingMap.put(key, value);
	}
}
